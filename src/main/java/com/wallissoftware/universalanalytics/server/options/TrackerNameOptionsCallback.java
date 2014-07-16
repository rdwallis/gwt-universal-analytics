package com.wallissoftware.universalanalytics.server.options;

import java.util.HashMap;
import java.util.Map;

import com.wallissoftware.universalanalytics.shared.HitCallback;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;

public abstract class TrackerNameOptionsCallback extends OptionsCallback<String> {


    private Map<String, String> options = new HashMap<>();

    @Override
    public void addHitCallback(final HitCallback hitCallback) {
        hitCallback.onCallback();
    }

    @Override
    public String getOptions() {
        return options.get("name");
    }


    @Override
    public void putBoolean(final String fieldName, final boolean value) {
        putText(fieldName, value ? "1" :"0");

    }

    @Override
    public void putNumber(final String fieldName, final double value) {
        putText(fieldName, value + "");

    }

    @Override
    public void putText(final String fieldName, final String value) {
        options.put(fieldName, value);
    }

}