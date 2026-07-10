package com.design.patterns.abstractfactory.product.concrete;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;
import com.design.patterns.abstractfactory.product.ISleepingBag;

@Component
public class MountainSleepingBag implements ISleepingBag {

	@Override
	public void unroll() {
		System.out.println("Unrolling a mountain sleeping bag!");
	}

	@Override
	public ExpeditionTerrain getExpeditionTerrain() {
		return ExpeditionTerrain.MOUNTAIN;
	}
}
