package com.design.patterns.subject.concreteSubject;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.observer.IObserver;
import com.design.patterns.subject.IObservable;

public class MessagePublisher implements IObservable {

	private List<IObserver> observers = new ArrayList<>();

	private String message;

	@Override
	public void attach(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyUpdate() {
		observers.forEach(IObserver::update);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		notifyUpdate();
	}
}
