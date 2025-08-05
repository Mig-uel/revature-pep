# Programming Foundations with Java - Day 2

## Testing Through the Main Method

The main method is a special method in Java that serves as the entry point for any Java application. It allows you to test your code by running it directly from the command line or an IDE.

All methods in a class are defined by their access modifier, any non-access modifiers, the return type, the method name, and the parameters. Together, these form the **method signature**.

The main method is a special method - when the code is executed, the JVM looks specifically for this method and invokes this unique method signature.

```java
public static void main(String[] args) {
    // Your code here
    System.out.println("Hello, World!");
}
```

The syntax of the main method is as follows:

- `public` keyword is an access modifier that ensures that the method is available throughout the project.
- `static` keyword is a non-access modifier that ensures that the method is not associated with any instance of the class.
- `void` is the return type, indicating that the method does not return any value.
- `main` is the name of the method.
- `String[] args` is an array of strings that can be used to pass command-line arguments to the program.

### Real World Application

In Java, the `main` method plays a crucial role as it serves as the entry point for the execution of a Java application.

Here are the key points about the importance of the `main` method:

- **Program Execution**: The `main` method is where the Java Virtual Machine (JVM) starts executing the program. Without a `main` method, the JVM will not know where to begin.
- **Required by JVM**: The JVM looks for the `main` method with the exact signature (`public static void main(String[] args)`) to start the execution of the program. If this method is not present, the program will not run.
- **Entry Point for Standalone Applications**: The `main` method serves as the entry point for standalone Java applications. It allows developers to run their code independently without relying on a web server or other external environment.
- **Initialization and Startup Logic**: The `main` method is often used to initialize resources, set up configurations, and perform any necessary startup logic before the application begins its main functionality.
- **Command-Line Arguments**: The `String[] args` parameter allows the program to accept command-line arguments, enabling users to pass input values when running the application. This is useful for configuring the behavior of the program at runtime.

It's important to note that while the `main` method is essential for standalone applications, it is not required for Java classes that are used as libraries or frameworks. In such cases, the classes can be instantiated and used without a `main` method.

## Methods

### What is a Method?

A method is a block of code that performs a specific task. It is a way to organize and reuse code in a program. Methods can take input parameters, perform operations, and return output values.

### Parts of a Method

There are 3 minimum required parts of a method:

- **Method Name**: The name of the method, which is used to call the method.
- **Method Parameters**: The input values that the method takes. These are optional and can be zero or more.
- **Return Type**: The type of value that the method returns. This can be any data type, including `void` if the method does not return a value.

```java
int addNumbers(int a, int b) {
    return a + b;
}
```

In this example:

- `int` is the return type, indicating that the method returns an integer value.
- `addNumbers` is the method name.
- `(int a, int b)` are the method parameters, indicating that the method takes two integer inputs.
- `return a + b;` is the return statement, which returns the sum of the two input parameters.

### How Do We Invoke a Method?

To invoke a method, you simply call it by its name and pass the required arguments (if any) in parentheses. Here's an example of how to invoke the `addNumbers` method:

```java
int result = addNumbers(5, 10);
System.out.println("The sum is: " + result);
```

In this example:

- `addNumbers(5, 10)` is the method call, where `5` and `10` are the arguments passed to the method.
- The return value of the method (the sum of the two numbers) is stored in the variable `result`.
- Finally, we print the result to the console.
- Note, the variable data type must match the return type of the method if you are storing the return value.

## Primitive Data Types

A variable is a container for storing data values. This is a key concept in programming, as it allows you to store and manipulate data within your program.

### Syntax for Using Variables in Java

```java
DataType variableName = value;
```

In this example:

- `DataType` is the type of data you want to store (e.g., `int`, `double`, `String`).
- `variableName` is the name you give to the variable.
- `value` is the initial value assigned to the variable.

Assigning a value to a variable is done using the assignment operator `=`. The value can be a literal value or an expression that evaluates to a value of the specified data type.

When you assign a value to a variable, this is known as **initialization**. You can also change the value of a variable later in your program by reassigning it.

### Primitive Data Types in Java

Java has several primitive data types that are used to store simple values. These data types are built into the language and are not objects.

Note: Java makes an important distinction between primitive data types and reference data types (objects).

- **Primitive Data Types**: These are the basic data types that store simple values directly in memory. They include:
  - `int`: Used to store integer values (whole numbers).
  - `double`: Used to store floating-point numbers (decimal values).
  - `char`: Used to store a single character.
  - `boolean`: Used to store true or false values.
- **Reference Data Types**: These are used to store references to objects in memory. They include:
  - `String`: Used to store a sequence of characters (text).
  - Arrays: Used to store multiple values of the same type.
  - Classes: Used to define custom data types.

A key difference between primitive and reference data types is that the memory location associated with a primitive data type variable contains the actual value, while a reference data type variable contains a reference (or pointer) to the memory location where the object is stored.

Java defines a total of eight primitive data types. Of the eight primitive data types, six are numeric data types, one is a character data type, and one is a boolean data type.

To memorize the 8 primitive data types, you can use the saying: "Bitter black coffee sure is for long days."

| Saying | Primitive Data Type | Size (bits)       | Usage             |
| ------ | ------------------- | ----------------- | ----------------- |
| Bitter | `boolean`           | 1                 | true/false values |
| black  | `byte`              | 1 byte (8 bits)   | Small integers    |
| coffee | `char`              | 2 bytes (16 bits) | Single characters |
| sure   | `short`             | 2 bytes (16 bits) | Small integers    |
| is     | `int`               | 4 bytes (32 bits) | Integers          |
| for    | `float`             | 4 bytes (32 bits) | Floating-point    |
| long   | `long`              | 8 bytes (64 bits) | Large integers    |
| days   | `double`            | 8 bytes (64 bits) | Double precision  |

### Real World Application

Primitive data types in Java exist for several reasons:

- **Efficiency**: Primitive data types are designed to be efficient in terms of memory usage and performance. They are stored directly in memory, which allows for faster access and manipulation compared to reference data types.
- **Simplicity**: Primitive data types provide a simple way to represent basic values such as numbers, characters, and boolean values. They are easy to understand and use, making them suitable for basic programming tasks.
- **Language Design**: Java was designed to be a statically typed language, meaning that variable types are known at compile time. Primitive data types allow for strict type checking, which helps catch errors early in the development process.
- **Historical Reasons**: Primitive data types have been part of programming languages for a long time. They provide a foundation for building more complex data structures and algorithms.

Overall, primitive data types in Java serve to provide foundational set of data representation that is efficient, simple, and consistent with the language's design principles. They are essential for performing basic operations and calculations in Java programs.
