package com.design.patterns.factory;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.design.patterns.enums.DesignType;
import com.design.patterns.factory.contract.Shape;
import com.design.patterns.factory.contract.concret.Circle;

@Component
public class ShapeFactory {

	private final EnumMap<DesignType, Shape> shapeMap;
	private final Shape defaultShape;

	public ShapeFactory(List<? extends Shape> shapes, Circle circle) {
		this.defaultShape = Objects.requireNonNull(circle, "default circle must not be null");
		this.shapeMap = shapes.stream().collect(Collectors.toMap(Shape::getDesignType, Function.identity(), (a, b) -> b,
				() -> new EnumMap<>(DesignType.class)));
	}

	public Shape getShape(final DesignType designType) {
		return shapeMap.getOrDefault(designType, defaultShape);
	}
}
