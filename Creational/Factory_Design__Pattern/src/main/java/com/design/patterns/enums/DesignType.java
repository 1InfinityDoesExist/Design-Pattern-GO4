package com.design.patterns.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DesignType {

	CIRCLE("CIRCLE"),

	TRIANGLE("TRIANGLE"),

	RECTANGLE("RECTANGLE");

	private String name;

	private DesignType(String name) {
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}
}
