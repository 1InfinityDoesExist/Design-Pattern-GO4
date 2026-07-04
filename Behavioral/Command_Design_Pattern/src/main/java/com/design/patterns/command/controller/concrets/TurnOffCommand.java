package com.design.patterns.command.controller.concrets;

import com.design.patterns.command.controller.Command;
import com.design.patterns.command.receiver.Device;

public class TurnOffCommand implements Command {
	private Device device;

	public TurnOffCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOff();
	}
}
