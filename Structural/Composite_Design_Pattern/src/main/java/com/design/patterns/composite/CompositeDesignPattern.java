package com.design.patterns.composite;

import com.design.patterns.composite.component.FileSystemComponent;
import com.design.patterns.composite.composite.Directory;
import com.design.patterns.composite.leaf.File;

public class CompositeDesignPattern {

	public static void main(String[] args) {
		System.out.println("Composite Design Pattern");

		Directory root = new Directory("root");
		root.add(new File("Image1.png", 1024));
		root.add(new File("Image2.png", 1024));

		Directory documents = new Directory("documents");
		documents.add(new File("resume.pdf", 2048));
		root.add(documents);

		FileSystemComponent fileSystem = root;
		fileSystem.display();
	}
}
