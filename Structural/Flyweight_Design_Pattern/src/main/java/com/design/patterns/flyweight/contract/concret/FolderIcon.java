package com.design.patterns.flyweight.contract.concret;

import com.design.patterns.flyweight.contract.Icon;

public class FolderIcon implements Icon {

	// intrinsic state: shared by every placement of a folder icon
	private final String color = "RED";

	@Override
	public void display(int x, int y) {
		System.out.println("----Drawing " + color + " FolderIcon at (" + x + "," + y + ")");
	}
}
