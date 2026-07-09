package com.design.patterns.flyweight;

import com.design.patterns.flyweight.contract.Icon;
import com.design.patterns.flyweight.contract.enums.IconType;
import com.design.patterns.flyweight.factory.IconFactory;

public class FlyweightDesignPattern {

	public static void main(String[] args) {
		System.out.println("Flyweight Design Pattern");

		IconFactory iconFactory = new IconFactory();

		Icon file1 = iconFactory.getIcon(IconType.FILE);
		file1.display(10, 20);
		Icon file2 = iconFactory.getIcon(IconType.FILE);
		file2.display(30, 40);
		iconFactory.getIcon(IconType.FOLDER).display(50, 60);
		iconFactory.getIcon(IconType.FOLDER).display(70, 80);

		System.out.println("FILE flyweight reused (file1 == file2): " + (file1 == file2));
		System.out.println("Objects in pool for 4 placements: " + iconFactory.poolSize());
	}
}
