package com.design.patterns.decorator;

import com.design.patterns.component.IShipment;

public abstract class AbstractShipmentDecorator implements IShipment {

	protected final IShipment shipment;

	public AbstractShipmentDecorator(IShipment shipment) {
		this.shipment = shipment;
	}

	@Override
	public String getDescription() {
		return shipment.getDescription() + ":" + getSurchargeLabel();
	}

	@Override
	public int getCost() {
		return shipment.getCost() + getSurcharge();
	}

	@Override
	public void process() {
		shipment.process();
		System.out.println("Added " + getSurchargeLabel() + " to " + shipment.getDescription()
				+ " -> cost of " + getDescription() + ":" + getCost());
	}

	public abstract int getSurcharge();

	public abstract String getSurchargeLabel();

}
