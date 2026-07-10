package com.design.patterns.prototype.contract.concrete;

import com.design.patterns.prototype.contract.IEnemyUnit;

public class Marauder implements IEnemyUnit {

	private int armorRating;
	private String faction;

	public Marauder(int armorRating, String faction) {
		this.armorRating = armorRating;
		this.faction = faction;
	}

	public int getArmorRating() {
		return armorRating;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	@Override
	public IEnemyUnit cloneUnit() {
		return new Marauder(armorRating, faction);
	}

	@Override
	public String toString() {
		return "Marauder{armorRating=" + armorRating + ", faction=" + faction + "}";
	}
}
