package com.design.patterns.proxy.subject.realsubject;

import com.design.patterns.proxy.subject.Image;

public class RealImage implements Image {

	private final String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk();
	}

	private void loadFromDisk() {
		System.out.println("-----Loading image from disk: " + fileName);
	}

	@Override
	public void display() {
		System.out.println("-----Displaying real image: " + fileName);
	}
}
