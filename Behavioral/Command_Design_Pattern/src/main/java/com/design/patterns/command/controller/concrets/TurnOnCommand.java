package com.design.patterns.command.controller.concrets;

import com.design.patterns.command.controller.Command;
import com.design.patterns.command.receiver.Device;

public class TurnOnCommand implements Command {
	private Device device;

	public TurnOnCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOn();
	}
}
