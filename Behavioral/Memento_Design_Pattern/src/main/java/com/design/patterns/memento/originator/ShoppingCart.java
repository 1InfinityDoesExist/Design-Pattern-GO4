package com.design.patterns.memento.originator;

public class ShoppingCart {

	private String manifest;

	public ShoppingCart(String manifest) {
		this.manifest = manifest;
	}

	public void addItem(String line) {
		this.manifest += line;
	}

	public String getManifest() {
		return this.manifest;
	}

	public CartSnapshot createSnapshot() {
		return new CartSnapshot(this.manifest);
	}

	public void restoreSnapshot(CartSnapshot snapshot) {
		this.manifest = snapshot.getSavedManifest();
	}

}
