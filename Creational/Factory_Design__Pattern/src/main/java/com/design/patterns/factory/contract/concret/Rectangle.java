package com.design.patterns.factory.contract.concret;

import org.springframework.stereotype.Component;

import com.design.patterns.enums.DesignType;
import com.design.patterns.factory.contract.Shape;

@Component
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape is rectangle");
	}

	@Override
	public DesignType getDesignType() {
		return DesignType.RECTANGLE;
	}
}
