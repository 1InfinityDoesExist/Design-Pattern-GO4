package com.design.patterns.chainofresponsibility.handler;

import com.design.patterns.chainofresponsibility.request.Request;

public interface ISupportHandler {

	void handleRequest(Request request);

	void setNextHandler(ISupportHandler iSupportHandler);

}
