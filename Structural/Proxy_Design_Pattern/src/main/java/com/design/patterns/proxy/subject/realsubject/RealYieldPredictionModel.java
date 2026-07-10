package com.design.patterns.proxy.subject.realsubject;

import com.design.patterns.proxy.subject.IYieldPredictionModel;

public class RealYieldPredictionModel implements IYieldPredictionModel {

	private final String modelId;

	public RealYieldPredictionModel(String modelId) {
		this.modelId = modelId;
		loadModelWeights();
	}

	private void loadModelWeights() {
		System.out.println("-----Loading model weights into memory: " + modelId);
	}

	@Override
	public void predict() {
		System.out.println("-----Running yield prediction with model: " + modelId);
	}
}
