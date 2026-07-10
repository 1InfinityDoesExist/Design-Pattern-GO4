package com.design.patterns.decorator.concreteDecorator;

import com.design.patterns.component.IShipment;
import com.design.patterns.decorator.AbstractShipmentDecorator;

public class InsuranceDecorator extends AbstractShipmentDecorator {

	public InsuranceDecorator(IShipment shipment) {
		super(shipment);
	}

	@Override
	public int getSurcharge() {
		return 15;
	}

	@Override
	public String getSurchargeLabel() {
		return "Insurance";
	}

}
