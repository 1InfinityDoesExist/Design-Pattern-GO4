package com.design.patterns.command.controller.concretes;

import com.design.patterns.command.controller.IActuatorCommand;
import com.design.patterns.command.receiver.concretes.GripperActuator;

public class GripPayloadCommand implements IActuatorCommand {

	private GripperActuator gripper;

	public GripPayloadCommand(GripperActuator gripper) {
		this.gripper = gripper;
	}

	@Override
	public void run() {
		gripper.gripPayload();
	}
}
