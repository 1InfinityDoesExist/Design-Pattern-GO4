package com.design.patterns.factory;

import com.design.patterns.factory.contract.Shape;

/**
 * GoF Creator: declares the factory method; each concrete creator subclass
 * decides which ConcreteProduct to instantiate.
 */
public abstract class ShapeCreator {

	public abstract Shape createShape();

	// an operation written against the Product interface only —
	// it works for every shape any subclass ever decides to create
	public void render() {
		Shape shape = createShape();
		shape.draw();
	}
}
