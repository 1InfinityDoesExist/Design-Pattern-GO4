package com.design.patterns.templatemethod;

import com.design.patterns.templatemethod.template.BeverageMaker;
import com.design.patterns.templatemethod.template.concrets.CoffeeMaker;
import com.design.patterns.templatemethod.template.concrets.TeaMaker;

public class TemplateMethodDesignPattern {

	public static void main(String[] args) {
		System.out.println("Template Method Design Pattern");

		System.out.println("-----Its time to make coffee.");
		BeverageMaker coffeeMaker = new CoffeeMaker();
		coffeeMaker.makeBeverage();
		System.out.println("-----Now its time to make tea.");

		BeverageMaker teaMaker = new TeaMaker();
		teaMaker.makeBeverage();
	}
}
