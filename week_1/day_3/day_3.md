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

## Debugging

Debugging is the process of identifying and fixing errors or bugs in your code. It is an essential skill for any programmer, as it helps ensure that your code runs correctly and efficiently.

It is a multi-step process that involves identifying a problem, isolating the source of the problem, and then either correcting the problem or determining a way to work around it. The final step of debugging is to test the solution or workaround to ensure that it resolves the issue without introducing new problems.

Debugging is part of the software testing process and is an integral part of the entire software development lifecycle. It is often an iterative process, as fixing one bug may reveal other issues that need to be addressed.

Below are some common steps in the debugging process:

**Identify the Problem**: The first step in debugging is to identify the problem.

- This may involve observing the behavior of the program, reading error messages, or using debugging tools to gather information about the program's state.
- Gathering information about the issue, such as error logs, user reports, or screenshots, can help in understanding the problem.
- Clearly defining wha the expected behavior should be versus what is actually happening.

**Reproduce the Problem**: This step is crucial for understanding and eventually fixing the the bug.

- Creating a set of steps that consistently reproduce the issue can help in isolating the problem.
- Identifying the specific conditions under which the problem occurs, such as input values, user actions, or environmental factors.
- Documenting the reproduction steps can be helpful for both fixing the issue and for future reference.

**Isolate the Source of the Problem**: Once you can consistently reproduce the problem, the next step is to isolate the source of the problem.

- Narrowing down the problem to a specific component, module, or section of code can help in identifying the root cause.
- Using debugging tools, such as breakpoints, watch variables, and stack traces, can help in understanding the program's flow and state.
- Examining relevant variables, data structures, and program flow at the point where the problem occurs.

**Fix Implementation**: After isolating the source of the problem, the next step is to fix the implementation.

- Modifying the code to address the root cause of the issue
- Ensuring that the fix is efficient and inline with the overall design and coding standards of the project.
- Considering potential side effects of the fix on other parts of the codebase.

**Test the Solution**: After implementing a fix, it is important to test the solution to ensure that it resolves the issue without introducing new problems.

- Running the program with the same conditions that previously reproduced the issue to verify that the problem is resolved.
- Conducting additional testing to ensure that the fix does not introduce new issues or regressions.
- Performing broader testing to ensure that the fix does not negatively impact other parts of the application, possibly including automated tests, to validate overall stability.

**Document the Fix**: Finally, it is important to document the fix for future reference.

- Updating any relevant documentation, such as code comments, issue trackers, or project documentation, to reflect the changes made.
- Providing context about the issue, the steps taken to resolve it, and any potential implications for future development.
- Sharing knowledge with team members to help prevent similar issues in the future.

This process is often iterative, as fixing one bug may reveal other issues that need to be addressed. It is important to approach debugging systematically and methodically to ensure that the root cause of the problem is identified and resolved effectively.

Here are some tips and suggestions for efficiently debugging your code:

**Compile/Run Your Code Frequently**: Regularly compiling and running your code helps catch errors early in the development process. This allows you to identify and fix issues as they arise, rather than waiting until the end of the development cycle.

**Use Print Statements**: Adding print statements to your code can help you track the flow of execution and the values of variables at different points in your program. This can be especially useful for identifying where things go wrong.

**Google or Use AI Tools**: If you encounter an error message or issue that you don't understand, try searching for it online. There are many resources available, including forums, documentation, and AI tools like ChatGPT, that can help you find solutions to common problems.

**Try Alternative Approaches**: If you're stuck on a particular problem, try approaching it from a different angle. This might involve using a different algorithm, data structure, or programming technique.

**Use Comments Effectively**: Adding comments to your code can help clarify your thought process and make it easier to understand for both yourself and others. Use comments to explain complex logic, document assumptions, and outline the overall structure of your code.

**Use Binary Search for Bugs**: If you're not sure where a bug is occurring, try using a binary search approach. This involves dividing your code into smaller sections and testing each section individually to narrow down the source of the problem.

**Interactive Debugging Tools**: Many integrated development environments (IDEs) offer interactive debugging tools that allow you to set breakpoints, step through code, and inspect variables. These tools can be invaluable for understanding the state of your program at different points in its execution.

**Automated Tests**: Writing automated tests for your code can help catch bugs early and ensure that your code behaves as expected. Consider using testing frameworks like JUnit for Java to create and run tests.

**Program Output Analysis**: Carefully analyze the output of your program to identify discrepancies between expected and actual results. This can help pinpoint areas of the code that may be causing issues.

**Rubber Duck Debugging**: Explain your code and the problem you're facing to an inanimate object, like a rubber duck. This technique can help you clarify your thoughts and identify issues that you might have overlooked. If a rubber duck is not available, a pet or a friend can also work.

**Ask for Help**: If you're stuck and can't figure out the problem on your own, don't hesitate to ask for help. Reach out to colleagues, mentors, or online communities for assistance.

**Take Breaks**: Sometimes, stepping away from your code for a short period can help you gain a fresh perspective. Taking breaks can help reduce frustration and improve your problem-solving abilities.

## Real World Application

### Scenario

A major bank has recently updated its mobile banking application. Shortly after the update, customer support starts receiving numerous complaints about failed transactions. The bank's development team needs to quickly identify and resolve the issue to maintain customer trust and satisfaction.

### Problem

Users report that when they attempt to transfer money between accounts, the application shows a successful transaction message, but the money does not actually move. This inconsistency is causing confusion and frustration among users.

### Debugging Process

1. **Identify the Problem**:

- Customer support logs the complaints and alerts the development team.
- The team confirms the issue by reproducing the problem in a test environment.

2. **Reproduce the Problem**:

- The developers create a test account and attempt to transfer money between accounts using the updated application.
- They notice the issue occurs consistently when transferring amounts over a certain threshold.

3. **Isolate the Source of the Problem**:

- The team reviews the transaction processing code, focusing on the sections that handle transfers.
- They use logging tools to examine the application's behavior during the transaction process.
- They discover that the app is correctly sending transaction requests to the server, but there's an issue with the server's response handling.
- Developers suspect that a recent change in the server-side code might be causing the problem.
- They theorize that a new validation check for large transactions might be incorrectly implemented.
- The team reviews recent code changes.
- They set breakpoints in the server code to inspect the flow of execution and variable states during a transaction.
- By stepping through the code, they find that a new function that was intended to add an extra layer of security for large transactions has logical errors.

4. **Fix Implementation**:

- The developers correct the logical errors in the validation function.
- They also add more comprehensive error handling to ensure that any future issues are logged and reported correctly.

5. **Test the Solution**:

- The team runs a series of tests, including unit tests and integration tests, to ensure that the fix resolves the issue without introducing new problems.
- They also conduct user acceptance testing (UAT) to verify that the application behaves as expected from a user's perspective.
- The developers confirm that transactions over the threshold are now processed correctly, and users receive accurate feedback.
- They deploy the fix to a staging environment for further testing.

### Debugging Techniques Used

**Log Analysis**: The team used logging tools to track the application's behavior and identify where the issue occurred.

**Interactive Debugging Tools**: Breakpoints and step-through debugging helped the developers inspect the code execution flow and variable states.

**Code Review**: Reviewing recent code changes allowed the team to identify potential sources of the problem.

**Unit and Integration Testing**: Running tests ensured that the fix worked as intended and did not introduce new issues.

**Integration Testing**: Testing the application in a staging environment helped verify that the fix worked in a real-world scenario.

### Outcome

After implementing and verifying the fix, the bank rolls out an emergency update to the app and server. They also communicate with affected customers, explaining the issue and assuring that all transactions are correctly processed.

The debugging process not only resolved the immediate issue but also highlighted areas for improvement in the development and testing processes, leading to more robust future updates.

This real-world example demonstrates the importance of a systematic debugging approach, effective use of debugging tools, and thorough testing to ensure software reliability and user satisfaction.

## Troubleshooting a Technical Issue

### What is Troubleshooting?

Troubleshooting is the process of diagnosing and resolving problems or issues in a system, device, or software application. It involves identifying the root cause of a problem, analyzing the symptoms, and implementing solutions to restore normal operation.

Troubleshooting tends to exist at a higher level than debugging, often focusing on broader system issues rather than specific code problems. This process requires interviewing end users, analyzing logs, and testing various components to pinpoint the source of the problem.

Troubleshooting can be applied to any system, including hardware, software, networks, and processes. For instance, doing your laundry can be considered a system that consists of a washer and dryer. If one of those components fails, you need to troubleshoot where the issue lies. It may beyond your expertise to fix it, but you can still identify the problem and seek help from a professional.

## Real World Application

Here are the most common IT problems and how to troubleshoot them:

### Lack of Employee (Internal) Security Measures

Perhaps the most serious technology issue in business is employee security. In fact, 48% of data breaches are caused because of employee negligence. Employees carry sensitive data with them at all times, and can easily lose data o:

- Phishing attacks
- Weak passwords
- Unauthorized access to sensitive information

To mitigate these risks, it's important to create a map of who has access to what data, and to implement security measures.

To tackle weak passwords and phishing attacks, it's important to educate your employees and implement strong password policies.

### Outdated Equipment and Software

Another common issue is the use of outdated hardware and software. This can lead to security vulnerabilities, compatibility issues, and decreased productivity. Regularly updating and replacing equipment is essential to maintain a secure and efficient IT environment.

This is especially true for small businesses, as they often lack the resources to keep up with the latest technology.

It's important to have regular maintenance done on your current devices and to use support services whenever necessary.

As as best practice, it's always best to consult with IT experts.

### New Technology Integration

Before implementing new technology, it's crucial to conduct a thorough assessment of the existing IT infrastructure. This includes evaluating hardware, software, and network capabilities to ensure compatibility and identify potential challenges.

This can be accomplished by enlisting assistance from your current tech support or consulting with a managed service provider (MSP). They can help you assess your current IT infrastructure and provide recommendations for new technology that will work with your existing systems.

### Data Loss and Recovery

Data loss can occur due to hardware failures, software bugs, accidental deletions, or cyber attacks. Implementing regular data backups and recovery plans is essential to minimize the impact of data loss.

The risk of data loss is a fear that most businesses face on a daily basis. It was reported that losing 100 files can cost a business between $18,000 - $35,000. Data can be lost from a number of sources, including:

- Power outages
- Cyber attacks
- Hardware failures
- Human error

Having a disaster recovery plan that incorporates the use of a cloud-based data backup solution is essential to ensure that your data is safe and can be restored in the event of a disaster.

Using a reputable cloud service with layers of security can allow a business to store sensitive information without the fear of losing it. A disaster recovery plan should include the following:

- Backup, disaster, and business continuity plans
- IT support contacts
- Backup servers
- Cloud services
- External storage

### Troubleshooting Best Practices

**Bottom-Up Approach**: Start troubleshooting from the most basic components and work your way up to more complex systems. This helps identify issues at the foundational level before moving on to higher-level components.

**Drill Down**: Focus on specific symptoms or error messages to narrow down the potential causes of the problem. This helps avoid getting overwhelmed by the complexity of the system.

**Start Looking Horizontally**: Examine related systems or components that may be affected by the issue. This can help identify potential dependencies or interactions that could be contributing to the problem.
