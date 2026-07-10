package com.design.patterns.templatemethod;

import com.design.patterns.templatemethod.template.AbstractInspectionProcedure;
import com.design.patterns.templatemethod.template.concrete.CarInspectionProcedure;
import com.design.patterns.templatemethod.template.concrete.MotorcycleInspectionProcedure;

public class VehicleInspectionStation {

	public static void main(String[] args) {
		System.out.println("Template Method Design Pattern");

		System.out.println("-----Time to inspect the car.");
		AbstractInspectionProcedure carInspection = new CarInspectionProcedure();
		carInspection.performInspection();
		System.out.println("-----Now time to inspect the motorcycle.");

		AbstractInspectionProcedure motorcycleInspection = new MotorcycleInspectionProcedure();
		motorcycleInspection.performInspection();
	}
}
