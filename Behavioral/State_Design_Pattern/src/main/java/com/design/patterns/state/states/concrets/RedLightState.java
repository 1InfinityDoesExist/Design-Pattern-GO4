package com.design.patterns.state.states.concrets;

import com.design.patterns.state.context.TrafficLightContext;
import com.design.patterns.state.states.ITrafficLightState;

public class RedLightState implements ITrafficLightState {

	@Override
	public void handleRequest(TrafficLightContext trafficLightContext) {
		System.out.println("Red Light: Cars must stop.");
		trafficLightContext.setState(new GreenLightState());
	}
}
