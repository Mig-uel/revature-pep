# Java Collections and Algorithms - Day 3

## Creational Patterns: Factory

Factory Pattern is a design pattern which provides a way to create objects without specifying the exact class of object that will be created. It is used when the type of the object to be created is determined at runtime. There are several reasons to use the Factory Pattern:

- If you do not know the exact types needed before running the code.
- If you want to hide the creational logic, which prevents end user creating things that they should not be creating.
- If you need an easy way to extend internal components by adding new types without changing existing code.
- Depending on implementation, the factory pattern can be used to reuse existing objects instead of creating new ones, which can improve performance and reduce memory usage.

Some extra befits of using the Factory Pattern include:

- Single Responsibility Principle is upheld because the creation logic is separated from the business logic.
- Open/Closed Principle is supported as new types can be added without modifying existing code.
- Abstracts the actual implementation of the object creation, allowing for more flexible and maintainable code.

### Real World Example

The Factory Pattern offers flexibility, encapsulation, and separation of concerns within an application, so it can be widely useable across a variety of scenarios. Many libraries and frameworks implement the Factory Pattern to ensure proper creation of required objects, but allows for the implementor using the library or framework to specify their own use cases. Other real world examples include:

- **Object Creation with Complex Initialization**: When an object requires complex setup or configuration, a factory can encapsulate this logic, making it easier to create instances without exposing the complexity to the client code.
- **Dependency Injection**: In frameworks that support dependency injection, factories can be used to create instances of classes with their dependencies automatically injected, promoting loose coupling and easier testing.
- **Database Access**: A factory can be used to create different types of database connection objects based on configuration settings, allowing the application to switch between databases without changing the code that uses the connections.
- **Logging**: In logging frameworks, a factory can create different types of loggers (e.g., file logger, console logger, remote logger) based on configuration or runtime conditions.
- **GUI Component Creation**: In graphical user interface (GUI) frameworks, factories can be used to create different types of UI components (e.g., buttons, text fields, panels) based on user preferences or application state.

### Implementation

To make a factory, we typically follow these steps:

- Create an interface or abstract class that defines the method for creating objects.
- Create several concrete classes that implement the interface or extend the abstract class, each representing a different type of object to be created (the objects whose instantiation details may not be known until runtime).
- Set up a static method whose return type is the interface or abstract class, which will return the concrete instance based on input parameters or configuration.

```java
// Abstract Data Type
public interface Dessert {}

// Concrete Data Types
public class Cake implements Dessert {}
public class IceCream implements Dessert {}
public class Cookie implements Dessert {}

// Good practice to throw an exception if the desired concrete type is not found
public class DessertNotFoundException extends RuntimeException {}

// Factory Class that creates objects based on input and returns the abstract type
public class DessertFactory {
  public static Dessert getDessert(String dessertType) {
    switch (dessertType.toLowerCase()) {
      case "cake":
        return new Cake();
      case "ice cream":
        return new IceCream();
      case "cookie":
        return new Cookie();
      default:
        throw new DessertNotFoundException(dessertType + " is not a valid dessert type");
    }
  }
}

// Client code
public class Main {
  public static void main(String[] args) {
    Dessert myDessert = DessertFactory.getDessert("cake");
    System.out.println("Enjoy your " + myDessert.getClass().getSimpleName());
  }
}
```

## Video: Factory Design Pattern

- The Factory pattern defines a method that will return an object of a varying class, depending on the input to the method.
- The class is chosen at runtime, so the code that calls the factory method does not need to know about the different classes that might be returned.
- The benefits of the Factory pattern is that it abstracts the away the complexity of choosing the right class to instantiate the object as well as how to instantiate it.
- It follows the Single Responsibility Principle by separating the object creation logic from the business logic.

## Creational Patterns: Singleton

The Singleton Pattern is a design pattern that restricts the instantiation of a class to a single instance and provides a global point of access to that instance. This is useful when exactly one object is needed to coordinate actions across the system. It can be useful for services in an application, or other resources like a connection pool or thread pool.

There are many benefits to using the Singleton Pattern:

- There will be only one instance of the class, which can save memory and resources and allows coordination of actions across the system.
- There is a clear way to fetch the correct instance of the class, which can simplify code and make it easier to understand. For example, a `getInstance()` method can be used to retrieve the singleton instance.
- The programmer has complete control over the instantiation process, which can be useful for managing resources or enforcing certain constraints.
- It is a global access point to the instance, which can be useful for services that need to be accessed from multiple parts of an application.
- The singleton instance can be lazily instantiated, meaning it is only created when it is first needed, which can improve performance and reduce startup time.

However, there are also some drawbacks to using the Singleton Pattern:

- Harder to work with in a multi-threaded environment, as multiple threads may try to create the instance at the same time.
- Different components can be given too much control over the other components, which can lead to tight coupling and make it harder to change or refactor the code.

Overall, there are many situations to use the Singleton Pattern, for instance:

- Where other creational patterns need to limit the number of instances to one.
- Facade pattern (another design pattern) often uses the Singleton pattern to ensure that there is only one instance of the facade class.
- State objects may break if there are multiple instances, so the Singleton pattern can be used to ensure that there is only one instance of the state object.
- Objects used by many different pieces, such as game boards or memory caches, can benefit from being singletons to ensure consistency and avoid duplication.

### Real World Application

The primary benefit of the Singleton Pattern is the management of data or functionality through a single object in memory. There are many real world applications that can benefit from the Singleton Pattern, including:

- **Logging**: A logging class can be implemented as a singleton to ensure that all parts of an application use the same logging instance, which can help maintain consistent logging behavior and configuration.
- **Database Connections**: A database connection manager can be implemented as a singleton to ensure that there is only one instance managing the database connections, which can help prevent resource leaks and improve performance.
- **Caching**: A caching class can be implemented as a singleton to ensure that all parts of an application use the same cache instance, which can help improve performance and reduce memory usage.
- **Configuration Management**: A configuration manager can be implemented as a singleton to ensure that all parts of an application use the same configuration instance, which can help maintain consistent configuration settings and avoid duplication.
- **Thread Pool or Task Manager**: A thread pool or task manager can be implemented as a singleton to ensure that there is only one instance managing the threads or tasks, which can help improve performance and resource management.

### Implementation

To make a class follow the Singleton Pattern, we typically follow these steps:

- `private static` variable of the class type that holds the single instance of the class.
- `private` constructor to prevent instantiation from outside the class.
- `public static getInstance()` method that returns the single instance of the class, creating it if it does not already exist.

```java
public class Singleton {
  // Private static variable to hold the single instance
  private static Singleton instance;
  private int number;

  // Private constructor to prevent instantiation from outside
  private Singleton() {
    this.number = 0; // Example initialization
  }

  // Public static method to provide access to the instance
  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
  // This method is called from an instance of the class
  // However, because there is only one instance, whenever it is called,
  // it will affect all pointers to the instance
  public void printer() {
    this.number++;
    System.out.println("The number is: " + this.number);
  }
}

// Client code
public class Main {
  public static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance(); // Get the single instance
    singleton1.printer(); // Output: The number is: 1

    Singleton singleton2 = Singleton.getInstance(); // Get the same instance
    singleton2.printer(); // Output: The number is: 2

    System.out.println(singleton1 == singleton2); // Output: true (both references point to the same instance)
  }
}
```
