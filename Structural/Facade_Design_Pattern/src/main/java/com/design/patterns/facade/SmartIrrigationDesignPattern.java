package com.design.patterns.facade;

public class SmartIrrigationDesignPattern {

	public static void main(String[] args) {
		System.out.println("Facade Design Pattern");

		IrrigationFacade irrigationFacade = new IrrigationFacade();
		irrigationFacade.startWatering();
		irrigationFacade.stopWatering();
	}
}
