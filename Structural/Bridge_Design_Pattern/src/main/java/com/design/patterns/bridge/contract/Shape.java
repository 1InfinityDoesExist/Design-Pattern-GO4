package com.design.patterns.bridge.contract;

public abstract class Shape {

	protected final Color color;

	protected Shape(Color color) {
		this.color = color;
	}

	abstract public String draw();

}
