package com.design.patterns.subject;

import com.design.patterns.observer.IObserver;

public interface IObservable {
	public void attach(IObserver observer);

	public void detach(IObserver observer);

	public void notifyUpdate();

}
