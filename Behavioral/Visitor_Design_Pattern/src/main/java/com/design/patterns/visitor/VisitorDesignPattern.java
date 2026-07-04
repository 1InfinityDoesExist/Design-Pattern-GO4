package com.design.patterns.visitor;

import com.design.patterns.visitor.elements.IEmployeeElement;
import com.design.patterns.visitor.elements.concrets.InternEmployee;
import com.design.patterns.visitor.visitors.concrets.TaxVisitor;

public class VisitorDesignPattern {

	public static void main(String[] args) {
		System.out.println("Visitor Design Pattern");

		IEmployeeElement iternEmployee = new InternEmployee();
		iternEmployee.accept(new TaxVisitor());
	}
}
