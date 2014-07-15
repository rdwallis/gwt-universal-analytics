package com.wallissoftware.universalanalytics.shared.options;

public class EventsOptions extends AnalyticsOptions {

    EventsOptions(final OptionsCallback<?> optionsCallback, final String EventCategory, final String EventAction) {
        super(optionsCallback);
        putText("eventCategory", EventCategory);
        putText("eventAction", EventAction);
    }

    /**
     * Optional.
     * </p>
     * <p>Specifies the event label.</p>
     * Default Value: None<br>
     * Example Value: <code>Label</code>
     **/
    public EventsOptions EventLabel(final String EventLabel) {
        putText("eventLabel", EventLabel);
        return this;
    }

    /**
     * Optional.
     * </p>
     * <p>Specifies the event value. Values must be non-negative.</p>
     * Default Value: None<br>
     * Example Value: <code>55</code>
     **/
    public EventsOptions EventValue(final int EventValue) {
        putNumber("eventValue", EventValue);
        return this;
    }

}
