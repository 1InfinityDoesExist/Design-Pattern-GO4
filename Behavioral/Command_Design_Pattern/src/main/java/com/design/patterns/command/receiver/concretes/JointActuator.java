package com.design.patterns.command.receiver.concretes;

import com.design.patterns.command.receiver.IActuator;

public class JointActuator implements IActuator {

	@Override
	public void engage() {
		System.out.println("Joint actuator is now engaged");
	}

	@Override
	public void disengage() {
		System.out.println("Joint actuator is now disengaged");
	}

	public void moveToNextWaypoint() {
		System.out.println("Joint moved to next waypoint");
	}
}
