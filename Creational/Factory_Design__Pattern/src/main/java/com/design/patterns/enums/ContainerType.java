package com.design.patterns.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContainerType {

	CARTON("CARTON"),

	MAILING_TUBE("MAILING_TUBE"),

	ENVELOPE("ENVELOPE");

	private String name;

	private ContainerType(String name) {
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}
}
