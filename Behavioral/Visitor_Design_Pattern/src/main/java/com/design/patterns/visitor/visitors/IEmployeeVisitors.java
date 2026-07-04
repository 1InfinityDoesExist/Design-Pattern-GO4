package com.design.patterns.visitor.visitors;

import com.design.patterns.visitor.elements.concrets.ContractEmployee;
import com.design.patterns.visitor.elements.concrets.FullTimeEmployee;
import com.design.patterns.visitor.elements.concrets.InternEmployee;

public interface IEmployeeVisitors {

	void visit(InternEmployee internEmployee);

	void visit(FullTimeEmployee fullTimeEmployee);

	void visit(ContractEmployee contractEmployee);

}
