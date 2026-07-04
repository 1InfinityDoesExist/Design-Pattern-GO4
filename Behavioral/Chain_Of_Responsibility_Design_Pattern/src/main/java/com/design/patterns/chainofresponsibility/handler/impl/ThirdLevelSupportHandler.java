package com.design.patterns.chainofresponsibility.handler.impl;

import com.design.patterns.chainofresponsibility.handler.ISupportHandler;
import com.design.patterns.chainofresponsibility.request.Priority;
import com.design.patterns.chainofresponsibility.request.Request;

public class ThirdLevelSupportHandler implements ISupportHandler {

	@Override
	public void handleRequest(Request request) {
		if (request.getPriority() == Priority.CRITICAL) {
			System.out.println("Level 3 Support handled the request.");
		} else {
			System.out.println("Request cannot be handled.");
		}

	}

	@Override
	public void setNextHandler(ISupportHandler iSupportHandler) {
	}
}
