package com.design.patterns.flyweight.factory;

import java.util.EnumMap;
import java.util.Map;

import com.design.patterns.flyweight.contract.ISeatClass;
import com.design.patterns.flyweight.contract.concrete.BusinessSeatClass;
import com.design.patterns.flyweight.contract.concrete.EconomySeatClass;
import com.design.patterns.flyweight.contract.enums.SeatClassType;

public class SeatClassFactory {

	private final Map<SeatClassType, ISeatClass> pool = new EnumMap<>(SeatClassType.class);

	public ISeatClass getSeatClass(SeatClassType type) {
		return pool.computeIfAbsent(type, SeatClassFactory::create);
	}

	private static ISeatClass create(SeatClassType type) {
		System.out.println("(pool miss) creating flyweight for " + type);
		switch (type) {
		case ECONOMY:
			return new EconomySeatClass();
		case BUSINESS:
			return new BusinessSeatClass();
		default:
			throw new IllegalArgumentException("No flyweight registered for " + type);
		}
	}

	public int poolSize() {
		return pool.size();
	}
}
