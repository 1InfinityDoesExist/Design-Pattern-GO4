package com.design.patterns.subject;

import com.design.patterns.observer.Observer;

public interface Observable {
	public void attach(Observer observer);

	public void detach(Observer observer);

	public void notifyUpdate();

}
