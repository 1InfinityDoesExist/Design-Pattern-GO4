package com.design.patterns.bridge.contract;

public abstract class AbstractReport {

	protected final IExportFormat outputFormat;

	protected AbstractReport(IExportFormat outputFormat) {
		this.outputFormat = outputFormat;
	}

	abstract public String export();

}
