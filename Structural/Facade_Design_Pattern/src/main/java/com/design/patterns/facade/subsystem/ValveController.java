package com.design.patterns.facade.subsystem;

public class ValveController {

	public void open() {
		System.out.println("-----Valve Controller Open");
	}

	public void close() {
		System.out.println("-----Valve Controller Closed");
	}

	public void increaseFlowRate() {
		System.out.println("-----Valve Controller Flow Increased");
	}
}
