# Java Basics and OOP Intro - Day 3

## OOP Inheritance

**What is inheritance?**

Inheritance is a fundamental concept in Object-Oriented Programming (OOP) that allows a new class (called a subclass or derived class) to inherit properties and behaviors (methods) from an existing class (called a superclass or base class). This promotes code reuse and establishes a hierarchical relationship between classes.

Inheritance is all about inheriting the common state and behavior of a parent class (super class) by its derived class (subclass or child class). A subclass can inherit all **non-private** members (fields and methods) from its superclass, and it can also add new members or override existing ones.

Inheritance can be one of four types - depending on the class' hierarchy:

1. **Single Inheritance**: A subclass inherits from one superclass.
2. **Multiple Inheritance**: A subclass inherits from multiple superclasses (not supported in Java).

- Note: not all programming languages support multiple inheritance due to complexity and ambiguity issues (like the Diamond Problem).

3. **Hierarchical Inheritance**: Multiple subclasses inherit from a single superclass.
4. **Multilevel Inheritance**: A subclass inherits from a superclass, which is also a subclass of another superclass.

### Real World Application

Inheritance is a fundamental concept in object-oriented programming (OOP) with several important benefits:

- **Code Reusability**: Inheritance allows subclasses to reuse code from their superclasses, reducing redundancy and improving maintainability.
- **Extensibility**: New functionality can be added to existing classes without modifying them, making it easier to extend applications.
- **Polymorphism**: Inheritance enables polymorphic behavior, allowing objects of different subclasses to be treated as objects of a common superclass. This simplifies code and enhances flexibility. Polymorphism is the ability of objects to take on different forms or behaviors based on their subclass. Subclasses can override or extend methods inherited from their superclass to provide specific implementations while maintaining a consistent interface. This allows for more flexible and extensible designs.
- **Abstraction and Modularity**: Inheritance promotes abstraction by allowing developers to define common behaviors in a superclass while leaving specific implementations to subclasses. This modular approach makes code easier to understand and maintain.
- **Code Organization and Readability**: Inheritance helps organize code into a clear hierarchy, making it easier to navigate and understand the relationships between classes. This improves code readability and maintainability.

Overall, inheritance is a powerful mechanism in OOP that promotes code reusability, polymorphism, extensibility, abstraction, modularity, and code readability. By leveraging inheritance, developers can create more efficient and maintainable software systems that are easier to understand and extend over time.

### Implementation

The following examples showcase the implementation of inheritance in Java.

```java
public class Bicycle {
  public int cadence;
  public int gear;
  public int speed;

  public Bicycle(int cadence, int gear, int speed) {
    this.cadence = cadence;
    this.gear = gear;
    this.speed = speed;
  }

  public void setCadence(int newValue) {
    this.cadence = newValue;
  }

  public void setGear(int newValue) {
    this.gear = newValue;
  }

  public void applyBrake(int decrement) {
    this.speed -= decrement;
  }

  public void speedUp(int increment) {
    this.speed += increment;
  }
}
```

```java
public class MountainBike extends Bicycle {
  public int seatHeight;

  public MountainBike(int cadence, int gear, int speed, int startHeight) {
    super(cadence, gear, speed);
    this.seatHeight = startHeight;
  }

  public void setHeight(int newValue) {
    this.seatHeight = newValue;
  }
}
```

`MountainBike` is a subclass of `Bicycle` that inherits all the fields and methods from the `Bicycle` class, while also introducing its own specific field (`seatHeight`) and method (`setHeight`). This demonstrates how inheritance allows for the creation of specialized subclasses that build upon the functionality of their superclasses.

## Polymorphism

By definition, **polymorphism** means "taking on many forms". In the context of object-oriented programming, it refers to the ability of different classes to be treated as instances of the same class through a common interface. The most common use of polymorphism is when a parent class reference is used to refer to a child class object.

Polymorphism describes how objects can behave differently in different contexts, allowing for flexibility and extensibility in code design. The most common examples of polymorphism in Java are method overriding and method overloading.

**Method Overloading**

**Method overloading** is a feature that allows a class to have more than one method with the same name, as long as their parameter lists are different. This enables methods to be called with different arguments, providing flexibility in how they are used. Method overloading is determined at compile-time, based on the method signatures.

Basically, method overloading is when there exists two or more methods in a class with the same method name, but different method signatures by changing the parameter list.

We can change the number of parameters, the types of the parameters, or the oder in which parameters are defined. Which version of the method is executed is determined by the arguments passed at runtime or invoked. Note that varying the return type of the method alone is not permitted in some OOP languages.

Because the argument list is known at compilation, the compiler knows which version of the method will be executed. Therefore, method overloading is a type of **compile-time** or **static** polymorphism.

**Method Overriding**

**Method overriding** is a feature that allows a subclass to provide a specific implementation of a method that is already defined in its superclass. When a subclass overrides a method, it provides its own version of the method with the same name, return type, and parameter list as the method in the superclass. This allows the subclass to customize or extend the behavior of the inherited method.

Overriding methods makes class hierarchies more flexible and allows for dynamic method resolution at runtime, which is a key aspect of polymorphism.

If we have a child object that overrides a parent class method, the child classes implementation of a method will be executed. This is known as **virtual method invocation**. The method that gets executed is determined at runtime based on the actual object type, not the reference type. The parent class (if it is abstract) does not even need to define any methods, it just needs to define the method signature. This is the reason why method overriding is sometimes referred to as **runtime** or **dynamic** polymorphism.

One more thing to note with method overriding is that static methods cannot be overridden in the same way as instance methods. If a subclass defines a static method with the same name and signature as a static method in the parent class, it is not considered an override but rather a new method that hides the parent class method. This is known as **method hiding**.

**Covariant Return Types**

When overriding a method, we also have the option of changing the return type - provided that the overridden method's return type **is a subclass of the original return type**. This is known as **covariant return types** and allows for more specific return types in the subclass implementation. We can also choose to change the access modifier of an overridden method, as long as it is not more restrictive than the original method.

## Real World Application

In object-oriented programming, Polymorphism provides the means to perform a single action in multiple different ways. Taking the real world example of animals, if we ask different animals to speak, they respond in their own unique way. A dog barks, a cat meows, and a cow moos. In programming, polymorphism allows us to define a common interface for these animals and implement their specific behaviors in their respective classes.

As another example, consider your mobile phone. You can save your contact in it. Now suppose want to save 2 numbers for one person. You can do it by saving the second number under the same name as the first number, but with a different label (e.g., "Home" and "Work"). This is similar to method overloading, where you can have multiple methods with the same name but different parameters.

## Implementation

There are two types of polymorphism, **static** and **dynamic**.

**Static Polymorphism** (also known as compile-time polymorphism) is achieved through method overloading and operator overloading. In static polymorphism, the method to be executed is determined at compile time based on the method signature.

```java
class Overloading {
  public void display(char c) {
    System.out.println("Character: " + c);
  }
  public void display(char c, int num) {
    System.out.println("Character: " + c + ", Number: " + num);
  }
}

public class Main {
  public static void main(String args[]) {
    Overloading obj = new Overloading();
    obj.display('A'); // Calls the first method
    obj.display('B', 10); // Calls the second method
  }
}
```

**Dynamic Polymorphism** (also known as runtime polymorphism) is achieved through method overriding. In dynamic polymorphism, the method to be executed is determined at runtime based on the actual object type, not the reference type.

```java
public class Animal {
  public void animalSound() {
    System.out.println("Animal makes a sound");
  }
}

public class Dog extends Animal {
  public void animalSound() {
    System.out.println("Dog barks");
  }

  public static void main(String[] args) {
    Animal myDog = new Dog(); // Animal reference but Dog object
    myDog.animalSound(); // Calls the Dog's overridden method
  }
}
```

## Object Class

In Java, the `Object` class is the root class of the Java class hierarchy. Every class in Java implicitly extends the `Object` class, either directly or indirectly. This means that all classes in Java inherit methods from the `Object` class, which provides a set of fundamental methods that are common to all objects.

`Object` is a special class that provides basic functionality for all Java objects.

Consider this example:

```java
public class Manager extends SalariedEmployee {}
public class SalariedEmployee extends Employee {}
public class Employee extends Person {}
public class Person {}
```

The `Manager` class inherits the `Object` class indirectly because it inherits from `SalariedEmployee`, which inherits from `Employee`, which inherits from `Person`. Therefore, all classes in Java have access to the methods defined in the `Object` class.

Creating a class that does not inherit `Object` is not possible in Java, as every class is a descendant of `Object`. This means that every class in Java has access to the methods defined in the `Object` class.

Since all objects inherit from the `Object` class, they have access to the following methods:

- `Object clone()`: Creates and returns a copy of the object.
- `boolean equals(Object obj)`: Compares the object with another object for equality.
- `void finalize()`: Called by the garbage collector before the object is destroyed.
- `Class<?> getClass()`: Returns the runtime class of the object.
- `int hashCode()`: Returns a hash code value for the object.
- `void notify()`: Wakes up a single thread that is waiting on the object's monitor
- `void notifyAll()`: Wakes up all threads that are waiting on the object's monitor.
- `String toString()`: Returns a string representation of the object.
- `void wait()`: Causes the current thread to wait until another thread invokes the `notify()` or `notifyAll()` method on this object.
- `void wait(long timeout)`: Causes the current thread to wait until another thread invokes the `notify()` or `notifyAll()` method on this object, or until the specified timeout expires.
- `void wait(long timeout, int nanos)`: Causes the current thread to wait until another thread invokes the `notify()` or `notifyAll()` method on this object, or until the specified timeout expires, with nanosecond precision.

## Real World Application

The `Object` class is the foundation of Java's object-oriented programming model. It provides essential methods that are inherited by all classes, allowing for consistent behavior across objects. The methods defined in the `Object` class are used for various purposes, such as comparing objects, obtaining their class information, and managing their lifecycle.

The `toString()` method is automatically called if you print an object. Usually, this is overridden to provide a meaningful string representation of the object. Otherwise, you will print out `fully.qualified.ClassName@memoryAddress`, which is not very useful.

The `equals(Object o)` method compares two objects. The `==` operator also compares objects, but only the memory address (i.e. will return `true` if and only if the variables refer to the exact same object in memory). By default, and unless you explicitly override it, the `equals()` method behaves like the `==` operator.

The `hashCode()` method returns a hash code value for the object. There are a few rules that the method follows:

- You are expected to override `hashCode()` if you override `equals()`.
- The result of `hashCode()` should not change during the lifetime of the object.
- If `equals()` returns `true`, then `hashCode()` must return the same value for both objects.
- If `equals()` returns `false`, then `hashCode()` may return the same value for both objects, but it is not required.
- The `finalize()` method is called by the garbage collector when it determines there are no more references to the object. It can be overridden to perform cleanup operations before the object is destroyed, but it is generally not recommended to rely on this method for resource management and has been deprecated in Java 9.

### Implementation

We will introduce two methods that closely belong together: `equals()` and `hashCode()`. We will focus on their relationship with each other, how to properly override them, and why we should do so.

**`equals()`**

The `Object` class defines both `equals()` and `hashCode()` methods, which means that these two methods are implicitly available to all Java objects. The default implementation of `equals()` in the `Object` class compares memory addresses, which means that two different objects will always be considered unequal, even if they have the same content.

```java
class Money {
  int amount;
  String currencyCode;
}
```

```java
Money income = new Money(55, "USD");
Money expenses = new Money(55, "USD");
boolean balanced = income.equals(expenses);
```

We would expect `balanced` to be `true`, but it will actually be `false` because the default implementation of `equals()` compares memory addresses, not the content of the objects.

The default implementation of `equals()` in the `Object` class says that equality is the same as object identity (i.e., two references are equal if they point to the same object in memory), and `income` and `expenses` are two different objects in memory.

Let's override the `equals()` method do that it does not consider only object identity, but also the content of the objects:

```java
@Override
public boolean equals(Object o) {
  if (o == this) return true;

  if (!(o instanceOf Money)) return false;

  Money other = (Money)o; // cast the object to Money

  boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null) || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));

  return this.amount == other.amount && currencyCodeEquals;
}
```

This implementation first checks if the object being compared is the same instance (`o == this`). If it is, it returns `true`. Then, it checks if the object is an instance of the `Money` class. If not, it returns `false`. Finally, it compares the `amount` and `currencyCode` fields for equality.

`equals()` conditions Java defines:

1. Reflexive: an object must equal itself
2. Symmetric: `x.equals(y)` must return the same result as `y.equals(x)`
3. Transitive: if `x.equals(y)` and `y.equals(z)` are both true, then `x.equals(z)` must also be true
4. Consistent: the value of `equals()` should change only if a property that is contained in `equals()` changes (no randomness allowed)
5. Non-nullity: for any non-null reference value `x`, `x.equals(null)` must return `false`

**Violating `equals()` Symmetry with Inheritance:**

If the criteria for `equals()` is such common sense, then how can we violate it at all? Well, violations happen most often if we extend a class that has overridden `equals()` in a way that is not consistent with the superclass's implementation. For example, if a subclass adds new fields to the comparison but does not account for the superclass's fields, it can lead to asymmetric behavior.

Let's consider a `Voucher` class that extends our `Money` class:

```java
class WrongVoucher extends Money {
  private String store;

  @Override
  public boolean equals(Object o) {
    if (o == this) return true; // check if the object is the same instance

    if (!(o instanceof WrongVoucher)) return false; // check if the object is an instance of WrongVoucher

    WrongVoucher other = (WrongVoucher)o; // cast the object to WrongVoucher

    boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null) || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));

    boolean storeEquals = (this.store == null && other.store == null) || (this.store != null && this.store.equals(other.store));

    return this.amount == other.amount && currencyCodeEquals && storeEquals;
  }
}
```

At first glance, the `WrongVoucher` class and its overridden `equals()` method seem to be correct. And both `equals()` methods behave correctly as long as we compare `Money` to `Money` or `Voucher` to `Voucher`. But what would happen if we compare `Money` to `WrongVoucher`?

```java
Money cash = new Money(42, "USD");
WrongVoucher voucher = new WrongVoucher(42, "USD", "Amazon");

voucher.equals(cash); // returns false (expected)
cash.equals(voucher); // returns true (unexpected)
```

This violates the symmetry condition of `equals()`, because `voucher.equals(cash)` returns `false`, while `cash.equals(voucher)` returns `true`. The reason for this violation is that the `WrongVoucher` class's `equals()` method does not consider the fields of the `Money` class, leading to inconsistent behavior when comparing objects of different types. To avoid such issues, it is generally recommended to use composition over inheritance when designing classes that require equality.

**Fixing `equals()` Symmetry with Composition**

To avoid this pitfall, we should favor composition over inheritance. Instead of sub-classing `Money`, we can create a `Voucher` class that contains a `Money` instance:

```java
class Voucher {
  private Money value;
  private String store;

  Voucher(int amount, String currencyCode, String store) {
    this.value = new Money(amount, currencyCode);
    this.store = store;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;

    if (!(o instanceof Voucher)) return false;

    Voucher other = (Voucher)o; // cast the object to Voucher

    boolean valueEquals = (this.value == null && other.value == null) || (this.value != null && this.value.equals(other.value)); // check if value is null or equals

    boolean storeEquals = (this.store == null && other.store == null) || (this.store != null && this.store.equals(other.store)); // check if store is null or equals

    return valueEquals && storeEquals;
  }
}
```

**`hashCode()`**

`hashCode()` is a method that returns an integer hash code value for the object. It is used in hash-based collections like `HashMap`, `HashSet`, and `HashTable` to quickly locate objects. The hash code is used to determine the bucket in which the object will be stored, allowing for efficient retrieval.

When overriding `equals()`, it is essential to also override `hashCode()` to maintain the contract between these two methods. The contract states that if two objects are considered equal by the `equals()` method, they must return the same hash code.

`hashCode()` conditions:

- Internal consistency: the value of `hashCode()` may only change if a property that is in `equals()` changes.
- Equals consistency: objects that are equal to each other must return the same hash code.
- Collisions: unequal objects may return the same hash code, but it is not required.

**Violating the Consistency of `hashCode()` and `equals()`**

If we override `equals()` but forget to override `hashCode()`, we can end up with inconsistent behavior in hash-based collections. For example, if two objects are considered equal by `equals()` but have different hash codes, they may end up in different buckets in a `HashMap`, leading to unexpected behavior when retrieving them.

By far the most widespread violation of the `hashCode()` and `equals()` contract occurs when developers override `equals()` but neglect to override `hashCode()`. This can lead to subtle bugs that are difficult to track down, especially in large codebases.

Let's see such an example:

```java
class Team {
  String city;
  String department;

  @Override
  public final boolean equals(Object o) {
    // implementation of equals()
  }
}
```

The `Team` class overrides `equals()`, but it still implicitly uses the default implementation of `hashCode()`, which is based on the object's memory address. Thus returns a different hash code for each instance of `Team`, even if they are considered equal by the `equals()` method which violates the rule that equal objects must have the same hash code.

Now, if we create two `Team` objects, both with city "New York" and department "Marketing", they will be considered equal by the `equals()` method, but they will have different hash codes. This can lead to unexpected behavior when using these objects in hash-based collections.

But why is the violation in our `Team` class a problem? Well, the trouble starts when some hash-based collection (like a `HashMap`) uses the `Team` objects as keys. If we try to retrieve a value using one of the `Team` objects, it will not be found because the hash code of the other `Team` object is different, even though they are considered equal by the `equals()` method.

Let's try to use our `Team` class as a key of a `HashMap`:

```java
Map<Team, String> leaders = new HashMap<>();

leaders.put(new Team("New York", "Development"), "Anne");
leaders.put(new Team("Boston", "Development"), "Brian");
leaders.put(new Team("Boston", "Marketing"), "Charlie");

Team myTeam = new Team("New York", "Development");
String myTeamLeader = leaders.get(myTeam); // returns null
```

We would expect `myTeamLeader` to be "Anne", but it is `null`. This is because the `Team` class does not override `hashCode()`, so the default implementation is used, which is based on the object's memory address. As a result, the `HashMap` cannot find the value associated with the key `myTeam`, even though it is considered equal to the key used when the entry was added.

If we want to use instances of the `Team` class as `HashMap` keys, we have to override the `hashCode()` method to ensure that equal objects have the same hash code.

```java
@Override
public final int hashCode() {
  int result = 17; // a non-zero constant to start with

  if (city != null) {
    result = 31 * result + city.hashCode(); // multiply by a prime number
  }

  if (department != null) {
    result = 31 * result + department.hashCode(); // multiply by a prime number
  }

  return result; // the final hash code
}
```

After this change, the `Team` class will have a consistent `hashCode()` implementation that matches the `equals()` implementation, allowing it to be used correctly in hash-based collections.

When do we override `equals()` and `hashCode()`? The general rule of thumb is:

1. **Override `equals()`** when you need to define a custom equality check for your objects. This is often the case when your class has meaningful fields that should be considered when determining equality.

2. **Override `hashCode()`** whenever you override `equals()`. Failing to do so can lead to the issues we discussed earlier, where equal objects have different hash codes, causing problems in hash-based collections.

In summary, if you override `equals()`, you must also override `hashCode()` to maintain the general contract for the `hashCode()` method, which states that equal objects must have the same hash code.

Domain-Driven Design (DDD) can help us decide when to override `equals()` and `hashCode()`. In DDD, we often define entities and value objects. Entities are objects that have a distinct identity, while value objects are objects that are defined by their attributes and do not have a distinct identity.
