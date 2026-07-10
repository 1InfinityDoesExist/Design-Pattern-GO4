package com.design.patterns.command.controller.concretes;

import com.design.patterns.command.controller.IActuatorCommand;
import com.design.patterns.command.receiver.IActuator;

public class DisengageActuatorCommand implements IActuatorCommand {
	private IActuator actuator;

	public DisengageActuatorCommand(IActuator actuator) {
		this.actuator = actuator;
	}

	@Override
	public void run() {
		actuator.disengage();
	}
}
