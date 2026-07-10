package com.design.patterns.factory.contract;

import com.design.patterns.enums.ContainerType;

public interface IParcelContainer {
	public ContainerType getContainerType();

	public void seal();

}
