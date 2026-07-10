package com.design.patterns.decorator.concreteDecorator;

import com.design.patterns.component.IShipment;
import com.design.patterns.decorator.AbstractShipmentDecorator;

public class ExpressHandlingDecorator extends AbstractShipmentDecorator {

	public ExpressHandlingDecorator(IShipment shipment) {
		super(shipment);
	}

	@Override
	public int getSurcharge() {
		return 25;
	}

	@Override
	public String getSurchargeLabel() {
		return "ExpressHandling";
	}

}
