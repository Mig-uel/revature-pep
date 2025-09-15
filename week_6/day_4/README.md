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

## Video - Test Driven Development (TDD) Notes

- Testing should not be optional, an afterthought, a chore, time-consuming, or expensive.
- It should be strictly about 'code coverage' and 'quality assurance'.

- When creating an executing tests you should make sure that you:
  - Clarify any ambiguity in the requirements of the code.
  - Ensure software meets expectations and helps achieve business objectives.
  - Can easily identify areas that do not meet requirements.
  - Assume product quality from the start.

One methodology to achieve this is Test Driven Development (TDD).

In this methodology, you write tests before writing the code that needs to be tested. These tests are based on the requirements that are established earlier.

When you want to follow a TDD approach, you should follow these steps:

1. Write a failing test based on the requirements.
2. Fix the test by writing applicable code.
3. Retest and refactor the code as needed.
4. Repeat for each new requirement or feature.

There are many different forms of testing:

- Unit Testing - Testing individual units or components of a software application in isolation.
- User Interface Testing - Testing the user interface of a software application to ensure it meets the requirements and is user-friendly.
- Integration Testing - Testing the interaction between integrated components or systems.
- Functional Testing - Testing the functionality of a software application to ensure it meets the requirements.
- Quality Assurance Testing - Testing the overall quality of a software application to ensure it meets the required standards.
- Performance Testing - Testing the performance of a software application to ensure it meets the required performance standards.
- Security Testing - Testing the security of a software application to ensure it meets the required security standards.

This list doesn't encapsulate all forms of testing, but it does give you an idea of the different types of testing that are available.

Unit tests are all about verifying functionality at a micro level, testing individual methods or entities in isolation.

- Write tests which execute the code on the individual units we want to inspect.
- When the code under scrutiny deviates from the expected behavior, the test fails.
- If the test passes, this means that the code behaves as expected.

**UNIT TESTING SHOULD NEVER INTERACT WITH EXTERNAL SYSTEMS SUCH AS DATABASES OR APIs**

## JUnit Annotations and Assertions

#### What's New in JUnit 5?

JUnit 5 is is a complete rewrite of the framework and requires Java 8 or higher, though it can test Java code that is written in older versions of Java.

The new version allows us to use lambdas in assertions, a feature you might already know from the popular AssertJ library. Unlike it predecessor, JUnit 5 is not an all-in-one framework, but rather a collection of different modules that can be used independently.

JUnit 5 tests look a lot like JUnit 4 tests: just create a class and add test methods annotated with `@Test`. However, JUnit 5 provides a completely new set of annotations that reside in a different package than their JUnit 4 counterparts. In addition, the assertion methods moved from `org.junit.Assert` to `org.junit.jupiter.api.Assertions`.

#### JUnit 5 Assertions

The available assertion methods in JUnit 5 are similar to those in JUnit 4. The Assertions class provides `assertTrue`, `assertEquals`, `assertNull`, `assertSame`, and their negated counterparts. What's new is the overloaded versions of these methods that expect a lambda expression as the last parameter, which supplies the assertion message or boolean condition only if the assertion fails. On top of that, there is a new feature called grouped assertions, which allows us to group multiple assertions in a single test and report all failures at once. It was previously considered bad practice to put multiple assertions into a single test method, because the test would stop executing after the first failure. With grouped assertions, we can now do this without losing information about other failures.

Another improvement over JUnit 4 is they way to assert expected exceptions. Instead of putting the expected exception type into the `@Test` annotation, or wrapping your test code in a `try-catch` block, you can use `assertThrows` and `assertEquals` to verify that a specific exception is thrown and check its message.

#### Testing Best Practices

When it comes to testing code, a few best practices should be followed:

- Utilize dependency injection to make your code more testable.
- Write testable code by following the Single Responsibility Principle.
- Use a mocking library like Mockito to isolate the code under test.
- Measure your code coverage with a tool like JaCoCo.
- Externalize test data when possible (i.e. read it from a file).
- Generally, you still want one assertion per test method, unless you are using grouped assertions.
- Write deterministic tests that always produce the same result.

### Real World Application

The following code is an example of using annotations and assertions in JUnit. Here, we have a class called `NumberUtility` that will accept an integer as input and determine if it is a prime number or not. It should return a boolean value of `true` if the number is prime and `false` if it is not.

We will use JUnit annotations and assertions to test the functionality of the `NumberUtility` class.`

```java
public class NumberUtility {
  /**
   * Determines if a number is prime.
   * True if the number is prime, false otherwise.
   * Prime: a number that can only be divided by 1 and itself.
   *
   * @param number the number to check
   * @return true if the number is prime, false otherwise
   */
  public boolean isPrime(int number) {
    if (number <= 1) {
      return false; // edge case
    }

    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false; // number is divisible by i, so it is not prime
      }
    }

    return true; // number is prime
  }
}
```

Below is a class called `NumberUtilityTest` that uses JUnit annotations and assertions to test the functionality of the `NumberUtility` class.

```java
/**
 * This class will contain various test cases to test the functionality of
 * the NumberUtility class.
 */
public class NumberUtilityTest {
  public static NumberUtility nu;

  /**
   * @Test: Marks a method as a test method.
   * @BeforeAll: Marks a method to be run before all test methods in the class.
   * @AfterAll: Marks a method to be run after all test methods in the class
   * have been run.
   * @BeforeEach: Marks a method to be run before each test method.
   * @AfterEach: Marks a method to be run after each test method.
   */
  @BeforeAll
  public static void setup() {
    nu = new NumberUtility();
    System.out.println("Runs before all test methods.");
  }

  @BeforeEach
  public void init() {
    System.out.println("Runs before each test method.");
  }

  @AfterEach
  public void tearDown() {
    System.out.println("Runs after each test method.");
  }

  @AfterAll
  public static void done() {
    System.out.println("Runs after all test methods.");
  }

  // We will write some unit tests inside of this class.

  @Test
  public void testIsPrime_1_shouldBeFalse() {
    /**
     * AAA Pattern:
     * Arrange: set up the data needed for the test.
     * Act: run the method that is being tested.
     * Assert: compare the actual result to the expected result.
     */

    // Arrange
    // NumberUtility nu = new NumberUtility(); // moved to @BeforeAll method
    int input = 1;
    boolean expected = false;

    // Act
    boolean actual = nu.isPrime(input);

    // Assert
    // Assertions.assertEquals(expected, actual);
    Assertions.assertFalse(actual);
  }

  @Test
  public void testIsPrime_13_shouldBeTrue() {
    // Arrange
    // NumberUtility nu = new NumberUtility(); // moved to @BeforeAll method
    int input = 13;
    boolean expected = true;

    // Act
    boolean actual = nu.isPrime(input);

    // Assert
    // Assertions.assertEquals(expected, actual);
    Assertions.assertTrue(actual);
  }

  @Test
  public void testIsPrime_negativeNumber_shouldBeFalse() {
    // Arrange
    // NumberUtility nu = new NumberUtility(); // moved to @BeforeAll method
    int input = -1000;
    boolean expected = false;

    // Act
    boolean actual = nu.isPrime(input);

    // Assert
    // Assertions.assertEquals(expected, actual);
    Assertions.assertFalse(actual);
  }
}
```

## Intro to Mockito

#### What is Mockito?

Mockito is a popular mocking framework for Java that allows developers to create mock objects for unit testing. Mock objects are used to simulate the behavior of real objects in a controlled way, allowing developers to isolate the code under test and verify its behavior.

Mockito is used for mocking objects (mock objects) and methods (method stubbing) in unit tests. Using Mockito greatly simplifies the development of tests for classes with external dependencies, such as databases or web services.

A **mock object** is a dummy implementation of a class or interface that is used in place of a real object during testing. It allows you to define the output of certain method calls. It typically records the interaction with the system so that you can perform behavior testing. **Behavior testing** is where you verify the interactions between the objects in your code rather than just the output or state changes of those objects. There also exists **spies**, which are partial mocks that allow you to call real methods while still being able to stub and verify interactions.

Recent versions of Mockito can also mock static methods, final classes, and private methods.

During testing, a stub is a piece of code that takes the place of another component or module. Stubs are used to simulate the behavior of real components in a controlled way, allowing developers to isolate the code under test and verify its behavior.

Mocks and stubs are Java classes and methods that are used in place of external dependencies. These classes are created before running tests to allow a developer to dictate expected behaviors from integrations and focus on local methods, typically in unit tests.

More specifically:

- A **stub** is a fake implementation of a class or interface that returns predefined responses to method calls. It is used to isolate the code under test from external dependencies and to simulate specific scenarios.
- A **mock** is a more advanced version of a stub that can also verify that certain methods were called with specific arguments. It is used to test the interactions between the code under test and its dependencies.
- A **spy** is a partial mock that allows you to call real methods while still being able to stub and verify interactions. It is used when you want to test the behavior of a real object while still being able to control its dependencies.

### Real World Application

Mockito is a mocking framework that works really well. It lets you write beautiful tests with a clean and simple API. Mockito does not give you a hangover because the tests are very readable and they produce clean output.

- A massive StackOverflow community voted Mockito the best mocking framework for Java. Even though StackOverflow shuns questions that likely raise emotional debates, the fact is Mockito has the most votes.
- It is in the top 10 libraries across all categories, not only in testing. In late 2013, an analysis was made of 30,000 GitHub projects. Although Mockito reached number 9 in the main report, mockito-core and mockito-all are the same library, so if you combine the votes, Mockito reaches number 4, surpassing famous tools like Guava or Spring. Treat this study as an indicator of the significant impact that Mockito makes every day on unit tests written by thousands of developers in the Java community.
- Dan North, the originator of Behavior Driven Development (BDD), said "We decided during the main conference that we should use JUnit 4 and Mockito because we think they are the future of TDD and mocking in Java."

### Implementation

#### Adding Mockito to Your Project

Using the Mockito libraries should be done via a modern dependency management tool like Maven or Gradle. All modern IDEs (Eclipse, Visual Studio Code, IntelliJ IDEA) have built-in support for these tools.

Below is a class we will be using to demonstrate Mockito, `Pet`.

```java
public class Pet {
  private int id
  private String name;
  private int age;
  private String species;
  private int vetId;

  // ... constructors, getters, setters, toString(), etc. ...

  public String talk() {
    return "animal noise";
  }

  public String bow() {
    return "the pet bows";
  }

  public void doTrick() {
    talk();
    bow();
    talk();
  }
}
```

#### Creating Mocks

Using the `mock()` method from the `Mockito` class, we can create a mock object of the `Pet` class.

```java
public class PetTest {
  Pet petMock = mock(Pet.class);

  // ... tests omitted
}
```

Using the `@Mock` annotation and the `MockitoAnnotations.openMocks(this)` method, we can create a mock object of the `Pet` class.

```java
public class PetTest {
  @Mock
  Pet petMock;

  @BeforeEach
  public void setUpTests() {
    MockitoAnnotations.openMocks(this);
  }

  // ... tests omitted
}
```

Using the `@Mock` annotation and the `@ExtendWith(MockitoExtension.class)` annotation, we can create a mock object of the `Pet` class.

```java
@ExtendWith(MockitoExtension.class)
public class PetTest {
  @Mock
  Pet petMock;

  // ... tests omitted
}
```

Please note that the `@ExtendWith()` annotation is included in a separate dependency, `mockito-junit-jupiter`, which must be added to your project.

#### Stubbing Methods

Stubbed methods allow you to define the output of certain method calls.

```java
@Test
public void talk_returnsNull() {
  String actual = petMock.talk();
  String expected = null;

  Assertions.assertEquals(expected, actual); // This test will pass
}
```

To change the output of the `talk()` method, we can use the `when()` and `thenReturn()` methods from the `Mockito` class.

```java
@Test
public void bow_returnsSomethingDifferent() {
  when(petMock.bow()).thenReturn("return this other string");
}
```

Sometimes in testing, you would want to test behavior if an exception is thrown. To throw exceptions in your tests, you can use the `thenThrow()` method from the `Mockito` class.

```java
@Test
public void bow_throwExceptionJustBecause() {
  when(petMock.bow()).thenThrow(Exception.class);
}
```

Stubbing void methods requires the use of a different syntax because the `when()` method does not support void methods, but the results are the same.

```java
public void doTrick_throwsException() {
  // doTrick() is a void method, so we use doThrow() instead of when()
  // when(petMock.doTrick()).thenThrow(Exception.class); // This won't compile

  doThrow(Exception.class).when(petMock).doTrick(); // This will compile
}
```

#### Creating Spies

You can create a spy just as you would create a mock, using any of the three methods shown above. The difference is that a spy will call the real methods unless they are stubbed and the word "spy" is used instead of "mock".

```java
public class PetTest {
  Pet petSpy = spy(Pet.class);
}
```

#### Behavior Verification

Checking that the spy's not stubbed `doTrick()` method does call the `talk()` method at least once.

```java
@Test
public void doTrick_callsTalkAtLeastOnce() {
  petSpy.doTrick();
  verify(petSpy, atLeastOnce()).talk(); // This test will pass
}
```

You can use the Mockito class's `verify()` method to test or verify interactions between objects and their method calls. The first argument is the mock or spy object, and the second argument is a verification mode. The default verification mode is `times(1)`, which means that the method should be called exactly once.
And then you specify the method you want to verify.

You can also verify the order of method calls using the `InOrder` class or that an interaction never happened using the `never()` verification mode.

#### Dependency Injection

Mockito provides an annotation for injecting mock objects into dependent objects, called `@InjectMocks`. We will now have a `PetService` interface and an implementation class, `PetServiceImpl`. This layer of our application depends on a DAO layer. We can see the dependency in the `PetServiceImpl` class. Our goal is to test the service layer, not the DAO layer.

```java
public interface PetService {
  public Pet getPetById(int id);
  public List<Pet> getAllPetsByVetId(int vetId);
  // ... other methods omitted
}
```

```java
public class PetServiceImpl implements PetService {
  // dependency on the DAO layer
  private PetDAO petDAO;

  public PetServiceImpl(PetDAO petDAO) {
    this.petDAO = petDAO;

  @Override
  public Pet getPetById(int id) {
    return petDAO.getPetById(id);
  }

  @Override
  public List<Pet> getAllPetsByVetId(int vetId) {
    List<Pet> allPetsReturned = petDAO.getAllPets();

    return allPetsReturned.stream()
        .filter(pet -> pet.getVetId() == vetId)
        .collect(Collectors.toList());
  }

  // ... other methods omitted
}
```

Let's write a test class for the `PetServiceImpl` class.

```java
public class PetServiceTest {
  // specify which object to inject into
  @InjectMocks
  private PetService petService = new PetServiceImpl(null);

  // specify what to inject
  @Mock
  private PetDAO petDAO;

  // create a variable that keeps track of mocked objects
  private AutoCloseable openMocks;

  @BeforeEach
  public void setUpTests() {
    // perform actual dependency injection
    openMocks = MockitoAnnotations.openMocks(this);
  }

  // ... tests omitted

  @AfterEach
  public void tearDown() throws Exception {
    openMocks.close();
    petService = null;
    petDAO = null;
  }
}
```

Notice that we are using the `@InjectMocks` annotation to specify which object to inject into, and the `@Mock` annotation to specify what to inject. We then create a mock, and in the `@BeforeEach` method, we perform the actual dependency injection using the `MockitoAnnotations.openMocks(this)` method. Note that `InjectMocks` annotation only works with `@Mock` or `@Spy` annotated fields.
`MockitoAnnotations.openMocks(this)` returns an `AutoCloseable` object that we can use to close the mocks in the `@AfterEach` method. This allows us to keep track of our mocks and release their resources when we are done with them.

Let's do an example of of a service method test:

```java
@Test
public void getPetById_succeeds() {
  // Arrange
  Pet pet = new Pet(1, "Fido", 3, "Dog", 1);

  when(petDAO.getPetById(1)).thenReturn(pet);

  // Act: use the actual service method of the object under test
  Pet petReturned = petService.getPetById(1);

  // Assert: the service layer method should return whatever the DAO layer method returns
  Assertions.assertEquals(pet, petReturned);
}
```

## Mocking the DAO Layer

#### The DAO Layer and the Service Layer

The DAO (Data Access Object) layer is responsible for interacting with the database. It contains methods for CRUD (Create, Read, Update, Delete) operations on the database. It encapsulates data access logic and provides abstraction over the data source.

The Service layer is responsible for the business logic of the application. It contains methods that perform operations on the data and interact with the DAO layer to retrieve or store data in the database. The Service layer acts as a bridge between the presentation layer (e.g., controllers) and the DAO layer.
The Service layer implements use cases, enforces business rules, performs validation, and coordinates transactions.

The service layer depends on the DAO layer to access and manipulate data. Service contain DAO instances that can be used to call their respective CRUD operation methods.

#### Testing the Service Layer

When testing the Service layer, we want to isolate it from the DAO layer. This is where mocking comes in. We can use Mockito to create mock objects of the DAO layer and inject them into the Service layer. This allows us to test the Service layer without actually interacting with the database.

When testing the Service layer, we want to focus on the business logic and not the data access logic. DAO's are often mocked or stubbed to isolate the service logic from database interactions. Mocking DAO's allow for unit testing of service methods with controlled data scenarios. DAOs are tested separately to ensure correct database interactions and query execution; however, these are integration tests rather than unit tests.

We can use Mockito to mock the DAO instance. The `@InjectMocks` annotation can be used to automatically inject mocked dependencies into the fields of the target object being tested. It simplifies the process of setting up the tests by automatically creating mocks for the dependencies of the target object and injecting them during test initialization.

### Real World Application

Understanding how to mock dependencies and test the service layer is crucial for several reasons:

- **Isolation of Unit Tests**: By mocking dependencies, you can isolate the code under test from its collaborators, such as databases, external APIs, or third-party services. This allows you to focus on testing the logic specific to the service layer without the need for complex setup or teardown of external systems.
- **Flexibility in Test Scenarios**: Mocking dependencies gives you control over the behavior and responses of external components, allowing you to simulate various scenarios and edge cases that may be difficult to reproduce in a real-world environment. This enables thorough testing of error handling, edge cases, and specific business logic.
- **Enhances Code Quality and Maintainability**: Writing tests for the service layer with mocked dependencies encourages modular, loosely coupled design principles, leading to cleaner, more maintainable code. It also provides documentation of the service layer's expected behavior and interactions with its dependencies.

In summary, understanding how to mock dependencies and test the service layer is essential for effective and comprehensive unit testing of your application's business logic and behavior.

### Implementation

The use case for the following test is finding a birthday celebration that actually happened. Let's assume birthdays were stored in a database with their year, but we do not know which was the latest, as celebrations did not happen every year. Thus, the business logic is searching back from a given year to find the most recent birthday celebration.

It is this logic that we want to test, and nothing else. We are not interested in testing databases access; furthermore, we do not want to rely on data stored in a database, as this would make our tests brittle and unreliable.

Technically, we know that the service layer depends on the DAO layer to access and manipulate data so we will mock the DAO layer to isolate the service layer. We also have access to the service implementation class, so we can construct it. Nevertheless, the DAO is a private hidden field in the service. The challenge is write a unit test, using Mockito, that asserts that the service actually searches back from a given year to find the most recent birthday celebration.

#### Setting Up the Project

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>fri</groupId>
    <artifactId>mockitoTest3</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>3.1.0</version>
        </dependency>

    </dependencies>

</project>
```

#### Service and DAO Layer

The code below is the service interface. The comment on the `findBirthdayCelebration()` method describes the business logic.
Note: methods in interfaces are public by default.

```java
public interface BirthdayCelebrationService {
  /**
   * Find the most recent birthday celebration on or before the given year.
   * If no birthday celebration is found, return null.
   *
   * @param year the year to search back from
   * @return the most recent birthday celebration on or before the given year, or null if none found
   */
  BirthdayCelebration findBirthdayCelebration(int year);
}
```

The service implementation contains the business logic that we want to test. It depends on the DAO layer to access the data.

```java
public class BirthdayCelebrationServiceImpl implements BirthdayCelebrationService {
  private static final int MAX_YEARS_BACK = 100;
  private BirthdayCelebrationDao dao = new BirthdayCelebrationDao();

  public Date findBirthdayCelebration(int startYear) {
    Date found = null;
    int year = startYear;
    for (int count = 0; found == null && count < MAX_YEARS_BACK; count++) {
      found = dao.getBirthdayCelebration(year);
      year--;
    }
    return found;
  }
}
```

Finally, here is the DAO layer that normally encapsulates the data access logic.

```java
public class BirthdayCelebrationDao {
  public Date getBirthdayCelebration(int year) {
    // This method would normally access the database to retrieve the birthday celebration for the given year.
    // For this example, we will return null to simulate that no celebration was found.
    return null;
  }
}
```

#### The Unit Test

```java
public class BirthdayCelebrationServiceTest {
  @Mock private BirthdayCelebrationDao dao;

  @InjectMocks
  private BirthdayCelebrationService service = new BirthdayCelebrationServiceImpl();

  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenNoBirthdayCelebrationThenSkipToPreviousYear_Success() {
    // Arrange
    final int LATEST_BIRTHDAY_CELEBRATION_YEAR = 2017;
    final Date expected = newBirthdayDate(LATEST_BIRTHDAY_CELEBRATION_YEAR);
    final int START_YEAR = LATEST_BIRTHDAY_CELEBRATION_YEAR + 2;

    for (int year = START_YEAR; year > LATEST_BIRTHDAY_CELEBRATION_YEAR; year--) {
      when(dao.getBirthdayCelebration(year)).thenReturn(null);
    }
    when(dao.getBirthdayCelebration(LATEST_BIRTHDAY_CELEBRATION_YEAR)).thenReturn(expected);

    // Act
    final Date actual = service.findBirthdayCelebration(START_YEAR);

    // Assert
    Assertions.assertEquals(expected, actual);
  }


  private Date newBirthdayDate(int year) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 12);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }
}
```
