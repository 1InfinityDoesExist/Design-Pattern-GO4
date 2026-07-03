package com.design.patterns.decorator;

import com.design.patterns.component.ICar;

public abstract class CarDecorator implements ICar {

	public ICar iCar;

	public CarDecorator(ICar _iCar) {
		// TODO Auto-generated constructor stub
		this.iCar = _iCar;
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		this.iCar.assemble();
	}

}
