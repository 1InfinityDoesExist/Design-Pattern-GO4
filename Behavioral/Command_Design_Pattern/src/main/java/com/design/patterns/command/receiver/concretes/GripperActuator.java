package com.design.patterns.command.receiver.concretes;

import com.design.patterns.command.receiver.IActuator;

public class GripperActuator implements IActuator {

	@Override
	public void engage() {
		System.out.println("Gripper actuator is now engaged");
	}

	@Override
	public void disengage() {
		System.out.println("Gripper actuator is now disengaged");
	}

	public void gripPayload() {
		System.out.println("Jaws gripped around payload");
	}
}
