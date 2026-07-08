package com.design.patterns.interpreter.expressions.nonterminal;

import com.design.patterns.interpreter.expressions.IExpression;

public class SubtractExpression implements IExpression {

	private IExpression leftExpression;
	private IExpression rightExpression;

	public SubtractExpression(IExpression leftExpression, IExpression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() - rightExpression.interpret();
	}
}
