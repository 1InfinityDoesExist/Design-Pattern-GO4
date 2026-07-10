package com.design.patterns.templatemethod.template;

public abstract class AbstractInspectionProcedure {

	public final void performInspection() {
		checkFluidLevels();
		checkSafetySystems();
		recordInspectionLog();
		issueCertificate();
	}

	public abstract void checkSafetySystems();

	public abstract void issueCertificate();

	void checkFluidLevels() {
		System.out.println("Checking engine oil and coolant levels");
	}

	void recordInspectionLog() {
		System.out.println("Recording inspection log entry");
	}
}
