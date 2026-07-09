package com.design.patterns.command.invoker;

import com.design.patterns.command.controller.Command;

public class RemoteControl {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		if (command != null) {
			command.execute();
		} else {
			System.out.println("No command assigned");
		}
	}
}
