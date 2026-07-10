package com.design.patterns.flyweight.contract.concrete;

import com.design.patterns.flyweight.contract.ISeatClass;

public class BusinessSeatClass implements ISeatClass {

	private final String cabinTier = "BUSINESS";

	@Override
	public void reserve(String seatNumber, String passengerName) {
		System.out.println("----Reserving " + cabinTier + " seat " + seatNumber + " for " + passengerName);
	}
}
