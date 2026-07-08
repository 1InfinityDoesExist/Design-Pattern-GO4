package com.design.patterns.flyweight.factory;

import java.util.EnumMap;
import java.util.Map;

import com.design.patterns.flyweight.contract.Icon;
import com.design.patterns.flyweight.contract.concret.FileIcon;
import com.design.patterns.flyweight.contract.concret.FolderIcon;
import com.design.patterns.flyweight.contract.enums.IconType;

public class IconFactory {

	private final Map<IconType, Icon> pool = new EnumMap<>(IconType.class);

	/**
	 * Lazily creates one flyweight per type on first request; every later
	 * request for the same type returns the same shared instance.
	 */
	public Icon getIcon(IconType type) {
		return pool.computeIfAbsent(type, IconFactory::create);
	}

	private static Icon create(IconType type) {
		System.out.println("(pool miss) creating flyweight for " + type);
		switch (type) {
		case FILE:
			return new FileIcon();
		case FOLDER:
			return new FolderIcon();
		default:
			throw new IllegalArgumentException("No flyweight registered for " + type);
		}
	}

	public int poolSize() {
		return pool.size();
	}
}
