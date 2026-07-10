package com.design.patterns.templatemethod.template.concrete;

import com.design.patterns.templatemethod.template.AbstractInspectionProcedure;

public class CarInspectionProcedure extends AbstractInspectionProcedure {

	@Override
	public void checkSafetySystems() {
		System.out.println("Testing airbags, seatbelts and ABS");
	}

	@Override
	public void issueCertificate() {
		System.out.println("Issuing four-wheeler roadworthiness certificate");
	}
}
