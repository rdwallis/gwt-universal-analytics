package com.wallissoftware.universalanalytics.shared.options;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;
import com.wallissoftware.universalanalytics.shared.options.ExceptionOptions;

public class ExceptionOptions extends AnalyticsOptions {

	ExceptionOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* Optional.
* </p>
* <p>Specifies the description of an exception.</p>
* Default Value: None<br>
* Example Value: <code>DatabaseError</code>
**/
public ExceptionOptions ExceptionDescription(String ExceptionDescription) {
putText("exDescription", ExceptionDescription);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies whether the exception was fatal.</p>
* Default Value: 1<br>
* Example Value: <code>true</code>
**/
public ExceptionOptions IsExceptionFatal(boolean IsExceptionFatal) {
putBoolean("exFatal", IsExceptionFatal);
return this;
}



}