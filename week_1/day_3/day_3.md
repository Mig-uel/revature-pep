# Programming Foundations with Java - Day 3

## Flow Control Statements

Up to this point, the Java code we have written have run straight through from start to finish, without making any decisions or repeating any actions.

Flow control statements are used to control the execution flow of a program. They allow you to make decisions, repeat actions, and manage the order in which statements are executed.

We will discuss two Java statements that create flow control in our programs: **if statements** and **switch statements**.

### If Statements

An `if` statement allows you to execute a block of code only if a specified condition is true. If the condition is false, the block of code is skipped.

- The `if` statement depends on the use of boolean expressions to determine whether the code block should be executed.
- A boolean expression is an expression that evaluates to either `true` or `false`.
- A statement or block of statements can be executed if the boolean expression evaluates to `true`.
- `else` and `else if` statements provide alternate paths of execution based on different conditions.

Boolean expression can be complicated; however, frequently they involve the comparison of the value of a variable to a constant or the value of another variable. These comparisons are made using **comparison operators**. The most common comparison operators are:

| Operator | Description              |
| -------- | ------------------------ |
| `==`     | Equal to                 |
| `!=`     | Not equal to             |
| `>`      | Greater than             |
| `<`      | Less than                |
| `>=`     | Greater than or equal to |
| `<=`     | Less than or equal to    |

**Basic Syntax of an If Statement:**

```java
if (condition) {
    // code to be executed if condition is true
} else if (anotherCondition) {
    // code to be executed if anotherCondition is true
} else {
    // code to be executed if both conditions are false
}
```

### Switch Statements

A `switch` statement is used to execute one block of code among many based on the value of a variable or expression. It is an alternative to using multiple `if-else` statements when you have a fixed set of possible values.

- The `switch` statement provides a more elegant way to handle multiple conditions based on the value of a single variable.
- Each `case` in a `switch` statement represents a possible value for the variable being evaluated.
- The `break` statement is used to exit the `switch` block after executing a matching case. If `break` is omitted, execution will continue into the next case (this is known as "fall-through" behavior).

**Basic Syntax of a Switch Statement:**

```java
switch (variable) {
    case value1:
        // code to be executed if variable equals value1
        break;
    case value2:
        // code to be executed if variable equals value2
        break;
    // more cases...
    default:
        // code to be executed if variable does not match any case
}
```

### Control Flow Statements

Control flow statements are essential for making decisions and executing different paths in your code. They allow you to create dynamic and responsive programs by controlling the flow of execution based on conditions and user input.

These are known as loops, and they allow you to repeat a block of code multiple times until a certain condition is met.

Loops are key for writing one of the most common types of programs: programs that get input from the user, process the output, then get more input from the user, and so on. This is known as an **interactive program**.

Just like with `if` statements, loops rely on boolean expressions to determine whether the loop should continue executing or stop.

The following are the most common types of loops in Java:

- **for loop**: Used when you know the number of iterations in advance.
- **while loop**: Used when you want to repeat a block of code as long as a condition is true.
- **do-while loop**: Similar to the `while` loop, but guarantees that the block of code will be executed at least once before checking the condition.

### For Loop

A `for` loop is used when you know the number of iterations in advance. It consists of three parts: initialization, condition, and increment/decrement.

They include 3 statements separated by semicolons:

```java
for (initialization; condition; increment/decrement) {
    // code to be executed in each iteration
}
```

Any object which implements the `Iterable` interface can be iterated over using an **enhanced for loop** (also known as a "for-each" loop). This is a more concise way to iterate over collections and arrays.

```java
List<String> list = getListOfStrings();
for (String item : list) {
    System.out.println(item);
}
```

### While Loop

A `while` loop is used when you want to repeat a block of code as long as a condition is true. The condition is checked before each iteration, and if it evaluates to false, the loop terminates.

```java
while (condition) {
    // code to be executed as long as condition is true
}
```

### Do-While Loop

A `do-while` loop is similar to a `while` loop, but it guarantees that the block of code will be executed at least once before checking the condition. The condition is checked after each iteration.

```java
do {
    // code to be executed at least once
} while (condition);
```

### Overview of `break` and `continue`

The `break` and `continue` statements are used to control the flow of loops.

- The `break` statement is used to exit a loop prematurely, regardless of the loop's condition.
- The `continue` statement is used to skip the current iteration of a loop and move to the next iteration.

## Real World Application

In real-world applications, flow control statements are essential for creating dynamic and interactive programs. They allow developers to implement complex logic, handle user input, and manage the flow of execution based on various conditions.

- **Decision Making in User Interfaces**: Flow control statements are used to create responsive user interfaces that react to user input. For example, an application might use `if` statements to show or hide certain elements based on user choices.
- **Business Logic**: In business applications, flow control statements are used to implement complex business rules. For instance, an e-commerce application might use `switch` statements to handle different payment methods based on user selection.
- **Data Processing and Filtering**: Flow control statements are also used in data processing tasks, such as filtering and transforming data. For example, a program might use loops and conditionals to process a list of records and generate a report based on specific criteria.

## Implementation

### Nested Conditionals

A nested conditional is an `if` or `switch` statement that is contained within another `if` or `switch` statement. Nested conditionals allow you to create more complex decision-making structures by evaluating multiple conditions in a hierarchical manner.

Writing statements this way will create a limited context (or scope) for variables and provides a logical container for operations.

For example:

```java
if (condition1) {
    // code to be executed if condition1 is true
    if (condition2) {
        // code to be executed if condition2 is true
    } else {
        // code to be executed if condition2 is false
    }
} else {
    // code to be executed if condition1 is false
}
```

### Writing Nested Conditional Statements

You may find yourself in a situation where you need to evaluate multiple conditions to determine the appropriate course of action. For example, say we need to apply code for an automatic sprinkler system that will spray a specified amount of liters of water based on the change of rain according to the following rules:

| Chance of Rain (%) | Water Output (Liters) |
| ------------------ | --------------------- |
| 0 - 19             | 30                    |
| 20 - 30            | 10                    |
| 31 - 55            | 0                     |
| 56 - 100           | 0                     |

To implement this logic using nested conditionals, we can use an `if-else` structure to evaluate the chance of rain and determine the appropriate water output. Here's how you can write the code:

```java
public class WaterSystem {
  public static void main(String[] args) {
    int precipitation = 0; // Example chance of rain percentage
    int waterOutput = 0; // Variable to hold the water output in liters

    // Evaluate the chance of rain using nested conditionals
    if (precipitation < 20) {
      waterOutput = 30; // Set water output to 30 liters
    } else if (precipitation <= 30) {
      waterOutput = 10; // Set water output to 10 liters
    } else {
      waterOutput = 0; // Set water output to 0 liters for 31% and above
    }

    System.out.println("Water output: " + waterOutput + " liters");
  }
}
```

What if we needed to model a more complex situation? Perhaps we need to also factor in current temperature into our sprinkler system. We can extend our nested conditional structure to include temperature checks as well.

| Chance of Rain (%) | Temperature (°F) | Water Output (Liters) |
| ------------------ | ---------------- | --------------------- |
| 0 - 19             | <= 75            | 30                    |
|                    | > 75             | 45                    |
| 20 - 30            | <= 75            | 10                    |
|                    | > 75             | 25                    |
| 31 - 55            | <= 75            | 0                     |
|                    | > 75             | 15                    |
| 56 - 100           | <= 75            | 0                     |
|                    | > 75             | 0                     |

For each change of rain percentage, there are 2 associated temperature conditions that will affect the water output. One is for temperatures less than or equal to 75°F, and the other is for temperatures greater than 75°F.

To implement this logic, we can use nested `if-else` statements to check both the chance of rain and the temperature. Here's how you can write the code:

```java
public class WaterSystem {
  public static void main(String[] args) {
    int precipitation = 0; // Example chance of rain percentage
    int temperature = 0; // Example temperature in Fahrenheit
    int waterOutput = 0; // Variable to hold the water output in liters

    // Evaluate the chance of rain and temperature using nested conditionals
    if (precipitation < 20) {
      if (temperature <= 75) {
        waterOutput = 30; // Set water output to 30 liters
      } else {
        waterOutput = 45; // Set water output to 45 liters
      }
    } else if (precipitation <= 30) {
      if (temperature <= 75) {
        waterOutput = 10; // Set water output to 10 liters
      } else {
        waterOutput = 25; // Set water output to 25 liters
      }
    } else if (precipitation <= 55) {
      if (temperature <= 75) {
        waterOutput = 0; // Set water output to 0 liters
      } else {
        waterOutput = 15; // Set water output to 15 liters
      }
    } else {
      waterOutput = 0; // Set water output to 0 liters for precipitation above 55%
    }

    System.out.println("Water output: " + waterOutput + " liters");
  }
}
```

### Switches and Fallthrough Logic

A `switch` statement can also be used to handle multiple conditions based on the value of a variable. It provides a cleaner and more organized way to manage complex decision-making scenarios.

Recall that a `switch` statement evaluates a variable against multiple `case` values. If a match is found, the corresponding block of code is executed.

Example:

```java
int x = 5;

switch (x) {
  case 1:
    System.out.println("x is 1");
    break;
  case 2:
    System.out.println("x is 2");
    break;
  default:
    System.out.println("x is neither 1 nor 2");
    break;
}
```

In the example above, if `x` is neither 1 nor 2, the `default` case will be executed.

### Fallthrough Logic

In Java, if you omit the `break` statement at the end of a `case`, the program will continue executing the next case's code block. This is known as "fallthrough" behavior.

What do you think will happen if we change the order of the the two `case` statements (case 1 and default) in the previous example?

```java
int x = 5;

switch (x) {
  default:
    System.out.println("x is neither 1 nor 2");
    // No break here, so it will fall through to the next case
  case 1:
    System.out.println("x is 1");
}
```

In this case, if `x` is 5, the output will be:

```
x is neither 1 nor 2
x is 1
```

Why does this happen? Because the `default` case does not have a `break` statement, it falls through to the next case, which is case 1. Also, switch statements support fallthrough logic, which means that whatever case is met first, all other cases below it will also be executed until a `break` statement is encountered.

### Using `break`

In most scenarios, you'll use a `break` statement at the end of each case to prevent fallthrough. This ensures that only the code block for the matching case is executed.

```java
int x = 5;

switch (x) {
  case 1:
    System.out.println("x is 1");
    break;
  case 2:
    System.out.println("x is 2");
    break;
  default:
    System.out.println("x is neither 1 nor 2");
    break; // optional, but good practice
}
```

Now in this example, if `x` is 5, only the `default` case will be executed, and the output will be:

```
x is neither 1 nor 2
```

You can also use curly braces `{}` to group multiple statements within a single case. This is useful when you want to execute more than one statement for a particular case.

### Loops

**For Loop**

A `for` loop is used when you know the number of iterations in advance. It consists of three parts: initialization, condition, and increment/decrement.

We'll create a loop that counts from 1 to 10, inclusively, and prints each number to the console.

```java
for (int i = 1; i <= 10; i++) {
  System.out.println(i);
}
```

Based on the code above, can you use the variable `i` outside of the loop? Why or why not?

No, you cannot use the variable `i` outside of the loop because it is declared within the loop's initialization statement. This means that `i` has a scope limited to the block of the `for` loop, and it is not accessible outside of that block.

**While Loop**

A `while` loop is used when you want to repeat a block of code as long as a condition is true. The condition is checked before each iteration, and if it evaluates to false, the loop terminates.

```java
while (condition) {
  // Code to be executed repeatedly
}
```

**Do-While Loop**

A `do-while` loop is similar to a `while` loop, but it guarantees that the block of code will be executed at least once before checking the condition. The condition is checked after each iteration.

```java
do {
  // Code to be executed at least once
} while (condition);
```

### Break Statements

The `break` statement is used to exit a loop prematurely, regardless of the loop's condition. It can be used in `for`, `while`, and `do-while` loops. It's also used in `switch` statements to exit the case block.

**Using `break` as a Form of Goto**

Goto means to jump to a specific part of the code. In Java, the `break` statement can be used to exit loops or switch statements, effectively acting as a form of goto. However, Java does not have a traditional `goto` statement like some other programming languages. Instead, Java uses labels to achieve similar behavior.

A label is used to identify a block of code, and you can use the `break` statement with a label to exit that specific block.

```java
class Main {
  public static void main(String[] args) {
    // First label
    first:
      for (int i = 0; i < 3; i++) {
        // Second label
        second:
          for (int j = 0; j < 3; j++) {
            if (i == 1 && j == 1) {
              // Exit the first label
              break first;
            }

            System.out.println("i: " + i + ", j: " + j);
          }
      }
  }
}
```

In this example, the `break first;` statement exits the outer loop when `i` is 1 and `j` is 1, effectively skipping the remaining iterations of both loops.

### Continue Statements

The `continue` statement is used to skip the current iteration of a loop and move to the next iteration. It can be used in `for`, `while`, and `do-while` loops.
When the `continue` statement is encountered, the loop skips the remaining code in the current iteration and proceeds to the next iteration.

```java
for (int i = 0; i < 5; i++) {
  if (i == 2) {
    continue; // Skip the rest of the loop when i is 2
  }
  System.out.println("i: " + i);
}
```
