package com.design.patterns.interpreter.expressions.terminal;

import com.design.patterns.interpreter.expressions.IExpression;

public class NumberExpression implements IExpression {

	private int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	@Override
	public int interpret() {
		return number;
	}

}
