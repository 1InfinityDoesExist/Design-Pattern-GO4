package com.design.patterns.factory.creators;

import com.design.patterns.factory.AbstractContainerPacker;
import com.design.patterns.factory.contract.IParcelContainer;
import com.design.patterns.factory.contract.concrete.Envelope;

public class EnvelopePacker extends AbstractContainerPacker {

	@Override
	public IParcelContainer packContainer() {
		return new Envelope();
	}
}
