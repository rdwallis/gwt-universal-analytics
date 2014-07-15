package com.wallissoftware.universalanalytics.shared.options;


public class TimingOptions extends AnalyticsOptions {

    TimingOptions(final OptionsCallback<?> optionsCallback, final String UserTimingCategory,
            final String UserTimingVariableName, final int UserTimingTime) {
        super(optionsCallback);
        putText("timingCategory", UserTimingCategory);
        putText("timingVar", UserTimingVariableName);
        putNumber("timingValue", UserTimingTime);
    }

    /**
     * Optional.
     * </p>
     * <p>Specifies the user timing label.</p>
     * Default Value: None<br>
     * Example Value: <code>label</code>
     **/
    public TimingOptions UserTimingLabel(final String UserTimingLabel) {
        putText("timingLabel", UserTimingLabel);
        return this;
    }



}