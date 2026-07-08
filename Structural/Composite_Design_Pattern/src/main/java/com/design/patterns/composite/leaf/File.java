package com.design.patterns.composite.leaf;

import com.design.patterns.composite.component.FileSystemComponent;

public class File implements FileSystemComponent {

	private String name;
	private int size;

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public void display() {
		System.out.println("File : " + name + " with size : " + size);
	}
}
