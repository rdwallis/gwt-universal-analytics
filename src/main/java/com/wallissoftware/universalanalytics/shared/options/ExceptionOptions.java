package com.wallissoftware.universalanalytics.shared.options;


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