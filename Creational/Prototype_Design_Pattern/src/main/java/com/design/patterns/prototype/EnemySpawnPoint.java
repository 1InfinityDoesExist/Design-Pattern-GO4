package com.design.patterns.prototype;

import com.design.patterns.prototype.contract.concrete.Marauder;

public class EnemySpawnPoint {

	public static void main(String[] args) {
		System.out.println("Dungeon Spawn Point");

		Marauder templateMarauder = new Marauder(45, "Crimson Horde");
		Marauder spawnedMarauder = (Marauder) templateMarauder.cloneUnit();

		System.out.println("Template : " + templateMarauder);
		System.out.println("Spawn    : " + spawnedMarauder);
		System.out.println("Distinct objects: " + (templateMarauder != spawnedMarauder));

		spawnedMarauder.setFaction("Ashfall Renegades");
		System.out.println("After the spawn defects:");
		System.out.println("Template : " + templateMarauder);
		System.out.println("Spawn    : " + spawnedMarauder);
	}
}
