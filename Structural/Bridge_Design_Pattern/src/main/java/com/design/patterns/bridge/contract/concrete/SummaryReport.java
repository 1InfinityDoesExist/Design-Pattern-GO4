package com.design.patterns.bridge.contract.concrete;

import com.design.patterns.bridge.contract.IExportFormat;
import com.design.patterns.bridge.contract.AbstractReport;

public class SummaryReport extends AbstractReport {

	public SummaryReport(IExportFormat outputFormat) {
		super(outputFormat);
	}

	@Override
	public String export() {
		return "Summary report exported as : " + outputFormat.render();
	}
}
