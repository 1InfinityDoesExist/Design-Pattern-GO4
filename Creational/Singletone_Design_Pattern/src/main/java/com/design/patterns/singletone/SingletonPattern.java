package com.design.patterns.singletone;

public class SingletonPattern {

	private static volatile SingletonPattern instance;
	private static final Object mutex = new Object();

	private SingletonPattern() {
	}

	public static SingletonPattern getInstance() {
		SingletonPattern result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null) {
					instance = result = new SingletonPattern();
				}
			}
		}
		return result;
	}

	public void msg() {
		System.out.println("Threadsafe singletone design pattern implemented");
	}
}
