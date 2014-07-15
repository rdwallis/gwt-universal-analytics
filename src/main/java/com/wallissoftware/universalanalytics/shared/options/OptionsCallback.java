package com.wallissoftware.universalanalytics.shared.options;

public abstract class OptionsCallback<T> {

    void doCallback() {
        onCallback(getOptions());
    }

    public abstract T getOptions();

    public abstract void onCallback(T options);

    abstract public void putBoolean(String fieldName, boolean value);

    abstract public void putNumber(String fieldName, double value);

    abstract public void putText(String fieldName, String value);

}
