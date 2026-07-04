package com.design.patterns.strategy.concretStrategy;

import com.design.patterns.strategy.OperationStrategy;

public class DivisionOperationStrategy implements OperationStrategy {

	@Override
	public int doOperation(int x, int y) {
		return x / y;
	}
}
