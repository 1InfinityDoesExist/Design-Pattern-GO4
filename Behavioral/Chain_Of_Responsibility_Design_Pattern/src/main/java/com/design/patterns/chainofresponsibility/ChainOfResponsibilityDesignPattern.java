package com.design.patterns.chainofresponsibility;

import com.design.patterns.chainofresponsibility.handler.impl.AutoFilterModerator;
import com.design.patterns.chainofresponsibility.handler.impl.CommunityModerator;
import com.design.patterns.chainofresponsibility.handler.impl.SeniorModerator;
import com.design.patterns.chainofresponsibility.report.Report;
import com.design.patterns.chainofresponsibility.report.Severity;

public class ChainOfResponsibilityDesignPattern {

	public static void main(String[] args) {
		System.out.println("Chain Of Responsibility Design Pattern");

		AutoFilterModerator autoFilterModerator = new AutoFilterModerator();
		CommunityModerator communityModerator = new CommunityModerator();
		SeniorModerator seniorModerator = new SeniorModerator();

		autoFilterModerator.setNextHandler(communityModerator);
		communityModerator.setNextHandler(seniorModerator);

		System.out.println("-- LOW severity report --");
		autoFilterModerator.handleReport(new Report(Severity.LOW));

		System.out.println("-- MEDIUM severity report --");
		autoFilterModerator.handleReport(new Report(Severity.MEDIUM));

		System.out.println("-- HIGH severity report --");
		autoFilterModerator.handleReport(new Report(Severity.HIGH));
	}
}
