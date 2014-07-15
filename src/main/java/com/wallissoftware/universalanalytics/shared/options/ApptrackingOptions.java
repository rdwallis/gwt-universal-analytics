package com.wallissoftware.universalanalytics.shared.options;

public class ApptrackingOptions extends AnalyticsOptions {

    ApptrackingOptions(OptionsCallback<?> optionsCallback) {
        super(optionsCallback);
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the application name.</p>
    * Default Value: None<br>
    * Example Value: <code>My App</code>
    **/
    public ApptrackingOptions ApplicationName(String ApplicationName) {
        putText("appName", ApplicationName);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Application identifier.</p>
    * Default Value: None<br>
    * Example Value: <code>com.company.app</code>
    **/
    public ApptrackingOptions ApplicationId(String ApplicationId) {
        putText("appId", ApplicationId);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Specifies the application version.</p>
    * Default Value: None<br>
    * Example Value: <code>1.2</code>
    **/
    public ApptrackingOptions ApplicationVersion(String ApplicationVersion) {
        putText("appVersion", ApplicationVersion);
        return this;
    }

    /**
    * Optional.
    * </p>
    * <p>Application installer identifier.</p>
    * Default Value: None<br>
    * Example Value: <code>com.platform.vending</code>
    **/
    public ApptrackingOptions ApplicationInstallerId(String ApplicationInstallerId) {
        putText("appInstallerId", ApplicationInstallerId);
        return this;
    }

}
