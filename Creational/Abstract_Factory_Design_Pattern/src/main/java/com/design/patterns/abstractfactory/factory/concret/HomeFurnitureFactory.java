package com.design.patterns.abstractfactory.factory.concret;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.FurnitureType;
import com.design.patterns.abstractfactory.factory.IFurnitureFactory;
import com.design.patterns.abstractfactory.product.IChair;
import com.design.patterns.abstractfactory.product.ITable;
import com.design.patterns.abstractfactory.product.concret.HomeChair;
import com.design.patterns.abstractfactory.product.concret.HomeTable;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HomeFurnitureFactory implements IFurnitureFactory {

	private final HomeChair homeChair;
	private final HomeTable homeTable;

	@Override
	public IChair createChair() {
		return homeChair;
	}

	@Override
	public ITable createTable() {
		return homeTable;
	}

	@Override
	public FurnitureType getFurnitureType() {
		return FurnitureType.HOME;
	}
}
