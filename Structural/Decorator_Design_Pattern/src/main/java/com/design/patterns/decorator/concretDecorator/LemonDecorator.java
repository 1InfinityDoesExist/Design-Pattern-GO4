package com.design.patterns.decorator.concretDecorator;

import com.design.patterns.component.Beverage;
import com.design.patterns.decorator.BeverageDecorator;

public class LemonDecorator extends BeverageDecorator {

	public LemonDecorator(Beverage beverage) {
		super(beverage);
	}

	@Override
	public int getIncrementPrice() {
		return 10;
	}

	@Override
	public String getDecoratedName() {
		return "Lemon";
	}

}
