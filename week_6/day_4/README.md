# APIs and Testing - Day 4

## Intro to Test Driven Development (TDD)

When developing software, it is important to ensure that most, if not all, of your code is tested. This is to ensure that your code works as expected and to catch any bugs early in the development process. One way to achieve this is through Test Driven Development (TDD).

#### TDD Process

The TDD process consists of writing unit tests first, **before** the actual code implementation. Then, the implementation code can be written to make the tests pass, and the process can be repeated for each new feature or functionality.

The TDD process can be summarized in the following steps:

- Design interface/functionality
- Write a test that uses that functionality
- Refactor method signatures if needed
- Implement the functionality to make the test pass
- Run all tests to ensure everything works
- Refactor code for optimization and readability
- Repeat for new functionality

Following the TDD process helps ensure that your code is well-tested and works as expected, leading to more reliable and maintainable software.

#### Unit Testing

Unit testing is the testing of individual units or components of a software application in isolation. Meaning that each unit is tested independently to ensure that it works as expected. Unit tests are typically automated and can be run frequently during the development process to catch any bugs or issues early on. In Java, the most commonly used framework for unit testing is JUnit.

### Real World Application

TDD offers several important benefits in real-world software development:

- **Improved Code Quality**: By writing tests first, developers are encouraged to think about the design and functionality of their code before implementation. This often leads to cleaner, more modular code that is easier to maintain and understand. By writing tests first, developers focus on defining clear requirements and expected behavior, leading to better-designed code.
- **Fast Feedback Loop**: TDD promotes a rapid feedback loop where developers receive immediate feedback on the correctness of their code. Running tests frequently helps catch bugs early in the development process, reducing the time and effort required for debugging later on.
- **Simplified Refactoring**: TDD provides a safety net for refactoring code. Because tests are written before the code implementation, developers can refactor with confidence, knowing that any changes made will be validated by the existing tests. This encourages continuous improvement of the codebase without fear of introducing new bugs.
- **Documentation and Specification**: Unit tests serve as a form of documentation for the codebase. They provide clear examples of how the code is expected to behave, making it easier for new developers to understand the functionality and usage of different components.

Overall, TDD is a valuable practice that can lead to higher-quality software, faster development cycles, and improved collaboration among development teams.

### Implementation

Below is an example of Test Driven Development (TDD) in Java that does not use a Unit Testing framework like JUnit.

#### Step 1: Write Initial Tests

In order to know what tests to write, we need to know what functionality we want to implement. For this example, we want to test a method that returns `true` if a number is prime and false otherwise. Note: a prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers. The first few prime numbers are 2, 3, 5, 7, 11, and 13.

Two expected test cases are:

- The method should return `true` for a prime number (e.g., 7)
- The method should return `false` for a non-prime number (e.g., 4)

```java
public static void isPrime_ReturnsTrue_WithPrimeInput() {
  // 1. Set up any data needed for the test
  int input = 7;

  // 2. Run the method that is being tested
  boolean actual = isPrime(input);
  boolean expected = true;

  // 3. Compare the actual result to the expected result
  if (actual != expected) {
    throw new RuntimeException("Test failed: expected " + expected + " but got " + actual);
  }

  System.out.println("The test isPrime_ReturnsTrue_WithPrimeInput passed!");
  System.out.println("--------------------------------------------------");
  System.out.println("Expected: " + expected + " | Actual: " + actual);
}

public static void isPrime_ReturnsFalse_WithNonPrimeInput() {
  // 1. Set up any data needed for the test
  int input = 4;

  // 2. Run the method that is being tested
  boolean actual = isPrime(input);
  boolean expected = false;

  // 3. Compare the actual result to the expected result
  if (actual != expected) {
    throw new RuntimeException("Test failed: expected " + expected + " but got " + actual);
  }

  System.out.println("The test isPrime_ReturnsFalse_WithNonPrimeInput passed!");
  System.out.println("--------------------------------------------------");
  System.out.println("Expected: " + expected + " | Actual: " + actual);
}
```

#### Step 2: Implement the Functionality

Now that we have our tests written, we can implement the `isPrime` method to make the tests pass.

```java
public static boolean isPrime(int num) {
  if (num <= 1) return false;

  for (int i = 2; i <= Math.sqrt(num); i++) {
    if (num % i == 0) return false;
  }

  return true;
}
```

#### Step 3: Run the Tests

Now we can run our tests by calling the test methods in the `main` method and see if they pass.
