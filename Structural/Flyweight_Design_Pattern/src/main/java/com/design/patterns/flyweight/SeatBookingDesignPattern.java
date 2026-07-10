package com.design.patterns.flyweight;

import com.design.patterns.flyweight.contract.ISeatClass;
import com.design.patterns.flyweight.contract.enums.SeatClassType;
import com.design.patterns.flyweight.factory.SeatClassFactory;

public class SeatBookingDesignPattern {

	public static void main(String[] args) {
		System.out.println("Flyweight Design Pattern");

		SeatClassFactory seatClassFactory = new SeatClassFactory();

		ISeatClass booking1 = seatClassFactory.getSeatClass(SeatClassType.ECONOMY);
		booking1.reserve("14A", "A. Menon");
		ISeatClass booking2 = seatClassFactory.getSeatClass(SeatClassType.ECONOMY);
		booking2.reserve("22F", "R. Iyer");
		seatClassFactory.getSeatClass(SeatClassType.BUSINESS).reserve("2C", "S. Kapoor");
		seatClassFactory.getSeatClass(SeatClassType.BUSINESS).reserve("3A", "N. Verma");

		System.out.println("ECONOMY flyweight reused (booking1 == booking2): " + (booking1 == booking2));
		System.out.println("Objects in pool for 4 reservations: " + seatClassFactory.poolSize());
	}
}
