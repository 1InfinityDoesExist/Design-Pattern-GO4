package com.design.patterns.abstractfactory.factory.concrete;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;
import com.design.patterns.abstractfactory.factory.IExpeditionGearFactory;
import com.design.patterns.abstractfactory.product.ISleepingBag;
import com.design.patterns.abstractfactory.product.ITent;
import com.design.patterns.abstractfactory.product.concrete.MountainSleepingBag;
import com.design.patterns.abstractfactory.product.concrete.MountainTent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MountainGearFactory implements IExpeditionGearFactory {

	private final MountainTent mountainTent;
	private final MountainSleepingBag mountainSleepingBag;

	@Override
	public ITent createTent() {
		return mountainTent;
	}

	@Override
	public ISleepingBag createSleepingBag() {
		return mountainSleepingBag;
	}

	@Override
	public ExpeditionTerrain getExpeditionTerrain() {
		return ExpeditionTerrain.MOUNTAIN;
	}
}
