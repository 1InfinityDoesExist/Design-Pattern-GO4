package com.design.patterns.composite;

import com.design.patterns.composite.component.IUnit;
import com.design.patterns.composite.composite.Squad;
import com.design.patterns.composite.leaf.Soldier;

public class BattleFormationDesignPattern {

	public static void main(String[] args) {
		System.out.println("Composite Design Pattern");

		Squad alphaCommand = new Squad("Alpha Command");
		alphaCommand.add(new Soldier("Rook", 120));
		alphaCommand.add(new Soldier("Talon", 95));

		Squad reconTeam = new Squad("Recon Team");
		reconTeam.add(new Soldier("Scout-7", 60));
		alphaCommand.add(reconTeam);

		IUnit formation = alphaCommand;
		formation.muster();
	}
}
