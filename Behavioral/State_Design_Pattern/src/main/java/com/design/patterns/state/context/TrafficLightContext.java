package com.design.patterns.state.context;

import com.design.patterns.state.states.ITrafficLightState;

public class TrafficLightContext {

	private ITrafficLightState nextITrafficLightState;

	public void setState(ITrafficLightState nextITrafficLightState) {
		this.nextITrafficLightState = nextITrafficLightState;
	}

	public void request() {
		nextITrafficLightState.handleRequest(this);
	}
}
