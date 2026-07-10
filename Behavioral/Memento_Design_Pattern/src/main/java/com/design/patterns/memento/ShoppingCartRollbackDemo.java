package com.design.patterns.memento;

import com.design.patterns.memento.caretaker.CartCheckpoint;
import com.design.patterns.memento.originator.ShoppingCart;

public class ShoppingCartRollbackDemo {

	public static void main(String[] args) {
		System.out.println("Shopping Cart Bulk-Update Rollback");
		ShoppingCart cart = new ShoppingCart("2x Espresso Beans 1kg\n");
		CartCheckpoint checkpoint = new CartCheckpoint();

		cart.addItem("1x Pour-Over Filter Pack\n");
		checkpoint.saveSnapshot(cart.createSnapshot());

		cart.addItem("40x Clearance Travel Mugs\n");
		checkpoint.saveSnapshot(cart.createSnapshot());

		cart.restoreSnapshot(checkpoint.getSnapshot(0));

		System.out.println(cart.getManifest());

	}
}
