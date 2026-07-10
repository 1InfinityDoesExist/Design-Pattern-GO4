package com.design.patterns.bridge;

import com.design.patterns.bridge.contract.AbstractReport;
import com.design.patterns.bridge.contract.concrete.CsvExportFormat;
import com.design.patterns.bridge.contract.concrete.DetailedReport;
import com.design.patterns.bridge.contract.concrete.PdfExportFormat;
import com.design.patterns.bridge.contract.concrete.SummaryReport;

public class ReportExportBridgeDemo {

	public static void main(String[] args) {
		System.out.println("Bridge Design Pattern");

		AbstractReport[] reports = { new SummaryReport(new PdfExportFormat()), new SummaryReport(new CsvExportFormat()),
				new DetailedReport(new PdfExportFormat()), new DetailedReport(new CsvExportFormat()) };

		for (AbstractReport report : reports) {
			System.out.println(report.export());
		}
	}
}
