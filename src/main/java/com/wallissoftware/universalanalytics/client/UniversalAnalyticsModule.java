package com.wallissoftware.universalanalytics.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.name.Names;
import com.wallissoftware.universalanalytics.shared.UniversalAnalytics;

public class UniversalAnalyticsModule extends AbstractGinModule {
    public static class Builder {
        private final String userAccount;
        private boolean autoCreate = true;

        public Builder(final String userAccount) {
            this.userAccount = userAccount;
        }

        /**
         * Set this to false if you want to create the universal analytics tracker with custom options.
         * You can manually create the tracker by calling analytics.create() from your bootstrapper;
         * @param autoCreate
         * @return
         */
        public Builder autoCreate(final boolean autoCreate) {
            this.autoCreate = autoCreate;
            return this;
        }

        public UniversalAnalyticsModule build() {
            return new UniversalAnalyticsModule(userAccount, autoCreate);
        }

    }

    private final String userAccount;
    private boolean autoCreate;

    private UniversalAnalyticsModule(final String userAccount,
            final boolean autoCreate) {
        this.userAccount = userAccount;
        this.autoCreate = autoCreate;
    }

    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("gaAccount")).to(userAccount);
        bindConstant().annotatedWith(Names.named("uaAutoCreate")).to(autoCreate);
        bind(UniversalAnalyticsImpl.class).asEagerSingleton();
        bind(UniversalAnalytics.class).to(UniversalAnalyticsImpl.class);

    }
}
