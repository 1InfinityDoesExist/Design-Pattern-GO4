package com.design.patterns.flyweight.contract.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IConEmums {

	RED("RED"),

	BLUE("BLUE");

	private String color;

	IConEmums(String color) {
		this.color = color;
	}

	@JsonValue
	public String getColor() {
		return this.color;
	}
}
