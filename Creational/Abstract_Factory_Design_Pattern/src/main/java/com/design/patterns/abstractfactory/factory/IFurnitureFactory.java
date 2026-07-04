package com.design.patterns.abstractfactory.factory;

import com.design.patterns.abstractfactory.enums.FurnitureType;
import com.design.patterns.abstractfactory.product.IChair;
import com.design.patterns.abstractfactory.product.ITable;

public interface IFurnitureFactory {

	FurnitureType getFurnitureType();

	IChair createChair();

	ITable createTable();
}
