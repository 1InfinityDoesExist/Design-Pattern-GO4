package com.design.patterns.chainofresponsibility;

import com.design.patterns.chainofresponsibility.handler.impl.FirstLevelSupportHandler;
import com.design.patterns.chainofresponsibility.handler.impl.SecondLevelSupportHandler;
import com.design.patterns.chainofresponsibility.handler.impl.ThirdLevelSupportHandler;
import com.design.patterns.chainofresponsibility.request.Priority;
import com.design.patterns.chainofresponsibility.request.Request;

public class ChainOfResponsibilityDesignPattern {

	public static void main(String[] args) {
		System.out.println("Chain Of Responsibility Design Pattern");

		FirstLevelSupportHandler firstLevelSupportHandler = new FirstLevelSupportHandler();
		SecondLevelSupportHandler secondLevelSupportHandler = new SecondLevelSupportHandler();
		ThirdLevelSupportHandler thirdLevelSupportHandler = new ThirdLevelSupportHandler();

		firstLevelSupportHandler.setNextHandler(secondLevelSupportHandler);
		secondLevelSupportHandler.setNextHandler(thirdLevelSupportHandler);

		firstLevelSupportHandler.handleRequest(new Request(Priority.CRITICAL));
	}
}
