package com.wallissoftware.universalanalytics.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.wallissoftware.universalanalytics.shared.AnalyticsPlugin;
import com.wallissoftware.universalanalytics.shared.HitType;
import com.wallissoftware.universalanalytics.shared.UniversalAnalytics;
import com.wallissoftware.universalanalytics.shared.options.AnalyticsOptions;
import com.wallissoftware.universalanalytics.shared.options.ContentOptions;
import com.wallissoftware.universalanalytics.shared.options.CreateOptions;
import com.wallissoftware.universalanalytics.shared.options.EventsOptions;
import com.wallissoftware.universalanalytics.shared.options.GeneralOptions;
import com.wallissoftware.universalanalytics.shared.options.SocialOptions;
import com.wallissoftware.universalanalytics.shared.options.TimingOptions;

public class UniversalAnalyticsImpl implements UniversalAnalytics {
    private final String userAccount;

    @Inject
    UniversalAnalyticsImpl(@Named("gaAccount") final String userAccount,
            @Named("uaAutoCreate") final boolean autoCreate) {
        init();
        this.userAccount = userAccount;
        if (autoCreate) {
            create();
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
    public CreateOptions create() {
        return create(userAccount);
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
    public AnalyticsOptions send(final HitType hitType) {
        return send(null, hitType);
    }

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
    public TimingOptions sendTiming(final String trackerName, final String timingCategory, final String timingVar, final int timingValue) {
        return send(trackerName, HitType.TIMING).timingOptions(timingCategory, timingVar, timingValue);
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



}
