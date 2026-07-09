package com.design.patterns.bridge;

import com.design.patterns.bridge.contract.Shape;
import com.design.patterns.bridge.contract.concrets.Blue;
import com.design.patterns.bridge.contract.concrets.Circle;
import com.design.patterns.bridge.contract.concrets.Red;
import com.design.patterns.bridge.contract.concrets.Triangle;

public class BridgeDesignPattern {

	public static void main(String[] args) {
		System.out.println("Bridge Design Pattern");

		Shape[] shapes = { new Triangle(new Red()), new Triangle(new Blue()),
				new Circle(new Red()), new Circle(new Blue()) };

		for (Shape shape : shapes) {
			System.out.println(shape.draw());
		}
	}
}
