package com.wallissoftware.universalanalytics.shared.options;

public class TrafficsourcesOptions extends AnalyticsOptions {

    TrafficsourcesOptions(OptionsCallback<?> optionsCallback) {
        super(optionsCallback);
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies which referral source brought traffic to a website. This value is also used to compute the traffic source. The format of this value is a URL. This field is initialized by the create command and is only set when the current hostname differs from the referrer hostname, unless the &#39;alwaysSendReferrer&#39; field is set to true.</p>
    * Default Value: document.referrer<br>
    * Example Value: <code>http://example.com</code>
    **/
    public TrafficsourcesOptions DocumentReferrer(String DocumentReferrer) {
        putText("referrer", DocumentReferrer);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the campaign name.</p>
    * Default Value: None<br>
    * Example Value: <code>(direct)</code>
    **/
    public TrafficsourcesOptions CampaignName(String CampaignName) {
        putText("campaignName", CampaignName);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the campaign source.</p>
    * Default Value: None<br>
    * Example Value: <code>(direct)</code>
    **/
    public TrafficsourcesOptions CampaignSource(String CampaignSource) {
        putText("campaignSource", CampaignSource);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the campaign medium.</p>
    * Default Value: None<br>
    * Example Value: <code>organic</code>
    **/
    public TrafficsourcesOptions CampaignMedium(String CampaignMedium) {
        putText("campaignMedium", CampaignMedium);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the campaign keyword.</p>
    * Default Value: None<br>
    * Example Value: <code>Blue Shoes</code>
    **/
    public TrafficsourcesOptions CampaignKeyword(String CampaignKeyword) {
        putText("campaignKeyword", CampaignKeyword);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the campaign content.</p>
    * Default Value: None<br>
    * Example Value: <code>content</code>
    **/
    public TrafficsourcesOptions CampaignContent(String CampaignContent) {
        putText("campaignContent", CampaignContent);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the campaign ID.</p>
    * Default Value: None<br>
    * Example Value: <code>ID</code>
    **/
    public TrafficsourcesOptions CampaignId(String CampaignId) {
        putText("campaignId", CampaignId);
        return this;
    }

}
