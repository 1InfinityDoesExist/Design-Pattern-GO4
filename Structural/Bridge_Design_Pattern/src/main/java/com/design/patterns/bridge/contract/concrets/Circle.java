package com.design.patterns.bridge.contract.concrets;

import com.design.patterns.bridge.contract.Color;
import com.design.patterns.bridge.contract.Shape;

public class Circle extends Shape {

	public Circle(Color color) {
		super(color);
	}

	@Override
	public String draw() {
		return "Circle shape with color : " + color.fill();
	}
}
