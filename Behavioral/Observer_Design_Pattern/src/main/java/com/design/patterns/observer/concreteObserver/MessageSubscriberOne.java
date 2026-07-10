package com.design.patterns.observer.concreteObserver;

import com.design.patterns.observer.IObserver;
import com.design.patterns.subject.concreteSubject.MessagePublisher;

public class MessageSubscriberOne implements IObserver {

	private MessagePublisher observable;

	public MessageSubscriberOne(MessagePublisher observable) {
		this.observable = observable;
		this.observable.attach(this);
	}

	@Override
	public void update() {
		System.out.println("SubscriberOne received: " + this.observable.getMessage());
	}

}
