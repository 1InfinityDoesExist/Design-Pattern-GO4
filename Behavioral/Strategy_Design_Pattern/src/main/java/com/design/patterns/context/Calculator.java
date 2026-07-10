package com.design.patterns.context;

import com.design.patterns.strategy.IOperationStrategy;

public class Calculator {

	private IOperationStrategy operationStrategy;

	public Calculator(IOperationStrategy operationStrategy) {
		this.operationStrategy = operationStrategy;
	}

	public void setOperationStrategy(IOperationStrategy operationStrategy) {
		this.operationStrategy = operationStrategy;
	}

	public int calculate(int x, int y) {
		return operationStrategy.doOperation(x, y);
	}

}
