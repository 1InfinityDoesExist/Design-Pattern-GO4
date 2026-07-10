package com.design.patterns.factory;

import com.design.patterns.factory.contract.IParcelContainer;

public abstract class AbstractContainerPacker {

	public abstract IParcelContainer packContainer();

	public void dispatch() {
		IParcelContainer container = packContainer();
		container.seal();
	}
}
