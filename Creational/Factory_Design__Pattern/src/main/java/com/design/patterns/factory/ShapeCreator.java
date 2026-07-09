package com.design.patterns.factory;

import com.design.patterns.factory.contract.Shape;

public abstract class ShapeCreator {

	public abstract Shape createShape();

	public void render() {
		Shape shape = createShape();
		shape.draw();
	}
}
