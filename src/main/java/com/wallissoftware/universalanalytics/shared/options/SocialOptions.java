package com.wallissoftware.universalanalytics.shared.options;

public class SocialOptions extends AnalyticsOptions {

    SocialOptions(final OptionsCallback<?> optionsCallback, final String SocialNetwork, final String SocialAction,
            final String SocialActionTarget) {
        super(optionsCallback);
        putText("socialNetwork", SocialNetwork);
        putText("socialAction", SocialAction);
        putText("socialTarget", SocialActionTarget);
    }

}
