package com.design.patterns.abstractfactory.factory.concrete;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;
import com.design.patterns.abstractfactory.factory.IExpeditionGearFactory;
import com.design.patterns.abstractfactory.product.ISleepingBag;
import com.design.patterns.abstractfactory.product.ITent;
import com.design.patterns.abstractfactory.product.concrete.DesertSleepingBag;
import com.design.patterns.abstractfactory.product.concrete.DesertTent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DesertGearFactory implements IExpeditionGearFactory {

	private final DesertTent desertTent;
	private final DesertSleepingBag desertSleepingBag;

	@Override
	public ITent createTent() {
		return desertTent;
	}

	@Override
	public ISleepingBag createSleepingBag() {
		return desertSleepingBag;
	}

	@Override
	public ExpeditionTerrain getExpeditionTerrain() {
		return ExpeditionTerrain.DESERT;
	}
}
