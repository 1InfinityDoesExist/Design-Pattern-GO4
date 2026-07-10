package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.component.IShipment;
import com.design.patterns.component.concreteComponent.DomesticParcel;
import com.design.patterns.component.concreteComponent.InternationalCrate;
import com.design.patterns.decorator.concreteDecorator.ExpressHandlingDecorator;
import com.design.patterns.decorator.concreteDecorator.InsuranceDecorator;

@SpringBootApplication
public class ShippingDesignPattern {

	public static void main(String[] args) {
		SpringApplication.run(ShippingDesignPattern.class, args);

		IShipment crateShipment = new ExpressHandlingDecorator(new InsuranceDecorator(new InternationalCrate("Machinery Crate")));
		crateShipment.process();

		IShipment parcelShipment = new ExpressHandlingDecorator(new InsuranceDecorator(new DomesticParcel("Book Parcel")));
		parcelShipment.process();
	}

}
