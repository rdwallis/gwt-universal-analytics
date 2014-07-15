package com.wallissoftware.universalanalytics.shared.options;


public class ExperimentsOptions extends AnalyticsOptions {

	ExperimentsOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* Optional.
* </p>
* <p>This parameter specifies that this user has been exposed to an experiment with the given ID. It should be sent in conjunction with the Experiment Variant parameter.</p>
* Default Value: None<br>
* Example Value: <code>Qp0gahJ3RAO3DJ18b0XoUQ</code>
**/
public ExperimentsOptions ExperimentId(String ExperimentId) {
putText("expId", ExperimentId);
return this;
}

/**
* Optional.
* </p>
* <p>This parameter specifies that this user has been exposed to a particular variation of an experiment. It should be sent in conjunction with the Experiment ID parameter.</p>
* Default Value: None<br>
* Example Value: <code>1</code>
**/
public ExperimentsOptions ExperimentVariant(String ExperimentVariant) {
putText("expVar", ExperimentVariant);
return this;
}



}