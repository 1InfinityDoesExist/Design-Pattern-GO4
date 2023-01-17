package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.builderPattern.Customer;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		Customer customer = new Customer.CustomerBuilder().name("Avinash Patel").email("infinityDoesExist@gmail.com")
				.build();
		System.out.println(customer.getEmail());
		System.out.println(customer.getName());

	}

}
