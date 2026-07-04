package com.design.patterns.factory.contract;

import com.design.patterns.enums.DesignType;

public interface Shape {
	public DesignType getDesignType();

	public void draw();

}
