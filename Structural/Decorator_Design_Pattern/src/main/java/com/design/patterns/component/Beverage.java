package com.design.patterns.component;

import lombok.Data;

@Data
public abstract class Beverage {
	protected String name;
	protected int price;

	public Beverage() {
	}

	public Beverage(String name) {
		this.name = name;
	}

	public abstract void decorateBeverage();

}
