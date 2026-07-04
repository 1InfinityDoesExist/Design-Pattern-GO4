package com.design.patterns.abstractfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.design.patterns.abstractfactory.enums.FurnitureType;
import com.design.patterns.abstractfactory.factory.FurnitureFactoryProvider;
import com.design.patterns.abstractfactory.factory.IFurnitureFactory;

@SpringBootApplication
public class AbstractFactoryDesignPattern {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AbstractFactoryDesignPattern.class, args);

		FurnitureFactoryProvider provider = context.getBean(FurnitureFactoryProvider.class);

		IFurnitureFactory officeFactory = provider.getFactory(FurnitureType.OFFICE);
		officeFactory.createChair().sitOn();
		officeFactory.createTable().use();

		IFurnitureFactory homeFactory = provider.getFactory(FurnitureType.HOME);
		homeFactory.createChair().sitOn();
		homeFactory.createTable().use();
	}
}
