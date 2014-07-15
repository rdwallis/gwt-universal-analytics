package com.wallissoftware.universalanalytics.shared.options;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;
import com.wallissoftware.universalanalytics.shared.options.ContentOptions;

public class ContentOptions extends AnalyticsOptions {

	ContentOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* Optional.
* </p>
* <p>Specifies the full URL (excluding anchor) of the page. This field is initialized by the create command.</p>
* Default Value: None<br>
* Example Value: <code>http://foo.com/home?a=b</code>
**/
public ContentOptions DocumentLocationUrl(String DocumentLocationUrl) {
putText("location", DocumentLocationUrl);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies the hostname from which content was hosted.</p>
* Default Value: None<br>
* Example Value: <code>foo.com</code>
**/
public ContentOptions DocumentHostName(String DocumentHostName) {
putText("hostname", DocumentHostName);
return this;
}

/**
* Optional.
* </p>
* <p>The path portion of the page URL. Should begin with &#39;/&#39;. Used to specify virtual page paths.</p>
* Default Value: None<br>
* Example Value: <code>/foo</code>
**/
public ContentOptions DocumentPath(String DocumentPath) {
putText("page", DocumentPath);
return this;
}

/**
* Optional.
* </p>
* <p>The title of the page / document. Defaults to document.title.</p>
* Default Value: None<br>
* Example Value: <code>Settings</code>
**/
public ContentOptions DocumentTitle(String DocumentTitle) {
putText("title", DocumentTitle);
return this;
}

/**
* Optional.
* </p>
* <p>If not specified, this will default to the unique URL of the page by either using the &amp;dl parameter as-is or assembling it from &amp;dh and &amp;dp. App tracking makes use of this for the &#39;Screen Name&#39; of the screenview hit.</p>
* Default Value: None<br>
* Example Value: <code>High Scores</code>
**/
public ContentOptions ScreenName(String ScreenName) {
putText("screenName", ScreenName);
return this;
}

/**
* Optional.
* </p>
* <p>The ID of a clicked DOM element, used to disambiguate multiple links to the same URL in In-Page Analytics reports when Enhanced Link Attribution is enabled for the property.</p>
* Default Value: None<br>
* Example Value: <code>nav_bar</code>
**/
public ContentOptions LinkId(String LinkId) {
putText("linkid", LinkId);
return this;
}



}