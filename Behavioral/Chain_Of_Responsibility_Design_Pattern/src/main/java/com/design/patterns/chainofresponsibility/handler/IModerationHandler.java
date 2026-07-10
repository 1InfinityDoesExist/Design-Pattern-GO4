package com.design.patterns.chainofresponsibility.handler;

import com.design.patterns.chainofresponsibility.report.Report;

public interface IModerationHandler {

	void handleReport(Report report);

	void setNextHandler(IModerationHandler nextHandler);

}
