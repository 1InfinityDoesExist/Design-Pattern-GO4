package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.factory.ShapeFactory;
import com.design.patterns.factory.concretFactory.Shape;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		ShapeFactory factory = new ShapeFactory();
		Shape shape = factory.getShape("Circle");
		shape.draw();

	}

}
