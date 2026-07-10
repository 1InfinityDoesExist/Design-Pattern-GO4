package com.design.patterns.abstractfactory.factory;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;
import com.design.patterns.abstractfactory.product.ISleepingBag;
import com.design.patterns.abstractfactory.product.ITent;

public interface IExpeditionGearFactory {

	ExpeditionTerrain getExpeditionTerrain();

	ITent createTent();

	ISleepingBag createSleepingBag();
}
