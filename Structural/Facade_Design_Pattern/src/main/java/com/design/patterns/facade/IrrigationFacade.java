package com.design.patterns.facade;

import com.design.patterns.facade.subsystem.SoilMoistureSensor;
import com.design.patterns.facade.subsystem.ValveController;

public class IrrigationFacade {

	private ValveController valveController;
	private SoilMoistureSensor soilMoistureSensor;

	public IrrigationFacade() {
		this.valveController = new ValveController();
		this.soilMoistureSensor = new SoilMoistureSensor();
	}

	public void startWatering() {
		valveController.open();
		soilMoistureSensor.activate();
		valveController.increaseFlowRate();
	}

	public void stopWatering() {
		valveController.close();
		soilMoistureSensor.deactivate();
	}
}
