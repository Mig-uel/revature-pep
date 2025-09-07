# APIs and Testing - Day 1

Java is mainly an **object-oriented programming language**. This means that everything in Java is associated with **classes and objects**, along with its attributes and methods. However, Java can also be used for **functional programming**.

Functional programming is a different way of thinking about programming. While OOP uses objects and object interactions to design applications, functional programming focuses on using functions to build software. Instead of having objects interacting with each other, functional programming relies on the use of pure functions to transform data.

In functional programming, functions are first-class citizens, meaning they can be passed as arguments, returned from other functions, and assigned to variables. In Java, we can use **lambda expressions** and **method references** as our "first-class citizen" functions, and we can use "functional interfaces" variables and method parameters to hold them.

Using functional programming in Java can be similar to utilizing object casting in OOP. Just as we can cast objects to different types to access specific behaviors, we can use functional programming techniques to manipulate data in a more declarative way.

The below example assumes we have an `Animal` supertype and `Dog` and `Cat` subtypes. We can use object casting to access subtype-specific methods:

![example_1](example_1.gif)

With object casting, we can swap subclass objects if we have a supertype reference variable. Meaning, we can assign a `Dog` or `Cat` object to an `Animal` reference variable. However, we can only access the methods defined in the `Animal` class unless we cast the object back to its original type.

We can do something similar if we use **functional interfaces**. A **functional interface** is an interface that contains only **ONE** abstract method. We can use the interface as a supertype reference variable and we can assign it a function (lambda expression or method reference) that matches the abstract method's signature. This allows us to swap different functions while using the same interface reference variable.

In the below example, we have a variable be of the functional interface type, and then we assign it a lambda as its value. We can then call the abstract method on the interface variable, which will execute the lambda function.

![example_2](example_2.gif)

The most common use case of functional programming in Java is to have functional interface types as method parameters. This allows us to pass different functions to a method, enabling us to change the behavior of the method without changing its implementation.

![example_3](example_3.gif)

### Real World Application

Understanding functional interfaces in Java is important because they are a fundamental concept in modern Java programming, especially with the introduction of lambda expressions and the Stream API in Java 8. Here are some reasons why understanding functional interfaces is important:

- **Lambda Expressions**: Functional interfaces enable the use of lambda expressions, which provide a concise way to express instances of single-method interfaces. Lambda expressions can make code more readable and maintainable by reducing boilerplate code.
- **Stream API**: The Stream API in Java heavily relies on functional interfaces for operations like filtering, mapping, and reducing collections. These methods accept functional interfaces as parameters, allowing developers to pass custom behavior to process data in a functional style.
- **Parallel Processing**: Functional interfaces enable parallel processing of collections using features like parallel streams. Parallel streams internally use functional interfaces to split the workload and execute operation concurrently, improving performance for large datasets.
- **Higher-Order Functions**: Functional interfaces allow the creation of higher-order functions, which are functions that can take other functions as arguments or return them as results. This enables more abstract and flexible programming patterns.
- **Functional Programming Paradigm**: Functional interfaces are a key component of the functional programming paradigm, which promotes writing code in a declarative and composable manner. Understanding functional interfaces helps developers embrace functional programming concepts and write cleaner, more modular code.

In summary, understanding functional interfaces in Java is crucial for leveraging modern Java features, writing more expressive code, and embracing functional programming principles.

### Implementation

Let's look at an example of object casting versus functional programming. Let's say we have three classes: `Animal`, `Dog`, and `Cat`.

```java
abstract class Animal {
    public abstract void makeNoise();
}

abstract class Cat extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Meow!");
    }
}
abstract class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Woof!");
    }
}
```

In `Main.java`, we can use object casting to swap `Animal` implementations wherever there is an `Animal` reference variable. (Note: This is not functional programming, just OOP with object casting aka polymorphism.)

```java
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();
        myAnimal.makeNoise(); // Outputs "Woof!"

        myAnimal = new Cat();
        myAnimal.makeNoise(); // Outputs "Meow!"
    }
}
```

Now, let's implement functional programming. First, we will need a functional interface so that we can yse it as a reference/supertype variable. There are already many built-in functional interfaces in the `java.util.function` package, and you'll most likely use those in real-world applications. However, for this example, we will create our own functional interface called `Prettier`:

```java
public interface Prettier {
  /**
   * This method takes in an Object, translates it to a pretty String, and
   * returns that String.
   *
   * @param obj The object to be prettified.
   * @return A pretty String representation of the object.
   */
  public abstract String prettify(Object obj);
}
```

Functional interfaces conventionally have names ending in `-er` or `-able`, such as `Runnable`, `Callable`, `Comparable`, etc. They also typically have only one abstract method, which is the method that will be implemented by the lambda expression or method reference. In this case, we have an interface called `Prettier` with one abstract method called `prettify` and the functionality of the interface is to convert an object to a pretty string. We define a single abstract method that takes in an `Object` and returns a `String`.

Let's implement this functionality using a lambda expression in `Main.java`:

```java
public class Main {
  public static void main(String[] args) {
    // ---- Functional Programming ---- //

    // write functionality
    Prettier prettierImpl = x -> "*~*~ " + x + " ~*~*";

    // use functionality
    Integer myInteger = 5;
    String result = prettierImpl.prettify(myInteger);
    System.out.println(result); // output: "*~*~ 5 ~*~*"

    // swap implementations
    prettierImpl = x -> "+-+- " + x + " -+-+";
    result = prettierImpl.prettify(myInteger);
    System.out.println(result); // output: "+-+- 5 -+-+"
  }
}
```

Let's break down the code:

- The statement: `Prettier prettierImpl = x -> "*~*~ " + x + " ~*~*";` is a lambda expression that implements the `prettify` method of the `Prettier` interface and assigns it to the `prettierImpl` variable. The lambda takes in a single parameter `x` (of type `Object`, inferred from the interface) and returns a formatted string.
- The expression `x -> "*~*~ " + x + " ~*~*"` has unusual syntax because it is a lambda expression. Think of lambdas as functions we can create "on the fly" without needing to create a whole new class that implements the interface. They allow us to write functionality concisely by omitting boilerplate code.
- The `-> ` syntax separates the parameter list (on the left) from the body of the lambda (on the right). In this case, the body is a single expression that concatenates strings.
- Lambdas implicitly return the value of the expression on the right side of the `->` if there are no curly braces `{}`. If there were curly braces, we would need to use an explicit `return` statement.
- We then use the implementation by calling `prettierImpl.prettify(myInteger)` and passing in an `Integer` object. The lambda implementation is executed, and the result is printed.

One significant difference between OOP and functional programming is that we can use much less code to omplement some standalone functionality. For example, if we wanted to create a `Prettier` implementation using OOP, we would need to create a new class that implements the `Prettier` interface:

```java
public class FancyPrettier implements Prettier {
  @Override
  public String prettify(Object obj) {
    return "*~*~ " + obj + " ~*~*";
  }
}

public class Main {
  public static void main(String[] args) {
    // ---- Object Oriented Programming ---- //

    // write functionality
    Prettier prettierImpl = new FancyPrettier();

    // use functionality
    Integer myInteger = 5;
    String result = prettierImpl.prettify(myInteger);
    System.out.println(result); // output: "*~*~ 5 ~*~*"
  }
}
```
