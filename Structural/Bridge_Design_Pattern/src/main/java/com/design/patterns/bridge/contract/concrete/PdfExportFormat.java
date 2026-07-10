package com.design.patterns.bridge.contract.concrete;

import com.design.patterns.bridge.contract.IExportFormat;

public class PdfExportFormat implements IExportFormat {

	@Override
	public String render() {
		return "PDF";
	}
}
