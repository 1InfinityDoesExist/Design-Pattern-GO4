package com.design.patterns.observer.concretObserver;

import com.design.patterns.observer.Observer;
import com.design.patterns.subject.concretSubject.MessagePublisher;

public class MessageSubscriberTwo implements Observer {

	private MessagePublisher observable;

	public MessageSubscriberTwo(MessagePublisher observable) {
		this.observable = observable;
		this.observable.attach(this);
	}

	@Override
	public void update() {
		System.out.println("SubscriberTwo received: " + this.observable.getMsg());
	}

}
