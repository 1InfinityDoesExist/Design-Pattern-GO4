package com.design.patterns.mediator;

import com.design.patterns.mediator.colleague.IAirplane;
import com.design.patterns.mediator.colleague.concret.CommercialAirplane;
import com.design.patterns.mediator.mediator.IAirTrafficControlTower;
import com.design.patterns.mediator.mediator.concret.AirportControlTower;

public class MediatorDesignPattern {

	public static void main(String[] args) {
		System.out.println("Mediator Design Pattern");

		IAirTrafficControlTower controlTower = new AirportControlTower();

		IAirplane airplane1 = new CommercialAirplane(controlTower);
		IAirplane airplane2 = new CommercialAirplane(controlTower);

		airplane1.requestTakeOff();
		airplane2.requestLanding();

	}
}
