package com.design.patterns.proxy;

import com.design.patterns.proxy.subject.Image;
import com.design.patterns.proxy.subject.proxy.ProxyImage;

public class ProxyDesignPattern {

	public static void main(String[] args) {
		System.out.println("Proxy Design Pattern");

		Image image = new ProxyImage("holiday-photo.png");

		// first call: proxy loads the real image lazily, then displays
		image.display();

		// second call: no reload — the proxy reuses the already-loaded subject
		image.display();
	}
}
