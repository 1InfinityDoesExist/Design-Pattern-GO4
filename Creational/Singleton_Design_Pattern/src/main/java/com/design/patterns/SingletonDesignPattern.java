package com.design.patterns;

import com.design.patterns.singleton.LicenseKeyRegistry;

public class SingletonDesignPattern {

	public static void main(String[] args) {
		LicenseKeyRegistry first = LicenseKeyRegistry.getInstance();
		LicenseKeyRegistry second = LicenseKeyRegistry.getInstance();

		System.out.println("Both references point to the same instance: " + (first == second));
		System.out.println("Active license key: " + first.getActiveLicenseKey());
	}
}
