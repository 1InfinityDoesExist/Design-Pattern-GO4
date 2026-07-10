package com.design.patterns.observer.concreteObserver;

import com.design.patterns.observer.IObserver;
import com.design.patterns.subject.concreteSubject.MessagePublisher;

public class MessageSubscriberTwo implements IObserver {

	private MessagePublisher observable;

	public MessageSubscriberTwo(MessagePublisher observable) {
		this.observable = observable;
		this.observable.attach(this);
	}

	@Override
	public void update() {
		System.out.println("SubscriberTwo received: " + this.observable.getMessage());
	}

}
