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
