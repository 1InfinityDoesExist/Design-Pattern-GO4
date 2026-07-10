package com.design.patterns.adapter;

import com.design.patterns.adapter.adaptee.LegacyFahrenheitSensor;
import com.design.patterns.adapter.adapter.FahrenheitSensorAdapter;
import com.design.patterns.adapter.target.ICelsiusThermometer;

public class ThermometerAdapterDemo {

	public static void main(String[] args) {
		System.out.println("Adapter Design Pattern");

		ICelsiusThermometer thermometer = new FahrenheitSensorAdapter(new LegacyFahrenheitSensor());
		System.out.println("Celsius reading: " + thermometer.readCelsius());
	}
}
