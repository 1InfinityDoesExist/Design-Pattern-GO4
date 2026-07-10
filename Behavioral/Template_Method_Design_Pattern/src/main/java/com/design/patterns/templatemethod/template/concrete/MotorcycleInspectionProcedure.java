package com.design.patterns.templatemethod.template.concrete;

import com.design.patterns.templatemethod.template.AbstractInspectionProcedure;

public class MotorcycleInspectionProcedure extends AbstractInspectionProcedure {

	@Override
	public void checkSafetySystems() {
		System.out.println("Testing brake lights and horn");
	}

	@Override
	public void issueCertificate() {
		System.out.println("Issuing two-wheeler roadworthiness certificate");
	}
}
