package com.design.patterns.state;

import com.design.patterns.state.context.CombatContext;
import com.design.patterns.state.states.concrete.IdleState;

public class StateDesignPattern {

	public static void main(String[] args) {
		System.out.println("State Design Pattern");

		CombatContext combatContext = new CombatContext();
		combatContext.enterState(new IdleState());

		combatContext.takeTurn();
		combatContext.takeTurn();
		combatContext.takeTurn();

	}
}
