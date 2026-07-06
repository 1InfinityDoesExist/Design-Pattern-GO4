package com.design.patterns.bridge.contract.concrets;

import com.design.patterns.bridge.contract.Color;

public class Blue implements Color {

	@Override
	public String fill() {
		return "Blue";
	}
}
