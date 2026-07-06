package com.design.patterns.mediator.colleague.concret;

import com.design.patterns.mediator.colleague.IAirplane;
import com.design.patterns.mediator.mediator.IAirTrafficControlTower;

public class CommercialAirplane implements IAirplane {

	private IAirTrafficControlTower iAirTrafficControlTower;

	public CommercialAirplane(IAirTrafficControlTower iAirTrafficControlTower) {
		this.iAirTrafficControlTower = iAirTrafficControlTower;
	}

	@Override
	public void requestTakeOff() {
		iAirTrafficControlTower.requestTakeoff(this);
	}

	@Override
	public void requestLanding() {
		iAirTrafficControlTower.requestLanding(this);
	}

	@Override
	public void notifyAirTrafficControl(String msg) {
		System.out.println("Commercial Airplane: " + msg);
	}
}
