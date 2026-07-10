package com.design.patterns.bridge.contract.concrete;

import com.design.patterns.bridge.contract.IExportFormat;
import com.design.patterns.bridge.contract.AbstractReport;

public class DetailedReport extends AbstractReport {

	public DetailedReport(IExportFormat outputFormat) {
		super(outputFormat);
	}

	@Override
	public String export() {
		return "Detailed report exported as : " + outputFormat.render();
	}
}
