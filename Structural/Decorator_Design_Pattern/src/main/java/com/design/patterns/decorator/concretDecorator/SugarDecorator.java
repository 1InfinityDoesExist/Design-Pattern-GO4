package com.design.patterns.decorator.concretDecorator;

import com.design.patterns.component.Beverage;
import com.design.patterns.decorator.BeverageDecorator;

public class SugarDecorator extends BeverageDecorator {

	public SugarDecorator(Beverage beverage) {
		super(beverage);
	}

	@Override
	public int getIncrementPrice() {
		return 5;
	}

	@Override
	public String getDecoratedName() {
		return "Sugar";
	}
}
