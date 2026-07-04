package com.design.patterns.command;

import com.design.patterns.command.controller.Command;
import com.design.patterns.command.controller.concrets.AdjustVolumeCommand;
import com.design.patterns.command.controller.concrets.ChangeChannelCommand;
import com.design.patterns.command.controller.concrets.TurnOffCommand;
import com.design.patterns.command.controller.concrets.TurnOnCommand;
import com.design.patterns.command.invoker.RemoteControl;
import com.design.patterns.command.receiver.concrets.Stereo;
import com.design.patterns.command.receiver.concrets.TV;

public class CommandDesignPattern {

	public static void main(String[] args) {
		System.out.println("Command Design Pattern");

		TV tv = new TV();
		Stereo stereo = new Stereo();

		Command turnOnTV = new TurnOnCommand(tv);
		Command turnOffTV = new TurnOffCommand(tv);
		Command adjustVolume = new AdjustVolumeCommand(stereo);
		Command changeChannel = new ChangeChannelCommand(tv);

		RemoteControl remote = new RemoteControl();

		remote.setCommand(turnOnTV);
		remote.pressButton();

		remote.setCommand(adjustVolume);
		remote.pressButton();

		remote.setCommand(changeChannel);
		remote.pressButton();

		remote.setCommand(turnOffTV);
		remote.pressButton();
	}
}
