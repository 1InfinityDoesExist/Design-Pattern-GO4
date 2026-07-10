package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.builder.Customer;

@SpringBootApplication
public class BuilderDesignPattern {

	public static void main(String[] args) {
		SpringApplication.run(BuilderDesignPattern.class, args);

		Customer customer = new Customer.CustomerBuilder().name("Avinash Patel").email("infinityDoesExist@gmail.com")
				.build();
		System.out.println(customer);

	}

}
