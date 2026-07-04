package com.design.patterns.abstractfactory.factory.concret;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.FurnitureType;
import com.design.patterns.abstractfactory.factory.IFurnitureFactory;
import com.design.patterns.abstractfactory.product.IChair;
import com.design.patterns.abstractfactory.product.ITable;
import com.design.patterns.abstractfactory.product.concret.OfficeChair;
import com.design.patterns.abstractfactory.product.concret.OfficeTable;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OfficeFurnitureFactory implements IFurnitureFactory {

	private final OfficeChair officeChair;
	private final OfficeTable officeTable;

	@Override
	public IChair createChair() {
		return officeChair;
	}

	@Override
	public ITable createTable() {
		return officeTable;
	}

	@Override
	public FurnitureType getFurnitureType() {
		return FurnitureType.OFFICE;
	}
}
