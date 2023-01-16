package com.design.patterns.strategy.concretStrategy;

import com.design.patterns.strategy.OperationStrategy;

public class AdditionOperationStrategy implements OperationStrategy {

	@Override
	public int doOperation(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;

	}

}
