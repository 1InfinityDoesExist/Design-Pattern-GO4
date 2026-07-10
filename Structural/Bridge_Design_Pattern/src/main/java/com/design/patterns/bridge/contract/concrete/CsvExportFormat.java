package com.design.patterns.bridge.contract.concrete;

import com.design.patterns.bridge.contract.IExportFormat;

public class CsvExportFormat implements IExportFormat {

	@Override
	public String render() {
		return "CSV";
	}
}
