package com.design.patterns.decorator.concretDecorator;

import com.design.patterns.component.Beverage;
import com.design.patterns.decorator.BeverageDecorator;

public class LemonDecorator extends BeverageDecorator {

	public LemonDecorator(Beverage _beverage) {
		super(_beverage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decorateBeverage() {
		// TODO Auto-generated method stub
		super.decorateBeverage();
		decorateLemon();
	}

	public void decorateLemon() {
		System.out.println("Added Lemon to:" + beverage.getName());
	}

	@Override
	public int getIncrementPrice() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public String getDecoratedName() {
		// TODO Auto-generated method stub
		return "lemon";
	}

}
