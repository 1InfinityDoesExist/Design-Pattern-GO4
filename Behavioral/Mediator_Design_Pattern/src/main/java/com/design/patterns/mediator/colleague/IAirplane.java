package com.design.patterns.mediator.colleague;

public interface IAirplane {

	void requestTakeOff();

	void requestLanding();

	void notifyAirTrafficControl(String msg);

}
