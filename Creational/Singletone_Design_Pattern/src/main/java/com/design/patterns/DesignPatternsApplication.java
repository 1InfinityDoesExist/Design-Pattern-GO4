package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.singletone.SingletonPattern;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		SingletonPattern first = SingletonPattern.getInstance();
		SingletonPattern second = SingletonPattern.getInstance();

		first.msg();
		System.out.println("Both references point to the same instance: " + (first == second));
	}
}
