package com.wallissoftware.universalanalytics.shared.options;


public class GeneralOptions extends AnalyticsOptions {

	GeneralOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* Optional.
* </p>
* <p>When present, the IP address of the sender will be anonymized.</p>
* Default Value: None<br>
* Example Value: <code>true</code>
**/
public GeneralOptions AnonymizeIp(boolean AnonymizeIp) {
putBoolean("anonymizeIp", AnonymizeIp);
return this;
}

/**
* Optional.
* </p>
* <p>By default, tracking beacons sent from https pages will be sent using https while beacons sent from http pages will be sent using http. Setting forceSSL to true will force http pages to also send all beacons using https.</p>
* Default Value: false<br>
* Example Value: <code>true</code>
**/
public GeneralOptions ForceSsl(boolean ForceSsl) {
putBoolean("forceSSL", ForceSsl);
return this;
}



}