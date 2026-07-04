package com.design.patterns.abstractfactory.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FurnitureType {

	HOME("HOME"),

	OFFICE("OFFICE");

	private final String name;

	FurnitureType(final String name) {
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}
}
