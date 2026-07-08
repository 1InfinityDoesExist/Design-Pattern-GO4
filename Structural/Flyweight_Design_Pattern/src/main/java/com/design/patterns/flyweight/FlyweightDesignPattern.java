package com.design.patterns.flyweight;

import java.util.List;

import com.design.patterns.flyweight.contract.Icon;
import com.design.patterns.flyweight.contract.concret.FileIcon;
import com.design.patterns.flyweight.contract.concret.FolderIcon;
import com.design.patterns.flyweight.contract.enums.IConEmums;
import com.design.patterns.flyweight.factory.IconFactory;

public class FlyweightDesignPattern {

	public static void main(String[] args) {
		System.out.println("Flyweight Design Pattern");

		List<Icon> icons = List.of(new FileIcon(), new FolderIcon());

		IconFactory iconFactory = new IconFactory(icons);
		iconFactory.getIcon(IConEmums.BLUE).display();
	}
}
