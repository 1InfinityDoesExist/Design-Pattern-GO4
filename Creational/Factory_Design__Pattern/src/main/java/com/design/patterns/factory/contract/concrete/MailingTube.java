package com.design.patterns.factory.contract.concrete;

import org.springframework.stereotype.Component;

import com.design.patterns.enums.ContainerType;
import com.design.patterns.factory.contract.IParcelContainer;

@Component
public class MailingTube implements IParcelContainer {

	@Override
	public void seal() {
		System.out.println("Mailing tube sealed with end caps");
	}

	@Override
	public ContainerType getContainerType() {
		return ContainerType.MAILING_TUBE;
	}
}
