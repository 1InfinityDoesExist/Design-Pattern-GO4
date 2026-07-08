package com.design.patterns.visitor;

import java.util.List;

import com.design.patterns.visitor.elements.IEmployeeElement;
import com.design.patterns.visitor.elements.concrets.ContractEmployee;
import com.design.patterns.visitor.elements.concrets.FullTimeEmployee;
import com.design.patterns.visitor.elements.concrets.InternEmployee;
import com.design.patterns.visitor.visitors.IEmployeeVisitors;
import com.design.patterns.visitor.visitors.concrets.PerformanceReportVisitor;
import com.design.patterns.visitor.visitors.concrets.TaxVisitor;

public class VisitorDesignPattern {

	public static void main(String[] args) {
		System.out.println("Visitor Design Pattern");

		List<IEmployeeElement> employees = List.of(new InternEmployee(), new FullTimeEmployee(),
				new ContractEmployee());

		// two operations over the same element structure — each visitor is
		// dispatched to the right overload via accept() (double dispatch)
		for (IEmployeeVisitors visitor : List.of(new TaxVisitor(), new PerformanceReportVisitor())) {
			employees.forEach(employee -> employee.accept(visitor));
		}
	}
}
