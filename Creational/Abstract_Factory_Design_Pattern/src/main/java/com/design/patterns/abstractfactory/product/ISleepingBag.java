package com.design.patterns.abstractfactory.product;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;

public interface ISleepingBag {

	ExpeditionTerrain getExpeditionTerrain();

	void unroll();
}
