package com.design.patterns.proxy;

import com.design.patterns.proxy.subject.IYieldPredictionModel;
import com.design.patterns.proxy.subject.proxy.ProxyYieldPredictionModel;

public class ProxyDesignPattern {

	public static void main(String[] args) {
		System.out.println("Proxy Design Pattern");

		IYieldPredictionModel model = new ProxyYieldPredictionModel("corn-yield-forecaster-v3");

		model.predict();

		model.predict();
	}
}
