package com.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.design.patterns.observer.concretObserver.MessageSubscriberOne;
import com.design.patterns.observer.concretObserver.MessageSubscriberTwo;
import com.design.patterns.subject.concretSubject.MessagePublisher;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);

		MessagePublisher publisher = new MessagePublisher();
		publisher.setMsg("---I am going to change-----");

		MessageSubscriberOne messageSubscriberOne = new MessageSubscriberOne(publisher);
		messageSubscriberOne.update();

		publisher.setMsg("-----Am i going to change------");
		MessageSubscriberTwo messageSubscriberTwo = new MessageSubscriberTwo(publisher);
		messageSubscriberTwo.update();
	}

}
