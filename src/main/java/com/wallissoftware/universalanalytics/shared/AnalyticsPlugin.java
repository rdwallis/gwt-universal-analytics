package com.wallissoftware.universalanalytics.shared;

public enum AnalyticsPlugin {
    DISPLAY("displayfeatures");

    private final String fieldName;

    AnalyticsPlugin(final String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
