package com.design.patterns.prototype.contract.concret;

import com.design.patterns.prototype.contract.Shape;

public class Circle implements Shape {

	int radius;
	String color;

	public Circle(int radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	@Override
	public Shape clone() {
		return new Circle(radius, color);
	}
}
