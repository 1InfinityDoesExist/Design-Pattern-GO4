package com.design.patterns.abstractfactory.product.concret;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.FurnitureType;
import com.design.patterns.abstractfactory.product.IChair;

@Component
public class HomeChair implements IChair {

	@Override
	public void sitOn() {
		System.out.println("Sitting on a home chair!");
	}

	@Override
	public FurnitureType getFurnitureType() {
		return FurnitureType.HOME;
	}
}
