# Flyweight Design Pattern (scaffold)

> This module is a **placeholder** — the pattern is not implemented here yet. The full, runnable, production-mirrored example lives in `Design-Pattern-RealUseCase/RealUseCase_Structural/RealUseCase_Flyweight_Design_Pattern`.

## Target UML (what the implementation should look like)

```
 +---------------------+   forKey(k)   +-----------------+
 |  FlyweightFactory   |-------------->| SharedInstance  |
 | -pool : Map<K,F>    |  same key ->  |  (immutable)    |
 +---------------------+  same object  +-----------------+
```

## Current code, line by line

```java
package com.design.patterns.flyweight;

public class FlyweightDesignPattern {

	public static void main(String[] args) {
		System.out.println("Flyweight Design Pattern");
	}
}
```

- `package com.design.patterns.flyweight;` — the pattern's dedicated package, ready for the real classes.
- `public class FlyweightDesignPattern` — the module's entry class, named after the pattern.
- `public static void main(String[] args)` — standard JVM entry point so the scaffold runs standalone.
- `System.out.println("Flyweight Design Pattern");` — prints the pattern name, proving the module builds and runs; replace with a real demo when implementing.
