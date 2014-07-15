package com.wallissoftware.universalanalytics.shared;

import com.wallissoftware.universalanalytics.shared.options.AnalyticsOptions;
import com.wallissoftware.universalanalytics.shared.options.ContentOptions;
import com.wallissoftware.universalanalytics.shared.options.CreateOptions;
import com.wallissoftware.universalanalytics.shared.options.EventsOptions;
import com.wallissoftware.universalanalytics.shared.options.GeneralOptions;
import com.wallissoftware.universalanalytics.shared.options.SocialOptions;
import com.wallissoftware.universalanalytics.shared.options.TimingOptions;

public interface UniversalAnalytics {

    /**
     * Create a new tracker using the user id bound to GaAccount.<br>
     * Example: create();<br>
     * create().name("My Tracker") //create a custom named tracker
     */
    CreateOptions create();

    /**
     * Create a new tracker using a supplied user id.<br>
     * Example: create("UA-XXXXXXX-X");<br>
     * create("UA-XXXXXXX-X").name("My Tracker") //create a custom named tracker
     */
    CreateOptions create(String userAccount);

    /**
     * Enable an analytics plugin.  This must be called immediately after create();
     * If you are using plugins you should probably turn off autoCreate when building the
     * UniversalAnalyticsModule and create your tracker manually in your bootstrapper.
     * @param plugin
     */
    void enablePlugin(AnalyticsPlugin plugin);

    /**
     * Used in conjuction with startTimingEvent to automatically setup and log timing events;
     * Call endTimingEvent with the same timingCategory and timingVariableName as you used in startTimingEvent()
     * to fire the event.
     * @param timingCategory
     * @param timingVariableName
     */
    TimingOptions endTimingEvent(String timingCategory, String timingVariableName);

    /**
     * Used in conjuction with startTimingEvent to automatically setup and log timing events;
     * Call endTimingEvent with the same timingCategory and timingVariableName as you used in startTimingEvent()
     * to fire the event.
     * @param timingCategory
     * @param timingVariableName
     */
    TimingOptions endTimingEvent(String trackerName, String timingCategory, String timingVariableName);

    /**
     * send a specific HitType.
     * @param hitType
     * see https://developers.google.com/analytics/devguides/collection/analyticsjs/field-reference#hit
     * Example: send(HitType.PAGE_VIEW);
     */
    AnalyticsOptions send(HitType hitType);

    /**
     * send a specific HitType to a specific tracker.
     * @param trackerName the name of the tracker
     * @param hitType
     * see https://developers.google.com/analytics/devguides/collection/analyticsjs/field-reference#hit
     * Example: send(HitType.PAGE_VIEW);
     */
    AnalyticsOptions send(String trackerName, HitType hitType);

    /**
     * send an event.
     * @param category  the event category
     * @param action the event action<br>
     * see https://developers.google.com/analytics/devguides/collection/analyticsjs/field-reference#events
     * Example: sendEvent("button", "click");
     */
    EventsOptions sendEvent(String category, String action);

    /**
     * send an event to a specific tracker.
     * @param trackerName the name of the tracker
     * @param category  the event category
     * @param action the event action<br>
     * see https://developers.google.com/analytics/devguides/collection/analyticsjs/field-reference#events
     * Example: sendEvent("button", "click");
     */
    EventsOptions sendEvent(String trackerName, String category, String action);

    /**
     * send a pageview to a specific tracker.
     * Example: sendPageView();<br>
     * sendPageView().documentPath("/foo"); //send a pageview for /foo
     */
    ContentOptions sendPageView();

    /**
     * send a pageview to a specific tracker.
     * @param trackerName the name of the tracker
     * Example: sendPageView();<br>
     * sendPageView().documentPath("/foo"); //send a pageview for /foo
     */
    ContentOptions sendPageView(String trackerName);

    /**
     * send a social event.
     * @param socialNetwork the social network
     * @param socialAction the action taken
     * @param socialTarget the target of the action
     * Example: sendSocial("facebook", "like", "http://www.example.com");<br>
     */
    SocialOptions sendSocial(String socialNetwork, String socialAction, String socialTarget);

    /**
     * send a social event to a specific tracker.
     * @param trackerName the name of the tracker
     * @param socialNetwork the social network
     * @param socialAction the action taken
     * @param socialTarget the target of the action
     * Example: sendSocial("facebook", "like", "http://www.example.com");<br>
     */
    SocialOptions sendSocial(String trackerName, String socialNetwork, String socialAction, String socialTarget);

    /**
     * send user timing information to the default tracker.
     * this is use to analyze page speed.
     * @param timingCategory - a category used to group related timing data
     * @param timingVar - a string to identify the variable being recorded
     * @param timingValue - the number of milliseconds of elapsed time.
     * Example: sendTiming("jQuery", "Load Library", 20);<br>
     */
    TimingOptions sendTiming(final String timingCategory, final String timingVar, final int timingValue);

    /**
     * send user timing information to a specific tracker.
     * this is use to analyze page speed.
     * @param trackerName - the name of the tracker
     * @param timingCategory - a category used to group related timing data
     * @param timingVar - a string to identify the variable being recorded
     * @param timingValue - the number of milliseconds of elapsed time.
     * Example: sendTiming("jQuery", "Load Library", 20).go();<br>
     */
    TimingOptions sendTiming(String trackerName, final String timingCategory, final String timingVar,
            final int timingValue);

    /**
     * set options for all subsequent calls.
     * Example: setGlobalSettings().anonymizeIp(true).go(); //anonymize ip addresses<br>
     */
    GeneralOptions setGlobalSettings();

    /**
     * A handy shortcut for setting up an event you want to time.
     * On it's own this method does nothing.
     * Call endTimingEvent with the same timingCategory and timingVariableName to fire the event.
     * @param timingCategory
     * @param timingVariableName
     */
    void startTimingEvent(String timingCategory, String timingVariableName);

}
