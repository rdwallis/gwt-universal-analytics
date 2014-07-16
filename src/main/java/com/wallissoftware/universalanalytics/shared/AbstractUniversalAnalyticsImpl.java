package com.wallissoftware.universalanalytics.shared;

import com.wallissoftware.universalanalytics.shared.options.AnalyticsOptions;
import com.wallissoftware.universalanalytics.shared.options.ContentOptions;
import com.wallissoftware.universalanalytics.shared.options.CreateOptions;
import com.wallissoftware.universalanalytics.shared.options.EventsOptions;
import com.wallissoftware.universalanalytics.shared.options.SocialOptions;
import com.wallissoftware.universalanalytics.shared.options.TimingOptions;

public abstract class AbstractUniversalAnalyticsImpl implements UniversalAnalytics {
    private final String userAccount;

    protected AbstractUniversalAnalyticsImpl(final String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public CreateOptions create() {
        return create(userAccount);
    }

    @Override
    public TimingOptions endTimingEvent(final String timingCategory, final String timingVariableName) {
        return endTimingEvent(null, timingCategory, timingVariableName);
    }

    protected String getTimingKey(final String timingCategory, final String timingVariableName) {
        return timingCategory + ":" + timingVariableName;
    }

    @Override
    public AnalyticsOptions send(final HitType hitType) {
        return send(null, hitType);
    }

    @Override
    public EventsOptions sendEvent(final String category, final String action) {
        return sendEvent(null, category, action);
    }

    @Override
    public EventsOptions sendEvent(final String trackerName, final String category, final String action) {
        return send(trackerName, HitType.EVENT).eventsOptions(category, action);
    }

    @Override
    public ContentOptions sendPageView() {
        return sendPageView(null);
    }

    @Override
    public ContentOptions sendPageView(final String trackerName) {
        return send(trackerName, HitType.PAGE_VIEW).contentOptions();
    }

    @Override
    public SocialOptions sendSocial(final String socialNetwork, final String socialAction, final String socialTarget) {
        return sendSocial(null, socialNetwork, socialAction, socialTarget);
    }

    @Override
    public SocialOptions sendSocial(final String trackerName, final String socialNetwork, final String socialAction, final String socialTarget) {
        return send(trackerName, HitType.SOCIAL).socialOptions(socialNetwork, socialAction, socialTarget);
    }

    @Override
    public TimingOptions sendTiming(final String timingCategory, final String timingVar, final int timingValue) {
        return sendTiming(null, timingCategory, timingVar, timingValue);
    }

    @Override
    public TimingOptions sendTiming(final String trackerName, final String timingCategory, final String timingVar,
            final int timingValue) {
        return send(trackerName, HitType.TIMING).timingOptions(timingCategory, timingVar, timingValue);
    }
}
