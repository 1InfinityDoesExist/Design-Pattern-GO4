package com.design.patterns.abstractfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.design.patterns.abstractfactory.enums.ExpeditionTerrain;
import com.design.patterns.abstractfactory.factory.ExpeditionGearFactoryProvider;
import com.design.patterns.abstractfactory.factory.IExpeditionGearFactory;

@SpringBootApplication
public class AbstractFactoryDesignPattern {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AbstractFactoryDesignPattern.class, args);

		ExpeditionGearFactoryProvider provider = context.getBean(ExpeditionGearFactoryProvider.class);

		IExpeditionGearFactory mountainGearFactory = provider.getFactory(ExpeditionTerrain.MOUNTAIN);
		mountainGearFactory.createTent().pitch();
		mountainGearFactory.createSleepingBag().unroll();

		IExpeditionGearFactory desertGearFactory = provider.getFactory(ExpeditionTerrain.DESERT);
		desertGearFactory.createTent().pitch();
		desertGearFactory.createSleepingBag().unroll();
	}
}
