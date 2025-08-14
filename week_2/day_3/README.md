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
