package com.design.patterns.factory.contract.concrete;

import org.springframework.stereotype.Component;

import com.design.patterns.enums.ContainerType;
import com.design.patterns.factory.contract.IParcelContainer;

@Component
public class Carton implements IParcelContainer {

	@Override
	public void seal() {
		System.out.println("Carton sealed with packing tape.");
	}

	@Override
	public ContainerType getContainerType() {
		return ContainerType.CARTON;
	}
}
