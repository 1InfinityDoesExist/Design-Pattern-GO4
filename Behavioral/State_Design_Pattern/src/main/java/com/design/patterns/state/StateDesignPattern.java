package com.design.patterns.state;

import com.design.patterns.state.context.TrafficLightContext;
import com.design.patterns.state.states.concrets.RedLightState;

public class StateDesignPattern {

	public static void main(String[] args) {
		System.out.println("State Design Pattern");

		TrafficLightContext context = new TrafficLightContext();
		context.setState(new RedLightState());

		context.request();
		context.request();
		context.request();

	}
}
