package com.design.patterns.factory.creators;

import com.design.patterns.factory.AbstractContainerPacker;
import com.design.patterns.factory.contract.IParcelContainer;
import com.design.patterns.factory.contract.concrete.MailingTube;

public class MailingTubePacker extends AbstractContainerPacker {

	@Override
	public IParcelContainer packContainer() {
		return new MailingTube();
	}
}
