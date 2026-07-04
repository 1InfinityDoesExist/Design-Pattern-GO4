package com.design.patterns.abstractfactory.factory;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.FurnitureType;

@Component
public class FurnitureFactoryProvider {

	private final EnumMap<FurnitureType, IFurnitureFactory> factoryMap;

	public FurnitureFactoryProvider(List<? extends IFurnitureFactory> factories) {
		this.factoryMap = factories.stream().collect(Collectors.toMap(IFurnitureFactory::getFurnitureType,
				Function.identity(), (a, b) -> b, () -> new EnumMap<>(FurnitureType.class)));
	}

	public IFurnitureFactory getFactory(final FurnitureType furnitureType) {
		return factoryMap.get(furnitureType);
	}
}
