package com.wallissoftware.universalanalytics.server;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.wallissoftware.universalanalytics.server.options.ServerOptionsCallback;
import com.wallissoftware.universalanalytics.server.options.TrackerNameOptionsCallback;
import com.wallissoftware.universalanalytics.shared.AbstractUniversalAnalyticsImpl;
import com.wallissoftware.universalanalytics.shared.AnalyticsPlugin;
import com.wallissoftware.universalanalytics.shared.HitType;
import com.wallissoftware.universalanalytics.shared.options.AnalyticsOptions;
import com.wallissoftware.universalanalytics.shared.options.CreateOptions;
import com.wallissoftware.universalanalytics.shared.options.GeneralOptions;
import com.wallissoftware.universalanalytics.shared.options.TimingOptions;

@Singleton
public class ServerUniversalAnalytics extends AbstractUniversalAnalyticsImpl {

    private final Provider<ServerOptionsCallback> serverOptionsCallbackProvider;

    private final Map<String, Long> timingEvents = new HashMap<>();

    private final Map<String, String> trackerNames = new HashMap<>();

    private final static Logger logger = Logger.getLogger(ServerUniversalAnalytics.class.getName());

    @Inject
    ServerUniversalAnalytics(final Provider<ServerOptionsCallback> serverOptionsCallbackProvider,
            @Named("gaAccount") final String userAccount) {
        super(userAccount);
        this.serverOptionsCallbackProvider = serverOptionsCallbackProvider;

    }


    @Override
    public CreateOptions create(final String userAccount) {
        return new AnalyticsOptions(new TrackerNameOptionsCallback() {

            @Override
            public void onCallback(final String trackerName) {
                trackerNames.put(trackerName, userAccount);

            }
        }).createOptions();
    }

    @Override
    public void enablePlugin(final AnalyticsPlugin plugin) {
        // Noop this has no affect on the server

    }


    @Override
    public TimingOptions endTimingEvent(final String trackerName, final String timingCategory,
            final String timingVariableName) {
        final String key = getTimingKey(timingCategory, timingVariableName);
        if (timingEvents.containsKey(key)) {
            return sendTiming(trackerName, timingCategory, timingVariableName,
                    (int) (System.currentTimeMillis() - timingEvents.remove(key)));
        }
        logger.severe("Timing Event Ended before it was started: " + key);
        return new AnalyticsOptions(new TrackerNameOptionsCallback() {

            @Override
            public void onCallback(final String trackerName) {
                //Do nothing a timing event was ended before it was started.  This is here just to stop a crash.
            }
        }).timingOptions(timingCategory, timingVariableName, 0);
    }
    @Override
    public AnalyticsOptions send(final String trackerName, final HitType hitType) {
        final ServerOptionsCallback options = serverOptionsCallbackProvider.get();
        if (trackerName != null) {
            options.putText("tid", trackerNames.get(trackerName));
        }
        options.putText("hitType", hitType.getFieldName());
        return new AnalyticsOptions(options);
    }

    @Override
    public GeneralOptions setGlobalSettings() {
        return new AnalyticsOptions(new TrackerNameOptionsCallback() {

            @Override
            public void onCallback(final String trackerName) {
                //Do nothing, this call is not valid on the server.
            }
        }).generalOptions();
    }

    @Override
    public void startTimingEvent(final String timingCategory, final String timingVariableName) {
        timingEvents.put(timingCategory + ":" + timingVariableName, System.currentTimeMillis());

    }

}
