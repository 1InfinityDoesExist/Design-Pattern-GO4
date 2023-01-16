package com.design.patterns.observer.concretObserver;

import com.design.patterns.observer.Observer;
import com.design.patterns.subject.concretSubject.MessagePublisher;

public class MessageSubscriberOne implements Observer {

	private MessagePublisher observable;

	public MessageSubscriberOne(MessagePublisher _obserObservable) {
		this.observable = _obserObservable;
		this.observable.attach(this);
	}

	@Override
	public void update() {
		System.out.println(this.observable.getMsg());

	}

}
