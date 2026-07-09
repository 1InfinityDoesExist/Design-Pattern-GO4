package com.design.patterns.flyweight.contract.concret;

import com.design.patterns.flyweight.contract.Icon;

public class FolderIcon implements Icon {

	private final String color = "RED";

	@Override
	public void display(int x, int y) {
		System.out.println("----Drawing " + color + " FolderIcon at (" + x + "," + y + ")");
	}
}
