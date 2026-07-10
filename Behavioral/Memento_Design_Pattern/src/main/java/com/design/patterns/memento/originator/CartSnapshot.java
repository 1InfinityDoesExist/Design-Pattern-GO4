package com.design.patterns.memento.originator;

public class CartSnapshot {

	private String manifest;

	CartSnapshot(String manifest) {
		this.manifest = manifest;
	}

	String getSavedManifest() {
		return this.manifest;
	}
}
