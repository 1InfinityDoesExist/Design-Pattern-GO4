package com.design.patterns.context;

import com.design.patterns.strategy.OperationStrategy;

public class Calculator {

	private OperationStrategy operationStrategy;

	public Calculator(OperationStrategy _operationStrategy) {
		this.operationStrategy = _operationStrategy;
	}

	public int calculate(int x, int y) {
		return operationStrategy.doOperation(x, y);
	}

}
