package com.design.patterns.flyweight.contract.concret;

import com.design.patterns.flyweight.contract.Icon;

public class FileIcon implements Icon {

	// intrinsic state: shared by every placement of a file icon
	private final String color = "BLUE";

	@Override
	public void display(int x, int y) {
		System.out.println("----Drawing " + color + " FileIcon at (" + x + "," + y + ")");
	}
}
