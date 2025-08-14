# Java Basics and OOP Intro - Day 2

## Wrapper Classes

In Java, wrapper classes are used to convert primitive data types into objects. Each primitive type has a corresponding wrapper class:

- `int` -> `Integer`
- `char` -> `Character`
- `double` -> `Double`
- `boolean` -> `Boolean`
- `byte` -> `Byte`
- `short` -> `Short`
- `long` -> `Long`
- `float` -> `Float`

Wrapper classes provide a way to use primitive types as objects, which is useful in situations where objects are required, such as in collections.

This is necessary, for example, for certain methods which only accept objects and not primitive types.

**Boxing** is the process of converting a primitive type into its corresponding wrapper class object. Java has a feature called **autoboxing** that automatically converts a primitive type to its wrapper class when needed.

**Unboxing** is the reverse process, where the wrapper class object is converted back to its corresponding primitive type. Java also supports **autounboxing**, which automatically converts a wrapper class object to its primitive type when needed.

Below are the wrapper classes and their corresponding primitive types:

| Primitive Type | Wrapper Class |
| -------------- | ------------- |
| `int`          | `Integer`     |
| `char`         | `Character`   |
| `double`       | `Double`      |
| `boolean`      | `Boolean`     |
| `byte`         | `Byte`        |
| `short`        | `Short`       |
| `long`         | `Long`        |
| `float`        | `Float`       |

### Autoboxing and Unboxing Example

```java
public class WrapperExample {
    public static void main(String[] args) {
        // Autoboxing
        int primitiveInt = 5;
        Integer wrappedInt = Integer.valueOf(primitiveInt);

        // Unboxing
        Integer anotherWrappedInt = 10;
        int anotherPrimitiveInt = anotherWrappedInt.intValue();
    }
}
```

### Real World Application

In real-world applications, wrapper classes in Java are essential for several reasons:

1. **Integration with Collections**: Java's collection framework (like `ArrayList`, `HashMap`, etc.) works with objects, not primitives. Wrapper classes allow you to store primitive values in these collections.

2. **Nullability**: Wrapper classes can be `null`, which is useful when you need to represent the absence of a value. For example, an `Integer` can be `null`, while an `int` cannot.

3. **Utility Methods**: Wrapper classes come with useful methods for converting between types, parsing strings, and more. For example, `Integer.parseInt("123")` converts a string to an `int`, while `Double.toString(3.14)` converts a `double` to a string.

4. **Compatibility with Generics**: When using generics, you can only use objects. Wrapper classes allow you to use primitive types in generic classes and methods.

Overall, wrapper classes play a crucial role in Java programming by bridging the gap between primitive types and the object-oriented nature of the language. This enables compatibility with collections, generics, APIs, and additional functionality that primitive types lack. They provide flexibility, nullability, and enhanced functionality, making them indispensable in many Java applications.

## Exceptions vs Errors and Hierarchy

In Java, exceptions and errors are both subclasses of the `Throwable` class, but they serve different purposes and have different implications for error handling.

An error in Java signifies a serious problem that a reasonable application should not try to catch. Errors are typically related to the Java Virtual Machine (JVM) and indicate issues that are outside the control of the application, such as running out of memory or a stack overflow. These errors can manifest as compile-time issues, hindering successful compilation, or as run-time issues, impacting program execution. It is essential to address errors, encompassing both compile-time and run-time, before entering either phase.

**It is important to note that you should not catch errors in your code.** They are meant to indicate serious problems that cannot be handled gracefully.

Alternatively, exceptions in Java denote unexpected or undesirable events that occur during the execution of a program. Exceptions can be anticipated and handled by the application, allowing it to recover from the error and continue running.

Exceptions are further categorized into two main types:

1. **Checked Exceptions**: These are exceptions that are checked at compile-time. The Java compiler requires that you either handle these exceptions using a try-catch block or declare them in the method signature using the `throws` keyword. Examples include `IOException`, `SQLException`, etc.

2. **Unchecked Exceptions**: These are exceptions that are not checked at compile-time. They are usually a result of programming errors, such as logic mistakes or improper use of APIs. Unchecked exceptions extend the `RuntimeException` class and do not need to be declared or handled explicitly. Examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`, etc.

In the Java compilation process, the compiler checks that any checked exceptions that could be thrown are handled (via either try-catch blocks or method declarations). If this is not the case, the compiler cannot compile the code successfully. This is an example of a **compilation error** - not an exception.

**Exceptions are never thrown during compilation.** They only occur at runtime when the program is executed. If an exception occurs, it can be caught and handled using a try-catch block, allowing the program to continue running or terminate gracefully.

Compilation errors generally occur due to improper syntax, type mismatches, or other issues that prevent the code from being compiled successfully.

The table below summarizes the differences between Errors, Exceptions, and Compilation Errors:

| Name                | Description                                           | Occurs At    | Can Be Caught? | Must Be Handled? | Example              |
| ------------------- | ----------------------------------------------------- | ------------ | -------------- | ---------------- | -------------------- |
| Compilation Error   | The compiler cannot compile the source code           | Compile-time | N/A            | N/A              | Syntax error         |
| Error               | Severe problem with the Java Virtual Machine (JVM)    | Runtime      | No             | No               | OutOfMemoryError     |
| Checked Exception   | Any exception not derived from RuntimeException class | Compile-time | Yes            | Yes              | IOException          |
| Unchecked Exception | Any exception derived from RuntimeException class     | Runtime      | Yes            | No               | NullPointerException |

**Exception Class Hierarchy**

The exception class hierarchy in Java is structured as follows:

```
Throwable
├── Error
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── ...
└── Exception
    ├── RuntimeException
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   └── ...
    ├── IOException
    ├── SQLException
    └── ...
```

### Real World Application

In real-world applications, understanding the distinction between errors and exceptions is crucial for robust software development. Here are some scenarios illustrating their usage:

1. **Error Handling**: When developing a large-scale enterprise application, you might encounter `OutOfMemoryError` if the application consumes too much memory. In this case, it's essential to monitor memory usage and optimize resource management rather than attempting to catch the error.

2. **Checked Exceptions**: When working with file I/O, you may encounter `IOException`. Since this is a checked exception, you must handle it using a try-catch block or declare it in the method signature. This ensures that your application can gracefully handle file-related errors, such as missing files or permission issues.

3. **Unchecked Exceptions**: During development, you might introduce a `NullPointerException` due to a programming oversight. While you can catch this exception, it's better to fix the underlying issue (e.g., adding null checks) to prevent it from occurring in the first place.

By understanding and appropriately handling errors and exceptions, developers can create more resilient applications that provide a better user experience.

**Example of Compile-Time Error**

```java
public class CompileTimeErrorExample {
    public static void main(String[] args) {
        // Creating a final variable
        final int constantValue = 10;
        // Attempting to modify a final variable will cause a compile-time error
        constantValue = 20; // This line will cause a compile-time error
    }
}
```

**Example of Runtime Error**

```java
import org.apache.commons.math3.util.ArithmeticUtils;

public class RuntimeErrorExample {
    public static void main(String[] args) {
       // Attempt to use Apache Commons Math to compute the factorial of 5
       long factorial = ArithmeticUtils.factorial(5);
       System.out.println("Factorial of 5 is: " + factorial);
    }
}
```

The compiler will not catch this error at compile time, but it will throw an exception at runtime if the library is not included in the classpath.

When we imported the class using `import org.apache.commons.math3.util.ArithmeticUtils;`, it informs where to find the class during the compilation process. However, during runtime, the availability of the library is crucial. If the library is not present in the classpath, the JVM will throw a `NoClassDefFoundError` or `ClassNotFoundException`, indicating that it cannot find the specified class.

**Checked Exception Example**

Checked exceptions, such as `IOException`, are known to the compiler at compile time. Developer are required to either handle these exceptions using a `try-catch` block or declare them in the method signature using the `throws` keyword.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"));
            String line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
        }
    }
}
```

**Unchecked Exception Example**

Unchecked exceptions, such as `ArrayIndexOutOfBoundsException`, are not checked by the compiler at compile time. Unlike checked exceptions, the compiler does not enforce explicit handling of unchecked exceptions, providing more flexibility but requiring developers to be cautious about potential runtime errors.

```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        // Attempting to access an invalid index will throw an ArrayIndexOutOfBoundsException
        System.out.println(numbers[5]);
    }
}
```

## Handling Exceptions

When an exception occurs, a special class called `Exception` can be **thrown**, which indicates that something went wrong during the execution of the program. This allows developers to handle errors gracefully and take appropriate actions, such as logging the error or providing user feedback.

If the exception is not handled anywhere in the program, it will propagate up the call stack until it reaches the main method. If it remains unhandled, the program will terminate, and an error message will be displayed.

**Handling Exceptions**

When risky code is written that has the possibility of throwing an exception, it can be handled in one of two ways:

- Handling the exception using a try-catch block
- Declaring the exception in the method signature using the throws keyword

### Real World Application

The following class accounts for the possibility for the division by zero by throwing an exception if the denominator is zero:

```java
package com.revature.main;
import java.util.Scanner;
import com.revature.exception.DenominatorCannotBeZeroException;

public class Driver {
  private static Scanner sc = new Scanner(System.in);

  public static double divide(double x, double y) throws DenominatorCannotBeZeroException {
    if (y == 0) {
      throw new DenominatorCannotBeZeroException("Denominator cannot be zero.");
    }
    return x / y;
  }

  public static void main(String[] args) {
    System.out.println("Enter the numerator: ");
    double numerator = Double.parseDouble(sc.nextLine());

    System.out.println("Enter the denominator: ");
    double denominator = Double.parseDouble(sc.nextLine());

    try {
      System.out.println("Result: " + divide(numerator, denominator));
    } catch (DenominatorCannotBeZeroException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
```

## Checked vs Unchecked Exceptions

In Java, exceptions are categorized into two main types: checked and unchecked exceptions.

Exceptions that require mandatory handling are called checked exceptions. These exceptions are checked at compile-time, and the programmer is forced to handle them using try-catch blocks or by declaring them in the method signature with the throws keyword. Examples include IOException and SQLException.

Unchecked exceptions, on the other hand, are not checked at compile-time. These exceptions can occur at runtime and are usually a result of programming errors, such as logic mistakes or improper use of APIs. Examples include NullPointerException and ArrayIndexOutOfBoundsException.

### Real World Application

Checked exceptions are great, so long as you understand when they should be used.

Checked exceptions should be used for predictable, but unpreventable errors that are reasonable to recover from, such as trying to read a file that may not exist.

Unchecked exceptions should be used for errors that are not expected to occur and indicate a programming error, such as trying to access an index that is out of bounds in an array.

Here are some key points to remember about checked and unchecked exceptions:

- Predictable but unpreventable: The caller did everything within their power to validate the input parameters, but some external factor caused the error. For example, you try to reading a file but some deletes it between the time you check if it exists and the time you try to read it. By declaring the exception as checked, you force the caller to handle this case.
- Reasonable to recover from: There is no point telling callers to anticipate exceptions that they cannot recover from. If a user tries to read a file that does not exist, it is reasonable to handle this case by informing the user and allowing them to choose a different file or create the file.
- Unless the exception you are throwing meets all of these criteria, it should be an unchecked exception. Unchecked exceptions are not required to be handled or declared, allowing for more flexibility in error handling.
- Reevaluate at every level: Sometimes the method catching the checked exception isn't the right place to handle it. In that case, consider what is reasonable for your callers. If the exception is predictable, unpreventable, and reasonable to recover from, then it should be a checked exception. If not, it should be an unchecked exception.
- For both checked and unchecked exceptions, use the right abstraction level. For example, a code repo with two different implementations (database and filesystem) should avoid exposing implementation details by throwing `SQLException` or `IOException` directly. Instead, it should wrap the exceptions in an abstraction layer that spans both implementations, such as a custom exception that represents a general data access error.

### Implementation

**Programming with Exceptions**

Exceptions can used to help write robust programs. They provide an organized and structured approach to robustness. Without exceptions, error handling would be chaotic and difficult to manage. By using exceptions, developers can separate error-handling code from regular code, making the program easier to read and maintain.

When a program encounters an exceptional condition and has no way of handling it immediately, the program can throw an exception. In some cases, it makes sense to throw an exception belonging to one of Java's predefined classes, such as `IllegalArgumentException` or `IOException`. However, if there is no standard class that fits the situation, you can create your own exception class by extending the `Throwable` class or one of its subclasses.

In general, if the programmer does not want to require mandatory handling of an exception, they should use an unchecked exception (extend `RuntimeException`). If the programmer wants to require mandatory handling, they should use a checked exception (extend `Exception`).

Here is an example of a class that extends `Exception` and requires mandatory handling:

```java
public class ParseError extends Exception {
  public ParseError(String message) {
    // Create a ParseError object containing the provided message
    super(message);
  }
}
```

The class contains a constructor that takes a message as a parameter and passes it to the superclass constructor. This allows the exception to carry a descriptive message when it is thrown. It also inherits `getMessage()` and `toString()` methods from its superclass, which can be used to retrieve the exception message and a string representation of the exception.
If `e` refers to an object of type `ParseError`, then the function call `e.getMessage()` will return the message passed to the constructor when the exception was created.
The main point of the `ParseError` class is to simply exist. When an object of type `ParseError` is thrown, it indicates that a parsing error has occurred, and the program can handle it accordingly.

A `throw` statement can be used to throw an error of type `ParseError`:

```java
throw new ParseError("Invalid input");
```

or

```java
throw new ParseError("The word '" + word + "' is not valid");
```

Since `ParseError` is defined as a subclass of `Exception`, it is a checked exception. This means that the Java compiler will require any method that throws a `ParseError` to either handle it with a try-catch block or declare it in the method signature using the `throws` keyword.

```java
void getUserData() throws ParseError {
  // Some code that may throw a ParseError
}
```

This would not be required if `ParseError` were defined as a subclass of `RuntimeException` instead of `Exception`.

A way to handle `ParseError` is to use a try-catch block:

```java
try {
  getUserData();
  processUserData()
} catch (ParseError e) {
  System.out.println("An error occurred: " + e.getMessage());
}
```

Note that since `ParseError` is a subclass of `Exception`, a catch clause of the form `catch (Exception e)` would also catch `ParseError`. However, it is generally better to catch specific exceptions rather than using a generic catch clause, as this allows for more precise error handling.

Sometimes, it's useful to store extra data in an exception object, for example:

```java
class ShipDestroyed extends RuntimeException {
  Ship ship; // The ship that was destroyed
  int where_x, where_y; // Coordinates of the ship's destruction

  ShipDestroyed(String message, Ship s, int x, int y) {
    // Constructor creates a ShipDestroyed object
    // carrying an error message plus the information
    // that the ship 's' was destroyed at location (x, y)
    // on that screen
    super(message);
    ship = s;
    where_x = x;
    where_y = y;
  }
}
```

Here, a `ShipDestroyed` object contains an error message and some information about a ship that was destroyed. This could be used, for example, in a statement:

```java
if (userShip.isHit()) {
  throw new ShipDestroyed("You've been hit!", userShip, xPos, yPos);
}
```

Note: the condition represented by a `ShipDestroyed` object might not even be considered an error. It could just be an expected interruption to the normal flow of a game. Exceptions can sometimes be used to handle such interruptions neatly.

**General Purpose Exception Handling**

The ability to throw exceptions is useful in writing general-purpose methods and classes that are meant to be used in more than one program. In this case, the person writing the method or class often has no reasonable way of handling the error, since that person has no way of knowing exactly how the method or class will be used. In such cases, a novice programmer is often tempter to print an error message and forge ahead, but this is a bad idea. It is better to throw an exception and let the caller handle it.

The program that calls the method or uses the class needs to know that the error has occurred. In languages that do not support exceptions, the only alternative is to return some special value or set the value to some global variable to indicate that an error has occurred. It is very easy to be lazy about checking for special return values every time a method is called. This can lead to programs that behave incorrectly in the presence of errors. By using exceptions, the programmer is forced to think about error handling.

It is easy to modify a function to use exceptions instead of a special return value to signal an error. This modified method throw a `ParseError` when the user's input is illegal, where `ParseError` is the subclass of `Exception`. (Arguably, it might be reasonable to avoid defining a new class and just use `IllegalArgumentException`, which is a subclass of `RuntimeException`.)

```java
/**
 * Read the user's input measurement from one line of input.
 * Precondition: The input line is not empty.
 * Postcondition: If the user's input is valid, the method returns the
 *                measurement converted to inches.
 * @throws ParseError if the user's input is invalid.
 */
static double readMeasurement() throws ParseError {
  double inches; // Total number of inches in user's measurement
  double measurement; // One measurement, such as the 12 in "12 miles"

  String units; // The units of the measurement, such as "miles" or "feet"
  char ch; // Used to peek at the next character in the input

  inches = 0; // No inches read yet

  skipBlanks(); // Skip any leading blanks in the input
  ch = TextIO.peek(); // Peek at the next character in the input

  /* As long as there is more input on the line, read a measurement and add
     the equivalent number of inches to the variable, inches. If an error is
     detected during the loop, end the method prematurely by throwing a ParseError. */
  while (ch != '\n' && ch != '\r') {
    /* Get the next measurement and the units. Before reading anything,
       make sure that a legal value is there to read. */
    if (!Character.isDigit(ch))
      throw new ParseError("Expected to find a number, but found '" + ch + "' instead.");

    measurement = TextIO.getDouble(); // Read the measurement

    skipBlanks(); // Skip any blanks after the measurement

    if (TextIO.peek() == '\n') {
      throw new ParseError("Missing unit of measure at end of line.")
    }

    units = TextIO.getWord(); // Read the unit of measure
    units = units.toLowerCase(); // Convert to lower case for easier comparison

    // Convert the measurement to inches and add it to the total
    if (units.equals("inches") || units.equals("inch")) {
      inches += measurement;
    } else if (units.equals("feet") || units.equals("foot")) {
      inches += measurement * 12;
    } else if (units.equals("yards") || units.equals("yard")) {
      inches += measurement * 36;
    } else if (units.equals("miles") || units.equals("mile")) {
      inches += measurement * 63360;
    } else {
      throw new ParseError("Unknown unit of measure: " + units);
    }

    /* Look ahead to see whether the next thing on the line is
       the end of line. */
    skipBlanks();
    ch = TextIO.peek();
  }

  // If we get here, we have read all the measurements on the line.
  if (inches == 0) {
    throw new ParseError("No valid measurements found.");
  }

  return inches;
}

/* In the main program, this method is called in a try-catch block to handle any ParseError exceptions that may be thrown. */
```
