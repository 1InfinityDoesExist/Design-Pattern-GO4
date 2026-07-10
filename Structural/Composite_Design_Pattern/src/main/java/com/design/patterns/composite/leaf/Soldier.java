package com.design.patterns.composite.leaf;

import com.design.patterns.composite.component.IUnit;

public class Soldier implements IUnit {

	private String callsign;
	private int firepower;

	public Soldier(String callsign, int firepower) {
		this.callsign = callsign;
		this.firepower = firepower;
	}

	@Override
	public void muster() {
		System.out.println("Soldier : " + callsign + " with firepower : " + firepower);
	}
}
