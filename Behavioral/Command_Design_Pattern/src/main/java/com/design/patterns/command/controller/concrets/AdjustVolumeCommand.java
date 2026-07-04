package com.design.patterns.command.controller.concrets;

import com.design.patterns.command.controller.Command;
import com.design.patterns.command.receiver.concrets.Stereo;

public class AdjustVolumeCommand implements Command {

	private Stereo stereo;

	public AdjustVolumeCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.adjustVolume();
	}
}