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
		// TODO Auto-generated method stub
		observers.add(observer);

	}

	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyUpdate() {
		// TODO Auto-generated method stub
		observers.stream().forEach(observer -> {
			observer.update();
		});

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
