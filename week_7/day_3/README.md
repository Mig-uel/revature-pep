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
