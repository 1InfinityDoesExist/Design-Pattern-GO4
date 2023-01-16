package com.design.patterns.decorator.concretDecorator;

import com.design.patterns.component.ICar;
import com.design.patterns.decorator.CarDecorator;

public class SportsCarDecorator extends CarDecorator {

	public SportsCarDecorator(ICar _iCar) {
		super(_iCar);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		super.assemble();
		System.out.println("Adding features of sports car.");
	}

}
