package com.design.patterns.visitor;

import java.util.List;

import com.design.patterns.visitor.elements.IEmployeeElement;
import com.design.patterns.visitor.elements.concrete.ContractEmployee;
import com.design.patterns.visitor.elements.concrete.FullTimeEmployee;
import com.design.patterns.visitor.elements.concrete.InternEmployee;
import com.design.patterns.visitor.visitors.IEmployeeVisitors;
import com.design.patterns.visitor.visitors.concrete.PerformanceReportVisitor;
import com.design.patterns.visitor.visitors.concrete.TaxVisitor;

public class VisitorDesignPattern {

	public static void main(String[] args) {
		System.out.println("Visitor Design Pattern");

		List<IEmployeeElement> employees = List.of(new InternEmployee(), new FullTimeEmployee(),
				new ContractEmployee());

		for (IEmployeeVisitors visitor : List.of(new TaxVisitor(), new PerformanceReportVisitor())) {
			employees.forEach(employee -> employee.accept(visitor));
		}
	}
}
