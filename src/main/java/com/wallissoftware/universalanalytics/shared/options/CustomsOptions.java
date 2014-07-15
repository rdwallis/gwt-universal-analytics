package com.wallissoftware.universalanalytics.shared.options;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;
import com.wallissoftware.universalanalytics.shared.options.CustomsOptions;

public class CustomsOptions extends AnalyticsOptions {

	CustomsOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* Optional.
* </p>
* <p>Each custom dimension has an associated index. There is a maximum of 20 custom dimensions (200 for Premium accounts). The name suffix must be a positive integer between 1 and 200, inclusive.</p>
* Default Value: None<br>
* Example Value: <code>Sports</code>
**/
public CustomsOptions CustomDimension(String CustomDimension) {
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
public CustomsOptions CustomMetric(int CustomMetric) {
putNumber("metric", CustomMetric);
return this;
}



}