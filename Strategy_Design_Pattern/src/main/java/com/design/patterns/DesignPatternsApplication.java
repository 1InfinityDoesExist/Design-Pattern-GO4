package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.context.Calculator;
import com.design.patterns.strategy.concretStrategy.AdditionOperationStrategy;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		Calculator calculator = new Calculator(new AdditionOperationStrategy());
		int calculate = calculator.calculate(5, 20);
		System.out.println(calculate);

	}

}
