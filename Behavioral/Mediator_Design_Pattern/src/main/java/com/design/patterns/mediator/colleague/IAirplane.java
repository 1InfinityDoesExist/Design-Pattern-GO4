package com.design.patterns.mediator.colleague;

public interface IAirplane {

	void requestTakeoff();

	void requestLanding();

	void notifyAirTrafficControl(String msg);

}
