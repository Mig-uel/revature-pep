# Advanced SQL and Java - Day 4

## Thread Class

In Java, the `Thread` class is a fundamental part of the multithreading capabilities of the language. It represents a separate thread of execution in a program, allowing concurrent execution of multiple tasks within a single application. Threads can be created by extending the `Thread` class or implementing the `Runnable` interface. Each thread has its own call stack, program counter, and local variables, enabling independent execution.

#### Thread Methods

A few important methods of the `Thread` class include:

- getters for `name`, `id`, `priority`, `state`, and `isAlive()`
- setters for `name` and `priority`
- `interrupt()`: Explicitly interrupts a thread.
- `isAlive()`, `isInterrupted()`, and `isDaemon()`: Check the status of a thread.
- `join()`: Waits for a thread to die.
- `start()`: Starts the execution of the thread.

A few important `static` methods of the `Thread` class include:

- `Thread.currentThread()`: Returns a reference to the currently executing thread object.
- `Thread.sleep(long millis)`: Pauses the currently executing thread for a specified duration.

#### Thread Priorities

Priorities in Java threads are represented by integer values ranging from 1 to 10, and signify the relative importance of a thread and which order threads are to run. The `Thread` class provides three constants to represent thread priorities:

- `Thread.MIN_PRIORITY` (value 1): The lowest priority.
- `Thread.NORM_PRIORITY` (value 5): The default priority assigned to threads.
- `Thread.MAX_PRIORITY` (value 10): The highest priority.

#### Creating Threads

you can create a new thread by subclassing the `Thread` class and overriding its `run()` method, or by providing a `Runnable` object or lambda expression to a `Thread` constructor.

```java
class MyThread extends Thread {
  @Override
  public void run() {
    // Code to be executed in the new thread
    System.out.println("Thread is running");
  }
}

public class Main {
  public static void main(String[] args) {
    // Create a new thread
    Thread t1 = new MyThread(() -> {
      // Code to be executed in the new thread
      System.out.println("Thread is running");
    });

    Thread t2 = new MyThread();

    // Start the thread
    t1.start(); // Calls the run() method in a new thread
    t2.start(); // Calls the run() method in a new thread
  }
}
```

In the above example, we create a new thread by sub-classing the `Thread` class and overriding its `run()` method. We then create an instance of the `MyThread` class and call the `start()` method to begin execution in a new thread.

### Real World Example

A very good example of thread-based multithreading is a word processing program that checks the spelling of words in a document while the user is typing. The spell-checking function can run in a separate thread, allowing the user to continue typing without interruption.

Another familiar example is a web browser that starts rendering a web page while it is still downloading the remaining content.

Background tasks like running application servers which will come into action whenever a request is made to them.

Performing some execution while I/O operations are being performed.

Games are also very good examples of multithreading, where different threads can handle rendering graphics, processing user input, and managing game logic simultaneously.

Airplane ticket reservation systems, where multiple users can book tickets concurrently without conflicts.

### Implementation

In the following example, we will create an `Employee` class that extends the `Thread` class. We will override the `run()` method to define the task that each thread will perform. A thread begins its life inside the `run()` method.

```java
public class Employee extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " is working on task " + i);

      try {
        // Simulate some work with sleep
        Thread.sleep(100);
      } catch (InterruptedException e) {
        /**
         * InterruptedException is thrown when a thread is waiting, sleeping, or otherwise occupied,
         * and another thread interrupts it.
         */
        e.printStackTrace();
        break;
      }
    }
  }
}
```

#### Using the Thread

In the below example, we will be using the `Employee` class and use the thread we created. You will see the use of `start()` and `join()` methods.

We create an object of the `Employee` class and call the `start()` method to begin execution in a new thread. `start()` internally calls the `run()` method in a new thread.

We then call the `join()` method to wait for the thread to finish before proceeding with the main thread.

```java
public class Main {
  public static void main(String[] args) {
    // Create a new Employee thread
    Employee emp1 = new Employee();
    emp1.setPriority(1); // Minimum priority
    // emp1.run(); // This will not create a new thread, it will run in the main thread
    emp1.start(); // This will create a new thread and call the run() method; Thread state: RUNNABLE

    // Create another Employee thread
    Employee emp2 = new Employee();
    emp2.setPriority(2); // Maximum priority
    emp2.start(); // This will create a new thread and call the run() method; Thread state: RUNNABLE

    /**
     * join() method
     *
     * Using join() method, we can make the main thread wait for the completion of emp1 and emp2 threads.
     * This ensures that the main thread will not proceed until both emp1 and emp2 have finished their execution.
     */
    try {
      emp1.join(); // Main thread will wait for emp1 to finish
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Display the priority of threads
    System.out.println("emp1 priority: " + emp1.getPriority()); // Output: emp1 priority: 1
    System.out.println("emp2 priority: " + emp2.getPriority()); // Output: emp2 priority: 2

    // Check to see if a given thread is alive or not
    System.out.println("Is emp1 alive? " + emp1.isAlive()); // Output: Is emp1 alive? false
    System.out.println("Is emp2 alive? " + emp2.isAlive()); // Output: Is emp2 alive? false
  }
}
```

## Runnable Interface

The `Runnable` interface is a functional interface in Java that represents a task that can be executed by a thread. It contains a single abstract method, `run()`, which defines the code to be executed when the thread is started. The `Runnable` interface is often used to create threads in a more flexible way compared to extending the `Thread` class, as it allows a class to implement multiple interfaces and still be used as a thread.

#### Creating Threads with Runnable

- Create a class that implements the `Runnable` interface.
  - Override the `run()` method to define the task to be performed by the thread.
  - Pass an instance of the class to a `Thread` object.
- Call the `start()` method on the `Thread` object to begin execution.

```java
public class MyRunnable implements Runnable {
  @Override
  public void run() {
    // Code to be executed in the new thread
    System.out.println("Runnable thread is running");
  }
}
```

#### Runnable and Lambda Expressions

Because `Runnable` is a functional interface, we can use lambda expressions to define thread behavior inline instead of creating a separate class. We can directly pass a lambda expression as the `Runnable` type required by the `Thread` constructor.

```java
public class Main {
  public static void main(String[] args) {
    // Using a lambda expression to create a Runnable
    Thread t = new Thread(() -> {
      System.out.println("Runnable thread is running");
    });

    // Start the thread
    t.start(); // Calls the run() method in a new thread
  }
}
```

In the above example, we create a new thread by passing a lambda expression that implements the `Runnable` interface to the `Thread` constructor. We then call the `start()` method to begin execution in a new thread.

### Real World Example

Here are some real-world examples where the `Runnable` interface can be effectively used:

- **Web Servers**: In web server applications, the `Runnable` interface is used to handle incoming client requests concurrently. Each client request is encapsulated in a `Runnable` task, which is then executed by a thread from a thread pool to ensure efficient handling of multiple requests simultaneously.
- **Background Tasks**: Many applications perform background tasks, such as batch data processing, data synchronization, or periodic updates. The `Runnable` interface allows you to encapsulate these tasks as separate `Runnable` units of work, which can be asynchronously or on separate threads.
- **Parallel Processing**: In parallel processing applications, such as scientific computing or data analysis, the `Runnable` interface can be used to divide a large task into smaller subtasks. Each subtask can be implemented as a `Runnable` and executed concurrently to improve performance and reduce processing time.
- **Testing and Mocking**: In unit testing scenarios, the `Runnable` interface can be used to create mock implementations of tasks or services. This allows for easy testing of concurrent behavior without the need for complex thread management.

Overall, the `Runnable` interface is a versatile and widely used construct in Java for implementing multithreading and concurrent programming, making it suitable for various real-world applications that require parallel execution of tasks.

### Implementation

#### Creating a New Thread Using Runnable

- Create a `Runnable` implementer and implement the `run()` method.
- Instantiate the `Thread` class and pass the implementer to the `Thread`. `Thread` has a constructor that takes a `Runnable` object as an argument.
- Invoke the `start()` method of the `Thread` instance, which internally calls the `run()` method of the `Runnable` implementer in a new thread. Invoking the `run()` method directly will not create a new thread; it will execute in the current thread.

#### Example 1

```java
public class RunnableDemo {
  public static void main(String[] args) {
    System.out.println("Main thread is " + Thread.currentThread().getName());

    // Create a Thread
    Thread t = new Thread(new RunnableDemo().new RunnableImpl());

    // Start the thread
    t.start();
  }

  private class RunnableImpl implements Runnable {
    @Override
    public void run() {
      System.out.println("Runnable thread is " + Thread.currentThread().getName());
    }
  }
}
```

The example above demonstrates how to create a new thread using the `Runnable` interface. We define a class `RunnableImpl` that implements the `Runnable` interface and overrides the `run()` method. We then create a new `Thread` object, passing an instance of `RunnableImpl` to its constructor, and start the thread using the `start()` method.

#### Example 2

What happens when `Runnable` encounters an exception? `Runnable` cannot throw checked exceptions, but `RuntimeException` can be thrown from the `run()` method. Uncaught exceptions are handled by the exception handler of the thread, and if JVM can't handle or catch the exception, it will terminate the thread and print the stack trace to the console.

```java
import java.io.FileNotFoundException;

public class RunnableDemo {
  public static void main(String[] args) {
    System.out.println("Main thread is " + Thread.currentThread().getName());

    // Create a Thread
    Thread t = new Thread(new RunnableDemo().new RunnableImpl());

    // Start the thread
    t.start();
  }

  private class RunnableImpl implements Runnable {
    public void run() {
      System.out.println("Runnable thread is " + Thread.currentThread().getName());

      /**
       * Checked exceptions cannot be thrown from the run() method of Runnable.
       * Instead Runnable must handle them within the run() method.
       */
      try {
        throw new FileNotFoundException("File not found");
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      int r = 1 / 0; // This will throw ArithmeticException (a RuntimeException)

      // throw new NullPointerException("Null pointer exception"); // This will throw NullPointerException (a RuntimeException)
    }
  }
}
```

In the above example, we demonstrate how to handle checked exceptions within the `run()` method of a `Runnable` implementation. We also show that unchecked exceptions, such as `ArithmeticException`, can be thrown and will terminate the thread if not caught.

## States of a Thread

At any given time, a thread can be in one of the following states:

- **NEW**: A thread that has been created but not yet started is in this state.
- **RUNNABLE**: A thread that is ready to run and is waiting for CPU time is in this state.
- **BLOCKED**: A thread that is blocked waiting for a monitor lock is in this state.
- **WAITING**: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
- **TIMED_WAITING**: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
- **TERMINATED**: A thread that has exited is in this state.

#### Lifecycle of a Thread

- **New Thread**: When a thread is created using the `Thread` class or by implementing the `Runnable` interface, it is in the **NEW** state. The thread has not yet started to run when the thread is in this state. When a thread lies in the new state, its code is yet to be executed.
- **Runnable State**: A thread that is ready to run is moved to the **RUNNABLE** state. In this state, a thread might actually be running or it might ready to run but waiting for CPU time. It is the responsibility of the thread scheduler to give the thread, time to run. A multithreaded program allocates a fixed amount of time to each individual thread. Each and every thread runs for a short period of time and the pauses and relinquishes the CPU to another thread so that other threads can get a chance to run. This process is called context switching. When this happens, all such threads that are ready to run, waiting for the CPU time, are in the **RUNNABLE** state.
- **Blocked/Waiting State**: When a thread is temporarily inactive, is is in one the following states:
  - **BLOCKED**: A thread is in the **BLOCKED** state when it is waiting to acquire a monitor lock to enter or re-enter a synchronized block/method.
  - **WAITING**: A thread is in the **WAITING** state when it is waiting indefinitely for another thread to perform a particular action. This can happen when a thread calls methods like `Object.wait()`, `Thread.join()` without a timeout, or `LockSupport.park()`.
  - **TIMED_WAITING**: A thread is in the **TIMED_WAITING** state when it is waiting for another thread to perform an action for up to a specified waiting time. This can happen when a thread calls methods like `Thread.sleep()`, `Object.wait(long timeout)`, `Thread.join(long millis)`, or `LockSupport.parkNanos()`/`LockSupport.parkUntil()`.
- **Terminated State**: A thread is in the **TERMINATED** state when it has completed its execution or has been terminated. Once a thread enters this state, it cannot be restarted. A thread can enter the terminated state either by completing its `run()` method or by being terminated due to an uncaught exception.

### Real World Example

Knowing the different thread states is important for understanding and debugging multithreaded and concurrent applications. Here are several reasons why understanding thread states is important:

- **Debugging**: When troubleshooting concurrency issues, understanding thread states can help identify the cause of problems such as deadlocks, livelocks, or race conditions. By examining the states of threads, developers can gain insights into the behavior of concurrent code and diagnose issues more effectively.
- **Performance Optimization**: Understanding thread states can aid in performance optimization by identifying bottlenecks and inefficiencies in thread management. By analyzing the state transitions of threads, developers can identify areas where threads spend excessive time in certain states, such as waiting or blocked, and optimize the code to reduce contention and improve overall performance.
- **Concurrency Control**: Thread states are closely related to synchronization and concurrency control mechanisms, such as locks, monitors, and atomic operations. Understanding thread states helps developers reason about the correctness and effectiveness of synchronization strategies used to coordinate access to shared resources among multiple threads.

In summary, knowing the different thread states is crucial for effectively managing and debugging multithreaded applications, optimizing performance, and ensuring correct concurrency control.

### Implementation

#### Implementing Thread States

In Java, to get the current state of a thread, you can use the `getState()` method of the `Thread` class. This method returns an instance of the `Thread.State` enum, which represents the current state of the thread.

```java
class WorkerThread implements Runnable {
  public void run() {
    // Moving thread2 to times waiting state
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("State of thread1 while it called join() method on thread2 - " + ThreadStateDemo.thread1.getState());

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class ThreadStateDemo {
  public static Thread thread1;
  public static ThreadStateDemo instance;

  public static void main(String[] args) {
    instance = new ThreadStateDemo();
    thread1 = new Thread(instance);

    // thread1 is in new state
    System.out.println("State of thread1 after creating it - " + thread1.getState());
    thread1.start();

    // thread1 is in runnable state
    System.out.println("State of thread1 after calling .start() method on it - " + thread1.getState());
  }

  public void run() {
    WorkerThread worker = new WorkerThread();
    Thread thread2 = new Thread(worker);

    // thread2 is in new state
    System.out.println("State of thread2 after creating it - " + thread2.getState());
    thread2.start();

    // thread2 is in runnable state
    System.out.println("State of thread2 after calling .start() method on it - " + thread2.getState());

    // moving thread1 to waiting state
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("State of thread2 after calling .sleep() method on it - " + thread2.getState());

    // moving thread1 to waiting state
    try {
      // thread1 is waiting for thread2 to complete its task
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("State of thread2 when it has completed it's execution - " + thread2.getState());
  }
}
```

In the above example, we demonstrate the different states of a thread in Java. We create two threads, `thread1` and `thread2`, and print their states at various points in their lifecycle. The output will show the transitions between the different thread states, such as NEW, RUNNABLE, TIMED_WAITING, WAITING, and TERMINATED.

## Multithreading

#### Concurrency

**Concurrency** is the ability of a program to execute multiple tasks or processes simultaneously or in overlapping time periods. In a concurrent system, multiple tasks can make progress independently, even if they are not executing at the exact same time. Concurrency is often achieved through techniques such as multithreading, multiprocessing, or asynchronous programming.

It refers to breaking up as task or piece of computation into different parts that can be executed independently, out of order, or in partial order, without affecting the final outcome. One way -- but not the only way -- to achieve concurrency is by using multiple threads within a single process.

Operating systems use concurrency to manage the many different programs that run on them. For example, the GUI of an operating system us ran at the same time as other processes. Without this, any process that took too long in the background, like reading/writing to files, or making an HTTP request, would cause the GUI to freeze up and become unresponsive.

#### Multi-core Processing

Most computers today have multiple CPU cores. Each core can be thought of as a separate processor that can execute its own thread of instructions. Multi-core processing allows a computer to perform multiple tasks simultaneously, improving overall performance and responsiveness. Without multiple cores, operating systems would have to rely on time-slicing to give the illusion of concurrency, which can lead to inefficiencies and delays. Time-slicing means running one process for a short period of time, then switching to another process, and so on rapidly. This ensures that no process or application hogs the CPU, but it can also lead to delays and inefficiencies, especially if a process needs to wait for I/O operations or other resources.

#### Intro to Threads

A thread is a subset of a process that is also an independent sequence of execution, but threads of the main process run in the same memory space, managed independently by a scheduler. We can think of a thread as a "path of execution", but they can access the same objects and variables as other threads in the same process. This means that threads can share data and resources, but it also means that they can interfere with each other if they are not properly synchronized.

Every thread has its own call stack, program counter, and local variables, but they share the same heap memory space. This means that threads can access and modify the same objects and variables in the heap memory, which can lead to data inconsistencies and race conditions if not handled properly.

#### Multithreading

**Multithreading** extends the idea of multitasking into applications and processes. Each thread can have its own task that it is responsible for, and the operating system's scheduler will allocate CPU time to each thread as needed. Multi-core processors can actually run multiple different processes and threads concurrently, enabling true parallelism.

In Java, multithreading is achieved through the `Thread` class and the `Runnable` interface. Java provides built-in support for creating and managing threads, allowing developers to create multithreaded applications easily.

#### Note on Best Practices

In general, it is best to avoid implementing multithreading unless absolutely necessary. The benefit of multithreading is better performance due to non-blocking execution. However, you should always measure or attempt to estimate the performance benefit you will get by using threads versus the tradeoff of increased complexity and potential for bugs. Usually there are frameworks, tools, or libraries that have implemented the problem you are trying to solve, and you can leverage those instead of trying to implement it yourself. For example, web servers like Apache Tomcat have already implemented thread pools to handle multiple requests concurrently, so you don't have to implement your own thread management system.

### Real World Example

Understanding multithreading is crucial for developing modern software applications that need to efficiently utilize available hardware resources, improve performance, and enhance user experience. Here's why understanding multithreading is important:

- **Concurrency**: Multithreading allows programs to perform multiple tasks concurrently, making better use of available CPU resources and reducing idle time. This concurrency is essential for applications that need to handle multiple tasks simultaneously, such as web servers, databases, and user interfaces.
- **Responsiveness**: Multithreading enabled applications to remain responsive to user input while performing background tasks. For example, in GUI applications, background threads can handle time-consuming operations such as file I/O or network requests, while the main thread remains responsive to user interactions.
- **Parallelism**: Multithreading enabled parallel execution of tasks on multi-core processors, where tasks can execute independently and asynchronously without blocking the main thread of execution. Asynchronous programming is crucial for building responsive and non-blocking applications, such as web servers and real-time systems.
- **Fault Tolerance**: Multithreading can enhance fault tolerance and robustness in distributed systems by isolating failure-prone components or tasks in separate threads. By decoupling tasks and handling failures gracefully, multithreaded applications can continue to operate even when some threads encounter errors or exceptions.

In summary, understanding multithreading is essential for building efficient, responsive, and robust software applications that can effectively utilize modern hardware capabilities and meet the demands of concurrent and parallel processing.

### Implementation

Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such a program is called a thread, and each thread defines a separate path of execution. So, threads are lightweight processes within a process.

There are two ways to create a thread in Java:

1. By extending the `Thread` class
2. By implementing the `Runnable` interface

Both approaches have their use cases, and the choice between them depends on the specific requirements of the application.

#### Example 1: Extending the Thread Class

We create a class that extends the `java.lang.Thread` class and override its `run()` method to define the task that the thread will perform. We then create an instance of the class and call the `start()` method to begin execution in a new thread.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 5; // Number of threads
        for (int i = 0; i < n; i++) {
            MyThread t = new MyThread();
            t.start(); // Calls the run() method in a new thread
        }
    }
}
```

#### Example 2: Implementing the Runnable Interface

We create a class that implements the `Runnable` interface and override its `run()` method to define the task that the thread will perform. We then create an instance of the class, pass it to a `Thread` object, and call the `start()` method to begin execution in a new thread.

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 5; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new MyRunnable());
            t.start(); // Calls the run() method in a new thread
        }
    }
}
```

#### Thread Class vs Runnable Interface

- If we extend the `Thread` class, we cannot extend any other class because Java does not support multiple inheritance. However, if we implement the `Runnable` interface, we can still extend another class.
- We can achieve basic functionality of a thread by extending the `Thread` class because it provides some built-in methods like `yield()`, `interrupt()`, `join()`, etc. that are not available in the `Runnable` interface.
- Using the `Runnable` interface will give you an object that can be passed around, shared, and reused by multiple threads. This is not possible when you extend the `Thread` class.
