package com.design.patterns.chainofresponsibility.handler.impl;

import com.design.patterns.chainofresponsibility.handler.IModerationHandler;
import com.design.patterns.chainofresponsibility.report.Report;
import com.design.patterns.chainofresponsibility.report.Severity;

public class SeniorModerator implements IModerationHandler {

	@Override
	public void handleReport(Report report) {
		if (report.getSeverity() == Severity.HIGH) {
			System.out.println("Senior moderator resolved the report.");
		} else {
			System.out.println("Report could not be resolved by any moderator.");
		}

	}

	@Override
	public void setNextHandler(IModerationHandler nextHandler) {
	}
}
