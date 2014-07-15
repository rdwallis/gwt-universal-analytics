package com.wallissoftware.universalanalytics.client;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.wallissoftware.universalanalytics.shared.HitCallback;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;

public abstract class JSONOptionsCallback extends OptionsCallback<JSONObject> {

    private JSONObject jsonObject;

    public JSONOptionsCallback() {
        this.jsonObject = new JSONObject();
    }

    @Override
    public void addHitCallback(final HitCallback callback) {
        addHitCallback(jsonObject, new GuaranteedHitCallback(callback));
    }

    private native void addHitCallback(JSONObject jsonObject, HitCallback callback) /*-{
        jsonObject.hitCallback = function() {
            callback.@com.wallissoftware.universalanalytics.shared.HitCallback::onCallback()();
        }
    }-*/;

    @Override
    public JSONObject getOptions() {
        return jsonObject;
    }

    @Override
    public void putBoolean(final String fieldName, final boolean value) {
        jsonObject.put(fieldName, JSONBoolean.getInstance(value));

    }

    @Override
    public void putNumber(final String fieldName, final double value) {
        jsonObject.put(fieldName, new JSONNumber(value));

    }

    @Override
    public void putText(final String fieldName, final String value) {
        jsonObject.put(fieldName, new JSONString(value));

    }

}
