package com.design.patterns.command.controller.concretes;

import com.design.patterns.command.controller.IActuatorCommand;
import com.design.patterns.command.receiver.concretes.JointActuator;

public class MoveJointCommand implements IActuatorCommand {
	private JointActuator joint;

	public MoveJointCommand(JointActuator joint) {
		this.joint = joint;
	}

	@Override
	public void run() {
		joint.moveToNextWaypoint();
	}
}
