# Java Basics and OOP Intro - Day 2

## Wrapper Classes

In Java, wrapper classes are used to convert primitive data types into objects. Each primitive type has a corresponding wrapper class:

- `int` -> `Integer`
- `char` -> `Character`
- `double` -> `Double`
- `boolean` -> `Boolean`
- `byte` -> `Byte`
- `short` -> `Short`
- `long` -> `Long`
- `float` -> `Float`

Wrapper classes provide a way to use primitive types as objects, which is useful in situations where objects are required, such as in collections.

This is necessary, for example, for certain methods which only accept objects and not primitive types.

**Boxing** is the process of converting a primitive type into its corresponding wrapper class object. Java has a feature called **autoboxing** that automatically converts a primitive type to its wrapper class when needed.

**Unboxing** is the reverse process, where the wrapper class object is converted back to its corresponding primitive type. Java also supports **autounboxing**, which automatically converts a wrapper class object to its primitive type when needed.

Below are the wrapper classes and their corresponding primitive types:

| Primitive Type | Wrapper Class |
| -------------- | ------------- |
| `int`          | `Integer`     |
| `char`         | `Character`   |
| `double`       | `Double`      |
| `boolean`      | `Boolean`     |
| `byte`         | `Byte`        |
| `short`        | `Short`       |
| `long`         | `Long`        |
| `float`        | `Float`       |

### Autoboxing and Unboxing Example

```java
public class WrapperExample {
    public static void main(String[] args) {
        // Autoboxing
        int primitiveInt = 5;
        Integer wrappedInt = Integer.valueOf(primitiveInt);

        // Unboxing
        Integer anotherWrappedInt = 10;
        int anotherPrimitiveInt = anotherWrappedInt.intValue();
    }
}
```

### Real World Application

In real-world applications, wrapper classes in Java are essential for several reasons:

1. **Integration with Collections**: Java's collection framework (like `ArrayList`, `HashMap`, etc.) works with objects, not primitives. Wrapper classes allow you to store primitive values in these collections.

2. **Nullability**: Wrapper classes can be `null`, which is useful when you need to represent the absence of a value. For example, an `Integer` can be `null`, while an `int` cannot.

3. **Utility Methods**: Wrapper classes come with useful methods for converting between types, parsing strings, and more. For example, `Integer.parseInt("123")` converts a string to an `int`, while `Double.toString(3.14)` converts a `double` to a string.

4. **Compatibility with Generics**: When using generics, you can only use objects. Wrapper classes allow you to use primitive types in generic classes and methods.

Overall, wrapper classes play a crucial role in Java programming by bridging the gap between primitive types and the object-oriented nature of the language. This enables compatibility with collections, generics, APIs, and additional functionality that primitive types lack. They provide flexibility, nullability, and enhanced functionality, making them indispensable in many Java applications.
