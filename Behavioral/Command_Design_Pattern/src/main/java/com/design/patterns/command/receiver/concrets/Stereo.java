package com.design.patterns.command.receiver.concrets;

import com.design.patterns.command.receiver.Device;

public class Stereo implements Device {

	@Override
	public void turnOn() {
		System.out.println("Stereo is now on");
	}

	@Override
	public void turnOff() {
		System.out.println("Stereo is now off");
	}

	public void adjustVolume() {
		System.out.println("Volume adjusted");
	}
}
