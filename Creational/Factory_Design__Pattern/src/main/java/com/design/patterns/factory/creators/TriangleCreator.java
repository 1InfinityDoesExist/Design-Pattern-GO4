package com.design.patterns.factory.creators;

import com.design.patterns.factory.ShapeCreator;
import com.design.patterns.factory.contract.Shape;
import com.design.patterns.factory.contract.concret.Triangle;

public class TriangleCreator extends ShapeCreator {

	@Override
	public Shape createShape() {
		return new Triangle();
	}
}
