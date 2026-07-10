package com.design.patterns.state.states;

import com.design.patterns.state.context.CombatContext;

public interface ICombatState {

	void handleTurn(CombatContext combatContext);

}
