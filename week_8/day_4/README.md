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
