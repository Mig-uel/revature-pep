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
