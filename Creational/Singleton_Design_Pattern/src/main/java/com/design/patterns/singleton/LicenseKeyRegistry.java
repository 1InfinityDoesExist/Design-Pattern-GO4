package com.design.patterns.singleton;

public final class LicenseKeyRegistry {

	private final String activeLicenseKey;

	private LicenseKeyRegistry() {
		this.activeLicenseKey = "ENT-7734-9A2F-PROD";
	}

	private static final class InstanceHolder {
		private static final LicenseKeyRegistry INSTANCE = new LicenseKeyRegistry();
	}

	public static LicenseKeyRegistry getInstance() {
		return InstanceHolder.INSTANCE;
	}

	public String getActiveLicenseKey() {
		return activeLicenseKey;
	}
}
