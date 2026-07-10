package com.design.patterns.abstractfactory.product;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;

public interface ITent {

	ExpeditionTerrain getExpeditionTerrain();

	void pitch();
}
