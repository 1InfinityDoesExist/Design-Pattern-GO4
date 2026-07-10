package com.design.patterns.memento.caretaker;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.memento.originator.CartSnapshot;

public class CartCheckpoint {

	private List<CartSnapshot> snapshots;

	public CartCheckpoint() {
		this.snapshots = new ArrayList<>();
	}

	public void saveSnapshot(CartSnapshot snapshot) {
		this.snapshots.add(snapshot);
	}

	public CartSnapshot getSnapshot(int index) {
		return this.snapshots.get(index);
	}
}
