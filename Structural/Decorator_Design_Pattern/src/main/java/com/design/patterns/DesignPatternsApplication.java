package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.component.Beverage;
import com.design.patterns.component.concretComponent.Coffee;
import com.design.patterns.component.concretComponent.Tea;
import com.design.patterns.decorator.concretDecorator.LemonDecorator;
import com.design.patterns.decorator.concretDecorator.SugarDecorator;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		Beverage tea = new SugarDecorator(new LemonDecorator(new Tea("Assam Tea")));
		tea.decorateBeverage();

		Beverage coffee = new SugarDecorator(new LemonDecorator(new Coffee("Cappuccino")));
		coffee.decorateBeverage();
	}

}
