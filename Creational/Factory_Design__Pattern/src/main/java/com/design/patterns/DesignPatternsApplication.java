package com.design.patterns;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.factory.ShapeCreator;
import com.design.patterns.factory.creators.CircleCreator;
import com.design.patterns.factory.creators.RectangleCreator;
import com.design.patterns.factory.creators.TriangleCreator;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		// the client codes against the Creator abstraction; each concrete
		// creator's factory method decides the concrete product
		List<ShapeCreator> creators = List.of(new CircleCreator(), new TriangleCreator(), new RectangleCreator());
		creators.forEach(ShapeCreator::render);
	}

}
