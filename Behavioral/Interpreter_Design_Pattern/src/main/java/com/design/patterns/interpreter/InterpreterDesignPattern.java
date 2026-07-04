package com.design.patterns.interpreter;

import com.design.patterns.interpreter.context.Context;
import com.design.patterns.interpreter.expressions.IExpression;

public class InterpreterDesignPattern {

	public static void main(String[] args) {
		System.out.println("Interpreter Design Pattern");

		String inputExpression = "5 + 3 - 2";
		System.out.println("Evaluating Expression: " + inputExpression);

		Context context = new Context();
		IExpression expression = context.parseExpression(inputExpression);

		int result = expression.interpret();

		System.out.println("Result: " + result);
	}
}
