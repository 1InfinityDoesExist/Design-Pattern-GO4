package com.design.patterns.context;

import com.design.patterns.strategy.OperationStrategy;

public class Calculator {

	private OperationStrategy operationStrategy;

	public Calculator(OperationStrategy operationStrategy) {
		this.operationStrategy = operationStrategy;
	}

	public void setOperationStrategy(OperationStrategy operationStrategy) {
		this.operationStrategy = operationStrategy;
	}

	public int calculate(int x, int y) {
		return operationStrategy.doOperation(x, y);
	}

}
