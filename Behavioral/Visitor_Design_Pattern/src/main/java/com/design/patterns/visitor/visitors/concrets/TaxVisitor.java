package com.design.patterns.visitor.visitors.concrets;

import com.design.patterns.visitor.elements.concrets.ContractEmployee;
import com.design.patterns.visitor.elements.concrets.FullTimeEmployee;
import com.design.patterns.visitor.elements.concrets.InternEmployee;
import com.design.patterns.visitor.visitors.IEmployeeVisitors;

public class TaxVisitor implements IEmployeeVisitors {

	@Override
	public void visit(FullTimeEmployee employee) {
		System.out.println("Generating tax report for full-time employee.");
	}

	@Override
	public void visit(ContractEmployee employee) {
		System.out.println("Generating tax report for contract employee.");
	}

	@Override
	public void visit(InternEmployee internEmployee) {
		System.out.println("Generating tax report for intern employee.");
	}
}
