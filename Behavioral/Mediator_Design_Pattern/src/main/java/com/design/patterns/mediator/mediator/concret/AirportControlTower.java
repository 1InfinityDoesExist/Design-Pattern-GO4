package com.design.patterns.mediator.mediator.concret;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.mediator.colleague.IAirplane;
import com.design.patterns.mediator.mediator.IAirTrafficControlTower;

public class AirportControlTower implements IAirTrafficControlTower {

	private final List<IAirplane> airplanes = new ArrayList<>();

	@Override
	public void register(IAirplane airplane) {
		airplanes.add(airplane);
	}

	@Override
	public void requestTakeoff(IAirplane airplane) {
		airplane.notifyAirTrafficControl("Takeoff clearance granted.");
		notifyOthers(airplane, "Hold position: another aircraft is taking off.");
	}

	@Override
	public void requestLanding(IAirplane airplane) {
		airplane.notifyAirTrafficControl("Landing clearance granted.");
		notifyOthers(airplane, "Stay clear of the runway: another aircraft is landing.");
	}

	private void notifyOthers(IAirplane requester, String msg) {
		airplanes.stream()
				.filter(other -> other != requester)
				.forEach(other -> other.notifyAirTrafficControl(msg));
	}

}
