package com.design.patterns.flyweight.contract.concret;

import org.springframework.stereotype.Component;

import com.design.patterns.flyweight.contract.Icon;
import com.design.patterns.flyweight.contract.enums.IConEmums;

@Component
public class FolderIcon implements Icon {

	@Override
	public void display() {
		System.out.println("----Displaying FolderIcon-----");
	}

	@Override
	public IConEmums getIConENEmums() {
		return IConEmums.RED;
	}
}
