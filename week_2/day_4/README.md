# Java Basics and OOP Intro - Day 4

## OOP Encapsulation

**Encapsulation** is the OOP principle of bundling the data (attributes) and methods (functions) that operate on the data into a single unit, or class. It restricts direct access to some of an object's components, which can prevent the accidental modification of data.

An object encapsulates or controls the access to its internal state. This prevents arbitrary external interference, which could bring the object into an invalid state. By using access modifiers (like `private`, `protected`, and `public`), a class can hide its internal implementation details and expose only what is necessary for the outside world to interact with it.

When encapsulating code, certain convention should be followed:

- All instance fields for a class should be **private**.
- Each field should have a corresponding **getter** and/or **setter** method to control access and modification (typically these are **public** but other access modifiers can be used as needed).
- Getter and setter methods should be named clearly, following the convention of `getFieldName()` for getters and `setFieldName(value)` for setters.

### Real World Application

Encapsulation is a fundamental concept in OOP that allows developers to create classes that manage their own state and behavior. It provides several benefits:

- **Encapsulation promotes code maintainability**: By hiding the internal state of an object, changes to the implementation can be made without affecting external code that uses the class.
- **Encapsulation improves code readability and understandability**: By clearly defining what data can be accessed and modified, it becomes easier to understand how to interact with an object.
- **Encapsulation enhances security**: By restricting access to an object's internal state, it reduces the risk of unintended interference or misuse of the object's data.

Overall, encapsulation is a key principle in OOP that helps developers create robust, maintainable, and secure applications.

### Implementation

Encapsulation simply means that the attributes of a class should not be directly accessible from outside the class. Instead, they should be accessed through methods (getters and setters).

The following example showcases the application of encapsulation in Java:

```java
class EmployeeCount {
  private int numOfEmployees = 0;

  public void setNumOfEmployees(int count) {
    if (count < 0) throw new IllegalArgumentException("Count cannot be negative");

    this.numOfEmployees = count;
  }

  public int getNumOfEmployees() {
    return this.numOfEmployees;
  }
}

public class EncapsulationExample {
  public static void main(String[] args) {
    EmployeeCount ec = new EmployeeCount();
    ec.setNumOfEmployees(10);
    System.out.println("Number of Employees: " + ec.getNumOfEmployees());

    // Uncommenting the next line will cause a compilation error
    // ec.numOfEmployees = 20; // Error: numOfEmployees has private access in EmployeeCount
  }
}
```

## Access Modifiers

In Java, access modifiers are keywords that set the accessibility (visibility) of classes, methods, and other members. There are four main access modifiers:

1. **public**: The member is accessible from any other class.
2. **private**: The member is accessible only within its own class.
3. **protected**: The member is accessible within its own package and by subclasses.
4. **default** (no modifier): The member is accessible only within its own package.

```java
class AccessModifierExample {
  public int publicField;
  private int privateField;
  protected int protectedField;
  int defaultField; // default access
}
```

### Real World Application

A real-world example of using access modifiers can be found in a banking application. Consider a scenario where you have different types of bank accounts, such as a savings account and a checking account, each with specific rules and restrictions regarding access to account information and operations.

In this scenario, access modifiers can be used to control the visibility and accessibility of various class members (fields and methods) within the bank account classes.

**Private Access Modifier**

The balance field in the bank account class could be marked as private. This ensures that the balance of an account can only be accessed and modified internally within the class, preventing unauthorized access from outside the class.

**Protected Access Modifier**

The interestRate field in a savings account class could be marked as protected. This allows subclasses (e.g., specific types of savings accounts) to access and modify the interest rate while restricting access from other classes. Subclasses can override methods or define additional behavior based on the protected members inherited from the parent class.

**Public Access Modifier**

Getter and setter methods for accessing and modifying the account balance could be marked as public. This allows external classes, such as a user interface or transaction processing system, to interact with the account balance in a controlled manner.

By using access modifiers appropriately, developers can enforce encapsulation and ensure that the internal state of objects is protected from unauthorized access or modification. This leads to more robust and maintainable code.

### Implementation

**Private Access Modifier**

The private access modifier is used to restrict access to class members (fields and methods) to within the same class.

```java
class A {
  private int data = 40;
  private void msg() {
    System.out.println("Data: " + data);
  }
}

public class Example {
  public static void main(String args[]) {
    A obj = new A();
    // obj.data = 50; // Error: data has private access in A
    // obj.msg(); // Error: msg() has private access in A
  }
}
```

**Private Constructor**

If you make any class constructor private, then that class cannot be instantiated from outside the class. This is useful when you want to restrict the instantiation of a class, for example, in the Singleton design pattern.

```java
class A {
  private A() {
    // Private constructor
  }
  void msg() {
    System.out.println("Hello");
  }
}

public class Example {
  public static void main(String args[]) {
    // A obj = new A(); // Error: A() has private access in A
  }
}
```

**Default Access Modifier**

The default access modifier (also known as package-private) is used when no access modifier is specified. Members with default access are accessible only within their own package. It provides more accessibility than private but it is more restrictive than protected and public.

```java
class pack;
class A {
  void msg() {
    System.out.println("Hello");
  }
}

package pack2;
import pack.*;

class B {
  public static void main(String args[]) {
    A obj = new A(); // Error: A is not public in pack; cannot be accessed from outside package
    obj.msg(); // Error: msg() is not public in A; cannot be accessed from outside package
  }
}
```

**Protected Access Modifier**

The protected access modifier allows access to class members within the same package and also to subclasses (even if they are in different packages).

The protected access modifier can be applied on the data member, method, and constructor. It cannot be applied on the class itself.

It provides more accessibility than the default access modifier but is more restrictive than the public access modifier.

```java
package pack;
public class A {
  protected void msg() {
    System.out.println("Hello");
  }
}

package pack2;
import pack.*;

class B extends A {
  public static void main(String args[]) {
    B obj = new B();
    obj.msg(); // This works because B is a subclass of A
  }
}
```

**Public Access Modifier**

The public access modifier allows class members to be accessed from any other class in any package. It provides the highest level of accessibility.

```java
package pack;
public class A {
  public void msg() {
    System.out.println("Hello");
  }
}

package pack2;
import pack.*;

class B {
  public static void main(String args[]) {
    A obj = new A();
    obj.msg(); // This works because msg() is public in A
  }
}
```

## Abstraction

**Abstraction** is the OOP principle of hiding the complex implementation details and showing only the essential features of an object. It allows developers to focus on what an object does rather than how it does it.

Think of a car - you do not need to know how the car works, just how to use the interfaces you are given, like the steering wheel and pedals. Thus, a car "abstracts" away the internal details of the engine, motor, driveshaft, and other components, allowing you to drive without needing to understand the complexities of the machinery involved.

Another example is, if an `Animal` class were part of a library for creating animals in Java. The user of the library would not need to know how the `Animal` class is implemented internally; they only need to know how to create an animal and call its methods.

We can also use the generic `Animal` type for reference variables, allowing us to write code that can work with any subclass of `Animal` without knowing the specific type at compile time.

Let's assume that the `Dog` and `Cat` class extend the `Animal` class. When creating an instance of a `Dog` or `Cat`, we can use the `Animal` type for the reference variable:

```java
Animal myDog = new Dog();
Animal myCat = new Cat();
```

This way, we can treat both `Dog` and `Cat` objects as `Animal` objects, allowing us to write more flexible and reusable code.
The advantage of writing code this way is that later if we decide to add more animal types, we can do so without changing the existing code that uses the `Animal` type. This promotes code reusability and maintainability.

### Real World Application

Abstraction means hiding the lower-level details and showing only the essential features of the object. It helps to reduce programming complexity and effort.

The following example showcases the use of abstraction in Java:

```java
abstract class Shape {
  String color;

  // abstract methods
  abstract double area();
  public abstract String toString();

  // abstract class can have a constructor
  public Shape (String color) {
    this.color = color;
  }

  // concrete method
  public String getColor() {
    return color;
  }
}
```

Here, we created a `Shape` class that is abstract and contains both abstract and concrete methods. The abstract methods `area()` and `toString()` must be implemented by any concrete subclass of `Shape`, while the concrete method `getColor()` can be used as-is by subclasses. The constructor of the abstract class allows us to set the color of the shape when it is created.

When we inherit from the `Shape` class, we must implement the abstract methods:

```java
class Circle extends Shape {
  double radius;

  public Circle(String color, double radius) {
    super(color); // call the constructor of the abstract class

    this.radius = radius;
  }

  @Override
  double Area() {
    return Math.PI * radius * radius; // area of a circle
  }

  @Override
  public String toString() {
    return "Circle [color=" + getColor() + ", radius=" + radius + "]";
  }
}

class Rectangle extends Shape {
  double length;
  double width;

  public Rectangle(String color, double length, double width) {
    super(color);
    this.length = length;
    this.width = width;
  }

  @Override
  double area() {
    return length * width; // area of a rectangle
  }

  @Override
  public String toString() {
    return "Rectangle [color=" + getColor() + ", length=" + length + ", width=" + width + "]";
  }
}
```

## Abstract Classes and Methods

An abstract class is a class that is declared with the `abstract` keyword. It may or may not include abstract methods (methods without a body). Abstract classes cannot be instantiated directly; they are meant to be subclassed.

Abstract classes can have a constructor but still cannot be instantiated directly. Even if you cannot instantiate an abstract class, it still may have some state that it passes down to subclasses that need to be initialized. When a subclass constructor calls `super()`, it calls the abstract class constructor and the state is initialized.

An abstract class can have 0 or more abstract methods, but if a class has at least one abstract method then it must be declared as abstract. It can also have concrete methods (methods with a body) that can be used by subclasses.

```java
public abstract class GraphicObject {
  abstract void draw(); // abstract method
}

class Circle extends GraphicObject {
  @Override
  void draw() {
    System.out.println("Drawing a circle");
  }

  void resize() {
    // implementation for resizing a circle
  }
}

class Rectangle extends GraphicObject {
  @Override
  void draw() {
    System.out.println("Drawing a rectangle");
  }

  void resize() {
    // implementation for resizing a rectangle
  }
}
```

### Real World Application

A real-world use case for abstract classes in Java can be found in the development of a game engine or simulation framework.

Consider a scenario where you are developing a game engine that supports different types of game objects, such as characters, enemies, and obstacles, each with common characteristics and behaviors shared amongst them. Abstract classes can be used to define a common interface and partial implementation for these game objects, while allowing specific objects to extend the abstract and provide their own implementations for certain methods.

- **Abstract GameObject Class**: You could create an abstract class called `GameObject` that defines common properties (like position, velocity) and methods (like `update()`, `draw()`) that all game objects share.
- **Concrete GameObject Classes**: Concrete subclasses like `Player`, `Enemy`, and `Obstacle` would extend `GameObject` and provide specific implementations for the abstract methods, as well as any additional properties or methods unique to each type of game object.
- **Usage in Game Engine**: The game engine could then manage a collection of `GameObject` instances, calling their `update()` and `draw()` methods as needed to render the game world and handle interactions between objects.

In this real-world use case, abstract classes provide a way to define a common interface and partial implementation for a group of related classes, promoting code reuse and reducing duplication.

### Implementation

The keyword `abstract` can be applied to a class or a method.

When applied to a method, it specifies to the compiler that the marked method should be implemented by any concrete subclass of the abstract class. This means that the method does not have a body in the abstract class and must be overridden in the subclasses, providing their own implementation.

```java
public abstract void methodName();
```

When you declare a method `abstract`, then its container class must also be declared as `abstract`. You may, however, declare a class abstract, but not have any abstract methods.

Remember that an abstract class cannot be instantiated directly. You can only create instances of concrete subclasses that implement all the abstract methods.

**Defining Abstract Methods**

As previously stated, abstract methods do not require a method body (i.e. no curly braces). They only require a method signature, which includes the method name, return type, and parameters (if any).

```java
package com.example;
public class Person {
  protected String name;
  public abstract String getName();
  public abstract void setName(String name);
}
```

The above code will throw a compilation error because the class `Person` is not declared as abstract, yet it contains abstract methods. To fix this, you need to either provide implementations for the abstract methods or declare the class as abstract.

```java
package com.example;
public abstract class Person {
  protected String name;
  public abstract String getName();
  public abstract void setName(String name);
}
```

**So why use abstract classes?**

The major reason is to provide a template for other classes to start from. Abstract classes allow you to define common behavior and attributes that can be shared across multiple subclasses, while still enforcing a contract for the subclasses to implement specific methods.

**Using Abstract Classes**

To use an abstract class, you need to create a concrete subclass that extends the abstract class and provides implementations for all its abstract methods.

```java
package com.example;

public class Developer extends Person {
  public Developer(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
```

This creates an inheritance relationship between the `Developer` class and the `Person` class, allowing the `Developer` class to inherit the properties and methods of the `Person` class while providing its own implementations for the abstract methods.
