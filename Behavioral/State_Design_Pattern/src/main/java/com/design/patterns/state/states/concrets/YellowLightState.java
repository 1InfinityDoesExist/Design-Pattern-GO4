package com.design.patterns.state.states.concrets;

import com.design.patterns.state.context.TrafficLightContext;
import com.design.patterns.state.states.ITrafficLightState;

public class YellowLightState implements ITrafficLightState {

	@Override
	public void handleRequest(TrafficLightContext trafficLightContext) {
		System.out.println("Yellow Light: Cars must slow down to stop.");
		trafficLightContext.setState(new RedLightState());
	}

}
