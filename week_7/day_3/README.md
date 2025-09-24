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

## What is an Algorithm?

An algorithm is a process or set of rules/steps to be followed in calculations or other problem-solving operations, especially by a computer. Algorithms are used for data processing, calculation, and other tasks. They can be expressed in various forms, including natural language, pseudocode, flowcharts, or programming languages.

When crafting algorithms, the amount or size input will often determine the efficiency of the algorithm.

As programmers, we measure the efficiency of algorithms based on their time complexity (how many steps are needed to complete the algorithm) and space complexity (how much memory is needed to complete the algorithm). Both complexities are often expressed using Big O notation, which classifies algorithms according to how their run time or space requirements grow as the input size grows.

Additionally, some problems occurs frequently in programming, such as sorting data sets or searching for specific values, and many common techniques exist which can be used to solve these problems.

### Real World Application

Developers use algorithms in nearly every facet of development. Some common real world applications of algorithms include:

- **Searching Algorithms**:
  - Algorithms which search through a collection of data to find a specific element or set of elements.
  - These are used in search engines to find the most relevant results based on user queries. Examples include binary search and depth-first search.
- **Sorting Algorithms**:
  - Algorithms which re-order elements of some larger collection based on an established sorting criteria.
  - These algorithms are essential in data processing for organizing data in a specific order, such as alphabetical or numerical order. Examples include quicksort, merge sort, and bubble sort.
- **Pathfinding Algorithms**:
  - Algorithms which find the shortest or most efficient path between two points in a graph or network.
  - These are used in GPS navigation systems to determine the best route from one location to another. Examples include Dijkstra's algorithm and A\* search algorithm.
- **Machine Learning Algorithms**:
  - Algorithms which allow computers to learn from and make predictions or decisions based on data.
  - These are used in recommendation systems, such as those used by streaming services to suggest content based on user preferences. Examples include decision trees, neural networks, and k-means clustering.
- **Cryptographic Algorithms**:
  - Algorithms which secure data through encryption and decryption processes.
  - These are used in secure communications, such as online banking and e-commerce, to protect sensitive information. Examples include RSA, AES, and SHA-256.

### Implementation

Unlike most other topics in Computer Science, the ability to effectively create or use algorithms is not as straightforward as memorizing syntax or learning about specific solutions. Instead, creating efficient algorithms requires practice and understanding how to apply various tools to certain scenarios. A common, loose-guideline for solving algorithmic problems is as follows:

- **Fully Understand the Problem**:
  - The first step is to understand what is being asked, and what components are available to solve the problem.
  - What is the input and desired output?
  - Are there any constraints or edge cases to consider?
- **Break Down the Problem Into Smaller Parts**:
  - Before working on solutions, it is helpful to break larger problems into smaller, more manageable problems or steps which should be solved in sequence or repeated based on some condition.
  - In many ways, this step is a further breakdown of the first step, as it helps to clarify the problem and identify potential solutions.
- **Create a Plan**:
  - Creating a plan involves working out the specific steps prior to writing any code.
  - You do not need to have working code to plan out what you want your code to do.
  - Pseudocode, flowcharts, and diagrams can be useful tools to help visualize the plan.
- **Implement a Solution**:
  - Once a plan is in place, the next step is to implement the solution in code.
  - With proper planning, implementation should primarily focus on writing the correct syntax, and not so much on what steps your code should be taking.
- **Test Your Solution**:
  - Although a solution may seem to be correct through your planning or at first glance, it is important to double check your work to ensure that the problem is fully solved.
  - Make sure to test edge cases and constraints to ensure that your solution is robust and can handle a variety of inputs.
- **Optimize Your Solution**:
  - No one get it right on the first try! If (and when) a solution does not function fully, it is best to move through each of the previous steps again to identify where the problem lies.

#### Pseudocode

Pseudocode is a simplified, half-English, half-code outline used to represent the logic of an algorithm or program. It is not written in any specific programming language, but rather uses a combination of natural language and programming constructs to describe the steps needed to solve a problem. Pseudocode helps in planning and visualizing the steps of an algorithm clearly, making it easier to later translate into actual code.

##### Key Characteristics of Pseudocode

- **Language-Agnostic**: Pseudocode is not tied to any specific programming language, allowing it to be understood by anyone familiar with programming concepts.
- **Focus on Logic**: It emphasizes the logic and structure of the algorithm rather than syntax.
- **Readable and Understandable**: Pseudocode is designed to be easily read and understood by humans, making it a useful tool for communication among developers.
- **Structured Format**: While it does not follow strict syntax rules, pseudocode often uses indentation and formatting to represent control structures like loops and conditionals.

##### Common Techniques and Rules for Writing Pseudocode

- **Use Clear and Concise Statements**: Pseudocode should be brief and to the point, avoiding overly complex sentences.
- **Use Standard Programming Constructs**: Utilize common programming constructs such as loops (for, while), conditionals (if, else), and function definitions.
- **Indentation for Structure**: Use indentation to represent nested structures, making it clear which statements belong to which control structures.
- **Descriptive Naming**: Use meaningful names for variables and functions to convey their purpose.
- **Specify Inputs and Outputs**: Clearly define what inputs the algorithm takes and what outputs it produces.
- **Commenting and Documentation**: Include comments to explain complex parts of the pseudocode or to clarify the purpose of certain steps.
- **Sequence of Steps**: Write the steps in a logical order, ensuring that each step follows naturally from the previous one.
- **Avoid Language-Specific Syntax**: Refrain from using syntax that is specific to a particular programming language, focusing instead on the logic and flow of the algorithm.

##### Example of Pseudocode

```plaintext
Procedure BubbleSort(Array A)
  For i from 1 to length(A)
    For j from 0 to length(A) - i - 1
      If A[j] > A[j + 1] Then
        Swap A[j] and A[j + 1]
      End If
    End For
  End For
```

This pseudocode outlines the Bubble Sort algorithm, which sorts an array by repeatedly stepping through the list, comparing adjacent elements and swapping them if they are in the wrong order. The process is repeated until the array is sorted.

## Recursive Algorithm

A recursive algorithm is an algorithm that calls itself or indirectly in order to continuously repeat the same set of steps until a solution is reached. Again, recursive algorithms are often used to solve problems that can be broken down into smaller, similar sub-problems. Each time the algorithm calls itself, it works on a smaller piece of the problem until it reaches a base case, which is a condition that stops the recursion.

Certain problems can actually be solved much more easily using recursion. Let's take a look at the pseudocode of a function that returns the summation up to a given input, `n`, using a `while` loop:

```plaintext
INPUT n is a non-negative integer

FUNCTION sum(n)
  SET sum TO 0

  WHILE n is greater than 0
    compute sum as sum + n
    decrement n by 1
  END WHILE
  RETURN sum
END FUNCTION
```

The above pseudocode loops descending through all integers from `n` down to `1`, adding each integer to a running total, `sum`. This is a perfectly valid way to solve the problem, but it can be simplified using recursion:

```plaintext
INPUT n is a non-negative integer

FUNCTION sumRecursion(n)
  IF n equals 0 THEN
    RETURN 0
  ELSE
    RETURN n + sumRecursion(n - 1)
  END IF
END FUNCTION
```

With the second version of the function, we can see that the problem is broken down into smaller pieces. The function calls itself with a decremented value of `n` until it reaches the base case of `n` being equal to `0`. At that point, the recursion stops and the function returns `0`. Each previous call to the function then adds its value of `n` to the result of the next call, ultimately returning the total sum.

### Real World Application

Recursive algorithms find applications in various real-world scenarios where problems can be broken down into smaller, similar sub-problems of the same type. Here is a real-world application of recursive algorithms:

**File System Traversal**: Recursive algorithms are commonly used to traverse file systems. Each directory can be treated as a node in a tree, and the files and subdirectories within it are its children. A recursive function can be employed to explore each directory, processing files as it goes and making recursive calls for each subdirectory it encounters. This approach simplifies the code and makes it easier to handle directories of arbitrary depth.

### Implementation

#### How to Write a Recursive Function

We can break recursive function down into a few main parts. First, let us review what the fibonacci sequence is: it is a series of numbers where each number is the sum of the two preceding ones, usually starting with 0 and 1. That is, the sequence begins 0, 1, 1, 2, 3, 5, 8, 13, and so on.

#### Base Case

With recursive functions, we are usually going to keep calling the function (recursing) until we reach some condition called the base case. The base case in recursion is the condition that defines the simplest scenario or stopping point for the recursive algorithm. In the case of the Fibonacci sequence, the base cases are when `n` is `0` or `1`, as these values can be returned directly without further recursion. So we can write a function that retrieves the `nth` number in the Fibonacci sequence, starting with these base cases:

```plaintext
INPUT n is an non-negative integer

FUNCTION fibonacci(n)
  IF n is equal to 0 THEN
    RETURN 0
  ELSE IF n is equal to 1 THEN
    RETURN 1
  END IF
END FUNCTION
```

In this case, we directly return `0` if `n` is `0`, and `1` if `n` is `1`. These are our base cases. Once we have our base cases, we can move on to the recursive case.

Note: if you do not include a base case in your recursive function, it will continue to call itself indefinitely until the program runs out of memory and crashes.

#### Recursive Case

```plaintext
RETURN the sum of CALLING fibonacci(n - 1) and CALLING fibonacci(n - 2)
```

This is all we have to write because we just want the sum of the previous 2 numbers.

#### Complete Implementation

```plaintext
INPUT n is an non-negative integer

FUNCTION fibonacci(n)
  IF n is equal to 0 THEN
    RETURN 0
  IF n is equal to 1 THEN
    RETURN 1
  END IF

  RETURN the sum of CALLING fibonacci(n - 1) and CALLING fibonacci(n - 2)
END FUNCTION
```

## Greedy Algorithm

A greedy algorithm is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most immediate benefit or the most optimal choice at that moment. The idea is to make a series of choices, each of which looks best at the time, with the hope that these local optimum choices will lead to a global optimum solution.

As such, greedy algorithms are not always the most optimal paradigm to use; however, it is often the most lightweight and cost effective in terms of time and space complexity. Greedy algorithms are often used in optimization problems, where the goal is to find the best solution among a set of possible solutions.

### Real World Application

Greedy algorithms are widely used in various real-world applications where making a series of locally optimal choices leads to a globally optimal solution. Here are some common real-world applications of greedy algorithms:

- **Telecommunication Networks**: Building a telecommunication network infrastructure to connect different regions or cities while minimizing the cost of laying cables or setting up towers. Algorithms like Prim's or Kruskal's can be used to find the minimum spanning tree, ensuring that all locations are connected with the least total cost.
- **Transportation Networks**: Planning transportation routes such as highways or railways to connect multiple cities or towns efficiently while minimizing construction costs. Greedy algorithms can help in selecting the most cost-effective routes.
- **Pipeline Networks**: Designing pipeline networks for transporting resources like water, oil, or gas from extraction points to processing facilities or distribution centers while minimizing the cost of laying pipes. Greedy algorithms can assist in determining the optimal layout of the pipeline network.

### Implementation

To implement a greedy algorithm, we typically follow these steps:

- **Define the Problem**: Clearly understand the problem and identify the objective that needs to be optimized (e.g., minimize cost, maximize profit).
- **Identify the Greedy Choice Property**: Determine the local optimal choice that can be made at each step of the algorithm. This choice should lead to a globally optimal solution.
- **Create a Greedy Algorithm**: Develop an algorithm that makes the greedy choice at each step and builds up the solution incrementally.
- **Prove Optimality**: Ensure that the greedy choice property holds and that the algorithm produces an optimal solution for the problem.
- **Analyze Time and Space Complexity**: Evaluate the efficiency of the algorithm in terms of time and space complexity.
