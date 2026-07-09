package com.design.patterns.decorator;

import com.design.patterns.component.Beverage;

public abstract class BeverageDecorator extends Beverage {

	protected final Beverage beverage;

	public BeverageDecorator(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getName() {
		return beverage.getName() + ":" + getDecoratedName();
	}

	@Override
	public int getPrice() {
		return beverage.getPrice() + getIncrementPrice();
	}

	@Override
	public void decorateBeverage() {
		beverage.decorateBeverage();
		System.out.println("Added " + getDecoratedName() + " to " + beverage.getName()
				+ " -> cost of " + getName() + ":" + getPrice());
	}

	public abstract int getIncrementPrice();

	public abstract String getDecoratedName();

}
