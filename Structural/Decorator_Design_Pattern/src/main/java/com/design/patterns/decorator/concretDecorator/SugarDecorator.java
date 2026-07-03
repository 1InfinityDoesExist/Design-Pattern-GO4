package com.design.patterns.decorator.concretDecorator;

import com.design.patterns.component.Beverage;
import com.design.patterns.decorator.BeverageDecorator;

public class SugarDecorator extends BeverageDecorator {
	public SugarDecorator(Beverage beverage) {
		super(beverage);
	}

	public void decorateBeverage() {
		super.decorateBeverage();
		decorateSugar();
	}

	public void decorateSugar() {
		System.out.println("Added Sugar to:" + beverage.getName());
	}

	public int getIncrementPrice() {
		return 5;
	}

	public String getDecoratedName() {
		return "Sugar";
	}
}
