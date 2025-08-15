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
