package com.wallissoftware.universalanalytics.shared.options;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;
import com.wallissoftware.universalanalytics.shared.options.SystemOptions;

public class SystemOptions extends AnalyticsOptions {

	SystemOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* Optional.
* </p>
* <p>Specifies the screen resolution. This field is initialized by the create command.</p>
* Default Value: None<br>
* Example Value: <code>800x600</code>
**/
public SystemOptions ScreenResolution(String ScreenResolution) {
putText("screenResolution", ScreenResolution);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies the viewable area of the browser / device. This field is initialized by the create command.</p>
* Default Value: None<br>
* Example Value: <code>123x456</code>
**/
public SystemOptions ViewportSize(String ViewportSize) {
putText("viewportSize", ViewportSize);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies the character set used to encode the page / document. This field is initialized by the create command.</p>
* Default Value: UTF-8<br>
* Example Value: <code>UTF-8</code>
**/
public SystemOptions DocumentEncoding(String DocumentEncoding) {
putText("encoding", DocumentEncoding);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies the screen color depth. This field is initialized by the create command.</p>
* Default Value: None<br>
* Example Value: <code>24-bits</code>
**/
public SystemOptions ScreenColors(String ScreenColors) {
putText("screenColors", ScreenColors);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies the language. This field is initialized by the create command.</p>
* Default Value: None<br>
* Example Value: <code>en-us</code>
**/
public SystemOptions UserLanguage(String UserLanguage) {
putText("language", UserLanguage);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies whether Java was enabled. This field is initialized by the create command.</p>
* Default Value: None<br>
* Example Value: <code>true</code>
**/
public SystemOptions JavaEnabled(boolean JavaEnabled) {
putBoolean("javaEnabled", JavaEnabled);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies the flash version. This field is initialized by the create command.</p>
* Default Value: None<br>
* Example Value: <code>10 1 r103</code>
**/
public SystemOptions FlashVersion(String FlashVersion) {
putText("flashVersion", FlashVersion);
return this;
}



}