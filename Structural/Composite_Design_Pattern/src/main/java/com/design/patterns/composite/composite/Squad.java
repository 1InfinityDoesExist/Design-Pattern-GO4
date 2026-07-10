package com.design.patterns.composite.composite;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.composite.component.IUnit;

public class Squad implements IUnit {

	private final String squadName;
	private final List<IUnit> members = new ArrayList<>();

	public Squad(String squadName) {
		this.squadName = squadName;
	}

	public void add(IUnit unit) {
		members.add(unit);
	}

	public void remove(IUnit unit) {
		members.remove(unit);
	}

	@Override
	public void muster() {
		System.out.println("Squad : " + this.squadName);
		members.forEach(IUnit::muster);
	}
}
