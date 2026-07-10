package com.design.patterns.facade.subsystem;

public class SoilMoistureSensor {

	public void activate() {
		System.out.println("-----Soil Moisture Sensor On");
	}

	public void deactivate() {
		System.out.println("-----Soil Moisture Sensor Off");
	}
}
