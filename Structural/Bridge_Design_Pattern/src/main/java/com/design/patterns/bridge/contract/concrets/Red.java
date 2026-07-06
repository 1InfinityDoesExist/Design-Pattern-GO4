package com.design.patterns.bridge.contract.concrets;

import com.design.patterns.bridge.contract.Color;

public class Red implements Color {

	@Override
	public String fill() {
		return "RED";
	}
}
