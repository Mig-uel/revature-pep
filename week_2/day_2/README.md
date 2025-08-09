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
