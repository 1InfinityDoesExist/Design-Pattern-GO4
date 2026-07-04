package com.design.patterns.prototype;

import com.design.patterns.prototype.contract.concret.Circle;

public class PrototypeDesignPattern {

	public static void main(String[] args) {
		System.out.println("Prototype Design Pattern");

		Circle originalCircle = new Circle(10, "Black");

		Circle copyCircle = (Circle) originalCircle.clone();

		System.out.println(originalCircle);
		System.out.println(copyCircle);
	}
}
