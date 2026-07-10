package com.design.patterns.component.concreteComponent;

import com.design.patterns.component.IShipment;

public class DomesticParcel implements IShipment {

	private final String description;
	private final int cost;

	public DomesticParcel(String description) {
		this.description = description;
		this.cost = 40;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public void process() {
		System.out.println("The cost of " + description + ":" + cost);
	}

}
