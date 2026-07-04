package com.design.patterns.state.states.concrets;

import com.design.patterns.state.context.TrafficLightContext;
import com.design.patterns.state.states.ITrafficLightState;

public class GreenLightState implements ITrafficLightState {

	@Override
	public void handleRequest(TrafficLightContext trafficLightContext) {
		System.out.println("Green Light: Cars can go.");
		trafficLightContext.setState(new YellowLightState());
	}
}
