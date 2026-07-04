package com.design.patterns.abstractfactory.product;

import com.design.patterns.abstractfactory.enums.FurnitureType;

public interface IChair {

	FurnitureType getFurnitureType();

	void sitOn();
}
