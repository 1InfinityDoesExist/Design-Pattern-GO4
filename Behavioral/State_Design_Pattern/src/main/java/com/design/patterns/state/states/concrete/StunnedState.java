package com.design.patterns.state.states.concrete;

import com.design.patterns.state.context.CombatContext;
import com.design.patterns.state.states.ICombatState;

public class StunnedState implements ICombatState {

	@Override
	public void handleTurn(CombatContext combatContext) {
		System.out.println("Stunned: The duelist reels and cannot act.");
		combatContext.enterState(new IdleState());
	}

}
