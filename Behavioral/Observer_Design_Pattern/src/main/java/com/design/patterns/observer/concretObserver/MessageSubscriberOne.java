package com.design.patterns.observer.concretObserver;

import com.design.patterns.observer.Observer;
import com.design.patterns.subject.concretSubject.MessagePublisher;

public class MessageSubscriberOne implements Observer {

	private MessagePublisher observable;

	public MessageSubscriberOne(MessagePublisher observable) {
		this.observable = observable;
		this.observable.attach(this);
	}

	@Override
	public void update() {
		System.out.println("SubscriberOne received: " + this.observable.getMsg());
	}

}
