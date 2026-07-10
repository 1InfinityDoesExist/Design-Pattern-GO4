# Adapter Design Pattern

**Category:** Structural | **GoF Reference:** Gang of Four — Design Patterns (1994), p. 139

---

## Table of Contents

1. [Intent](#intent)
2. [When to Use](#when-to-use)
3. [Structure — ASCII UML Diagram](#structure--ascii-uml-diagram)
4. [Package Structure](#package-structure)
5. [Line-by-Line Explanation of Every File](#line-by-line-explanation-of-every-file)
   - [ICelsiusThermometer.java — Target Interface](#1-icelsiusthermometerjava--target-interface)
   - [LegacyFahrenheitSensor.java — Adaptee](#2-legacyfahrenheitsensorjava--adaptee)
   - [FahrenheitSensorAdapter.java — Adapter](#3-fahrenheitsensoradapterjava--adapter)
   - [ThermometerAdapterDemo.java — Driver / Client](#4-thermometeradapterdemojava--driver--client)
6. [Execution Flow](#execution-flow)
7. [Real-World Use Cases](#real-world-use-cases)
8. [Class Adapter vs Object Adapter](#class-adapter-vs-object-adapter)
9. [Key Design Decisions](#key-design-decisions)
10. [How to Run](#how-to-run)
11. [Output](#output)
12. [Summary](#summary)

---

## Intent

The Adapter pattern converts the interface of one class into another interface that the client expects. It allows classes with incompatible interfaces to work together without modifying their source code. The pattern acts as a structural bridge: a wrapper object — the Adapter — implements the interface the client knows about (the Target), holds a reference to the object whose interface is incompatible (the Adaptee), and internally translates every call from the Target's contract into the equivalent call on the Adaptee. The result is that the client is completely unaware of the Adaptee's existence; from the client's perspective it is simply talking to a standard `ICelsiusThermometer`, not a `LegacyFahrenheitSensor` with a different method name, a different unit of measurement, and a different data type. This makes the pattern especially valuable when integrating existing or third-party code that cannot be modified.

---

## When to Use

Use the Adapter pattern in any of these situations:

- **Legacy hardware integration:** You have a working sensor driver that predates your current interface contract and reports in a unit your application no longer speaks natively. Rewriting the driver firmware is risky, expensive, or impossible (no source code access). The Adapter lets you reuse the legacy sensor without touching it.

- **Third-party libraries:** An external library ships a class whose method signatures and units differ from your application's interface. Writing an adapter avoids coupling your entire codebase to the third-party API surface; if the library changes, only the adapter changes.

- **Unit or vocabulary mismatch during team collaboration:** Two teams independently develop two components that must cooperate. One reports temperature in Fahrenheit, the other expects Celsius. An Adapter reconciles the difference — including the unit conversion — without a breaking change on either side.

- **Incremental migration:** You are replacing a fleet of legacy sensors piece by piece. The Adapter lets the new monitoring system speak to the old hardware through a translation layer while the migration is in progress, removing the need for a big-bang cutover.

- **Testing and mocking:** An Adapter wrapping a heavyweight external resource (a physical sensor, a serial port, a vendor SDK) lets you swap in a lightweight test double that satisfies the same Target interface.

---

## Structure — ASCII UML Diagram

```
  Client
    |
    | uses
    v
+------------------------+          +------------------------------+
|     <<interface>>      |          |            Adaptee            |
|         Target         |          |   (LegacyFahrenheitSensor)    |
|-------------------------|          |--------------------------------|
| + readCelsius(): double |          | + takeFahrenheitReading(): double |
+------------------------+          +------------------------------+
         ^                                       ^
         |  implements                           | has-a (composition)
         |                                       |
+---------------------------+                    |
|   FahrenheitSensorAdapter |--------------------+
|---------------------------|
| - legacyFahrenheitSensor  |
|---------------------------|
| + readCelsius(): double   |  ---delegates-to--->  (legacyFahrenheitSensor.takeFahrenheitReading() - 32) * 5 / 9
+---------------------------+
```

**Reading the diagram:**

- The **Client** (`ThermometerAdapterDemo.main`) depends only on the `Target` interface (`ICelsiusThermometer`). It never references `LegacyFahrenheitSensor` directly.
- The **Target** (`ICelsiusThermometer`) declares the interface the client was written against — a single `readCelsius()` method returning a Celsius reading.
- The **Adaptee** (`LegacyFahrenheitSensor`) is the existing sensor driver with an incompatible method name and an incompatible unit (`takeFahrenheitReading()` returns degrees Fahrenheit).
- The **Adapter** (`FahrenheitSensorAdapter`) simultaneously satisfies the Target interface (via `implements ICelsiusThermometer`) and holds a reference to the Adaptee (via composition). Its `readCelsius()` method delegates to `legacyFahrenheitSensor.takeFahrenheitReading()` and converts the result from Fahrenheit to Celsius before returning it.

---

## Package Structure

```
com.design.patterns.adapter
├── ThermometerAdapterDemo.java         (driver / client — root package)
│
├── target/
│   └── ICelsiusThermometer.java        (Target interface)
│
├── adaptee/
│   └── LegacyFahrenheitSensor.java     (Adaptee — the class being adapted)
│
└── adapter/
    └── FahrenheitSensorAdapter.java    (Adapter — the bridge)
```

### Why three separate packages?

**`target/` — the contract package.**
The `ICelsiusThermometer` interface represents the abstraction the application is built against. Isolating it in its own package signals that this is the stable API surface. New Adapters, mock implementations, and production implementations all live in their own packages and depend on this one. If `ICelsiusThermometer` ever needs a second implementation (e.g., a `NetworkThermometerAdapter`), the `target/` package remains untouched.

**`adaptee/` — the foreign/legacy code package.**
`LegacyFahrenheitSensor` lives in `adaptee/` to make it explicit that this class is the thing being adapted — it owns its own behavior and has no knowledge of `ICelsiusThermometer`. In a real project this package might be replaced by an import from a third-party jar or a vendor's hardware SDK; keeping it separate mirrors that reality and avoids accidental coupling.

**`adapter/` — the translation layer package.**
`FahrenheitSensorAdapter` is the only class that is allowed to import from both `target/` and `adaptee/`. Keeping it in its own package makes the dependency direction visible in the package structure itself: `adapter/` depends on `target/` and `adaptee/`; nothing else does.

**Root package — the client.**
`ThermometerAdapterDemo` is the driver. It lives in the root package so that it can import from all sub-packages. In a production application the "client" would be a monitoring service or a Spring `@Component`; the driver here simply stands in for that role.

---

## Line-by-Line Explanation of Every File

### 1. `ICelsiusThermometer.java` — Target Interface

```java
package com.design.patterns.adapter.target;
```

**What it does:** Declares the Java package that owns this type.

**Why it is written this way:** Placing the interface in the `target` sub-package separates the "what we expect" contract from all implementation details. Any code that wants a Celsius reading — the client, tests, alternative adapters — imports from this package alone, which enforces the Dependency Inversion Principle: depend on abstractions, not concretions.

```java
public interface ICelsiusThermometer {
```

**What it does:** Declares a public Java interface named `ICelsiusThermometer`.

**Why it is written this way:** An `interface` rather than an abstract class is used because the Target defines only a contract — zero shared state, zero shared behaviour. The `public` modifier is required so that classes in other packages (the adapter, the client) can implement and reference it. Using an interface also allows `FahrenheitSensorAdapter` to implement `ICelsiusThermometer` while independently extending any other class if needed (Java does not support multiple class inheritance but does support multiple interface implementation).

```java
    double readCelsius();
```

**What it does:** Declares a single abstract method `readCelsius()` with no parameters, returning a `double`.

**Why it is written this way:** This is the method the client calls. Its name and its unit are the "modern" or "expected" contract that the rest of the system has been written against: a temperature expressed in Celsius. The Adaptee's equivalent method is called `takeFahrenheitReading()` — a different name, and it reports in a different unit entirely. The Adapter's job is to map `readCelsius()` → `takeFahrenheitReading()` and convert the unit along the way. Keeping the interface minimal (one method) follows the Interface Segregation Principle: the client depends only on what it uses.

```java
}
```

Closes the interface declaration.

---

### 2. `LegacyFahrenheitSensor.java` — Adaptee

```java
package com.design.patterns.adapter.adaptee;
```

**What it does:** Declares the package for the legacy (adaptee) code.

**Why it is written this way:** Isolating legacy code in its own `adaptee` package communicates its role to every reader of the codebase. It also mirrors how real-world legacy or third-party code lands in a project — as an external dependency with its own namespace that you do not control, often a vendor's hardware driver shipped as a compiled `.jar`.

```java
public class LegacyFahrenheitSensor {
```

**What it does:** Declares the `LegacyFahrenheitSensor` concrete class.

**Why it is written this way:** It is a `class`, not an interface, because it already has behaviour. It does not implement `ICelsiusThermometer` — that is the whole problem the Adapter solves. In a real system this class might be compiled into a `.jar` you cannot modify, wrapping firmware from a hardware vendor; the pattern works identically whether you have the source or not.

```java
    public double takeFahrenheitReading() {
```

**What it does:** Declares a public method `takeFahrenheitReading()` — the Adaptee's own method signature, returning a `double`.

**Why it is written this way:** The method name `takeFahrenheitReading()` differs from `readCelsius()`, and its unit (Fahrenheit) differs from the Target's unit (Celsius). This dual mismatch — name and unit — is the root cause of the incompatibility. The method is `public` so the `FahrenheitSensorAdapter` in a different package can call it. There is no `@Override` because `LegacyFahrenheitSensor` does not implement any interface.

```java
        return 98.6;
```

**What it does:** Returns a fixed Fahrenheit reading of `98.6`.

**Why it is written this way:** This line represents the real work the legacy hardware performs — in a production context it might poll a serial port, read an analog-to-digital converter, or call a vendor SDK. The fixed value here is a stand-in that proves the Adaptee's real behaviour is actually being invoked and its raw Fahrenheit value is flowing through the Adapter's conversion logic.

```java
    }
}
```

Closes the method and the class declaration.

---

### 3. `FahrenheitSensorAdapter.java` — Adapter

```java
package com.design.patterns.adapter.adapter;
```

**What it does:** Declares the package for the adapter layer.

**Why it is written this way:** The `adapter` sub-package is the only package in this module that imports from both `target` and `adaptee`. Housing all translation logic here creates a clear seam: if the legacy sensor's API ever changes, only files in this package need to change.

```java
import com.design.patterns.adapter.adaptee.LegacyFahrenheitSensor;
```

**What it does:** Brings the `LegacyFahrenheitSensor` class into scope.

**Why it is written this way:** The Adapter must hold a reference to the Adaptee, so it must know the Adaptee's type. This is the only file outside the `adaptee` package that imports from it. If the Adaptee were replaced by a different legacy sensor class, only this import line and the constructor type would change.

```java
import com.design.patterns.adapter.target.ICelsiusThermometer;
```

**What it does:** Brings the `ICelsiusThermometer` Target interface into scope.

**Why it is written this way:** The Adapter implements the Target, so it must reference it. The fact that `FahrenheitSensorAdapter` imports from both `target` and `adaptee` packages is not a design flaw — it is the Adapter's explicit, intentional role.

```java
public class FahrenheitSensorAdapter implements ICelsiusThermometer {
```

**What it does:** Declares `FahrenheitSensorAdapter` as a concrete class that fulfils the `ICelsiusThermometer` interface contract.

**Why it is written this way:** `implements ICelsiusThermometer` is what makes the Adapter substitutable for any `ICelsiusThermometer` reference throughout the codebase. The client can write `ICelsiusThermometer t = new FahrenheitSensorAdapter(...)` and never know what is on the other side. The class is `public` so the client (in the root package) can instantiate it. The class is not declared `final` because a subclass could theoretically extend it to adapt a further-evolved legacy sensor.

```java
    private final LegacyFahrenheitSensor legacyFahrenheitSensor;
```

**What it does:** Declares an instance field of type `LegacyFahrenheitSensor`, marked `private` and `final`.

**Why it is written this way:**

- `private` — the field is an implementation detail. Nothing outside `FahrenheitSensorAdapter` should reach through the adapter to manipulate the Adaptee directly. Hiding it prevents accidental coupling.
- `final` — once the adapter is constructed, the Adaptee it wraps never changes. `final` enforces this invariant at compile time, makes the object effectively immutable with respect to its collaborator, and is safe to use in multi-threaded environments without additional synchronization.
- Type `LegacyFahrenheitSensor` — the field holds the concrete Adaptee. In more flexible designs the field type might be an interface or abstract class so that the Adapter can work with any of several legacy sensor implementations; for this focused example, the concrete type is sufficient.

```java
    public FahrenheitSensorAdapter(LegacyFahrenheitSensor legacyFahrenheitSensor) {
```

**What it does:** Declares a public constructor that accepts a `LegacyFahrenheitSensor` instance.

**Why it is written this way:** Constructor injection is the idiomatic way to supply a collaborator in plain Java and in dependency injection frameworks (Spring, Guice, CDI). The Adaptee is a required dependency — the Adapter cannot function without it — so it is passed at construction time rather than via a setter, making it impossible to create a partially initialised Adapter. Accepting `LegacyFahrenheitSensor` as a parameter (rather than creating it inside the constructor) is the Dependency Inversion Principle in action: the Adapter does not decide which sensor instance to use; the caller does.

```java
        this.legacyFahrenheitSensor = legacyFahrenheitSensor;
```

**What it does:** Assigns the constructor parameter to the instance field.

**Why it is written this way:** The `this.` qualifier disambiguates the instance field from the constructor parameter, which share the same name. The assignment completes the initialisation of the `final` field, satisfying the Java compiler's definite-assignment rule for `final` fields.

```java
    }
```

Closes the constructor.

```java
    @Override
    public double readCelsius() {
```

**What it does:** Implements the `readCelsius()` method declared in the `ICelsiusThermometer` interface.

**Why it is written this way:** `@Override` is a compile-time annotation that instructs the compiler to verify that this method genuinely overrides or implements a method from a parent type. If someone accidentally renamed `readCelsius()` to `ReadCelsius()` in the interface, the compiler would immediately flag the mismatch here. This is the Adapter's core method — the single point of translation between the Target's contract and the Adaptee's API.

```java
        return (legacyFahrenheitSensor.takeFahrenheitReading() - 32) * 5 / 9;
```

**What it does:** Calls the Adaptee's `takeFahrenheitReading()` method and converts the returned Fahrenheit value into Celsius using the standard formula `C = (F - 32) × 5⁄9`.

**Why it is written this way:** This one line is the entire translation, and it is a richer translation than a simple name swap: the Adapter not only renames the call, it transforms the data that flows through it. The client calls `readCelsius()`; the Adapter silently reroutes that call to `takeFahrenheitReading()` and performs the unit conversion so the client never has to know the underlying sensor speaks Fahrenheit. In more complex scenarios this line might also validate ranges, handle sensor error codes, or aggregate multiple Adaptee calls to satisfy one Target call. Here the transformation is a single arithmetic expression, which keeps the example focused while still demonstrating that Adapters can convert data, not just rename methods.

```java
    }
}
```

Closes the method and the class declaration.

---

### 4. `ThermometerAdapterDemo.java` — Driver / Client

```java
package com.design.patterns.adapter;
```

**What it does:** Places the driver class in the root `adapter` package.

**Why it is written this way:** The root package sits above all sub-packages, so it can import from `target`, `adaptee`, and `adapter` without circular dependency. In a real application the client would not normally import from `adaptee` at all — it would receive the `ICelsiusThermometer` via dependency injection and never construct a `LegacyFahrenheitSensor` directly.

```java
import com.design.patterns.adapter.adaptee.LegacyFahrenheitSensor;
```

**What it does:** Imports `LegacyFahrenheitSensor` so it can be instantiated in `main`.

**Why it is written this way:** The driver must create a `LegacyFahrenheitSensor` instance to pass into the `FahrenheitSensorAdapter` constructor. This is the composition root — the one place in an application where concrete types are assembled together. In a Spring application a `@Bean` factory method would play this role, keeping the rest of the codebase free from knowing about `LegacyFahrenheitSensor`.

```java
import com.design.patterns.adapter.adapter.FahrenheitSensorAdapter;
```

**What it does:** Imports `FahrenheitSensorAdapter` so it can be instantiated in `main`.

**Why it is written this way:** The driver is the only code that knows the concrete Adapter type. All subsequent usage goes through the `ICelsiusThermometer` interface variable.

```java
import com.design.patterns.adapter.target.ICelsiusThermometer;
```

**What it does:** Imports the `ICelsiusThermometer` Target interface.

**Why it is written this way:** The variable `thermometer` is declared as type `ICelsiusThermometer`, not `FahrenheitSensorAdapter`. This is the critical design point: after construction, the rest of the code deals exclusively with the interface. Swapping to a completely different `ICelsiusThermometer` implementation (e.g., a `NetworkThermometerAdapter`) would require changing only the two lines inside `main` that do construction — nothing else.

```java
public class ThermometerAdapterDemo {
```

**What it does:** Declares the public driver class.

**Why it is written this way:** Named after its role as the demo entry point. In a real project this would be replaced by an application entry point (`@SpringBootApplication`, a CLI runner, etc.).

```java
    public static void main(String[] args) {
```

**What it does:** Declares the JVM entry point.

**Why it is written this way:** `public static void main(String[] args)` is the mandated signature for a Java application entry point. `static` means no instance of `ThermometerAdapterDemo` is needed to run the program. `String[] args` allows command-line arguments to be passed, though this example does not use them.

```java
        System.out.println("Adapter Design Pattern");
```

**What it does:** Prints a header line identifying the running pattern.

**Why it is written this way:** This line is purely presentational — it labels the console output so that when multiple pattern demos are run in sequence, the reader knows which GoF pattern produced which output.

```java
        ICelsiusThermometer thermometer = new FahrenheitSensorAdapter(new LegacyFahrenheitSensor());
```

**What it does:** Creates a `LegacyFahrenheitSensor` instance, wraps it in a `FahrenheitSensorAdapter`, and stores the result in a variable declared as type `ICelsiusThermometer`.

**Why it is written this way:** Three things happen here:

1. `new LegacyFahrenheitSensor()` — instantiates the Adaptee. This is the object that carries the real behaviour.
2. `new FahrenheitSensorAdapter(...)` — wraps the Adaptee in the Adapter, passing it via constructor injection.
3. `ICelsiusThermometer thermometer = ...` — declares the variable as the interface type, not the concrete type. From this line onward the rest of the code knows only that `thermometer` is an `ICelsiusThermometer`. The Adapter and the LegacyFahrenheitSensor are hidden behind the interface.

```java
        System.out.println("Celsius reading: " + thermometer.readCelsius());
```

**What it does:** Invokes `readCelsius()` on the `ICelsiusThermometer` interface reference and prints the returned value.

**Why it is written this way:** The client calls the method it was designed to call — `readCelsius()` — and receives a value already expressed in the unit it expects. At runtime, dynamic dispatch routes this call to `FahrenheitSensorAdapter.readCelsius()`, which in turn calls `LegacyFahrenheitSensor.takeFahrenheitReading()` and converts the result. The client code is completely isolated from that routing and from the unit conversion; it simply asks an `ICelsiusThermometer` for a Celsius reading and prints what comes back.

```java
    }
}
```

Closes the `main` method and the class declaration.

---

## Execution Flow

The following numbered trace walks through every method call from JVM startup to the final printed line.

```
1. JVM loads ThermometerAdapterDemo and invokes main(String[] args)
   │
2. System.out.println("Adapter Design Pattern")
   │   → Prints: "Adapter Design Pattern"
   │
3. new LegacyFahrenheitSensor()
   │   → Java allocates a LegacyFahrenheitSensor object on the heap.
   │   → No constructor body defined; the default no-arg constructor runs silently.
   │
4. new FahrenheitSensorAdapter( <LegacyFahrenheitSensor instance> )
   │   → Java allocates a FahrenheitSensorAdapter object on the heap.
   │   → FahrenheitSensorAdapter(LegacyFahrenheitSensor legacyFahrenheitSensor) executes:
   │       this.legacyFahrenheitSensor = legacyFahrenheitSensor;   ← stores the reference
   │
5. ICelsiusThermometer thermometer = <FahrenheitSensorAdapter instance>
   │   → The variable 'thermometer' holds a reference to the FahrenheitSensorAdapter,
   │     but its declared type is ICelsiusThermometer (the interface).
   │
6. thermometer.readCelsius()
   │   → Dynamic dispatch: the JVM looks up the runtime type of 'thermometer'
   │     (which is FahrenheitSensorAdapter) and calls FahrenheitSensorAdapter.readCelsius().
   │
7. FahrenheitSensorAdapter.readCelsius() executes:
   │       return (legacyFahrenheitSensor.takeFahrenheitReading() - 32) * 5 / 9;
   │   → Calls takeFahrenheitReading() on the stored LegacyFahrenheitSensor reference.
   │
8. LegacyFahrenheitSensor.takeFahrenheitReading() executes:
   │       return 98.6;
   │   → Returns 98.6 (degrees Fahrenheit) to the caller.
   │
9. Back in FahrenheitSensorAdapter.readCelsius():
   │       (98.6 - 32) * 5 / 9  =  37.0
   │   → Returns 37.0 (degrees Celsius) to the client.
   │
10. System.out.println("Celsius reading: " + 37.0)
    │   → Prints: "Celsius reading: 37.0"
    │
11. Control unwinds: main() returns. JVM exits with code 0.
```

The key observation: the call chain `readCelsius()` → `takeFahrenheitReading()` — plus the unit conversion — is invisible to the client. At step 6 the client believes it is talking to a generic `ICelsiusThermometer`; the delegation and the arithmetic (steps 6 → 7 → 8 → 9) are entirely encapsulated inside the Adapter.

---

## Real-World Use Cases

### 1. Payment Gateway Integration

An e-commerce platform is built against an internal `PaymentGateway` interface with a method `processPayment(Order order)`. The company later integrates Stripe, whose SDK exposes `StripeClient.charge(ChargeParams params)`. Rather than rewriting all payment code to use Stripe's API, a `StripePaymentAdapter` wraps `StripeClient`, implements `PaymentGateway`, converts an `Order` into `ChargeParams`, and delegates. If the company later switches to Braintree, only a new `BraintreePaymentAdapter` is written; the rest of the application is unchanged.

```java
public class StripePaymentAdapter implements PaymentGateway {
    private final StripeClient stripeClient;

    public StripePaymentAdapter(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @Override
    public PaymentResult processPayment(Order order) {
        ChargeParams params = ChargeParams.builder()
            .amount(order.getTotalCents())
            .currency(order.getCurrencyCode())
            .source(order.getPaymentToken())
            .build();
        Charge charge = stripeClient.charge(params);
        return new PaymentResult(charge.getId(), charge.getStatus());
    }
}
```

### 2. Industrial Sensor Telemetry

A factory floor has thousands of legacy analog sensors reporting raw voltage or Fahrenheit readings through a proprietary serial protocol. A modern IoT monitoring platform is built against a `SensorReading` interface that expects SI units. A `LegacySensorAdapter` wraps the serial driver, polls the raw value, converts it to the expected unit, and implements `SensorReading`. When the factory eventually replaces the hardware with modern digital sensors that natively speak the new protocol, the adapter layer is simply removed — the rest of the monitoring platform never changes.

```java
public class LegacySensorAdapter implements SensorReading {
    private final SerialPortDriver serialPortDriver;

    @Override
    public double readValue() {
        double rawVoltage = serialPortDriver.pollRawVoltage();
        return convertVoltageToEngineeringUnits(rawVoltage);
    }
}
```

### 3. Jackson `ObjectMapper` with Legacy Serializers

Pre-Jackson code often used a custom `LegacyJsonSerializer` with a `toJson(Object obj)` method. When migrating to Jackson's `ObjectMapper`, a `JacksonSerializerAdapter` can implement the legacy `JsonSerializer` interface while delegating to `ObjectMapper.writeValueAsString()`. The migration is invisible to the rest of the codebase.

```java
public class JacksonSerializerAdapter implements JsonSerializer {
    private final ObjectMapper objectMapper;

    @Override
    public String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }
}
```

### 4. Spring's `HandlerAdapter`

Spring MVC internally uses the Adapter pattern to support multiple controller styles. The `DispatcherServlet` works against a `HandlerAdapter` interface. `RequestMappingHandlerAdapter` adapts `@RequestMapping`-annotated methods; `HttpRequestHandlerAdapter` adapts `HttpRequestHandler` implementations; `SimpleControllerHandlerAdapter` adapts the older `Controller` interface. The `DispatcherServlet` (the client) calls `HandlerAdapter.handle(request, response, handler)` without knowing which controller style is in use. Each `HandlerAdapter` implementation wraps a different controller type and translates the generic `handle()` call into the specific invocation that the underlying controller expects.

### 5. JDBC Driver

The JDBC specification defines the `java.sql.Driver` interface. Every database vendor (MySQL, PostgreSQL, Oracle) ships its own adapter that implements this interface and delegates to the vendor's proprietary wire protocol. Application code calls `DriverManager.getConnection(url)` and receives a `Connection` — a standard interface. The MySQL driver's internal classes translate every `Statement.execute(sql)` call into MySQL's binary protocol packets. Switching databases is, in principle, a matter of swapping the JDBC driver jar and the connection URL.

---

## Class Adapter vs Object Adapter

The GoF book describes two structural variants of the Adapter pattern. This codebase implements the **Object Adapter**.

### Object Adapter (this implementation)

The Adapter holds a **reference** (a field) to the Adaptee and delegates calls to it. The relationship is **composition** ("has-a").

```java
// Object Adapter — composition
public class FahrenheitSensorAdapter implements ICelsiusThermometer {
    private final LegacyFahrenheitSensor legacyFahrenheitSensor;   // <-- field reference

    public FahrenheitSensorAdapter(LegacyFahrenheitSensor legacyFahrenheitSensor) {
        this.legacyFahrenheitSensor = legacyFahrenheitSensor;
    }

    @Override
    public double readCelsius() {
        return (legacyFahrenheitSensor.takeFahrenheitReading() - 32) * 5 / 9;   // <-- delegation
    }
}
```

**Advantages of Object Adapter:**
- Works with the Adaptee and all of its subclasses — you can pass any subclass of `LegacyFahrenheitSensor` to the constructor.
- The Adaptee does not need to be known at compile time if you program to an interface.
- Preferred in Java because Java does not support multiple class inheritance.
- The Adaptee can be swapped at runtime by passing a different instance to the constructor.

### Class Adapter (hypothetical Java approximation)

The Adapter **inherits** from the Adaptee (or uses multiple inheritance in C++). In Java, this is only partially achievable: the Adapter can `extend` the Adaptee and `implement` the Target interface.

```java
// Class Adapter — inheritance (hypothetical Java version)
public class FahrenheitSensorClassAdapter extends LegacyFahrenheitSensor implements ICelsiusThermometer {

    @Override
    public double readCelsius() {
        return (takeFahrenheitReading() - 32) * 5 / 9;   // calls the inherited method from LegacyFahrenheitSensor
    }
}
```

**Drawbacks of Class Adapter in Java:**
- Binds the Adapter to one specific Adaptee class — subclasses of `LegacyFahrenheitSensor` are not automatically covered.
- Java allows only single class inheritance, so if `LegacyFahrenheitSensor` already extends something else, the Adapter cannot also extend a second useful class.
- The Adapter exposes the Adaptee's `public` methods directly, leaking the legacy API through the adapter.
- This form is generally discouraged in Java. C++ uses it more often because it supports true multiple inheritance.

**Verdict:** For Java, always prefer the Object Adapter (composition). The Class Adapter is a valid option in C++ and in languages that support mixins.

---

## Key Design Decisions

### `private final LegacyFahrenheitSensor legacyFahrenheitSensor` — Why `private` and `final`?

`private` enforces encapsulation: the Adaptee is an implementation detail of the Adapter. Nothing outside `FahrenheitSensorAdapter` should know or care that a `LegacyFahrenheitSensor` exists. If the field were `protected` or `public`, code elsewhere could bypass the Adapter and call `takeFahrenheitReading()` directly, defeating the purpose of the pattern — and worse, receiving a raw, un-converted Fahrenheit value where a Celsius value was expected.

`final` enforces immutability of the collaborator reference. Once the Adapter is constructed, its Adaptee cannot be replaced. This eliminates an entire class of bugs (e.g., a race condition where the Adaptee is swapped between calls in a multi-threaded environment). It also communicates intent: this Adapter is designed for exactly one Adaptee instance over its lifetime.

### Constructor Injection — Why not a setter?

The Adaptee is a **required** dependency. An Adapter without an Adaptee is meaningless and would throw a `NullPointerException` the moment `readCelsius()` is called. Requiring the Adaptee in the constructor makes invalid state — a constructed `FahrenheitSensorAdapter` with no `LegacyFahrenheitSensor` — impossible to represent. Setter injection would allow `new FahrenheitSensorAdapter()` to succeed, deferring the failure to the first method call, which is harder to diagnose.

Constructor injection also plays well with Spring's `@Autowired` constructor injection, making `FahrenheitSensorAdapter` a valid Spring bean without any framework-specific annotations in the field.

### `implements ICelsiusThermometer` — Why not `extends` some base class?

Implementing an interface rather than extending a base class keeps the Adapter's inheritance slot free. If `LegacyFahrenheitSensor` were already a subclass of some framework base class, a class-based Adapter would be impossible in Java. Using `implements` means the Adapter can extend any class it needs to for other reasons while still satisfying the `ICelsiusThermometer` contract.

Interfaces also carry no hidden state, which means the Adapter's behaviour is entirely determined by its own fields and the Adaptee's behaviour — there are no surprise inherited fields or methods to reason about.

### Unit Conversion Inside the Adapter — Why not push it onto the client?

The formula `(F - 32) × 5⁄9` lives inside `FahrenheitSensorAdapter.readCelsius()`, not in `ThermometerAdapterDemo`. This is deliberate: the Adaptee's unit is an implementation detail that the Adapter exists specifically to hide. If the conversion leaked into the client, every caller of `LegacyFahrenheitSensor` would need to remember to convert, and the mistake of forgetting to convert (or converting twice) becomes possible. Centralizing the conversion in the one place that already knows both sides of the translation (the Adapter) is the same principle that keeps `readCelsius()` → `takeFahrenheitReading()` name-mapping in the Adapter rather than in the client.

### Separate Packages — Why not one package?

A single package would work at compile time, but it would conceal the structural roles of each class. The three-package layout (`target`, `adaptee`, `adapter`) makes the dependency graph visible in the filesystem. A new team member can infer from the package names alone that `target` is the contract, `adaptee` is the legacy code, and `adapter` is the bridge. It also prepares the code for realistic scenarios where `adaptee` is replaced by a Maven dependency (a `.jar` shipped by a sensor vendor) and `target` is published as a shared API module.

---

## How to Run

This module is a Maven submodule of the parent `Design_Patterns` reactor (groupId `com.design.patterns`), built against a Spring Boot 2.7.7 parent and Java 1.8. Build and run it from inside this module directory (`Structural/Adapter_Design_Pattern`):

```bash
# Compile (use JDK 11+ explicitly if your default JDK is incompatible with the reactor)
JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64 mvn -o clean compile

# Run the compiled driver class directly
/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp target/classes com.design.patterns.adapter.ThermometerAdapterDemo
```

Drop the `-o` (offline) flag on the `mvn` command only if local dependency resolution fails and Maven needs to reach a remote repository. No application arguments are required — `main(String[] args)` does not read `args`.

---

## Output

Running `ThermometerAdapterDemo.main()` produces:

```
Adapter Design Pattern
Celsius reading: 37.0
```

Line 1 comes from the header `System.out.println` in `main()`. Line 2 comes from `FahrenheitSensorAdapter.readCelsius()`, which calls `LegacyFahrenheitSensor.takeFahrenheitReading()` (returning `98.6`°F), converts it to Celsius via `(98.6 - 32) * 5 / 9`, and returns `37.0` — the human body temperature, expressed in the unit the legacy sensor was never designed to speak.

---

## Summary

| Role | Class | Package | Responsibility |
|---|---|---|---|
| Target | `ICelsiusThermometer` | `target` | Defines the interface the client was written against |
| Adaptee | `LegacyFahrenheitSensor` | `adaptee` | Holds the real behaviour; incompatible method name and unit |
| Adapter | `FahrenheitSensorAdapter` | `adapter` | Implements Target; delegates to Adaptee and converts the unit |
| Client | `ThermometerAdapterDemo` | root | Constructs the objects; uses only the Target interface |

The Adapter pattern solves a fundamental software engineering problem: you have working code and a working interface, but they were not designed to fit together, and you cannot modify either. Rather than forcing a rewrite of the legacy sensor or a breaking change to the established interface, you write a thin translation layer — the Adapter — that makes them cooperate transparently, converting both vocabulary and data along the way. The pattern is ubiquitous in production Java: every JDBC driver, every Spring `HandlerAdapter`, and every legacy hardware integration you have ever used is an Adapter in disguise.
