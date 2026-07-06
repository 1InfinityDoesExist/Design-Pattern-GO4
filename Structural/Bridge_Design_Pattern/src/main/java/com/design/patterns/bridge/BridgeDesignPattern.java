package com.design.patterns.bridge;

import com.design.patterns.bridge.contract.Shape;
import com.design.patterns.bridge.contract.concrets.Red;
import com.design.patterns.bridge.contract.concrets.Triangle;

public class BridgeDesignPattern {

	public static void main(String[] args) {
		System.out.println("Bridge Design Pattern");

		Shape triangle = new Triangle(new Red());
		System.out.println(triangle.draw());
	}
}
