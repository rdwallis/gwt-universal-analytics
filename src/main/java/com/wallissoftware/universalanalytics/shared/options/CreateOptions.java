package com.wallissoftware.universalanalytics.shared.options;

public class CreateOptions extends AnalyticsOptions {

    CreateOptions(OptionsCallback<?> optionsCallback) {
        super(optionsCallback);
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>Name of the tracker object.</p>
    * Default Value: t0<br>
    * Example Value: <code>myTracker</code>
    **/
    public CreateOptions TrackerName(String TrackerName) {
        putText("name", TrackerName);
        return this;
    }

    /**
    * <strong>Required for all hit types.</strong>
    * </p>
    * <p>Anonymously identifies a browser instance. By default, this value is stored as part of the first-party analytics tracking cookie with a two-year expiration.</p>
    * Default Value: Randomly Generated<br>
    * Example Value: <code>35009a79-1a05-49d7-b876-2b884d0f825b</code>
    **/
    public CreateOptions ClientId(String ClientId) {
        putText("clientId", ClientId);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>This is intended to be a known identifier for a user provided by the site owner/tracking library user. It may not itself be PII. The value should never be persisted in GA cookies or other Analytics provided storage.</p>
    * Default Value: None<br>
    * Example Value: <code>as8eknlll</code>
    **/
    public CreateOptions UserId(String UserId) {
        putText("userId", UserId);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>Specifies what percentage of users should be tracked. This defaults to 100 (no users are sampled out) but large sites may need to use a lower sample rate to stay within Google Analytics processing limits.</p>
    * Default Value: 100<br>
    * Example Value: <code>5</code>
    **/
    public CreateOptions SampleRate(float SampleRate) {
        putNumber("sampleRate", SampleRate);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>This setting determines how often site speed tracking beacons will be sent. By default, 1% of users will be automatically be tracked.Note: Analytics restricts Site Speed collection hits for a single property to the greater of 1% of users or 10K hits per day in order to ensure an equitable distribution of system resources for this feature.</p>
    * Default Value: 1<br>
    * Example Value: <code>50</code>
    **/
    public CreateOptions SiteSpeedSampleRate(int SiteSpeedSampleRate) {
        putNumber("siteSpeedSampleRate", SiteSpeedSampleRate);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>By default the HTTP referrer URL, which is used to attribute traffic sources, is only sent when the hostname of the referring site differs from the hostname of the current page. Enable this setting only if you want to process other pages from your current host as referrals.</p>
    * Default Value: false<br>
    * Example Value: <code>true</code>
    **/
    public CreateOptions AlwaysSendReferrer(boolean AlwaysSendReferrer) {
        putBoolean("alwaysSendReferrer", AlwaysSendReferrer);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>By default, analytics.js will search for custom campaign parameters such as utm_source, utm_medium, etc. in both the query string and anchor of the current page&#39;s URL. Setting this field to false will result in ignoring any custom campaign parameters that appear in the anchor.</p>
    * Default Value: true<br>
    * Example Value: <code>false</code>
    **/
    public CreateOptions AllowAnchorParameters(boolean AllowAnchorParameters) {
        putBoolean("allowAnchor", AllowAnchorParameters);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>Name of the cookie used to store analytics data</p>
    * Default Value: _ga<br>
    * Example Value: <code>gaCookie</code>
    **/
    public CreateOptions CookieName(String CookieName) {
        putText("cookieName", CookieName);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>Specifies the domain used to store the analytics cookie. Setting this to &#39;none&#39; sets the cookie without specifying a domain.</p>
    * Default Value: document.location.hostname (normalized)<br>
    * Example Value: <code>example.com</code>
    **/
    public CreateOptions CookieDomain(String CookieDomain) {
        putText("cookieDomain", CookieDomain);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>Specifies the cookie expiration, in seconds.</p>
    * Default Value: 63072000 (two years)<br>
    * Example Value: <code>86400</code>
    **/
    public CreateOptions CookieExpiration(int CookieExpiration) {
        putNumber("cookieExpires", CookieExpiration);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>This field is used to configure how analytics.js searches for cookies generated by earlier Google Analytics tracking scripts such as ga.js and urchin.js.</p>
    * Default Value: None<br>
    * Example Value: <code>store.example.com</code>
    **/
    public CreateOptions LegacyCookieDomain(String LegacyCookieDomain) {
        putText("legacyCookieDomain", LegacyCookieDomain);
        return this;
    }

    /**
    * Optional.
    * This may only be set in the <code>create</code> method.
    * </p>
    * <p>Setting this field to true will enables the parsing of cross-domain linker parmeters used to transfer state across domains.</p>
    * Default Value: false<br>
    * Example Value: <code>true</code>
    **/
    public CreateOptions AllowLinkerParameters(boolean AllowLinkerParameters) {
        putBoolean("allowLinker", AllowLinkerParameters);
        return this;
    }

}
