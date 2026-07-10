package com.design.patterns;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.factory.AbstractContainerPacker;
import com.design.patterns.factory.creators.CartonPacker;
import com.design.patterns.factory.creators.EnvelopePacker;
import com.design.patterns.factory.creators.MailingTubePacker;

@SpringBootApplication
public class PackagingLineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagingLineApplication.class, args);

		List<AbstractContainerPacker> packers = List.of(new CartonPacker(), new MailingTubePacker(), new EnvelopePacker());
		packers.forEach(AbstractContainerPacker::dispatch);
	}

}
