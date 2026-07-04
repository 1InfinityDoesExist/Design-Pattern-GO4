package com.design.patterns.factory.contract.concret;

import org.springframework.stereotype.Component;

import com.design.patterns.enums.DesignType;
import com.design.patterns.factory.contract.Shape;

@Component
public class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape is triangle");
	}

	@Override
	public DesignType getDesignType() {
		return DesignType.TRIANGLE;
	}
}
