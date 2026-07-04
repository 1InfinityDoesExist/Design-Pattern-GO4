package com.design.patterns.command.controller.concrets;

import com.design.patterns.command.controller.Command;
import com.design.patterns.command.receiver.concrets.TV;

public class ChangeChannelCommand implements Command {
	private TV tv;

	public ChangeChannelCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.changeChannel();
	}
}