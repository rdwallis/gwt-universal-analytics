package com.wallissoftware.universalanalytics.server;

import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.ServletModule;
import com.wallissoftware.universalanalytics.server.options.ServerOptionsCallback;
import com.wallissoftware.universalanalytics.shared.UniversalAnalytics;

public class ServerUniversalAnalyticsModule extends ServletModule {

    private final String userAccount;

    public ServerUniversalAnalyticsModule(final String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    protected void configureServlets() {
        bindConstant().annotatedWith(Names.named("gaAccount")).to(userAccount);
        bind(ServerOptionsCallback.class).toProvider(ServerOptionsCallbackProvider.class).in(RequestScoped.class);
        bind(UniversalAnalytics.class).to(ServerUniversalAnalytics.class).in(Singleton.class);
        filter("/*").through(ServerOptionsCallbackProvider.class);
    }

}
