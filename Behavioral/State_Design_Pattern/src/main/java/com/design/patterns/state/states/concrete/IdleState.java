package com.design.patterns.state.states.concrete;

import com.design.patterns.state.context.CombatContext;
import com.design.patterns.state.states.ICombatState;

public class IdleState implements ICombatState {

	@Override
	public void handleTurn(CombatContext combatContext) {
		System.out.println("Idle: The duelist watches for an opening.");
		combatContext.enterState(new AttackingState());
	}
}
