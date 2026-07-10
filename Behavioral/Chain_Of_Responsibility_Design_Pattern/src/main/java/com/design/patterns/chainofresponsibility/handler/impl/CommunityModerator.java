package com.design.patterns.chainofresponsibility.handler.impl;

import com.design.patterns.chainofresponsibility.handler.IModerationHandler;
import com.design.patterns.chainofresponsibility.report.Report;
import com.design.patterns.chainofresponsibility.report.Severity;

public class CommunityModerator implements IModerationHandler {

	private IModerationHandler nextHandler;

	@Override
	public void handleReport(Report report) {
		if (report.getSeverity() == Severity.MEDIUM) {
			System.out.println("Community moderator resolved the report.");
		} else if (nextHandler != null) {
			System.out.println("-----Escalating report to next moderator: " + nextHandler.getClass().getName());
			nextHandler.handleReport(report);
		}
	}

	@Override
	public void setNextHandler(IModerationHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
}
