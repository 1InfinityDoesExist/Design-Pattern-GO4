package com.design.patterns.abstractfactory.product.concret;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.FurnitureType;
import com.design.patterns.abstractfactory.product.ITable;

@Component
public class HomeTable implements ITable {

	@Override
	public void use() {
		System.out.println("Using a home table!");
	}

	@Override
	public FurnitureType getFurnitureType() {
		return FurnitureType.HOME;
	}
}
