package com.design.patterns.flyweight.contract;

public interface Icon {

	/**
	 * Extrinsic state (x, y) is supplied by the caller on every call; the
	 * flyweight itself only carries shared, immutable intrinsic state.
	 */
	void display(int x, int y);

}
