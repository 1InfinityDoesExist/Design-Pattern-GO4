package com.design.patterns.proxy.subject.proxy;

import com.design.patterns.proxy.subject.Image;
import com.design.patterns.proxy.subject.realsubject.RealImage;

public class ProxyImage implements Image {

	private final String fileName;
	private RealImage realImage;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("----Calling via proxy");
		// virtual proxy: the expensive RealImage is created only on first use
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
