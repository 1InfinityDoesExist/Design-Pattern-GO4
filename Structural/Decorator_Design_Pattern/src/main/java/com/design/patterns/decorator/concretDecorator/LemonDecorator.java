package com.design.patterns.decorator.concretDecorator;

import com.design.patterns.component.Beverage;
import com.design.patterns.decorator.BeverageDecorator;

public class LemonDecorator extends BeverageDecorator {

	public LemonDecorator(Beverage _beverage) {
		super(_beverage);
	}

	@Override
	public void decorateBeverage() {
		super.decorateBeverage();
		decorateLemon();
	}

	public void decorateLemon() {
		System.out.println("Added Lemon to:" + beverage.getName());
	}

	@Override
	public int getIncrementPrice() {
		return 10;
	}

	@Override
	public String getDecoratedName() {
		return "lemon";
	}

}
