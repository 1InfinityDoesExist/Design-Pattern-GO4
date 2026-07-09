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

		MessageSubscriberOne subscriberOne = new MessageSubscriberOne(publisher);
		MessageSubscriberTwo subscriberTwo = new MessageSubscriberTwo(publisher);

		publisher.setMsg("first message");

		publisher.detach(subscriberOne);

		publisher.setMsg("second message");
	}

}
