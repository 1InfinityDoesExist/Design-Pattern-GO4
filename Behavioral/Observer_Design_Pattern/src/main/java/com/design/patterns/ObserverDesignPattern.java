package com.design.patterns;

import com.design.patterns.observer.concreteObserver.MessageSubscriberOne;
import com.design.patterns.observer.concreteObserver.MessageSubscriberTwo;
import com.design.patterns.subject.concreteSubject.MessagePublisher;

public class ObserverDesignPattern {

	public static void main(String[] args) {
		MessagePublisher publisher = new MessagePublisher();

		MessageSubscriberOne subscriberOne = new MessageSubscriberOne(publisher);
		MessageSubscriberTwo subscriberTwo = new MessageSubscriberTwo(publisher);

		publisher.setMessage("first message");

		publisher.detach(subscriberOne);

		publisher.setMessage("second message");
	}

}
