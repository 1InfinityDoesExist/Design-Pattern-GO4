package com.design.patterns.visitor.elements;

import com.design.patterns.visitor.visitors.IEmployeeVisitors;

public interface IEmployeeElement {
	void accept(IEmployeeVisitors visitor);

}
