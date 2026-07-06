package com.design.patterns.composite.composite;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.composite.component.FileSystemComponent;

public class Directory implements FileSystemComponent {

	private String directoryName;
	List<FileSystemComponent> fileSystemComponents = new ArrayList<>();

	public Directory(String directoryName, List<FileSystemComponent> fileSystemComponents) {
		this.directoryName = directoryName;
		this.fileSystemComponents = fileSystemComponents;
	}

	@Override
	public void display() {
		System.out.println("Directory : " + this.directoryName);
		fileSystemComponents.stream().forEach(FileSystemComponent::display);
	}
}
