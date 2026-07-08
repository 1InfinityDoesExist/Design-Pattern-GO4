package com.design.patterns.composite.composite;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.composite.component.FileSystemComponent;

public class Directory implements FileSystemComponent {

	private final String directoryName;
	private final List<FileSystemComponent> children = new ArrayList<>();

	public Directory(String directoryName) {
		this.directoryName = directoryName;
	}

	public void add(FileSystemComponent component) {
		children.add(component);
	}

	public void remove(FileSystemComponent component) {
		children.remove(component);
	}

	@Override
	public void display() {
		System.out.println("Directory : " + this.directoryName);
		children.forEach(FileSystemComponent::display);
	}
}
