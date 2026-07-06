package com.design.patterns.bridge.contract.concrets;

import com.design.patterns.bridge.contract.Color;
import com.design.patterns.bridge.contract.Shape;

public class Triangle extends Shape {

	public Triangle(Color color) {
		super(color);
	}

	@Override
	public String draw() {
		return "Triange shape with color : " + color.fill();
	}
}
