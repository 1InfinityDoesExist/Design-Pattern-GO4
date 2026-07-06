package com.design.patterns.composite;

import java.util.List;

import com.design.patterns.composite.component.FileSystemComponent;
import com.design.patterns.composite.composite.Directory;
import com.design.patterns.composite.leaf.File;

public class CompositeDesignPattern {

	public static void main(String[] args) {
		System.out.println("Composite Design Pattern");

		FileSystemComponent file1 = new File("Image1.png", 1024);
		FileSystemComponent file2 = new File("Image2.png", 1024);

		Directory directory = new Directory("MyDirectory", List.of(file1, file2));
		directory.display();
	}
}
