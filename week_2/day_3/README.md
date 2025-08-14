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
