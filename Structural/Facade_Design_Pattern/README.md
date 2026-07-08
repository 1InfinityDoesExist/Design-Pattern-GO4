# Facade Design Pattern

> **GoF intent:** *Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.*
> The client stops choreographing many small subsystem calls in the right order and instead calls one intention-revealing method on the facade.

## Structure of this implementation

```
                         +----------------------+
   client ─────────────► |    ThreaterFacade    |
   startMovie()          | -moviePlayer         |──► MoviePlayer  (on / off / increaseVolumn)
   endMovide()           | -musicPlayer         |──► MusicPlayer  (on / off)
                         +----------------------+
        (one call on the facade = an orchestrated sequence of subsystem calls)
```

| GoF role | Class in this module |
|---|---|
| **Facade** | `ThreaterFacade` — exposes `startMovie()` / `endMovide()` |
| **Subsystem classes** | `MoviePlayer`, `MusicPlayer` |
| **Client** | `FacadeDesignPattern.main()` |

## How it works

1. `MoviePlayer` and `MusicPlayer` are independent subsystem classes with their own fine-grained APIs (`on()`, `off()`, `increaseVolumn()`).
2. `ThreaterFacade` composes both and publishes two **workflow-level** operations:
   - `startMovie()` → movie on → music on → raise volume (the correct startup sequence, encoded once).
   - `endMovide()` → movie off → music off (the correct shutdown sequence).
3. The client calls the two facade methods and never needs to know the subsystem classes, their ordering rules, or their APIs.

**Verified output** (`java com.design.patterns.facade.FacadeDesignPattern`):

```
Facade Design Pattern
-----Move Player On
-----Music Player On
-----Move Player Increase Volume
-----Move Player Off
-----Music Player Off
```

## Why this follows the pattern

- ✅ **One entry point, many subsystems:** the facade fans a single client call out to an orchestrated sequence across `MoviePlayer` and `MusicPlayer`.
- ✅ **Knowledge moves out of the client:** the ordering rule ("music comes on after the movie, then raise volume") lives in exactly one place.
- ✅ **Subsystems stay independent and reachable:** Facade doesn't forbid direct subsystem access; it just makes the common path trivial — precisely the GoF trade-off.
- ✅ Same shape as real-world facades: `spring-boot-starter` auto-config entry points, a service class wrapping repository + mail + audit calls behind `placeOrder()`.

## Review notes (improvements worth making)

1. **Correct — no structural issues.** This is a clean, minimal facade.
2. Naming typos worth fixing while it's cheap: `ThreaterFacade` → `TheaterFacade`, `endMovide()` → `endMovie()`, `increaseVolumn()` → `increaseVolume()`, log text `"Move Player"` → `"Movie Player"`.
3. Optional: have the facade default-construct its subsystems (`new ThreaterFacade()`) for a simpler client, keeping the injection constructor for tests.
