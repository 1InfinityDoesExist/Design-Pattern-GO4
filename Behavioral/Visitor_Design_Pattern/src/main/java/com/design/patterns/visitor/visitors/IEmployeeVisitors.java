package com.design.patterns.visitor.visitors;

import com.design.patterns.visitor.elements.concrete.ContractEmployee;
import com.design.patterns.visitor.elements.concrete.FullTimeEmployee;
import com.design.patterns.visitor.elements.concrete.InternEmployee;

public interface IEmployeeVisitors {

	void visit(InternEmployee internEmployee);

	void visit(FullTimeEmployee fullTimeEmployee);

	void visit(ContractEmployee contractEmployee);

}
