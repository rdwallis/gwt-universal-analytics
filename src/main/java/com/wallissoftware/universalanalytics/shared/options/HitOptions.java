package com.wallissoftware.universalanalytics.shared.options;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;
import com.wallissoftware.universalanalytics.shared.options.HitOptions;

public class HitOptions extends AnalyticsOptions {

	HitOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* <strong>Required for all hit types.</strong>
* </p>
* <p>The type of hit. Must be one of &#39;pageview&#39;, &#39;screenview&#39;, &#39;event&#39;, &#39;transaction&#39;, &#39;item&#39;, &#39;social&#39;, &#39;exception&#39;, &#39;timing&#39;.</p>
* Default Value: None<br>
* Example Value: <code>pageview</code>
**/
public HitOptions HitType(String HitType) {
putText("hitType", HitType);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies that a hit be considered non-interactive.</p>
* Default Value: None<br>
* Example Value: <code>true</code>
**/
public HitOptions NonInteractionHit(boolean NonInteractionHit) {
putBoolean("nonInteraction", NonInteractionHit);
return this;
}



}