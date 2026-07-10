package com.design.patterns.adapter.adapter;

import com.design.patterns.adapter.adaptee.LegacyFahrenheitSensor;
import com.design.patterns.adapter.target.ICelsiusThermometer;

public class FahrenheitSensorAdapter implements ICelsiusThermometer {

	private final LegacyFahrenheitSensor legacyFahrenheitSensor;

	public FahrenheitSensorAdapter(LegacyFahrenheitSensor legacyFahrenheitSensor) {
		this.legacyFahrenheitSensor = legacyFahrenheitSensor;
	}

	@Override
	public double readCelsius() {
		return (legacyFahrenheitSensor.takeFahrenheitReading() - 32) * 5 / 9;
	}
}
