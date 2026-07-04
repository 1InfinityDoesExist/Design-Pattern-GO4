package com.design.patterns.state.states;

import com.design.patterns.state.context.TrafficLightContext;

public interface ITrafficLightState {

	void handleRequest(TrafficLightContext trafficLightContext);

}
