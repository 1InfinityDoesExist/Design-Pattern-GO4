package com.design.patterns.state.context;

import com.design.patterns.state.states.ICombatState;

public class CombatContext {

	private ICombatState currentCombatState;

	public void enterState(ICombatState currentCombatState) {
		this.currentCombatState = currentCombatState;
	}

	public void takeTurn() {
		currentCombatState.handleTurn(this);
	}
}
