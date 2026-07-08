package com.design.patterns.mediator;

import com.design.patterns.mediator.colleague.IAirplane;
import com.design.patterns.mediator.colleague.concret.CommercialAirplane;
import com.design.patterns.mediator.mediator.IAirTrafficControlTower;
import com.design.patterns.mediator.mediator.concret.AirportControlTower;

public class MediatorDesignPattern {

	public static void main(String[] args) {
		System.out.println("Mediator Design Pattern");

		IAirTrafficControlTower controlTower = new AirportControlTower();

		IAirplane flight101 = new CommercialAirplane("Flight-101", controlTower);
		IAirplane flight202 = new CommercialAirplane("Flight-202", controlTower);

		// airplanes never talk to each other directly — the tower coordinates
		flight101.requestTakeoff();
		flight202.requestLanding();
	}
}
