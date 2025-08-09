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
