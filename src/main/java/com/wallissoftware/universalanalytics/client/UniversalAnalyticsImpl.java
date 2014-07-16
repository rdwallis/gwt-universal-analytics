package com.wallissoftware.universalanalytics.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.wallissoftware.universalanalytics.shared.AbstractUniversalAnalyticsImpl;
import com.wallissoftware.universalanalytics.shared.AnalyticsPlugin;
import com.wallissoftware.universalanalytics.shared.HitType;
import com.wallissoftware.universalanalytics.shared.options.AnalyticsOptions;
import com.wallissoftware.universalanalytics.shared.options.CreateOptions;
import com.wallissoftware.universalanalytics.shared.options.GeneralOptions;
import com.wallissoftware.universalanalytics.shared.options.TimingOptions;

public class UniversalAnalyticsImpl extends AbstractUniversalAnalyticsImpl {

    private final Map<String, Double> timingEvents = new HashMap<>();

    @Inject
    UniversalAnalyticsImpl(@Named("gaAccount") final String userAccount,
            @Named("uaAutoCreate") final boolean autoCreate) {
        super(userAccount);
        init();
        if (autoCreate) {
            create().go();
        }
    }

    private void call(final JSONValue... params) {
        final JSONArray aryParams = new JSONArray();
        for (final JSONValue p:params) {
            aryParams.set(aryParams.size(), p);
        }
        nativeCall(aryParams.getJavaScriptObject());
    }

    @Override
    public CreateOptions create(final String userAccount) {
        return new AnalyticsOptions(new JSONOptionsCallback() {

            @Override
            public void onCallback(final JSONObject options) {
                call(new JSONString("create"), new JSONString(userAccount), options);
            }
        }).createOptions();
    }

    @Override
    public void enablePlugin(final AnalyticsPlugin plugin) {
        call(new JSONString("require"), new JSONString(plugin.getFieldName()));
    }

    @Override
    public TimingOptions endTimingEvent(final String trackerName, final String timingCategory, final String timingVariableName) {
        final String key = getTimingKey(timingCategory, timingVariableName);
        if (timingEvents.containsKey(key)) {
            return sendTiming(trackerName, timingCategory, timingVariableName,
                    (int) (Duration.currentTimeMillis() - timingEvents.remove(key)));
        }
        return new AnalyticsOptions(new JSONOptionsCallback() {

            @Override
            public void onCallback(final JSONObject options) {
                //Do nothing a timing event was ended before it was started.  This is here just to stop a crash.
            }
        }).timingOptions(timingCategory, timingVariableName, 0);
    }

    private native void init()/*-{
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })($wnd,$doc,'script','//www.google-analytics.com/analytics.js','__ua');
    }-*/;

    private native void nativeCall(JavaScriptObject params) /*-{
        $wnd.__ua.apply(null, params);
    }-*/;


    @Override
    public AnalyticsOptions send(final String trackerName, final HitType hitType) {
        return new AnalyticsOptions(new JSONOptionsCallback() {

            @Override
            public void onCallback(final JSONObject options) {
                call(new JSONString(trackerName == null ? "send" : trackerName + ".send"),
                        new JSONString(hitType.getFieldName()), options);
            }
        });

    }

    @Override
    public GeneralOptions setGlobalSettings() {
        return new AnalyticsOptions(new JSONOptionsCallback() {

            @Override
            public void onCallback(final JSONObject options) {
                call(new JSONString("set"), options);
            }

        }).generalOptions();
    }

    @Override
    public void startTimingEvent(final String timingCategory, final String timingVariableName) {
        timingEvents.put(timingCategory + ":" + timingVariableName, Duration.currentTimeMillis());

    }


}
