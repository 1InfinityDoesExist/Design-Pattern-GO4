package com.design.patterns.command.controller.concretes;

import com.design.patterns.command.controller.IActuatorCommand;
import com.design.patterns.command.receiver.IActuator;

public class EngageActuatorCommand implements IActuatorCommand {
	private IActuator actuator;

	public EngageActuatorCommand(IActuator actuator) {
		this.actuator = actuator;
	}

	@Override
	public void run() {
		actuator.engage();
	}
}
