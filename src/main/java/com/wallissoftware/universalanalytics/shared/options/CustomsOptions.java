package com.wallissoftware.universalanalytics.shared.options;

public class CustomsOptions extends AnalyticsOptions {

    CustomsOptions(final OptionsCallback<?> optionsCallback) {
        super(optionsCallback);
    }

    /**
     * Optional.
     * </p>
     * <p>Each custom dimension has an associated index. There is a maximum of 20 custom dimensions (200 for Premium accounts). The name suffix must be a positive integer between 1 and 200, inclusive.</p>
     * Default Value: None<br>
     * Example Value: <code>Sports</code>
     **/
    public CustomsOptions CustomDimension(final String CustomDimension) {
        putText("dimension", CustomDimension);
        return this;
    }

    /**
     * Optional.
     * </p>
     * <p>Each custom metric has an associated index. There is a maximum of 20 custom metrics (200 for Premium accounts). The name suffix must be a positive integer between 1 and 200, inclusive.</p>
     * Default Value: None<br>
     * Example Value: <code>47</code>
     **/
    public CustomsOptions CustomMetric(final int CustomMetric) {
        putNumber("metric", CustomMetric);
        return this;
    }

}
