# Java Basics and OOP Intro - Day 1

## Stack and Heap Memory

To run an application in an optimal manner, JVM divides memory into two main areas: Stack and Heap.

- **Stack Memory**: This is where method calls and local variables are stored. It's a fast and efficient memory area, but it's limited in size. When a method is called, a new stack frame is created, and when the method returns, the stack frame is popped off the stack.

- **Heap Memory**: This is where objects are stored. It's larger than stack memory and is used for dynamic memory allocation. However, accessing heap memory is slower than stack memory. Objects in the heap are managed by the garbage collector, which automatically frees up memory that's no longer in use.

Whenever we declare new variables and objects, call a new method, declare a `String`, or perform similar operations, JVM allocates memory in either the stack or heap.

Understanding the differences between stack and heap memory is crucial for writing efficient Java applications.

### Stack Memory in Java

In Java, stack memory is used for the execution of threads. Each thread has its own stack, which stores:

- **Method Calls**: Each time a method is called, a new stack frame is created and pushed onto the stack. This frame contains the method's local variables, parameters, and return address.

- **Local Variables**: Variables declared within a method are stored in the stack frame. They are only accessible within that method and are automatically removed when the method returns.

- **Primitive Data Types**: Variables of primitive data types (e.g., `int`, `char`, `boolean`) are stored directly in the stack.

The stack operates in a Last In, First Out (LIFO) manner, meaning the most recently added stack frame is the first to be removed when a method returns.

Stack memory is used for static memory allocation and the execution of threads. It contains primitive values that are specific to a method and references to objects in the heap.

Access to this memory is **LIFO** (Last In, First Out), meaning the last method called is the first one to be completed. Whenever we call a new method, a new block is created on top of the stack which contains values specific to that method, like primitive variables and references to objects.
When the method finishes execution, its corresponding stack frame is removed from the stack, freeing up the memory it occupied and the flow returns to the previous method.

**Key Features of Stack Memory:**

- It grows and shrinks as new methods are called and returned, ensuring efficient use of memory.
- Variables stored in the stack exist only as long as the method that created them is executing.
- It's automatically allocated and deallocated when methods are called and returned.
- If this memory is full, a `StackOverflowError` may occur, indicating that the stack has grown beyond its limit.
- Access to this memory is fast and efficient when compared to heap memory.
- This memory is thread safe, meaning that each thread has its own stack and there is no interference between threads.

### Heap Memory in Java

Heap memory is used for dynamic memory allocation in Java. It is a shared memory area that is accessible by all threads in the application. The heap is where all Java objects are stored, including instances of classes, arrays, and `String` objects.

When an object is created using the `new` keyword, memory for that object is allocated in the heap. The reference to that object is then stored in the stack memory. This allows multiple references to point to the same object in the heap.

It is used for the dynamic memory allocation of Java objects and JRE classes at runtime. New objects are always created in the heap, and the references are stored in the stack. Unlike stack memory, heap memory is not automatically deallocated when a method returns. Instead, it relies on the garbage collector to free up memory that is no longer in use.

We can break this memory model down into three main areas, called generations:

1. **Young Generation**: This is where all new objects are allocated. It is further divided into:

   - **Eden Space**: Where new objects are created.
   - **Survivor Space**: Where objects that survive garbage collection are moved.

2. **Old Generation**: This is where long-lived objects are stored. Objects that have survived multiple garbage collection cycles in the young generation are promoted to the old generation.

- When objects are stored in the young generation, a threshold for the object age is maintained. If an object survives long enough, it is moved to the old generation.

3. **Permanent Generation (or Metaspace in Java 8 and later)**: This area stores metadata about the classes and methods used in the application. It is not part of the heap but is still managed by the garbage collector.

Understanding these three areas can help developers write more efficient Java applications by minimizing garbage collection pauses and optimizing memory usage.

**Key Features of Java Heap Memory:**

- It's accessed via complex memory management techniques that include the Young Generation, Old Generation, and Permanent Generation.
- If heap space is full, a `OutOfMemoryError` may occur, indicating that the heap has grown beyond its limit.
- Access to this memory is slower compared to stack memory due to its dynamic nature.
- It is not thread-safe, meaning that multiple threads can interfere with each other's access to heap memory.
- This memory, in contrast to stack, is not automatically deallocated when a method returns. Instead, it relies on the garbage collector to free up memory that is no longer in use.
- Objects in the heap can be accessed from anywhere in the application, making it a shared memory area.

## Real World Application

Understanding the concepts of the stack and heap memory is essential for optimizing memory usage, managing resources efficiently, and avoiding memory-related issues such as leaks and overflows. By knowing how memory is allocated and deallocated in Java, developers can make informed decisions about object creation, lifecycle management, and performance tuning.

Here are some examples of real-world applications of knowing about the stack and heap:

- **Memory Management in Embedded Systems**: In resource-constrained environments, such as embedded systems, understanding stack and heap memory can help developers optimize memory usage and avoid overflows.
- **Performance Optimization in High-Performance Computing**: In applications that require high performance, such as scientific computing or financial modeling, understanding memory allocation can help optimize performance and reduce latency.
- **Multithreaded Programming**: In applications that use multiple threads, understanding stack and heap memory can help avoid race conditions and ensure thread safety.
- **Resource Management in Mobile and Game Development**: In mobile and game development, where resources are limited, understanding memory allocation can help optimize performance and reduce crashes.

### Implementation

Based on what we have learned so far, let's analyze a simple Java program to asses how to manage memory here:

```java
class Person {
  int id;
  String name;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

public class PersonBuilder {
  private static Person buildPerson(int id, String name) {
    return new Person(id, name);
  }

  public static void main(String[] args) {
    int id = 23;
    String name = "John";
    Person person = null;
    person = buildPerson(id, name);
  }
}
```

Let's analyze this step-by-step:

When we enter the `main()` method, space is allocated on the stack for the local variables `id`, `name`, and `person`. The `id` and `name` variables hold primitive and reference types, respectively. The `person` variable is initially set to `null`.

- The reference variable `name` points to a `String` object in the heap memory that contains the value "John".
- The reference variable `person` is currently `null`, meaning it does not point to any object in the heap.

The `main` method is further executed, and the `buildPerson` method is called with the parameters `id` and `name`. A new stack frame is created for this method call.

The call to the parameterized constructor of the `Person` class creates a new `Person` object in the heap memory. The constructor initializes the object's fields with the provided values.

- The `this` object reference of the calling object is stored in the stack frame of the `buildPerson` method.

Heap memory is allocated for the new `Person` object, and the reference to this object is returned to the `main` method.

## Casting

Casting is the process of converting a variable from one type to another. In Java, there are two types of casting: **primitive casting** and **reference casting**.

- **Primitive Casting**: This involves converting between primitive data types, such as `int`, `float`, and `char`. For example:

```java
int intValue = 10;
float floatValue = (float) intValue; // explicit casting
```

- **Reference Casting**: This involves converting between reference types, such as objects and their subclasses. For example:

```java
Animal animal = new Dog();
Dog dog = (Dog) animal; // explicit casting
```

Java can automatically convert some primitive types to others and so so whenever needed, but it cannot automatically convert reference types. In such cases, explicit casting is required.

For example, an `int` can be converted to a `float` without explicit casting, but large `int` values won't be converted exactly because `int` values can have more digits than `float` can represent.

Whenever you perform a mathematical operation on two values that aren't of the same type, Java automatically converts one of them to the type of the other. This is known as **type promotion**.

Here are some rules Java follows when doing a type conversion:

- If one of the values is a `double`, the other value is automatically converted to a `double`.
- If neither is a `double`, but one is a `float`, the other is converted to a `float`.
- If neither is a `double` nor a `float`, but one is a `long`, the other is converted to a `long`.
- If all else fails, the values are converted to `int`.

### Casting

Casting is the process of explicitly converting a variable from one type to another. In Java, you can cast primitive types and reference types. This is also called **type casting**. Casting is necessary in some situations, such as when you want to treat a subclass object as an instance of a superclass.

When working with some primitive numeric types, Java will automatically do the conversion for you. This will only work when the conversion is safe, meaning that the value can be represented in the target type without loss of information. The automatic conversion is supported when the source type is smaller than the target type. For example, you can convert an `int` to a `long` without any issues:

```java
int intValue = 100;
long longValue = intValue; // automatic conversion
```

### Real World Application

In the example below, an `int` (size of 32 bits) is being cast to a `double` (size of 64 bits). This is a safe conversion because a `double` can represent all possible values of an `int` without loss of information.

```java
public class CastingExample {
    public static void main(String[] args) {
        int intValue = 100;
        double doubleValue = intValue; // automatic conversion
    }
}
```

However, cases where the original data type is larger than the target type, you will have to use explicit casting using the cast operator `()`:

```java
public class CastingExample {
    public static void main(String[] args) {
        double doubleValue = 100.0;
        int intValue = (int) doubleValue; // explicit casting
    }
}
```

In some cases, you will have to use the data type's own methods to convert between types. Some of these methods are listed in the table below:

| Original | Target   | Method                          |
| -------- | -------- | ------------------------------- |
| `int`    | `String` | `String.valueOf(intValue)`      |
| `String` | `int`    | `Integer.parseInt(stringValue)` |

### Implementation

**Widening vs Narrowing**

There is an important distinction to be aware of when casting to a type that encompasses a larger range of values (widening) versus a smaller range of values (narrowing).

When implementing a widening type conversion, you won't have to worry about data loss, because you will have extra bits of information to store the number in. For example, when converting an `int` to a `long`, you are simply adding more bits to represent the number.

When implementing a narrowing type conversion, you can potentially lose data, because you are trying to fit a larger value into a smaller space. For example, when converting a `double` to an `int`, you may lose the decimal portion of the number:

- **Widening (Implicit):** This occurs when you convert a smaller primitive type to a larger primitive type. For example, converting an `int` to a `long` is widening because a `long` can hold all possible `int` values without any data loss.

```java
int intValue = 100;
long longValue = intValue; // automatic widening conversion
```

- **Narrowing (Explicit):** This occurs when you convert a larger primitive type to a smaller primitive type. For example, converting a `double` to an `int` is narrowing because an `int` cannot hold all possible `double` values, and you may lose the fractional part.

```java
double doubleValue = 100.99;
int intValue = (int) doubleValue; // explicit narrowing conversion
```

**Casting an `int` to a `byte`**:

Let's see what happens when we cast our value to a type that cannot hold all the bits of information. A `byte` is an 8-bit number that follows the **two's complement** representation for signed numbers. This means it can hold values from -128 to 127.

```java
int intValue = 200;
byte byteValue = (byte) intValue; // explicit narrowing conversion
```

In this example, the `int` value 200 is cast to a `byte`. However, since 200 is outside the range of a `byte`, the result will be a negative number due to overflow. The actual value of `byteValue` will be -56, which is the result of the two's complement representation.

In order to understand this, we need to think back to how binary numbers are represented in memory. The `int` value 200 is represented in binary as `11001000`. When we cast it to a `byte`, only the least significant 8 bits are kept, and the most significant bits are discarded. This results in the binary representation `11001000`, which is -56 in decimal (due to two's complement representation).

This is a common pitfall when working with casting in Java, and it highlights the importance of understanding the range of values that each primitive type can hold.

## Classes and Objects

Classes and objects are fundamental concepts in object-oriented programming (OOP). They allow you to model real-world entities and their behaviors in a structured way.

### Classes vs Objects and Reference Variables

It is important to understand the difference between a **class**, an **object**, and a **reference variable** in Java.

A `class` is a template used to instantiate objects. It is also called a **type** when used with a reference variable. A class that is used to instantiate an object determines what state and behavior that object will have.

An **object** is an instance of a class in memory. In Java, you never interact with objects directly. Instead, you interact with them through their reference, which is the memory address where the object is stored.

A **reference variable** is a variable that holds the memory address of an object. It allows you to access the object's state and behavior. Reference variables are declared using the class name as the type. Just like the type of a primitive variable determines the range of values it can hold, the type of a reference variable determines what kind of object it can refer to.

When a class is used as the type of a reference variable, that reference can only be used to refer to objects of that class or its subclasses.

Let's look at the following line of code that we have divided into three parts:

| 1        | 2      | 3                        |
| -------- | ------ | ------------------------ |
| `String` | `name` | `new String("John Doe")` |

1. **Type**: `String` is the type of the reference variable. It indicates that `name` can only refer to objects of type `String`.
2. **Reference Variable**: `name` is the reference variable that will hold the memory address of the `String` object.
3. **Object Creation**: `new String("John Doe")` is the expression that creates a new `String` object in memory. The `name` reference variable will hold the memory address of this object.

More in-depth:

- The `name` reference variable does not contain a `String` object itself. Instead, it holds the memory address where the `String` object is stored.
- The `String` type indicates that `name` can only refer to `String` objects or objects of subclasses of `String`.
- The `String` type means that the `name` reference variable can access methods and properties defined in the `String` class.
- The `new String("John Doe")` expression creates a new `String` object in memory, it is not the object itself. You can never access an object directly; you always access it through its reference variable.

Understanding these concepts is crucial for working with objects in Java and for grasping the principles of object-oriented programming.

## Constructors

A **constructor** is a special method in Java that is used to initialize objects. It is called when an object of a class is created, and it allows you to set the initial state of the object.

When we use the `new` keyword in order to create an object, the JVM invokes a special class member called a **constructor**. This constructor is a method that has the same name as the class and does not have a return type, not even `void`. It is used to initialize the object with default or specified values.

A constructor declares how an object is to be instantiated and initialized from the class "blueprint".

```java
public class ConstructorExample {
  int myNumber;

  // Constructor
  public ConstructorExample(int initialNumber) {
    myNumber = initialNumber;
  }
}
```

A constructor can be overloaded, meaning you can have multiple constructors in a class with different parameter lists. This allows you to create objects in different ways, depending on the information available at the time of creation.

```java
public class ConstructorExample {
  int myNumber;

  // Constructor
  public ConstructorExample(int initialNumber) {
    myNumber = initialNumber;
  }

  // Overloaded constructor
  public ConstructorExample() {
    myNumber = 0; // Default value
  }
}
```

**`this` Keyword**

The `this` keyword is a reference variable that refers to the current object. It is commonly used in constructors and methods to differentiate between instance variables and parameters with the same name.

```java
public class ConstructorExample {
  int myNumber;

  // Constructor
  public ConstructorExample(int myNumber) {
    this.myNumber = myNumber;
  }
}
```

`this` refers to the current object, allowing you to access its instance variables and methods.

**`super` Keyword**

The `super` keyword is used to refer to the superclass of the current object. It can be used to call a superclass constructor or to access superclass methods and variables.

```java
public class SuperExample {
  int myNumber;

  // Constructor
  public SuperExample(int myNumber) {
    this.myNumber = myNumber;
  }
}

public class SubExample extends SuperExample {
  int mySubNumber;

  // Constructor
  public SubExample(int myNumber, int mySubNumber) {
    super(myNumber); // Call superclass constructor
    this.mySubNumber = mySubNumber;
  }
}
```

A `super()` call (or a `this()` call) must be the first statement in the constructor. This means you cannot have any other statements before it. This rule ensures that the superclass is properly initialized before the subclass adds its own initialization logic. If not explicitly called, the default constructor of the superclass is called automatically.

**Default Constructor**

If a class does not explicitly define any constructor, the Java compiler automatically provides a default constructor. This default constructor is a no-argument constructor that initializes instance variables to their default values (e.g., `0` for integers, `null` for objects).

### Real World Application

Constructors are essential in object-oriented programming for several reasons:

1. **Initialization**: Constructors allow you to set initial values for object attributes, ensuring that objects are in a valid state when created.

2. **Overloading**: With constructor overloading, you can create objects in different ways, providing flexibility in how objects are instantiated.

3. **Encapsulation**: Constructors can enforce encapsulation by controlling how objects are created and initialized, allowing you to hide implementation details.

4. **Inheritance**: Inheritance allows subclasses to inherit constructors from their superclasses, promoting code reuse and reducing redundancy.

5. **Polymorphism**: Constructors can be used in conjunction with polymorphism to create objects of different classes through a common interface.

6. **Dependency Injection**: Constructors can be used to implement dependency injection, allowing you to provide an object with its dependencies at the time of creation.

Overall, constructors play a crucial role in the design and implementation of robust, maintainable object-oriented systems.

## Garbage Collection

In Java, garbage collection is the process of automatically reclaiming memory that is no longer in use by the program. It helps manage memory efficiently by identifying and removing objects that are no longer reachable or referenced by any part of the program.

The Java Virtual Machine (JVM) includes a garbage collector that runs in the background, monitoring the allocation and deallocation of memory. When an object is created, memory is allocated for it on the heap. If there are no references to that object (i.e., it is no longer reachable), the garbage collector can reclaim that memory for future use.

Garbage collection helps prevent memory leaks, which occur when memory that is no longer needed is not released, leading to increased memory usage and potential application crashes. However, it is important to note that garbage collection is not a substitute for proper memory management practices. Developers should still be mindful of object life-cycles and release resources when they are no longer needed.

Consider the following example:

```java
Object o1 = new Object(); // 1
Object o2 = new Object(); // 2
Object o3 = o1; // 3
o2 = o3; // 4
```

How many objects were created in the heap memory? We determine this by counting the number of `new` keywords used to create objects. In this case, two objects were created in the heap memory at lines 1 and 2.

However, we declared 3 reference variables that point to these objects in memory.
The third line does not create a new object but assigns the reference of `o1` to `o3`, meaning `o3` now points to the same object as `o1`.

The last line reassigns the `o2` reference variable to point to the same object as `o3`, which is the same object as `o1`. This means that the original object referenced by `o2` is no longer reachable, and it becomes eligible for garbage collection.

In lower-level programming languages, memory is manipulated directly in the code, but Java abstracts this process away from the developer. The garbage collector runs periodically to identify and reclaim memory occupied by unreachable objects.

**There is no way we can explicitly force or trigger the garbage collector to run.** However, we can suggest it by calling one of the following methods:

- `System.gc()`: This method suggests that the JVM should run the garbage collector, but it is not guaranteed to do so immediately.
- `Runtime.getRuntime().gc()`: This method also suggests that the JVM should run the garbage collector, but like `System.gc()`, it is not guaranteed to do so immediately.
- `System.runFinalization()`: This method suggests that the JVM should run finalization methods for objects that are eligible for garbage collection.

### Real World Application

The biggest benefit of Java's garbage collection is that it allows developers to focus on writing code without worrying about memory management. This leads to fewer memory leaks and crashes, making Java applications more robust and reliable.
Programmers working in languages without automatic garbage collection often have to manually manage memory, which can lead to bugs and inefficiencies.

Despite the extra work required, some programmers argue in favor of manual memory management over garbage collection, primarily for reasons of performance and control. They argue that garbage collection can introduce unpredictable pauses in application execution, which can be problematic for real-time applications or those requiring low latency.

For scenarios in which garbage collector is negatively impacting performance, developers can use techniques such as:

- **Object Pooling**: Reusing objects instead of creating new ones can reduce the frequency of garbage collection.
- **Weak References**: Using weak references allows the garbage collector to reclaim memory for objects that are no longer strongly reachable, helping to prevent memory leaks.
- **Finalizers**: Implementing finalizers allows objects to perform cleanup operations before being garbage collected, although this is generally discouraged due to performance concerns.
- **Explicit Nulling**: Setting references to `null` when they are no longer needed can help the garbage collector identify unreachable objects more easily.
