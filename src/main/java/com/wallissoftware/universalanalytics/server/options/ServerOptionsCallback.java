package com.wallissoftware.universalanalytics.server.options;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wallissoftware.universalanalytics.shared.HitCallback;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;

public abstract class ServerOptionsCallback extends OptionsCallback<String> {

    private static final Map<String, String> protocolMap = new HashMap<>();

    static {
        protocolMap.put("anonymizeIp", "aip");
        protocolMap.put("forceSSL", "None");
        protocolMap.put("hitCallback", "None");
        protocolMap.put("referrer", "dr");
        protocolMap.put("campaignName", "cn");
        protocolMap.put("campaignSource", "cs");
        protocolMap.put("campaignMedium", "cm");
        protocolMap.put("campaignKeyword", "ck");
        protocolMap.put("campaignContent", "cc");
        protocolMap.put("campaignId", "ci");
        protocolMap.put("screenResolution", "sr");
        protocolMap.put("viewportSize", "vp");
        protocolMap.put("encoding", "de");
        protocolMap.put("screenColors", "sd");
        protocolMap.put("language", "ul");
        protocolMap.put("javaEnabled", "je");
        protocolMap.put("flashVersion", "fl");
        protocolMap.put("hitType", "t");
        protocolMap.put("nonInteraction", "ni");
        protocolMap.put("location", "dl");
        protocolMap.put("hostname", "dh");
        protocolMap.put("page", "dp");
        protocolMap.put("title", "dt");
        protocolMap.put("screenName", "cd");
        protocolMap.put("linkid", "linkid");
        protocolMap.put("appName", "an");
        protocolMap.put("appId", "aid");
        protocolMap.put("appVersion", "av");
        protocolMap.put("appInstallerId", "aiid");
        protocolMap.put("eventCategory", "ec");
        protocolMap.put("eventAction", "ea");
        protocolMap.put("eventLabel", "el");
        protocolMap.put("eventValue", "ev");
        protocolMap.put("socialNetwork", "sn");
        protocolMap.put("socialAction", "sa");
        protocolMap.put("socialTarget", "st");
        protocolMap.put("timingCategory", "utc");
        protocolMap.put("timingVar", "utv");
        protocolMap.put("timingValue", "utt");
        protocolMap.put("timingLabel", "utl");
        protocolMap.put("exDescription", "exd");
        protocolMap.put("exFatal", "exf");
        protocolMap.put("dimension", "cd[1-9][0-9]*");
        protocolMap.put("metric", "cm[1-9][0-9]*");
        protocolMap.put("expId", "xid");
        protocolMap.put("expVar", "xvar");

    }

    private Map<String, String> options = new HashMap<>();

    @Override
    public void addHitCallback(final HitCallback hitCallback) {
        hitCallback.onCallback();
    }

    @Override
    public String getOptions() {
        final StringBuilder result = new StringBuilder();

        for (final Entry<String, String> entry : options.entrySet()) {
            result.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return result.toString();
    }

    private String getProtocolFieldName(final String fieldName) {
        if (protocolMap.containsKey(fieldName)) {
            return protocolMap.get(fieldName);
        }
        return fieldName;
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
        options.put(getProtocolFieldName(fieldName), value);
    }


}