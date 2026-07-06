package com.design.patterns.mediator.mediator.concret;

import com.design.patterns.mediator.colleague.IAirplane;
import com.design.patterns.mediator.mediator.IAirTrafficControlTower;

public class AirportControlTower implements IAirTrafficControlTower {

	@Override
	public void requestTakeoff(IAirplane airplane) {
		airplane.notifyAirTrafficControl("Requesting takeoff clearance.");
	}

	@Override
	public void requestLanding(IAirplane airplane) {
		airplane.notifyAirTrafficControl("Requesting landing clearance.");
	}

}
