package com.design.patterns.abstractfactory.product.concrete;

import org.springframework.stereotype.Component;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;
import com.design.patterns.abstractfactory.product.ITent;

@Component
public class DesertTent implements ITent {

	@Override
	public void pitch() {
		System.out.println("Pitching a desert tent!");
	}

	@Override
	public ExpeditionTerrain getExpeditionTerrain() {
		return ExpeditionTerrain.DESERT;
	}
}
