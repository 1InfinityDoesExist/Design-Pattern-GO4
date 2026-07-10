# State Design Pattern

## Intent

Let an object **change its behavior when its internal state changes**, so it appears to change its class. Instead of one object with a big conditional (`if phase == IDLE … else if phase == ATTACKING …`), you give each state its **own class**, and the object *delegates* its behavior to whichever state object it currently holds. Each state also knows **which state comes next**, so the transitions live in the states themselves.

Here the object is a **duelist in combat**. It behaves differently depending on whether it is idle, attacking, or stunned — and each phase knows what phase follows it: idle → attacking → stunned → idle.

## UML class diagram

```
 <<interface>> ICombatState
 | +handleTurn(CombatContext) |
     ^            ^             ^
     |            |             |
 IdleState   AttackingState  StunnedState
 "watches"     "strikes"      "reels"
     |            |             |
     +--- each sets context.enterState(NEXT) ---+
          IDLE -> ATTACKING -> STUNNED -> IDLE
 +----------------------+
 | CombatContext        |
 | -state               |
 | +enterState(state)   |
 | +takeTurn() ---------+--> state.handleTurn(this)
 +----------------------+
```

---

## The players

```
states/ICombatState                       the state contract: handleTurn(context)
states/concrete/IdleState                 "watches for an opening" → then becomes Attacking
              /AttackingState             "strikes"                → then becomes Stunned
              /StunnedState               "reels, cannot act"      → then becomes Idle
context/CombatContext                     the context: holds the current state, delegates to it

StateDesignPattern                        the demo — starts Idle, fires three turns
```

---

## The code, line by line

### `ICombatState` — the state contract

```java
public interface ICombatState {
	void handleTurn(CombatContext combatContext);
}
```

- One method: **`handleTurn(context)`** — "act according to *this* phase of combat, and then decide what phase the context should move to."
- It receives the **context** as a parameter. That's essential: it's how a state is able to push the context into its *next* state (see *Why the context is passed in* below).

### The concrete states

```java
public class IdleState implements ICombatState {
	@Override public void handleTurn(CombatContext c) {
		System.out.println("Idle: The duelist watches for an opening.");
		c.enterState(new AttackingState());          // transition: Idle → Attacking
	}
}
public class AttackingState implements ICombatState {
	@Override public void handleTurn(CombatContext c) {
		System.out.println("Attacking: The duelist strikes with a decisive blow.");
		c.enterState(new StunnedState());             // transition: Attacking → Stunned
	}
}
public class StunnedState implements ICombatState {
	@Override public void handleTurn(CombatContext c) {
		System.out.println("Stunned: The duelist reels and cannot act.");
		c.enterState(new IdleState());                // transition: Stunned → Idle
	}
}
```

Each state class does exactly **two things** inside `handleTurn`:

1. **The behavior for that state** — the `System.out.println(...)` line is what the duelist *does* while in this phase.
2. **The transition** — `c.enterState(new …())` tells the context which state to become next. This is the key idea: **each state owns its own outgoing transition.** Idle knows the next phase is Attacking; Attacking knows it's Stunned; Stunned knows it's Idle. The "what comes next" logic is distributed across the states, not centralized in the context.

Because each state points to the next, the three classes form a **cycle**: Idle → Attacking → Stunned → Idle → …

### `CombatContext` — the context

```java
public class CombatContext {

	private ICombatState currentCombatState;

	public void enterState(ICombatState currentCombatState) {
		this.currentCombatState = currentCombatState;
	}

	public void takeTurn() {
		currentCombatState.handleTurn(this);
	}
}
```

- **`private ICombatState currentCombatState;`** — the context holds its **current state** by the *interface* type. It never mentions `AttackingState` etc.; it only knows "I have some state." This is what lets the behavior change without the context changing. The field name says exactly what it holds — the state that is current *now*, and that will run the next time `takeTurn()` is called.
- **`enterState(...)`** — replaces the current state. It's called both from the outside (to set the *initial* state) and from *inside* the states themselves (to perform transitions). The parameter shares the field's name, so the assignment (`this.currentCombatState = currentCombatState;`) reads as a plain "adopt whatever state I was handed."
- **`takeTurn()`** — the context's single public action. It **delegates** straight to the current state's `handleTurn(this)`, passing itself along so the state can act *and* transition. The context contributes no behavior of its own — it just forwards to whatever state it's in.

### `StateDesignPattern` — the demo

```java
CombatContext combatContext = new CombatContext();
combatContext.enterState(new IdleState());     // start Idle

combatContext.takeTurn();   // Idle      → prints "watches for an opening", transitions to Attacking
combatContext.takeTurn();   // Attacking → prints "strikes",                transitions to Stunned
combatContext.takeTurn();   // Stunned   → prints "reels",                  transitions to Idle
```

- The context is seeded with the initial `IdleState`.
- Each `combatContext.takeTurn()` call runs the **current** state's behavior, then the state flips the context to the next phase. So the *same* call, `combatContext.takeTurn()`, produces **different output each time** — because the object behind the duelist keeps changing.

---

## Why the design decisions

### Why State instead of a big `if`/`switch` on a status field?

The procedural version looks like:

```java
void takeTurn() {
	if (phase == IDLE)          { print("watches"); phase = ATTACKING; }
	else if (phase == ATTACKING) { print("strikes"); phase = STUNNED; }
	else if (phase == STUNNED)   { print("reels");   phase = IDLE; }
}
```

Problems: **every** behavior and **every** transition is crammed into one growing method; adding a phase means editing that method (and probably several others like it); and the transition rules are tangled together where they're easy to get wrong. State replaces the conditional with **polymorphism** — each `case` becomes a class, and "which branch runs" becomes "which state object is currently held." Adding a phase is adding a class, not editing a conditional (Open/Closed Principle).

### Why does each state hold the transition to the *next* state?

So the state machine's wiring lives with the states that own it. `IdleState` is the single source of truth for "what follows idle." This keeps each transition **local and cohesive**: to understand or change the idle→attacking rule, you look in exactly one place. The context stays dumb — it doesn't need to know the transition table at all.

(Trade-off: because transitions are distributed, no single file shows the *whole* machine at a glance. When the graph is complex, some implementations instead centralize transitions in the context or a table. This module uses the distributed style, which is the classic GoF form.)

### Why is the context's state field typed as the interface?

Same principle as Strategy: **program to an interface, not an implementation.** Holding an `ICombatState` means the context works with any state, present or future, and its behavior changes purely by swapping the referenced object — the context's own code never changes.

### Why is the context passed into `handleTurn(this)`?

Because the state needs a way to **change the context's state** — that's the transition. By handing the state a reference to the context, the state can call `context.enterState(nextState)` to move the machine forward. Without that back-reference, states couldn't drive transitions and the context would have to contain the transition logic (back to the big conditional).

### State vs. Strategy (they look almost identical — here's the difference)

Structurally State and Strategy are twins: a context delegating to an interface-typed object. The difference is **intent and who changes the object**:

- **Strategy** — the *client* picks one algorithm and it usually stays put; strategies don't know about each other. It's about *how* to do something.
- **State (this module)** — the object **transitions between states on its own**, and states *do* know about each other (each sets the next). It's about *what the object is* right now, and it models a state machine that evolves over time.

The tell is the self-transition: `c.enterState(new AttackingState())` inside a state is pure State pattern — a Strategy would never reassign the context's strategy from inside itself.

---

## Execution flow (the demo — three turns)

```
main
 │  combatContext.enterState(IdleState)            initial state = Idle
 │
 ├── combatContext.takeTurn()
 │       └── IdleState.handleTurn(combatContext)
 │              ├── prints "Idle: The duelist watches for an opening."
 │              └── combatContext.enterState(AttackingState)   ← now Attacking
 │
 ├── combatContext.takeTurn()
 │       └── AttackingState.handleTurn(combatContext)
 │              ├── prints "Attacking: The duelist strikes with a decisive blow."
 │              └── combatContext.enterState(StunnedState)     ← now Stunned
 │
 └── combatContext.takeTurn()
         └── StunnedState.handleTurn(combatContext)
                ├── prints "Stunned: The duelist reels and cannot act."
                └── combatContext.enterState(IdleState)        ← back to Idle
```

Same method called three times, three different outcomes — because the context's internal state advances Idle → Attacking → Stunned on each call. A fourth `takeTurn()` would print the Idle message again and the cycle repeats.

---

## Expected output

```
State Design Pattern
Idle: The duelist watches for an opening.
Attacking: The duelist strikes with a decisive blow.
Stunned: The duelist reels and cannot act.
```

No Spring Boot involved — this is a plain `main`, so the JVM prints these four lines and exits immediately. This is the actual, verbatim console output captured from a real run of this module (`java -cp target/classes com.design.patterns.state.StateDesignPattern`).

---

## How to run

```bash
# From the module root directory
JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64 mvn -o clean compile

JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64 /usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp target/classes \
  com.design.patterns.state.StateDesignPattern
```

The `-o` (offline) flag works once the parent reactor and dependencies are already in your local Maven cache; drop it on a first build. This module has no runtime dependencies beyond the JDK, so no classpath assembly is needed beyond `target/classes`.

---

## Notes / possible extensions (not changed in the code)

- **States are created fresh on each transition** (`new AttackingState()` etc.). Since these states hold no data, they could be **singletons/shared instances** to avoid allocations — a common optimization when states are stateless.
- **Plain `main`, no Spring** — the pattern is pure OO structure and needs no container.

---

## Relationship to the other Behavioral patterns

- **State (this module)** — an object's behavior changes as it **transitions between states**; states know their successors and drive the transitions.
- **Strategy** — swap **one** algorithm chosen by the client; no self-transitions.
- **Chain of Responsibility** — pass a request along handlers until one handles it.
- **Template Method** — fix an algorithm skeleton, vary steps via inheritance.

Reach for State when an object has **distinct modes** with different behavior, and it should move between those modes over time — i.e. when you're really modeling a **finite state machine** and want each state's behavior and transitions kept in one cohesive place.
