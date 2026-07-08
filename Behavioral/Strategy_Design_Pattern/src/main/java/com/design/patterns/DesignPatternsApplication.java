package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.context.Calculator;
import com.design.patterns.strategy.concretStrategy.AdditionOperationStrategy;
import com.design.patterns.strategy.concretStrategy.DivisionOperationStrategy;
import com.design.patterns.strategy.concretStrategy.MultiplicationOperationStrategy;
import com.design.patterns.strategy.concretStrategy.SubtractionOperationStrategy;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		Calculator calculator = new Calculator(new AdditionOperationStrategy());
		System.out.println("5 + 20 = " + calculator.calculate(5, 20));

		// same context, strategies swapped at runtime
		calculator.setOperationStrategy(new SubtractionOperationStrategy());
		System.out.println("20 - 5 = " + calculator.calculate(20, 5));

		calculator.setOperationStrategy(new MultiplicationOperationStrategy());
		System.out.println("5 * 20 = " + calculator.calculate(5, 20));

		calculator.setOperationStrategy(new DivisionOperationStrategy());
		System.out.println("20 / 5 = " + calculator.calculate(20, 5));
	}

}
