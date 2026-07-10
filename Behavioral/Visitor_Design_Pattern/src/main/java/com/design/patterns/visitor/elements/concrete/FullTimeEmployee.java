package com.design.patterns.visitor.elements.concrete;

import com.design.patterns.visitor.elements.IEmployeeElement;
import com.design.patterns.visitor.visitors.IEmployeeVisitors;

public class FullTimeEmployee implements IEmployeeElement {

	@Override
	public void accept(IEmployeeVisitors visitor) {
		visitor.visit(this);
	}

}
