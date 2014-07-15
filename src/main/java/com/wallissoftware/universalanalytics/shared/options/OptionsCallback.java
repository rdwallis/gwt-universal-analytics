package com.wallissoftware.universalanalytics.shared.options;

import com.wallissoftware.universalanalytics.shared.HitCallback;

public abstract class OptionsCallback<T> {

    abstract public void addHitCallback(HitCallback hitCallback);

    void doCallback() {
        onCallback(getOptions());
    }

    public abstract T getOptions();

    public abstract void onCallback(T options);

    abstract public void putBoolean(String fieldName, boolean value);

    abstract public void putNumber(String fieldName, double value);

    abstract public void putText(String fieldName, String value);

}
