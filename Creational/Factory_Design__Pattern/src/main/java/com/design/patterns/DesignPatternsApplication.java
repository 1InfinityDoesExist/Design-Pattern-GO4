package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.design.patterns.enums.DesignType;
import com.design.patterns.factory.ShapeFactory;
import com.design.patterns.factory.contract.Shape;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DesignPatternsApplication.class, args);

		ShapeFactory shapeFactory = context.getBean(ShapeFactory.class);
		Shape shape = shapeFactory.getShape(DesignType.TRIANGLE);
		shape.draw();
	}

}