package com.design.patterns.prototype.contract.concret;

import com.design.patterns.prototype.contract.Shape;

public class Circle implements Shape {

	private int radius;
	private String color;

	public Circle(int radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	public int getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public Shape clone() {
		return new Circle(radius, color);
	}

	@Override
	public String toString() {
		return "Circle{radius=" + radius + ", color=" + color + "}";
	}
}
