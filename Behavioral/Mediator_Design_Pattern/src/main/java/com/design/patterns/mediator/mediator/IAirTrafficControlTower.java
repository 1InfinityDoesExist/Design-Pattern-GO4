package com.design.patterns.mediator.mediator;

import com.design.patterns.mediator.colleague.IAirplane;

public interface IAirTrafficControlTower {

	void requestTakeoff(IAirplane airplane);

	void requestLanding(IAirplane airplane);

}
