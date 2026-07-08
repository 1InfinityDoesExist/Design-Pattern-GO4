package com.design.patterns.subject.concretSubject;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.observer.Observer;
import com.design.patterns.subject.Observable;

public class MessagePublisher implements Observable {

	private List<Observer> observers = new ArrayList<>();

	private String msg;

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyUpdate() {
		observers.forEach(Observer::update);
	}

	public String getMsg() {
		return msg;
	}

	// a state change must push the news to every attached observer
	public void setMsg(String msg) {
		this.msg = msg;
		notifyUpdate();
	}
}
