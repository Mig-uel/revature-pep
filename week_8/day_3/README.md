# Advanced SQL and Java - Day 3

## Optional Class

The `Optional` class in Java is a container object which may or may not contain a non-null value. It is used to represent optional values and helps to avoid `NullPointerException`.

It was introduced in Java 8 as a way to handle scenarios where methods might return null values. Instead of returning null, a method can return an `Optional` object that either contains a value or is empty.

`Optional` encourages developers to explicitly handle the case where a value might be absent, leading to more robust and readable code.

#### Optional Methods

`Optional` is a generic class that can contain a value of type `T` or be empty. It provides several methods for accessing and manipulating the value if present. Here are some commonly used methods of the `Optional` class:

- `of(T value)`: Creates an `Optional` containing the specified non-null value. If the value is null, it throws a `NullPointerException`.
  - Example: `Optional.of("Hello")` creates an `Optional` containing the string "Hello".
- `ofNullable(T value)`: Creates an `Optional` that may or may not contain a non-null value. If the value is null, it returns an empty `Optional`.
  - Example: `Optional.ofNullable(null)` creates an empty `Optional`.
- `empty()`: Returns an empty `Optional` instance. Represents the absence of a value.
  - Example: `Optional.empty()` creates an empty `Optional`.
- `isPresent()`: Returns `true` if the `Optional` contains a value, otherwise returns `false`.
  - Example: `optional.isPresent()` checks if the `Optional` has a value.
- `isPresent(consumer)`: If a value is present, it performs the given action with the value, otherwise does nothing.
  - Example: `optional.ifPresent(value -> System.out.println(value))` prints the value if present.
- `get()`: Returns the value if present, otherwise throws `NoSuchElementException`.
  - Example: `optional.get()` retrieves the value from the `Optional`.
- `orElse(T other)`: Returns the value if present, otherwise returns the specified default value.
  - Example: `optional.orElse("Default")` returns the value or "Default" if the `Optional` is empty.
- `orElseGet(Supplier<? extends T> other)`: Returns the value if present, otherwise invokes the specified supplier and returns the result.
  - Example: `optional.orElseGet(() -> "Generated Default")` returns the value or generates a default value if the `Optional` is empty.
- `orElseThrow(Supplier<? extends X> exceptionSupplier)`: Returns the value if present, otherwise throws an exception created by the specified supplier.
  - Example: `optional.orElseThrow(() -> new IllegalStateException("Value not present"))` throws an exception if the `Optional` is empty.
- `map(Function<? super T, ? extends U> mapper)`: If a value is present, it applies the provided mapping function to it and returns an `Optional` describing the result. If no value is present, it returns an empty `Optional`.
  - Example: `optional.map(value -> value.toUpperCase())` transforms the value to uppercase if present.
- `flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)`: Similar to `map`, but the mapping function must return an `Optional`. This is useful for chaining operations that return `Optional` values.
  - Example: `optional.flatMap(value -> Optional.of(value.length()))` returns an `Optional` containing the length of the string if present.
- `filter(Predicate<? super T> predicate)`: If a value is present and it matches the given predicate, it returns an `Optional` describing the value, otherwise returns an empty `Optional`.
  - Example: `optional.filter(value -> value.length() > 3)` returns the `Optional` if the string length is greater than 3.

#### `orElse()` vs `orElseGet()`

It is recommended to use `orElse()` when you have a constant or simple default value. For a value resulting from a complex or expensive computation, use `orElseGet()` to avoid unnecessary computation when the `Optional` contains a value. The reason for this is that `orElseGet()` takes a `Supplier` function as an argument, which is only executed if the `Optional` is empty. This is known as lazy evaluation. If you were to pass an equivalent method call into the `orElse()` method as an argument, that method would be executed regardless of whether the `Optional` contains a value or not.

#### `map()` vs `flatMap()`

It is recommended to use `map()` when the transformation function returns a non-`Optional` value and you want to keep the result wrapped in an `Optional`. Use `flatMap()` when the transformation function itself returns an `Optional`, and you want to avoid nested `Optional` instances and flatten the result.

## Stream API

The Stream API in Java provides a modern way to process sequences of elements (like collections) in a functional style. It allows for operations such as filtering, mapping, and reducing data in a concise and readable manner.

Streams are an abstraction that represents a sequence of elements and supports various operations to manipulate those elements. It allows defining a pipeline of operations that can be executed on the elements of a collection and do not modify the original collection and are lazy executed. Streams **do not store data**; they simply define operations like filtering, mapping, and reducing, which can be combined with other operations to form a pipeline. Some built-in `Stream`s are located in the `java.util.stream` package.

Streams are divided into **intermediate** and **terminal** operations. Intermediate streams return a new stream and always lazy, meaning they do not execute until a terminal operation is invoked (a terminal operation is one that produces a result or side-effect, such as `collect() `, `forEach()`, or `reduce()`).
Terminal operations trigger the execution of the stream pipeline, which allows efficient processing of all operations in a single pass over the data.

Reduction operations combine the elements of a stream into a single result, such as summing numbers or concatenating strings. They are typically terminal operations and can be performed using methods like `reduce()` or `collect()`.

```java
List<Student> students = new ArrayList<>();

// Add students to the list

// Using Stream API to filter, map, and collect grades of students who are attending
List<Double> grades = students.stream()
    .filter(student -> student.isAttending()) // Intermediate operation: filter
    .mapToDouble(student -> student.getGrade()) // Intermediate operation: map
    .collect(Collectors.toList()); // Terminal operation: collect
```

The example above demonstrates how to use the Stream API to filter students who are attending, map their grades, and collect the results into a list. The operations are chained together in a fluent manner, making the code more readable and expressive.

## Reflection API

The Reflection API in Java allows programs to inspect and manipulate the runtime behavior of applications. It provides the ability to analyze classes, interfaces, fields, and methods at runtime, even if their names are not known until runtime. This is particularly useful for frameworks, libraries, and tools that need to work with classes and objects dynamically

Reflection is particularly useful for building generic code, implementing frameworks, and writing debugging tools. The API can be found in the `java.lang.reflect` package.

#### Using Reflection

The `java.lang.Class` class represents classes and interfaces in a running Java application. It provides methods to query information about a class, such as its name, superclass, implemented interfaces, constructors, methods, and fields. There are several ways to obtain a `Class` object:

- Using the `.class` syntax: `Class<MyClass> clazz = MyClass.class;`
- Using the `getClass()` method on an object: `Class<?> clazz = myObject.getClass();`
- Using `Class.forName("fully.qualified.ClassName")`: This method loads the class with the specified name.

Once you have a `Class` object, you can inspect its structure using methods such as `getFields()`, `getMethods()`, `getConstructors()`, `getDeclaredFields()`, `getDeclaredMethods()`, and `getDeclaredConstructors()`. These methods return arrays of `Field`, `Method`, and `Constructor` objects, which provide further details about the class members.

The difference between methods that start with `get` and those that start with `getDeclared` is that those that start with `get` return only the public members of the class, including those inherited from superclasses. In contrast, methods that start with `getDeclared` return all members declared in the class itself, regardless of their access modifiers (public, protected, private).

Just as there is a class that represents `Class`, there are classes that represent fields, methods, and constructors. These classes also contain methods that allow you to inspect and manipulate the corresponding members of a class.

### Real World Example

Knowing reflection is useful for many scenarios, such as:

- **Introspection**: Reflection enables you to inspect the structure and behavior of classes, interfaces, fields, methods, and constructors at runtime. This is particularly useful for debugging, logging, and analyzing code.
- **Dependency Injection and Inversion of Control**: Many dependency injection frameworks (like Spring) and inversion of control containers use reflection to inspect and wire dependencies at runtime. By using reflection, these frameworks can automatically instantiate and inject dependencies into objects based on configuration or annotations.
- **Testing and Debugging**: Reflection can be helpful in testing and debugging scenarios where you need to access and modify private fields or invoke private methods for testing purposes. It enables you to inspect and manipulate the internal state of objects, which can be useful for unit testing and debugging complex scenarios.
- **Annotations and Custom Annotations**: Reflection is often used in conjunction with annotations to process and interpret metadata associated with classes, methods, and fields. It allows you to extract and analyze annotation metadata at runtime, enabling powerful runtime behavior based on annotations.
- **Framework and Library Development**: Many frameworks and libraries leverage reflection to provide dynamic behavior and extensibility. For example, serialization frameworks use reflection to inspect object fields and convert them to a specific format (like JSON or XML) and vice versa.
- **Dynamic Proxies**: Reflection is used to create dynamic proxy classes that can intercept method calls and add additional behavior, such as logging, caching, or security checks. This is commonly used in frameworks like Java's built-in Proxy class and libraries like CGLIB.
- **ORM (Object-Relational Mapping)**: Many ORM frameworks (like Hibernate) use reflection to map Java objects to database tables and vice versa. Reflection allows these frameworks to inspect the structure of Java classes and generate SQL queries dynamically based on the class structure.

Overall, understanding reflection empowers developers to build more flexible, dynamic, and extensible applications by leveraging runtime introspection and manipulation capabilities. While reflection is a powerful tool, it should be used judiciously, as it can introduce performance overhead and security risks if not handled carefully.

### Implementation

When using the Reflection API, we use the following steps:

1. Obtain a `Class` object representing the class you want to inspect.
2. Use the methods of the `Class` object to retrieve information about the class, such as its fields, methods, and constructors.
3. Manipulate or use the retrieved information as needed.
4. If necessary, use reflection to create instances of the class, invoke methods, or access fields dynamically.

#### Obtaining a Class Object

```java
Class<?> classObj = String.class; // Using .class syntax to get Class object of String class
System.out.println(classObj); // Output: class java.lang.String

Class<?> classObj2 = Class.forName("java.lang.String"); // Using Class.forName() to get Class object
System.out.println(classObj2); // Output: class java.lang.String

Class<?> classObj3 = "Hello".getClass(); // Using getClass() method on an object
System.out.println(classObj3); // Output: class java.lang.String
```

Above are three different ways to obtain a `Class` object representing the `String` class.

#### Obtaining Class Members

```java
// Step 1: Obtain Class object
Class<?> classObj = Object.class; // Using .class syntax to get Class object of Object class
System.out.println(classObj + "\n"); // Output: class java.lang.Object

// Step 2: Get class members
Method[] methods = classObj.getDeclaredMethods(); // Get all declared methods
for (Method method : methods) {
    System.out.println(method); // Print each method
}
```

The above code demonstrates how to obtain a `Class` object for the `Object` class and retrieve all its declared methods using the `getDeclaredMethods()` method. It then iterates over the array of `Method` objects and prints each method to the console.

#### Using Class Members

```java
// Step 3: Use class members
Method method = (Method) classObj.getDeclaredMethods("getClass"); // Get specific method by name
System.out.println(method); // Print the method
System.out.println(method.invoke("Hello")); // Invoke the method on an object
```
