package com.design.patterns.factory.contract.concrete;

import org.springframework.stereotype.Component;

import com.design.patterns.enums.ContainerType;
import com.design.patterns.factory.contract.IParcelContainer;

@Component
public class Envelope implements IParcelContainer {

	@Override
	public void seal() {
		System.out.println("Envelope sealed with adhesive flap");
	}

	@Override
	public ContainerType getContainerType() {
		return ContainerType.ENVELOPE;
	}
}
