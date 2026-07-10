package com.design.patterns.factory.creators;

import com.design.patterns.factory.AbstractContainerPacker;
import com.design.patterns.factory.contract.IParcelContainer;
import com.design.patterns.factory.contract.concrete.Carton;

public class CartonPacker extends AbstractContainerPacker {

	@Override
	public IParcelContainer packContainer() {
		return new Carton();
	}
}
