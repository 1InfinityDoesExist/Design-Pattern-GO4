package com.design.patterns.abstractfactory.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ExpeditionTerrain {

	DESERT("DESERT"),

	MOUNTAIN("MOUNTAIN");

	private final String name;

	ExpeditionTerrain(final String name) {
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}
}
