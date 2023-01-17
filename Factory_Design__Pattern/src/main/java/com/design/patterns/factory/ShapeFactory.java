package com.design.patterns.factory;

import com.design.patterns.factory.concretFactory.Circle;
import com.design.patterns.factory.concretFactory.Rectangle;
import com.design.patterns.factory.concretFactory.Shape;
import com.design.patterns.factory.concretFactory.Triangle;

public class ShapeFactory {
	public Shape getShape(String shape) {
		if (shape.equalsIgnoreCase("Circle")) {
			return new Circle();
		}
		if (shape.equalsIgnoreCase("Triangle")) {
			return new Triangle();
		} else {
			return new Rectangle();
		}
	}

}
