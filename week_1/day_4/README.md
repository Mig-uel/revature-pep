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
