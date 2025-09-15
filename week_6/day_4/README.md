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

## Intro to JUnit

Unit testing can be done via two approaches: manually writing test cases as shown above, or by using a testing framework like JUnit. JUnit is a popular testing framework for Java that provides annotations and assertions to make writing and running tests easier.

In both approaches, the workflows are similar:

- Create a test class
- Reviewing it
- Reworking it as needed
- Executing the tests
- Analyzing the results

Automated testing is preferred over manual testing because it is faster, more reliable, and can be run frequently during the development process.

- Manual testing required a great deal of human effort and was prone to human error.
- Manual testing also requires more resources to be allocated to testing, which can be costly and time-consuming.
- Schedule constraints may put time allocated for testing at a premium.
- Automated tests can be run quickly and easily, allowing developers to catch bugs early in the development process.

#### What is JUnit?

JUnit is a popular testing framework for Java that provides annotations and assertions to make writing and running tests easier. JUnit is widely used in the Java community and is supported by many IDEs and build tools.

Some things to know about JUnit:

- Annotations are used to define test methods and setup/teardown methods.
- Assertions are used to compare expected and actual results.
- It provides a test runner to execute tests and report results.
- JUnit provides a basic built-in template for writing tests, but it can be extended with custom assertions and test runners.
- JUnit tests help you write independent modules, thereby improving the code coverage and the quality of the code.

#### Examples of JUnit Test Cases

Below are two examples of a very basic Hello World program to understand how a JUnit test class looks or how it differs from a usual Java class.

##### Example 1

Here is a JUnit test case `HelloWorldTest.java` that verifies that the string `"Hello, World!"` matches the string `"hello, world!"` (case insensitive), which fails on execution.

```java
public class HelloWorldTest {
  @Test
  public void test() {
    assertEquals("hello, world!", "Hello, World!"); // This test will fail
  }
}
```

##### Example 2

Here, we will see how a typical Java class interacts with a JUnit test class. We create a Java class `HelloWorld.java` with a constructor that allows us to pass a string value and a method `getText()` that returns the string value.

```java
public class HelloWorld {
  private String text;

  public HelloWorld(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
```

The JUnit test class `HelloWorldTest.java` has a tst that creates a `HelloWorld` object and passes a string into the constructor call. The `assertEquals()` from JUnit verifies if the expected and actual strings are the same.

```java
public class HelloWorldTest {
  @Test
  public void test() {
    HelloWorld hw = new HelloWorld("Hello, World!");
    assertEquals(hw.getText(), "Hello, World!"); // This test will pass
  }
}
```

### Real World Application

#### Unit Testing

Generally, software goes through four levels of testing:

- Unit Testing - Testing individual units or components of a software application in isolation.
- Integration Testing - Testing the interaction between integrated components or systems.
- System Testing - Testing the complete and integrated software application as a whole.
- Acceptance Testing - Testing the software application in a real-world environment to ensure it meets business requirements.

Sometimes, due to time constraints, software testers do minimal unit testing and focus more on integration and system testing. However, this can lead to issues later on in the development process, as bugs may be harder to track down and fix.

Some important reasons for unit testing are listed below:

- Unit testing helps testers and developers understand the root causes of errors.
- Unit testing helps with documentation, as tests can serve as examples of how to use the code.
- Unit testing fixes defects early in the development process, reducing the cost and effort required for debugging later on.
- Unit testing aids in code reusability, as well-tested code is easier to reuse in other projects.

Here are some best practices for using JUnit in the real world:

- **Always Test Core Methods**
  - It is not always possible to achieve 100% code coverage, so do not aim to write unit tests for each method. Instead, write unit tests for methods that are likely to have bugs during maintenance.
  - Always test core methods and core classes that are heavily used by different parts of the application.
- **Run the JUnit Tests as Part of the Build Process**
  - Integrate JUnit tests into the build process to ensure that tests are run automatically whenever the code is built. This helps catch issues early and ensures that new changes do not break existing functionality.
- **Always Test for Boundary Conditions**
  - Boundary conditions are the values at the edges of the input range for a method. Testing for boundary conditions helps ensure that the method behaves correctly for all possible input values.
- **Align Tests with Business Requirements**
  - Ensure that unit tests are aligned with business requirements and use cases. This helps ensure that the code meets the needs of the end-users and stakeholders.
- **Test for Non-Functional Requirements**
  - Non-functional requirements are the performance, scalability, and security requirements of the application. Testing for non-functional requirements helps ensure that the application meets the required standards and performs well under different conditions.
  - For example, while writing a thread-safe method, it's important to implement tests that break the thread safety of the method. This helps ensure that the method is truly thread-safe and can handle concurrent access without issues.
- **Test for Flow of Control**
  - Flow of control refers to the order in which statements are executed in a program. Testing for flow of control helps ensure that the program behaves correctly for different input values and scenarios.
  - If a function or method depends on the order of events, make sure your tests cover all possible orders of events to ensure the function behaves correctly in all scenarios.
  - Test both correct and incorrect orders of events to ensure the function behaves correctly in all scenarios.
- **Use Tools**
  - Always utilize the tools provided by your framework. For example, JUnit provides annotations and assertions that make writing and running tests easier.

### Implementation

In this example, we are implementing a Temperature Converter that converts Celsius to Fahrenheit and vice versa.

First, we design the interface for the Temperature Converter.

```java
public interface TemperatureConverter {
  double fahrenheitToCelsius(double fahrenheit);
  double celsiusToFahrenheit(double celsius);
  double convertTemp(double temp, String from, String to);
}
```

Next, we write the JUnit test cases for the Temperature Converter.

```java
/**
 * 1. As long as the test method finishes without throwing an exception, it is
 * considered a pass.
 *
 * 2. Assertions are used to check if the expected and actual results are the same
 * and if not, an AssertionError is thrown.
 *
 * 3. All test methods are void and take no parameters. That is JUnit convention.
 */
public class TemperatureConverterTest {
  TemperatureConverter converter = new TemperatureConverterImpl();

  @Test
  void celsius_to_fahrenheit() { // only acceptable use of underscores in method names
    double actual = this.converter.celsiusToFahrenheit(100);
    Assertions.assertEquals(212, actual, 0.001); // third parameter is delta - acceptable error range
  }

  @Test
  void fahrenheit_to_celsius() {
    double actual = this.converter.fahrenheitToCelsius(212);
    Assertions.assertEquals(100, actual, 0.001);
  }

  @Test // negative test case, ensures something fails when it should
  void absolute_zero_raises_exception() {
    Assertions.assertThrows(RuntimeException.class, () -> {
      this.converter.celsiusToFahrenheit(-400);
    });
  }

  @Test
  void kelvin_celsius() {
    double actual = this.converter.convertTemp(100, "Kelvin", "Celsius");
    Assertions.assertEquals(-173.15, actual, 0.001);
  }

  @Test
  void case_insensitive() {
    double result = this.converter.convertTemp(100, "KeLVin", "cElSiUs");
    Assertions.assertEquals(-173.15, result, 0.001);
  }
}
```

Finally, we implement the Temperature Converter to make the tests pass.

```java
public class TemperatureConverterImpl implements TemperatureConverter {
  @Override
  public double fahrenheitToCelsius(double fahrenheit) {
    if (fahrenheit < -459.67) {
      throw new RuntimeException("Temperature below absolute zero");
    }
    return (fahrenheit - 32) * 5 / 9;
  }

  @Override
  public double celsiusToFahrenheit(double celsius) {
    if (celsius < -273.15) {
      throw new RuntimeException("Temperature below absolute zero");
    }
    return (celsius * 9 / 5) + 32;
  }

  @Override
  public double convertTemp(double temp, String from, String to) {
    if (from.equalsIgnoreCase("Celsius") && to.equalsIgnoreCase("Fahrenheit")) {
      return celsiusToFahrenheit(temp);
    } else if (from.equalsIgnoreCase("Fahrenheit") && to.equalsIgnoreCase("Celsius")) {
      return fahrenheitToCelsius(temp);
    } else if (from.equalsIgnoreCase("Kelvin") && to.equalsIgnoreCase("Celsius")) {
      return kelvinToCelsius(temp);
    } else if (from.equalsIgnoreCase("Celsius") && to.equalsIgnoreCase("Kelvin")) {
      return celsiusToKelvin(temp);
    } else {
      throw new RuntimeException("Invalid temperature conversion");
    }
  }

  private double kelvinToCelsius(double kelvin) {
    if (kelvin < 0) {
      throw new RuntimeException("Temperature below absolute zero");
    }
    return kelvin - 273.15;
  }

  private double celsiusToKelvin(double celsius) {
    if (celsius < -273.15) {
      throw new RuntimeException("Temperature below absolute zero");
    }
    return celsius + 273.15;
  }
}
```
