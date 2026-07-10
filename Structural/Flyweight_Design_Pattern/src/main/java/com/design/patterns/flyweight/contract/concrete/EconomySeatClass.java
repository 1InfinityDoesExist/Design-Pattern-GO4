package com.design.patterns.flyweight.contract.concrete;

import com.design.patterns.flyweight.contract.ISeatClass;

public class EconomySeatClass implements ISeatClass {

	private final String cabinTier = "ECONOMY";

	@Override
	public void reserve(String seatNumber, String passengerName) {
		System.out.println("----Reserving " + cabinTier + " seat " + seatNumber + " for " + passengerName);
	}
}
