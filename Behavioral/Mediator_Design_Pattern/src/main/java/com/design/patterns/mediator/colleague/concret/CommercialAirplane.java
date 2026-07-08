package com.design.patterns.mediator.colleague.concret;

import com.design.patterns.mediator.colleague.IAirplane;
import com.design.patterns.mediator.mediator.IAirTrafficControlTower;

public class CommercialAirplane implements IAirplane {

	private final String callSign;
	private final IAirTrafficControlTower tower;

	public CommercialAirplane(String callSign, IAirTrafficControlTower tower) {
		this.callSign = callSign;
		this.tower = tower;
		tower.register(this);
	}

	@Override
	public void requestTakeoff() {
		System.out.println(callSign + " -> Tower: requesting takeoff.");
		tower.requestTakeoff(this);
	}

	@Override
	public void requestLanding() {
		System.out.println(callSign + " -> Tower: requesting landing.");
		tower.requestLanding(this);
	}

	@Override
	public void notifyAirTrafficControl(String msg) {
		System.out.println("Tower -> " + callSign + ": " + msg);
	}
}
