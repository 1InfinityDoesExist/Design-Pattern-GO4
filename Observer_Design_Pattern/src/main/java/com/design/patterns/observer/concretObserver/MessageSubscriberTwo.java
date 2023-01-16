package com.design.patterns.observer.concretObserver;

import com.design.patterns.observer.Observer;
import com.design.patterns.subject.concretSubject.MessagePublisher;

public class MessageSubscriberTwo implements Observer {

	private MessagePublisher observable;

	public MessageSubscriberTwo(MessagePublisher _obserObservable) {
		this.observable = _obserObservable;
		this.observable.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.observable.getMsg());

	}

}
