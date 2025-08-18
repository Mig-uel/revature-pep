# OOP, Maven, and Developer Practices - Day 1

## SOLID Design Principles

The **SOLID** principles are a set of five design principles that help software developers design maintainable, understandable, and flexible software systems. The principles are:

1. **Single Responsibility Principle (SRP)**
2. **Open/Closed Principle (OCP)**
3. **Liskov Substitution Principle (LSP)**
4. **Interface Segregation Principle (ISP)**
5. **Dependency Inversion Principle (DIP)**

By following these principles, developers can create systems that are easier to manage and extend over time.

**Single Responsibility Principle (SRP)**
SRP states that a class should have only one reason to change, meaning it should only have one job or responsibility. This principle helps to reduce the complexity of the code and makes it easier to maintain and understand.

- To apply SRP in Java, aim to create classes that have a clear and single responsibility, and avoid adding unrelated functionalities to them.
- If a class has multiple responsibilities, consider refactoring it into smaller, more focused classes, each with its own responsibility.

**Open/Closed Principle (OCP)**
OCP states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to add new functionality to a class without changing its existing code. To achieve this, you can use techniques such as inheritance, interfaces, and composition.

- To apply OCP in Java, aim to design classes that can be extended without modifying their existing code. Use abstract classes or interfaces to define contracts that can be implemented by other classes.
- This can be achieved by using interfaces, abstract classes, composition, and polymorphism.

**Liskov Substitution Principle (LSP)**
LSP states that subtypes should be substitutable for their base types without affecting the correctness of the program. This means that if a class is a subtype of another class, it should be able to replace the base class without altering the desirable properties of the program.

- To apply LSP in Java, ensure that subclasses can be used interchangeably with their parent classes without causing unexpected behavior.

**Interface Segregation Principle (ISP)**
ISP states that clients should not be forced to depend on interfaces they do not use. This means that you should create smaller, more specific interfaces rather than large, general-purpose ones.

- To apply ISP in Java, design interfaces that are focused on specific functionalities and avoid creating "fat" interfaces that include methods not needed by all implementing classes.

**Dependency Inversion Principle (DIP)**
DIP states that high-level modules should not depend on low-level modules; both should depend on abstractions. This principle encourages the use of interfaces or abstract classes to decouple high-level and low-level components.

- To apply DIP in Java, use dependency injection to provide dependencies to classes rather than hardcoding them. This allows for greater flexibility and easier testing.
- Abstractions should not depend on details, but details should depend on abstractions.
- You should use interfaces or abstract classes to define the behavior of your classes, and then use dependency injection to provide specific implementations.

By following these principles, you can create a well-structured and maintainable codebase that is easier to understand and extend over time.

### Real World Application

We will describe how each **SOLID** principle can be used in real world applications:

**Single Responsibility Principle (SRP)**

In a web application, a User class should handle user-specific functionalities like user authentication and user authorization, while a separate EmailService class should handle email-related functionalities like sending and receiving emails. SRP ensures that each class should be responsible for specific functionalities, making the codebase easier to maintain and extend. This separation also ensures that changes to the email functionality do not impact the user-related functionality and vice versa.

**Open-Closed Principle (OCP)**

Consider a payment system where new payment methods can be added. By leveraging OCP, rather than modifying the existing payment processing code, you can create new classes that extend the payment functionality. For example, you can define an interface called PaymentProcessor and have multiple classes implement it, such as CreditCardProcessor, PayPalProcessor, and BankTransferProcessor. This allows you to add new payment methods without changing the existing code, adhering to the OCP principle.

**Liskov Substitution Principle (LSP)**
In a banking application with different account types like SavingsAccount and CheckingAccount inheriting from the base class Account, LSP ensures that code expecting an Account object can seamlessly work with any subclass without knowing the details of the specific account type. This means that methods using the Account type can operate on any derived class, promoting code reusability and flexibility.

**Interface Segregation Principle (ISP)**

If we apply ISP to to a messaging system, instead of having a single IMessage interface with multiple methods like SendMessage, ReceiveMessage, and DeleteMessage, separate interfaces like ISender and IReceiver can be created. This way, classes that only need to send messages can implement ISender without being forced to implement methods they do not use. This leads to cleaner and more maintainable code.

**Dependency Inversion Principle (DIP)**
In an e-commerce application, instead of the OrderProcessor class depending directly on a specific payment gateway implementation, it can depend on an IPaymentGateway interface. This allows the OrderProcessor to work with any payment gateway that implements the interface, promoting flexibility and easier testing. By using dependency injection, the specific payment gateway implementation can be provided at runtime, adhering to the DIP principle.

### Implementation

**Single Responsibility Principle (SRP)**

Let's say we have a User entity that we want to be able to authenticate. In the example below, we have persistence and authentication logic within the same class.

```java
// Incorrect
class User {
  public boolean authenticateUser() {
    // authentication logic here
  }
  public void createUser() {
    // user persistence logic here
  }
}
```

This violates the Single Responsibility Principle because the User class has two responsibilities: authentication and persistence. To apply SRP, we can refactor the code into separate classes: `UserAuthenticator` and `UserDAO` (DAO stands for Data Access Object).

```java
// Correct
class UserAuthenticator {
  public boolean authenticateUser() {
    // authentication logic here
  }
  // other methods that handle user authentication
}

class UserDAO {
  public void createUser() {
    // user persistence logic here
  }
  // other methods that handle user persistence
}
```

**Open-Closed Principle (OCP)**
In the example below, we have a `Vehicle` class that has a speed instance variable and an `accelerate()` method.

```java
// Incorrect
class Vehicle {
  int speed;
  public double accelerate(Vehicle v) {
    if (v instanceof Car) {
      return v.speed + 10; // specific logic for Car
    }
    if (v instanceof Truck) {
      return v.speed += 5;
    }
  }
}
```

The logic above does NOT follow the Open-Closed Principle because it requires modifying the `Vehicle` class to add new vehicle types. To apply OCP, we can create a new class that implements the same interface and provides the new functionality:

```java
// Correct
interface Vehicle {
  public double accelerate();
}
class Car implements Vehicle {
  int speed;

  @Override
  public double accelerate() {
    this.speed += 10;
    return this.speed;
  }
}

class Truck implements Vehicle {
  int speed;

  @Override
  public double accelerate() {
    this.speed += 5;
    return this.speed;
  }
}
```

**Liskov Substitution Principle (LSP)**

In the example below, we have a `Bird` class and a `Penguin` subclass.

```java
// Incorrect
class Bird {
  public void fly() {}
}
class Penguin extends Bird {
  public void fly() {
    // implements walking logic since penguins can not fly
  }
}
```

The code above violates LSP because the subclass `Penguin` changes the intent of the `fly()` method. Instead of flying, it provides an implementation that does not fulfill the expected behavior of a `Bird`. To adhere to LSP, we could redesign the class hierarchy or the method to ensure that all subclasses maintain the expected behavior.

We can instead expand the inheritance hierarchy to have `Flying` and `Flightless` subtypes or use an interface that defines the `fly()` behavior:

```java
// Correct
class Bird {}

interface Flyable {
  public void fly();
}

class Penguin extends Bird {}

class Albatross extends Bird implements Flyable {
  @Override
  public void fly() {
    // flying logic here
  }
}
```

**Interface Segregation Principle (ISP)**

In the example below, we have a `Vehicle` interface that defines several behaviors. The `Bike` class can implement some of these behaviors, but not all of them.

```java
// Incorrect
interface Vehicle {
  public void accelerate();
  public void brake();
  public void openDoors();
}

class Bike implements Vehicle {
  @Override
  public void accelerate() {
    // bike-specific acceleration logic
  }

  @Override
  public void brake() {
    // bike-specific braking logic
  }

  @Override
  public void openDoors() {
    // bikes do not have doors, so this method is irrelevant
  }
}
```

The code above violates ISP because the `Bike` class is forced to implement a method (`openDoors()`) that it does not use. To apply ISP, we can create smaller, more specific interfaces:

```java
class Vehicle {
  public void accelerate();
  public void brake();
}

interface Enterable {
  public void openDoors();
}

class Bike implements Vehicle {
  @Override
  public void accelerate() {
    // bike-specific acceleration logic
  }

  @Override
  public void brake() {
    // bike-specific braking logic
  }
}

class Truck extends Vehicle implements Enterable {
  @Override
  public void accelerate() {
    // truck-specific acceleration logic
  }

  @Override
  public void brake() {
    // truck-specific braking logic
  }

  @Override
  public void openDoors() {
    // truck-specific door opening logic
  }
}
```

**Dependency Inversion Principle (DIP)**

In the example below, we have a `NotificationService` class that uses an `EmailSender` object to send a notification.

```java
// Incorrect
class NotificationService {
  EmailSender emailSender = new EmailSender();

  sendNotification() {
    emailSender.send();
  }
}

class EmailSender {
  send() {
    // email sending logic
  }
}
```

The code above violates DIP because the `NotificationService` class depends directly on the `EmailSender` class. To apply DIP, we can introduce an interface for sending notifications and use dependency injection to provide the specific implementation.

We can instead have a general supertype, `Sendable`. This allows our `NotificationService` class the flexibility of swapping between different implementations of the `Sendable` object:

```java
// Correct
class NotificationService {
  Sendable sender = new EmailSender();

  sendNotification() {
    sender.send();
  }
}

interface Sendable {
  send();
}

class EmailSender implements Sendable {
  @Override
  public void send() {
    // email sending logic
  }
}

class SmsSender implements Sendable {
  @Override
  public void send() {
    // SMS sending logic
  }
}
```
