package com.design.patterns.abstractfactory.factory;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;

@Component
public class ExpeditionGearFactoryProvider {

	private final EnumMap<ExpeditionTerrain, IExpeditionGearFactory> factoryMap;

	public ExpeditionGearFactoryProvider(List<? extends IExpeditionGearFactory> factories) {
		this.factoryMap = factories.stream().collect(Collectors.toMap(IExpeditionGearFactory::getExpeditionTerrain,
				Function.identity(), (a, b) -> b, () -> new EnumMap<>(ExpeditionTerrain.class)));
	}

	public IExpeditionGearFactory getFactory(final ExpeditionTerrain expeditionTerrain) {
		return factoryMap.get(expeditionTerrain);
	}
}
