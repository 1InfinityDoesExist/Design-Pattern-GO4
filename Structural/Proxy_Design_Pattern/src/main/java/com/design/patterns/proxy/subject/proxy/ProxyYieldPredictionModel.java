package com.design.patterns.proxy.subject.proxy;

import com.design.patterns.proxy.subject.IYieldPredictionModel;
import com.design.patterns.proxy.subject.realsubject.RealYieldPredictionModel;

public class ProxyYieldPredictionModel implements IYieldPredictionModel {

	private final String modelId;
	private RealYieldPredictionModel realYieldPredictionModel;

	public ProxyYieldPredictionModel(String modelId) {
		this.modelId = modelId;
	}

	@Override
	public void predict() {
		System.out.println("----Routing through model proxy");

		if (realYieldPredictionModel == null) {
			realYieldPredictionModel = new RealYieldPredictionModel(modelId);
		}
		realYieldPredictionModel.predict();
	}
}
