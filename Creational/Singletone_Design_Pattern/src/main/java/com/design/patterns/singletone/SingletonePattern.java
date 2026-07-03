package com.design.patterns.singletone;

import org.springframework.util.ObjectUtils;

public class SingletonePattern {

	private static volatile SingletonePattern instance;
	private static Object mutex = new Object();

	private SingletonePattern() {

	}

	public static SingletonePattern getInstnace() {
		SingletonePattern result = instance;
		if (ObjectUtils.isEmpty(result)) {
			synchronized (mutex) {
				result = instance;
				if (ObjectUtils.isEmpty(result)) {
					instance = result = new SingletonePattern();
				}
			}
		}
		return result;
	}

	public void msg() {
		System.out.println("Threadsafe singletone design pattern implemented");
	}

}
