package com.design.patterns.component.concretComponent;

import com.design.patterns.component.Beverage;

public class Coffee extends Beverage {

	public Coffee(String name) {
		super(name);
		setPrice(50);
	}

	@Override
	public void decorateBeverage() {
		// TODO Auto-generated method stub
		System.out.println("The cost of " + name + ":" + price);
	}

}
