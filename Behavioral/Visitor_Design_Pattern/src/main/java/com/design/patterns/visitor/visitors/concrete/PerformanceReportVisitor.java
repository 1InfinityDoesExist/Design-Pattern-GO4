package com.design.patterns.visitor.visitors.concrete;

import com.design.patterns.visitor.elements.concrete.ContractEmployee;
import com.design.patterns.visitor.elements.concrete.FullTimeEmployee;
import com.design.patterns.visitor.elements.concrete.InternEmployee;
import com.design.patterns.visitor.visitors.IEmployeeVisitors;

public class PerformanceReportVisitor implements IEmployeeVisitors {

	@Override
	public void visit(FullTimeEmployee employee) {
		System.out.println("Generating performance report for full-time employee.");
	}

	@Override
	public void visit(ContractEmployee employee) {
		System.out.println("Generating performance report for contract employee.");
	}

	@Override
	public void visit(InternEmployee internEmployee) {
		System.out.println("Generating performance report for intern employee.");
	}
}
