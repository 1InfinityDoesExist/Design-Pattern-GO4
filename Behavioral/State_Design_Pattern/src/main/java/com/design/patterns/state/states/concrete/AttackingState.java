package com.design.patterns.state.states.concrete;

import com.design.patterns.state.context.CombatContext;
import com.design.patterns.state.states.ICombatState;

public class AttackingState implements ICombatState {

	@Override
	public void handleTurn(CombatContext combatContext) {
		System.out.println("Attacking: The duelist strikes with a decisive blow.");
		combatContext.enterState(new StunnedState());
	}
}
