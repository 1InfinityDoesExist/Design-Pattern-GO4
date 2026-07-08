package com.design.patterns.flyweight.factory;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.design.patterns.flyweight.contract.Icon;
import com.design.patterns.flyweight.contract.enums.IConEmums;

@Component
public class IconFactory {

	private final EnumMap<IConEmums, Icon> iconInstances;

	public IconFactory(List<? extends Icon> icons) {
		this.iconInstances = (icons == null ? List.<Icon>of() : icons).stream().collect(Collectors
				.toMap(Icon::getIConENEmums, Function.identity(), (a, b) -> b, () -> new EnumMap<>(IConEmums.class)));
	}

	public Icon getIcon(IConEmums icon) {
		return iconInstances.get(icon);
	}
}