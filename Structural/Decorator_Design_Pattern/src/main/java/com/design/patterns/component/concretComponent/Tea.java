package com.design.patterns.component.concretComponent;

import com.design.patterns.component.Beverage;

public class Tea extends Beverage {

	public Tea(String name) {
		super(name);
		setPrice(20);
	}

	@Override
	public void decorateBeverage() {
		System.out.println("The cost of " + name + ":" + price);
	}
}
