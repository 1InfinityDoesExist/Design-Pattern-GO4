package com.design.patterns.decorator;

import com.design.patterns.component.Beverage;

public abstract class BeverageDecorator extends Beverage {

	protected Beverage beverage;

	public BeverageDecorator(Beverage _beverage) {
		this.beverage = _beverage;
		setName(beverage.getName() + ":" + getDecoratedName());
		setPrice(beverage.getPrice() + getIncrementPrice());
	}

	@Override
	public void decorateBeverage() {
		System.out.println("Cost of " + name + ":" + price);

	}

	public abstract int getIncrementPrice();

	public abstract String getDecoratedName();

}
