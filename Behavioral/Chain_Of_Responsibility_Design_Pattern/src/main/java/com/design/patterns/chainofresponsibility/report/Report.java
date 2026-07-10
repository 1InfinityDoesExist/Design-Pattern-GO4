package com.design.patterns.chainofresponsibility.report;

public class Report {
	private Severity severity;

	public Report(Severity severity) {
		this.severity = severity;
	}

	public Severity getSeverity() {
		return severity;
	}
}
