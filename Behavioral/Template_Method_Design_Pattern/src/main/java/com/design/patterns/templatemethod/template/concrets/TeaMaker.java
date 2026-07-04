package com.design.patterns.templatemethod.template.concrets;

import com.design.patterns.templatemethod.template.BeverageMaker;

public class TeaMaker extends BeverageMaker {

	@Override
	public void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding lemon");
	}
}
