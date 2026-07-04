package com.design.patterns.chainofresponsibility.handler.impl;

import com.design.patterns.chainofresponsibility.handler.ISupportHandler;
import com.design.patterns.chainofresponsibility.request.Priority;
import com.design.patterns.chainofresponsibility.request.Request;

public class SecondLevelSupportHandler implements ISupportHandler {

	private ISupportHandler nextSupportHandler;

	@Override
	public void handleRequest(Request request) {
		if (request.getPriority() == Priority.INTERMEDIATE) {
			System.out.println("Level 2 Support handled the request.");
		} else if (nextSupportHandler != null) {
			System.out.println("-----Calling next handler ie." + nextSupportHandler.getClass().getName());
			nextSupportHandler.handleRequest(request);
		}
	}

	@Override
	public void setNextHandler(ISupportHandler nextSupportHandler) {
		this.nextSupportHandler = nextSupportHandler;
	}
}
