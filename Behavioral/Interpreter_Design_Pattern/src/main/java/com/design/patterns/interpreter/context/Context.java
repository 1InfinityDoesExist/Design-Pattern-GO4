package com.design.patterns.interpreter.context;

import com.design.patterns.interpreter.expressions.IExpression;
import com.design.patterns.interpreter.expressions.nonterminal.AddExpression;
import com.design.patterns.interpreter.expressions.nonterminal.SubtractExpression;
import com.design.patterns.interpreter.expressions.terminal.NumberExpression;

public class Context {

	public IExpression parseExpression(String expression) {
		String[] tokens = expression.split(" ");
		IExpression result = new NumberExpression(Integer.parseInt(tokens[0]));
		for (int i = 1; i < tokens.length - 1; i += 2) {
			String operator = tokens[i];
			IExpression right = new NumberExpression(Integer.parseInt(tokens[i + 1]));
			if (operator.equals("+")) {
				result = new AddExpression(result, right);
			} else if (operator.equals("-")) {
				result = new SubtractExpression(result, right);
			} else {
				throw new IllegalArgumentException("Unsupported operator: " + operator);
			}
		}
		return result;
	}
}
