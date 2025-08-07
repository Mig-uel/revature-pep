# Programming Foundations with Java - Day 4

## Packages and Imports

**What is a package?**

A `package` is a `namespace` that organizes a set of related classes and interfaces. Conceptually similar to directories on your computer, packages help avoid name conflicts and can control access with protected and default access levels. In Java, packages are defined using the `package` keyword.

But what is a `namespace`? A namespace is a container that holds a set of identifiers (such as class names, variable names, etc.) and allows them to be organized and accessed in a controlled manner. In Java, packages serve as namespaces, helping to group related classes and interfaces together.

In simpler terms, a package is like a folder on your computer where you can store related files (classes and interfaces) to keep them organized and avoid naming conflicts. And, a namespace is like the folder itself, providing a way to access and manage the files within it.

(A package is a collection of classes, interfaces, and enums in a hierarchical structure. It helps to organize code and avoid naming conflicts.)

**Why use packages?**

- Organize code: Packages help to group related classes and interfaces together, making it easier to manage and maintain the codebase.
- Avoid naming conflicts: By placing classes in different packages, you can have multiple classes with the same name without causing conflicts.
- Control access: Packages can restrict access to classes and members, allowing you to implement encapsulation and protect your code.
- Packages allow you to distribute your classes to others in a structured way.

**Example of package declaration:**

```java
package com.example.myapp;
```

In this example, this line declares the `package` in which the class will reside, and:

- `com` is the top-level domain (TLD) of the organization.
- `example` is the domain name.
- `myapp` is the name of the application or module.
- This must always be the first line in your Java source file (excluding comments).
- Classes can be referenced anywhere in a program by their "fully qualified name" (e.g., `com.example.myapp.MyClass`).

Typically, we do not want to write out a verbose package declaration every time we reference a class. Instead, we can use the `import` statement to bring specific classes or entire packages into scope, allowing us to use shorter names.

```java
import com.example.myapp.MyClass;
```

With this import statement, we can now refer to `MyClass` directly without the package prefix.

By default, everything in the `java.lang` package is imported automatically, so you don't need to explicitly import classes like `String`, `System`, or `Math`.

However, other classes from different packages need to be imported explicitly using the `import` statement.

### Real World Application

Packages store and organize our Java class and/or interface files.

- Usually we separate them into areas of shared functionality
- In our class, we declare the package in which our class will reside.

Folders provide a good analogy for packages. Just as folders help us organize files on our computer, packages help us organize classes and interfaces in our Java projects.

- Typically, a class will be stored in packages within packages
- We indicate that one package is essentially a subfolder of another by separating the package names with dots (e.g., `com.example.myapp.subpackage`)

Packages follow a naming convention of lowercase characters separated by dots in the reverse domain name format (e.g., `com.example.myapp`).

Java packages must correspond to the directory structure of the project. For example, a class in the package `com.example.myapp` should be located in the directory `com/example/myapp/`.

## Static Members

In Java, a static member is a class-level variable or method that belongs to the class itself rather than to any specific instance of the class. Static members are shared among all instances of the class, meaning they can be accessed without creating an object of the class.

The `static` keyword is mainly used for memory management and to define class-level methods and variables.

We can apply the `static` keyword to variables, methods, blocks, and nest classes.

The `final` keyword can also be used with static members to indicate that the member cannot be changed after it is initialized. This means that the value of a static final variable cannot be modified, and a static final method cannot be overridden in subclasses.

To declare a true constant in Java, we can use the `static final` keywords together. This creates a constant that is associated with the class itself and cannot be changed.

**Example of static members:**

```java
public class MyStaticClass {
  public static int myStaticVariable = 10;

  public static void myStaticMethod() {
      System.out.println("Hello from a static method!");
  }
}
```

In this example, `myStaticVariable` is a static variable that can be accessed without creating an instance of `MyStaticClass`. The `myStaticMethod()` is a static method that can also be called without an instance.

In another file, we can access these members using the following syntax:

```java
public class Main {
  public static void main(String[] args) {
      // Accessing static variable
      System.out.println(MyStaticClass.myStaticVariable);

      // Accessing static method
      MyStaticClass.myStaticMethod();
  }
}
```

### Real World Application

The `static` keyword in Java is used to define class-level members that are shared among all instances of a class. This is useful for defining constants, utility methods, or variables that should be accessible without creating an instance of the class.

Here are some real-world examples of the importance of using the `static` keyword:

- **Constants**: When we need to define a constant value that should not change throughout the program, we can use `static final`. For example, defining a constant for the value of Pi:

```java
public class MathConstants {
  public static final double PI = 3.14159;
}
```

- **Utility Methods**: When we need to define a utility method that can be called without creating an instance of the class, we can use `static`. For example, a utility method for calculating the square of a number:

```java
public class MathUtils {
  public static int square(int number) {
      return number * number;
  }
}
```

- **Factories**: When we need to create factory methods that return instances of a class, we can use `static`. For example, a factory method for creating instances of a `Car` class:

```java
public class CarFactory {
  public static Car createCar(String model, String color) {
      return new Car(model, color);
  }
}
```

- **Counters and Trackers**: When we need to keep track of a count or state that should be shared across all instances of a class, we can use `static`. For example, a counter for the number of instances created:

```java
public class InstanceCounter {
  private static int instanceCount = 0;

  public InstanceCounter() {
      instanceCount++;
  }

  public static int getInstanceCount() {
      return instanceCount;
  }
}
```

- **Singleton Pattern**: When we need to ensure that only one instance of a class exists throughout the application, we can use `static`. For example, a singleton class for managing application settings:

```java
public class SettingsManager {
  private static SettingsManager instance;

  private SettingsManager() {
      // Private constructor to prevent instantiation
  }

  public static SettingsManager getInstance() {
      if (instance == null) {
          instance = new SettingsManager();
      }
      return instance;
  }
}
```

In summary, the static keyword promotes code reusability, simplifies usage, and facilitates the implementation of design patterns such as Singleton and Factory. By understanding and effectively using static members, developers can create more efficient and organized code.

### Implementation

In the Java program below, we are accessing static method `m1()` without creating any object of class `StaticDemo`. The static method can be called directly using the class name.

```java
public class StaticDemo {
  public static void m1() {
      System.out.println("Static method m1()");
  }
}

public class Main {
  public static void main(String[] args) {
      // Calling static method without creating an object
      StaticDemo.m1();
  }
}
```

**Static Blocks**

Static blocks are used for static initializations of a class. This code inside a static block is executed when the class is loaded, and it can be used to initialize static variables or perform any setup that needs to be done only once.

```java
public class StaticBlockDemo {
  static {
      System.out.println("Static block executed");
  }

  public static void main(String[] args) {
      System.out.println("Main method executed");
  }
}
```

If you need to do computation in order to initialize your static variables, you can declare a static block that gets executed exactly one, when the the class is loaded. This is useful for setting up complex static variables or performing one-time initialization tasks.

```java
public class StaticBlockDemo {
  static int a = 10;
  static int b;

  static {
      // Complex initialization logic
      b = a * 2;
      System.out.println("Static block executed");
  }

  public static void main(String[] args) {
      System.out.println("Value of b: " + b);
  }
}
```

**Static Methods**

When a method is declared with the `static` keyword, it is known as a static method. The most common example of a static method is the `main` method, which serves as the entry point for any Java application.

```java
public class StaticMethodDemo {
  public static void main(String[] args) {
      System.out.println("Main method executed");
  }
}
```

Any `static` member can be accessed before any objects of its class are created, and without reference to any object. Methods declared as static have several restrictions:

- They can only directly call other static methods.
- They cannot access instance variables or instance methods.
- They can only directly access static data.
- They cannot refer to `this` or `super` keywords.

```java
class Test {
  // static variable
  static int a = 10;

  // instance variable
  int b = 20;

  // static method
  static void m1() {
    a = 20;
    System.out.println("Static method m1() called");

    // cannot make a static reference to non-static variable b
    b = 30;

    // cannot make a static reference to the non static method m2()
    m2();

    // cannot use super in static context
    System.out.println(super.a);
  }

  // non-static method
  void m2() {
    System.out.println("Non-static method m2() called");
  }

  public static void main(String[] args) {
    // main method
  }
}
```

## Variable Scopes

In Java, variable scope refers to the visibility and lifetime of variables within a program. Understanding variable scope is crucial for managing memory and ensuring that variables are accessible only where they are needed.

When a variable is declared in a Java program, it is attached to a specific \*\*scope within the program, which determines where the variable resides.

The different \*\*scopes of variables in Java are:

- **Instance, or Object Scope**: Instance variables are declared within a class but outside any method. They are associated with an instance of the class and can be accessed by all methods within the class. Instance variables are created when an object of the class is created and destroyed when the object is destroyed.

- **Class or Static Scope**: Static variables are declared with the `static` keyword within a class but outside any method. They are associated with the class itself rather than any specific instance and can be accessed without creating an object of the class. Static variables are created when the class is loaded and destroyed when the class is unloaded.

- **Method Scope**: Variables declared within a method are local to that method and cannot be accessed from outside it. They are created when the method is called and destroyed when the method exits.

- **Block Scope**: Variables declared within a block (e.g., within curly braces `{}`) are local to that block and cannot be accessed from outside it. They are created when the block is entered and destroyed when the block is exited.

### Real World Application

**Overview**
In Java, as in any programming language, each variable has a scope that defines where it can be accessed and how long it exists in memory. Understanding variable scopes is crucial for writing efficient and maintainable code.

**Class Scope**
Class scope refers to variables that are declared within a class but outside any method. These variables are accessible by all methods within the class and are created when an instance of the class is created. Class scope variables are also known as instance variables.

**Method Scope**Method scope refers to variables that are declared within a method. These variables are only accessible within the method and are created when the method is called. Method scope variables are also known as local variables.

**Loop Scope**: Variables declared within a loop (e.g., within a `for` or `while` loop) are local to that loop and cannot be accessed from outside it. They are created when the loop is entered and destroyed when the loop is exited.

**Bracket Scope**: Variables declared within a pair of brackets (e.g., within `{}`) are local to that block and cannot be accessed from outside it. They are created when the block is entered and destroyed when the block is exited.

**Instance Variables**

Instance variables, also known as fields or attributes, are data associated with an instance of a class. They make up the state of an object and can hold different values for different instances.

```java
public class Car {
  public String color;
  public int speed;

  // Constructor
  public Car(String carColor, int carSpeed) {
    color = carColor;
    speed = carSpeed;
  }

  public static void main(String[] args) {
    Car myCar = new Car("Red", 120);
    System.out.println("Car color: " + myCar.color);
    System.out.println("Car speed: " + myCar.speed);
  }
}
```

The keyword `this` is used within an instance method or constructor to refer to the current object. It can be used to access instance variables, call instance methods, and pass the current object as a parameter to other methods.

```java
public class Car {
  public String color;
  public int speed;

  public Car(String color, int speed) {
    this.color = color;
    this.speed = speed;
  }

  public static void main(String[] args) {
    Car myCar = new Car("Red", 120);
    System.out.println("Car color: " + myCar.color);
    System.out.println("Car speed: " + myCar.speed);
  }
}
```

### Implementation

**Member Variables (Class Level Scope)**

Member variables (also known as instance variables) are declared within a class but outside any method. They are associated with an instance of the class and can be accessed by all methods within the class.

We can access these variables anywhere inside the class. Note that the access specifier (private, public, protected) will determine whether these variables can be accessed outside the class.

Java allows us to access the member variables outside the class with the following rules:

| Access Modifier | Package | Subclass | World |
| --------------- | ------- | -------- | ----- |
| public          | Yes     | Yes      | Yes   |
| protected       | Yes     | Yes      | No    |
| private         | No      | No       | No    |
| default         | Yes     | No       | No    |

## Arrays

An array is a data structure that allows us to store multiple values of the same type in a single variable. It is a collection of elements, each identified by an index or key.

It is a contiguous block of memory storing a group of sequentially stored elements of the same type. Arrays in Java are of a fixed size and cannot be resized after creation. Arrays are declared with square brackets `[]` after the data type.

```java
int[] numbers = new int[]{1, 2, 3, 4, 5};
String languages[] = {"Java", "Python", "JavaScript"};
```

Note that the square brackets can be placed before or after the name of the array:

```java
int[] numbers = new int[]{1, 2, 3, 4, 5};
String[] languages = {"Java", "Python", "JavaScript"};
```

- Each item of an array is called an element.
- All elements of an array must be of the same type.
- Items in an array are referenced via an index, which starts at 0.

```java
String myElement = languages[0];
```

Arrays also have a `length` property specifying the length of the array. This is helpful when iterating over arrays with a `for` loop:

```java
String[] myArr = {"Java", "Python", "JavaScript"};

for (int i = 0; i < myArr.length; i++) {
  System.out.println(myArr[i]);
}
```

Even though it has no corresponding class, an array is an object in Java. It inherits from the `Object` class and can be used with methods like `toString()`, `equals()`, and `hashCode()`.

- Thus, you can refer to an entire array by using the array name, and it will return a string representation of the array.

```java
public class ArrayDemo {
  public static void main(String[] args) {
    String[] myArr = {"Java", "Python", "JavaScript"};
    System.out.println(myArr);
  }
}
```

### Real World Application

Arrays are the simplest data structures that store items of the same data type.
Some real-world applications of arrays include:

- Arrangement of the leaderboard of a game
- 2D arrays, commonly known as matrices, are used in computer graphics, image processing, and data analysis.
- It is also used for speech processing, in which each speech signal is represented as an array of samples.
- Your viewing screen is also a 2D array of pixels, where each pixel is represented by an RGB value.
- Book titles in a library can be stored in an array, allowing for easy access and organization.
- Online ticketing systems can use arrays to store available seats, making it easier to manage reservations.
- Contacts on a phone can be stored in an array, allowing for quick access and searching.
- For CPU scheduling, arrays can be used to manage processes and their priorities.
- To store the possible moves of chess pieces on a chessboard, arrays can be used to represent the board and the pieces' positions.
- To store images of a specific size, arrays can be used to represent the pixel values of the image.
