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

## Working with Basic Operators

### Operators

Operators are special symbols or keywords that perform specific operations on one or more operands (values or variables). They are used to manipulate data and perform calculations in programming.

If we want to make programs that "do something", we are going to need to create instructions that manipulate values and return new ones.

Programming operations can be thought of just like mathematical operations. When programming however, we can almost never assume that a value is known or fixed.
Instead, we'd have to represent an equation as: `int result = a + b;` where `a` and `b` are variables that can change. The symbols that we to perform operations are called **operators**.

There are several types of operators in Java. We have already seen the assignment operator `=` which assigns a value to a variable.

### Increment and Decrement Operators

Increment and decrement operators are special operators that are used to increase or decrease the value of a variable by 1. They are often used in loops and other iterative processes.

In order to increment or decrement integral values, we can use the common **postfix** operators: `x++` and `x--`, where `x` is a `byte`, `short`, `int`, or `long` variable.

A similar operator is the **prefix** operator, which is written as `++x` or `--x`. The difference is that the prefix operator will change the value before the rest of the expression is evaluated, while the postfix operator will change the value after the rest of the expression is evaluated.

Example:

```java
int a = 5;
int b = a++; // b is assigned the value of a (5), then a is incremented to 6
int c = ++a; // c is assigned the value of a (7), a is incremented before assignment
System.out.println("a: " + a); // Outputs: a: 7
System.out.println("b: " + b); // Outputs: b: 5
System.out.println("c: " + c); // Outputs: c: 7
```

### Logical Operators

Logical operators are used to combine multiple boolean expressions and return a boolean result.

Logical, or boolean, operators perform operations that return **boolean** results. There are a few logical operators that you should be aware of:

- **&&**: is the logical AND operator - it compares two boolean values and returns true if both values are true.
- **||**: is the logical OR operator - it compares two boolean values and returns true if at least one of the values is true.
- **!**: is the logical NOT operator - it negates a boolean value, returning true if the value is false, and false if the value is true.

Example:

```java
boolean a = true;
boolean b = false;

if (!(a && b)) {
    System.out.println("At least one is false");
}
```

In this example, we use parentheses to prioritize the evaluation of the `a && b` expression. The `!` operator negates the result, so the condition evaluates to true, and the message is printed.

### Comparison Operators

Comparison operators are used to compare two values and return a boolean result. They are often used in conditional statements and loops.

Here the main comparison operators in Java:

- **==**: checks if two values are equal.
  - Example: `5 == 5` returns `true`, while `5 == 3` returns `false`.
- **!=**: checks if two values are not equal.
  - Example: `5 != 5` returns `false`, while `5 != 3` returns `true`.
- **>**: checks if the left value is greater than the right value.
  - Example: `5 > 3` returns `true`, while `5 > 5` returns `false`.
- **<**: checks if the left value is less than the right value.
  - Example: `5 < 3` returns `false`, while `5 < 5` returns `false`.
- **>=**: checks if the left value is greater than or equal to the right value.
  - Example: `5 >= 5` returns `true`, while `5 >= 3` returns `true`.
- **<=**: checks if the left value is less than or equal to the right value.
  - Example: `5 <= 5` returns `true`, while `5 <= 3` returns `false`.

### Ternary Operator

The ternary operator is a shorthand way to write an if-else statement. It takes three operands and is often used to assign a value based on a condition.

The syntax is as follows:

```java
x = condition ? valueIfTrue : valueIfFalse
```

If the condition is true, `x` is assigned the value of `valueIfTrue`. If the condition is false, `x` is assigned the value of `valueIfFalse`.

Example:

```java
boolean skyIsBlue = true;
boolean twoAndTwoIsFour = true;
boolean makesSense = (skyIsBlue && twoAndTwoIsFour) ? true : false;
```

In this example, the condition `(skyIsBlue && twoAndTwoIsFour)` evaluates to true, so `makesSense` is assigned the value of `true`.

### Operator Precedence

Operator precedence determines the order in which operators are evaluated in an expression. Operators with higher precedence are evaluated before operators with lower precedence. (Precedence means "which comes first".)

The operators below are listed in order of precedence, from highest to lowest. operators with higher precedence are evaluated before operators with lower precedence.

When operators of equal precedence appear in the same line of code:

- **Left to Right**: Most operators are evaluated from left to right. For example, in the expression `a - b + c`, the subtraction (`-`) is performed before the addition (`+`).
- Assignment operators (`=`, `+=`, `-=`) are evaluated from right to left. For example, in the expression `a = b = c`, `b = c` is evaluated first, and then the result is assigned to `a`.

| Operators                                      | Precedence |
| ---------------------------------------------- | ---------- |
| `++`, `--` (postfix)                           | Highest    |
| `++`, `--` (prefix)                            |            |
| multiplicative: `*`, `/`, `%`                  |            |
| additive: `+`, `-`                             |            |
| shift: `<<`, `>>`, `>>>`                       |            |
| relational: `<`, `>`, `<=`, `>=`, `instanceof` |            |
| equality: `==`, `!=`                           |            |
| bitwise AND: `&`                               |            |
| bitwise XOR: `^`                               |            |
| bitwise OR: `\|`                               |            |
| logical AND: `&&`                              |            |
| logical OR: `\|\|`                             |            |
| ternary: `? :`                                 |            |
| assignment: `=`, `+=`, `-=`, `*=`, `/=`, `%=`  | Lowest     |

## Real World Application

Operators are fundamental components of programming languages, including Java, and they serve several important purposes in real-world applications:

- **Data Manipulation**: Operators allow developers to manipulate data and perform calculations. This is essential for tasks such as mathematical computations, data processing, and algorithm implementation.
- **Control Flow**: Operators are used in conditional statements and loops to control the flow of execution in a program. For example, comparison operators are used in `if` statements to make decisions based on certain conditions.
- **Expressing Logic**: Logical operators enable developers to express complex logical conditions in a concise manner. This is particularly useful in scenarios where multiple conditions need to be evaluated.
- **Efficiency**: Operators provide a way to perform operations efficiently. For example, arithmetic operators allow for quick calculations, while bitwise operators enable low-level manipulation of data at the binary level.

Overall, operators are indispensable tools in application development, enabling developers to manipulate data, express logic, control program flow, manipulate strings, improve efficiency, adhere to coding standards, and abstract underlying computational concepts effectively.

## Implementation

### Java Unary Operators

The unary operators in Java are used to perform operations on a single operand. Unary operators are used to perform various operations such as:

- Incrementing or decrementing a value
- Negating an expression
- Inverting a boolean value
- Performing bitwise operations

Example of Unary Operators `++` and `--`:

```java
public class OperatorExample {
  public static void main(String[] args) {
    int x = 10;

    System.out.println("x++:", x++); // Postfix increment: prints 10, then increments x to 11
    System.out.println("++x:", ++x); // Prefix increment: increments x to 12, then prints 12
    System.out.println("x--:", x--); // Postfix decrement: prints 12, then decrements x to 11
    System.out.println("--x:", --x); // Prefix decrement: decrements x to 10, then prints 10
  }
}
```

Example of Unary Operator `!`:

```java
public class OperatorExample {
  public static void main(String[] args) {
    boolean isTrue = true;

    System.out.println("!isTrue:", !isTrue); // Inverts the boolean value, prints false
  }
}
```

### Java Arithmetic Operators

Arithmetic operators in Java are used to perform basic mathematical operations on numeric values. These operators include addition, subtraction, multiplication, division, and modulus.
Example of Arithmetic Operators:

```java
public class ArithmeticExample {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;

    System.out.println("Addition (a + b): " + (a + b)); // Outputs: 15
    System.out.println("Subtraction (a - b): " + (a - b)); // Outputs: 5
    System.out.println("Multiplication (a * b): " + (a * b)); // Outputs: 50
    System.out.println("Division (a / b): " + (a / b)); // Outputs: 2
    System.out.println("Modulus (a % b): " + (a % b)); // Outputs: 0
  }
}
```

### Java `AND` Operator Example: Logical `&&` and Bitwise `&`

The `AND` operator in Java can be used in two contexts: logical `&&` for boolean expressions and bitwise `&` for integer operations.

The logical `&&` operator does not evaluate the second operand if the first operand is false, while the bitwise `&` operator evaluates both operands.

Example of Logical `&&` Operator:

```java
public class LogicalAndExample {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;
    int c = 20;

    System.out.println(a < b && b < c); // Outputs: false, because a < b is false
    System.out.println(a < b & a < c); // Outputs: false, both conditions are evaluated
  }
}
```

Example of Bitwise `&` Operator:

```java
public class BitwiseAndExample {
  public static void main(String[] args) {
    int x = 6; // Binary: 0110
    int y = 3; // Binary: 0011

    System.out.println("x & y: " + (x & y)); // Outputs: 2 (Binary: 0010)
  }
}
```

### Java `OR` Operator Example: Logical `||` and Bitwise `|`

The `OR` operator in Java can be used in two contexts: logical `||` for boolean expressions and bitwise `|` for integer operations.

The logical `||` operator does not evaluate the second operand if the first operand is true, while the bitwise `|` operator evaluates both operands.

Example of Logical `||` Operator:

```java
public class LogicalOrExample {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;
    int c = 20;

    System.out.println(a > b || b < c); // Outputs: true, because a > b is true
    System.out.println(a > b | a < c); // Outputs: true, both conditions are evaluated
  }
}
```

Example of Bitwise `|` Operator:

```java
public class BitwiseOrExample {
  public static void main(String[] args) {
    int x = 6; // Binary: 0110
    int y = 3; // Binary: 0011

    System.out.println("x | y: " + (x | y)); // Outputs: 7 (Binary: 0111)
  }
}
```

### Java `XOR` Operator Example: Bitwise `^`

The `XOR` (exclusive OR) operator in Java is represented by the bitwise `^` operator. It performs a bitwise comparison between two integer values, returning a new integer where each bit is set to 1 if the corresponding bits of the operands are different.

```java
public class BitwiseXorExample {
  public static void main(String[] args) {
    int x = 6; // Binary: 0110
    int y = 3; // Binary: 0011

    System.out.println("x ^ y: " + (x ^ y)); // Outputs: 5 (Binary: 0101)
  }
}
```

### Java Ternary Operator

The ternary operator in Java is a shorthand way to write an if-else statement. It takes three operands and is often used to assign a value based on a condition.

Example of Ternary Operator:

```java
public class TernaryExample {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;

    String result = (a > b) ? "a is greater than b" : "b is greater than or equal to a";
    System.out.println(result); // Outputs: a is greater than b
  }
}
```

## String Basics

Strings in Java are sequences of characters used to represent text. They are one of the most commonly used data types in programming and are essential for handling textual data.

Strings are commonly used objects in Java that can hold multiple characters. In Java, strings are **not** primitive data types, but rather reference data types. They are immutable objects derived from the `String` class. To be immutable means that once a string is created, it cannot be changed. Any operation that appears to modify a string actually creates a new string object.

Because Strings are immutable, all of the methods in the `String` class return a new string object rather than modifying the original string.

For example:

```java
String str1 = "my string";
st1.concat(" is awesome!"); // This does not modify str1, it creates a new string
System.out.println(str1); // Outputs: my string
```

Strings are defined using double quotes, and they can contain letters, numbers, symbols, and whitespace. They can be created using string literals or by using the `String` class constructor.

```java
String str2 = new String("my string");
```

### Unique Properties of Strings in Java

Strings are very crucial in Java and also are very frequently used by developers.

**Strings do not use nay null character for termination**.
The `String` class does not use any null character for termination. On the contrary, strings and objects are backed by a character array that contains the characters of the string.

**Strings are placed in the String pool**.
Strings are placed in a special memory area called the "String pool." This is a part of the heap memory where Java stores string literals. When a string literal is created, Java checks if an identical string already exists in the pool. If it does, the reference to the existing string is returned instead of creating a new string object. This helps save memory and improves performance.

**Strings are immutable**.
Strings in Java are immutable, meaning that once a string object is created, its value cannot be changed. Any operation that appears to modify a string actually creates a new string object with the modified value. This immutability ensures that strings are thread-safe and can be shared safely across multiple threads without the risk of unintended modifications.

**Comparison of Strings is done using the `equals()` method**.
When comparing strings in Java, it is important to use the `equals()` method instead of the `==` operator. The `==` operator checks for reference equality (whether two references point to the same object), while the `equals()` method checks for value equality (whether the contents of the strings are the same).

### String Methods

To fully utilize the `String` class, it is important to understand the various methods available for manipulating strings. Here are some commonly used string methods:

- `length()`: Returns the length of the string (number of characters).
- `toUpperCase()`: Converts the string to uppercase.
- `toLowerCase()`: Converts the string to lowercase.
- `charAt(int index)`: Returns the character at the specified index.
- `concat(String str)`: Concatenates the specified string to the end of the original string.
- `equals(Object obj)`: Compares the string with another object for equality.
- `equalsIgnoreCase(String str)`: Compares the string with another string, ignoring case differences.
- `indexOf(String str)`: Returns the index of the first occurrence of the specified substring.
- `replace(char oldChar, char newChar)`: Replaces all occurrences of the specified character with a new character.
- `trim()`: Removes leading and trailing whitespace from the string.
- `substring(int beginIndex, int endIndex)`: Returns a substring of the original string from the specified indices.
- `split(String regex)`: Splits the string into an array of substrings based on the specified regular expression.

### Real World Application

Strings are fundamental in Java programming and have several real-world applications:

- **Text Handling**: Strings are used to represent and manipulate text data, such as user input, file contents, and messages. They are essential for tasks like parsing, formatting, and displaying text.
- **Standard Library Support**: The Java Standard Library provides a rich set of string manipulation methods, making it easy to perform common operations like searching, replacing, and formatting strings.
- **Interoperability**: Strings are often used to communicate with external systems, such as databases, web services, and APIs. They are the primary means of exchanging data in many applications.

