package com.design.patterns.strategy.concreteStrategy;

import com.design.patterns.strategy.IOperationStrategy;

public class SubtractionOperationStrategy implements IOperationStrategy {

	@Override
	public int doOperation(int x, int y) {
		return x - y;
	}
}
