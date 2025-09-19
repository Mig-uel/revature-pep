# Java Collections and Algorithms

## Iterators

#### Iterable and Iterator Interfaces

The `Iterable` interface represents a collection of elements that can be iterated over. It provides a method to obtain an `Iterator`, which is used to traverse the elements in the collection.

The `Iterator` interface provides methods to iterate over a collection, including:

- `hasNext()`: Checks if there are more elements to iterate over.
- `next()`: Returns the next element in the iteration.
- `remove()`: Removes the last element returned by the iterator (optional operation).

```java
List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

Iterator<String> iterator = names.iterator();

while (iterator.hasNext()) {
    String name = iterator.next();
    System.out.println(name);
}
```

In this example, we create a list of names and use an `Iterator` to traverse and print each name.

#### Enhanced For Loop

Any class that implements the `Iterable` interface can be used in an enhanced for loop (also known as a "for-each" loop). This provides a more concise way to iterate over collections.

```java
List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

// Using enhanced for loop
for (String name : names) { // Syntax: for (Type element : collection)
    System.out.println(name);
}
```

This example demonstrates the use of an enhanced for loop to iterate over the list of names. The syntax is `for (Type element : collection)`, where `Type` is the type of elements in the collection, `element` is a variable that holds the current element during each iteration, and `collection` is the iterable collection being traversed.

The downside of the enhanced for loop is that the index of the current iteration is not tracked, so if you need to know the index, you should use a traditional for loop or an iterator. However, this simplified syntax is beneficial for many simple iteration tasks.

Both `Iterator` and `Iterable` are interfaces in Java that look similar but are two different concepts. The `Iterable` interface represents a collection of elements that can be iterated over, while the `Iterator` interface provides methods to traverse the elements in a collection.

In short, if any class implements the `Iterable` interface, it gains the ability to be iterated over using an `Iterator`. The `Iterator` interface is used to actually perform the iteration over the elements of the collection.

#### Iterable

An `Iterable` represents a collection of elements that can be iterated over. It provides a method to obtain an `Iterator`, which is used to traverse the elements in the collection. Implementing the `Iterable` interface allows an object to make use of the `for-each` loop syntax. It does this by internally calling the `iterator()` method to get an `Iterator` instance.

For example, the following code works because the `List` interface extends the `Collection` interface, which in turn extends the `Iterable` interface:

```java
List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

for (String name: names) {
    System.out.println(name);
}
```

Wait, don't we have to get the iterator first? No, because the `for-each` loop does that for us behind the scenes. The `for-each` loop is syntactic sugar that simplifies the process of iterating over collections.

Please note that we can also call the `forEach` method directly on an `Iterable` object, which takes a lambda expression or method reference as an argument to perform an action for each element in the collection.

```java
names.forEach(name -> System.out.println(name));
// or using method reference
names.forEach(System.out::println);
```

On the other hand, the `Iterator` interface provides methods to iterate over a collection using the `hasNext()`, `next()`, and `remove()` methods. It is used to traverse the elements in a collection one by one.

```java
Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();

while (iterator.hasNext()) {
    Integer number = iterator.next();
    System.out.println(number);
}
```

Starting from Java 8, the `Iterator` interface also includes a `forEachRemaining` method, which allows you to perform an action for each remaining element in the iteration.

```java
Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
// Using forEachRemaining with a lambda expression
iterator.forEachRemaining(number -> System.out.println(number));
// or using method reference
iterator.forEachRemaining(System.out::println);
```

Once can also use an `Iterator` inside a `for-each` loop, but it is not common practice. The `for-each` loop is typically used with collections that implement the `Iterable` interface.

```java
for (Integer i : (Iterable<Integer>) () -> iterator) {
    System.out.println(i);
}
```

- Any class that implements the `Iterable` interface needs to override the `iterator()` method to return an `Iterator` instance. The `iterator()` method returns an `Iterator` that can be used to traverse the elements in the collection.
- Any class implementing the `Iterator` interface must override the `hasNext()`, `next()`, and optionally the `remove()` methods to provide the functionality for iterating over the elements in the collection.
- The `Iterator` instance stores the iteration state, such as the current position in the collection, while the `Iterable` interface does not store any state. It simply provides a way to obtain an `Iterator` for the collection.
- The contract for the `Iterable` is that it should produce a new instance of an `Iterator` each time the `iterator()` method is called. This means that multiple calls to `iterator()` should return independent `Iterator` instances that can be used to traverse the collection separately.
- For an `Iterable`, we can move forward only in the forward direction, but some of the `Iterator` implementations may allow bidirectional traversal (e.g., `ListIterator`).
- Additionally, `Iterable` does not provide any methods for modifying the collection, while the `Iterator` interface provides the `remove()` method to remove elements from the collection during iteration.

### Real World Application

Java iterators play a crucial role in modern Java applications for several reasons:

- **Standardized Interface**: Java iterators provide a standardized way to traverse collections, regardless of the underlying data structure. This allows developers to write code that can work with different types of collections (e.g., lists, sets, maps) without needing to know the specific implementation details.
- **Safe Iteration**: Iterators provide a safe way to iterate over collections, ensuring that modifications to the collection during iteration are detected and handled appropriately. This helps prevent `ConcurrentModificationException` and other issues that can arise when modifying a collection while iterating over it.
- **Compatibility with Enhanced For Loop**: The `Iterable` interface allows collections to be used with the enhanced for loop (for-each loop), which provides a more concise and readable way to iterate over elements. This is especially useful in modern Java applications where code readability and maintainability are important.
- **Support for Custom Collections**: Iterators can be implemented for custom collection classes, allowing developers to create their own data structures that can be easily traversed using the iterator pattern. This is particularly useful in applications that require specialized data handling.
- **Functional Programming**: With the introduction of lambda expressions and the Stream API in Java 8, iterators can be used in conjunction with functional programming techniques. This allows for more expressive and concise code when processing collections, such as filtering, mapping, and reducing elements.

### Implementation

#### Iterate an Iterable Using Enhanced For-Loop

Objects of classes implementing the `Collection` interface can be iterated using a for-each loop since the `Collection` interface extends the `Iterable` interface.

```java
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> list = new ArrayList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterate over the list using an enhanced for-loop
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
```

#### Iterate an Iterable Using forEach Method

The `forEach` method is a default method in the `Iterable` interface that takes a lambda expression or method reference as an argument to perform an action for each element in the collection.

```java
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> list = new ArrayList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterate over the list using the forEach method with a lambda expression
        list.forEach(fruit -> System.out.println(fruit));

        // Alternatively, using a method reference
        list.forEach(System.out::println);
    }
}
```

#### Iterate an Iterator Using Iterator

We can iterate through the elements of a Java `Iterable` by obtaining an `Iterator` from the `Iterable` and using its methods.

The methods used while traversing the collections using an `Iterator` are:

- `hasNext()`: Returns `true` if the iteration has more elements.
- `next()`: Returns the next element in the iteration.
- `remove()`: Removes from the underlying collection the last element returned by this iterator (optional operation).
- `forEachRemaining()`: Performs the given action for each remaining element until all elements have been processed or the action throws an exception.

```java
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> list = new ArrayList<>();

        // Add values
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Obtain iterator from list
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
```

## ArrayList and LinkedList

The `ArrayList` and `LinkedList` classes in Java are both implementations of the `List` interface, but they have different underlying data structures and performance characteristics.

Because they implement the `List` interface, this means you can perform list specific operations on both `ArrayList` and `LinkedList`, such as adding, removing, and accessing elements by index, and perform common `Collection` operations like checking for containment, iterating over elements, and converting to an array. Additionally, both classes include their own specific methods that are not part of the `List` interface.

#### ArrayList

The `ArrayList` class is a resizable array implementation of the `List` interface. It provides fast random access to elements and is efficient for storing and accessing data. However, it can be slower for inserting or deleting elements in the middle of the list, as it may require shifting elements to maintain the array structure.

It is a data structure that contains an array within it but can resize dynamically as elements are added or removed. When the internal array reaches its capacity, a new larger array is created, and the existing elements are copied to the new array. The main benefits of using an `ArrayList` are the ability to dynamically resize and the fast access time for elements by index.

#### LinkedList

A `LinkedList` is a doubly-linked list implementation of the `List` and `Deque` interfaces. It consists of nodes, where each node contains a reference to the previous and next node in the list. This structure allows for efficient insertions and deletions at both ends of the list and in the middle, as it only requires updating the references of the neighboring nodes. However, accessing elements by index can be slower compared to an `ArrayList`, as it may require traversing the list from the beginning or end to reach the desired index.

| ArrayList                                                     | LinkedList                                                                    |
| ------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| Backed by a dynamic array                                     | Backed by a doubly linked list                                                |
| Fast random access by index                                   | Slower access by index, requires traversal                                    |
| Better for storing and accessing data                         | Better for frequent insertions and deletions                                  |
| Can act as a a list only because it implements List interface | Can act as a list and a queue because it implements List and Deque interfaces |
| The memory location for the elements is contiguous            | The memory location for the elements is not contiguous                        |

### Real World Application

An `ArrayList` can be used whenever you need a resizable, ordered collection of elements that allows for fast random access. Here are some real world applications of `ArrayList`:

- **Caching Popular Searches**: An `ArrayList` can be used to store a list of popular search queries in a search engine application. The list can be dynamically updated as new popular searches emerge, and the fast access time allows for quick retrieval of the most popular searches.
- **High Score Lists in Games**: In a gaming application, an `ArrayList` can be used to maintain a list of high scores. Players' scores can be added to the list, and the list can be sorted to display the top scores efficiently.
- **Storing User Search History**: An `ArrayList` can be used to store a user's search history in a web application. The list can be dynamically updated as the user performs new searches, and the fast access time allows for quick retrieval of recent searches.

A `LinkedList` can be used whenever you need a stack, queue, or deque data structure that allows for efficient insertions and deletions. Here are some real world applications of `LinkedList`:

- **Undo/Redo Functionality**: In applications like text editors or graphic design software, a `LinkedList` can be used to implement undo and redo functionality. Each action can be stored as a node in the list, allowing users to easily navigate back and forth through their actions.
- **Live Support/Chat**: A `LinkedList` can be used to manage a queue of customer support requests in a live chat application. New requests can be added to the end of the list, and support agents can efficiently process and remove requests from the front of the list.
- **Tab Management in Browsers**: A `LinkedList` can be used to manage open tabs in a web browser. Users can easily add new tabs, close existing ones, and navigate between tabs, with efficient insertions and deletions.

### Implementation

#### Creating an ArrayList and LinkedList

```java
// Creating our collections
ArrayList<Integer> arrayList = new ArrayList<>();
LinkedList<Integer> linkedList = new LinkedList<>();

// Adding elements to the collections
/**
 * The Collections.addAll() method is a convenient way to add multiple
 * elements to a collection in a single call.
 * It takes a collection as the first argument and a variable number of elements to be added as subsequent arguments.
 * This method is particularly useful when you want to quickly populate
 * a collection with several elements without having to call the add()
 * method multiple times.
 */
Collections.addAll(arrayList, 1, 2, 3, 4, 5);
Collections.addAll(linkedList, 1, 2, 3, 4, 5);

// Displaying the collections
System.out.println("ArrayList: " + arrayList);
System.out.println("LinkedList: " + linkedList);

// ArrayLists can resize dynamically as elements are added or removed.
System.out.println("Initial size of ArrayList: " + arrayList.size()); // Output: 5
Collections.addAll(arrayList, 6, 7, 8);
System.out.println("Size of ArrayList after adding elements: " + arrayList.size()); // Output: 8
```

In the above code, we create an `ArrayList` and a `LinkedList`, add elements to both collections using `Collections.addAll()`, and display their contents. Rather than using the `add()` method multiple times, we use `Collections.addAll()` to add multiple elements in a single call.

We also demonstrate the dynamic resizing capability of the `ArrayList` by adding more elements and checking its size before and after the addition.

#### Manipulating ArrayList and LinkedList

```java
// Using indexes to access elements in an ArrayList
System.out.println(arrayList.get(0)); // Output: 1

// Using indexes to get index of an element in a LinkedList
System.out.println(linkedList.indexOf(3)); // Output: 2

// LinkedList specific operations
linkedList.addFirst(0); // Adding an element at the beginning
linkedList.addLast(6);  // Adding an element at the end
System.out.println("LinkedList after adding elements at both ends: " + linkedList); // Output: [0, 1, 2, 3, 4, 5, 6]

// Queue operations using LinkedList
System.out.println("Peek: " + linkedList.peek()); // Output: 0 (first element)
linkedList.offer(7); // Adding an element to the end of the queue
linkedList.poll();  // Removing the first element
System.out.println("LinkedList after queue operations: " + linkedList); // Output: [1, 2, 3, 4, 5, 6, 7]

// Stack operations using LinkedList
LinkedList<Integer> stack = new LinkedList<>();
stack.push(1); // Push element onto stack
stack.push(2);
stack.push(3);
stack.push(4);
stack.push(5);
System.out.println("Stack after pushing elements: " + stack); // Output: [5, 4, 3, 2, 1]

stack.push(6); // Push another element
System.out.println("Peek: " + stack.peek()); // Output: 6 (top element)
System.out.println("Stack after pushing another element: " + stack); // Output: [6, 5, 4, 3, 2, 1]

stack.pop(); // Pop the top element
System.out.println("Stack after popping the top element: " + stack); // Output: [5, 4, 3, 2, 1]
```

Both `ArrayList` and `LinkedList` implement the `List` interface, allowing for common list operations such as adding, removing, and accessing elements by index. However, `LinkedList` also implements the `Deque` interface, which provides additional methods for double-ended queue operations.

## PriorityQueue

The `PriorityQueue` class in Java is a queue data structure that orders its elements based on their natural ordering or a specified comparator. It is part of the Java Collections Framework and implements the `Queue` interface.

Note that `PriorityQueue` is different from other standard queues that implement the FIFO (First-In-First-Out) principle. In a `PriorityQueue`, elements with higher priority are served before elements with lower priority, regardless of their insertion order.

By default, the priority is determined by the natural ordering of the elements (for example, numeric or lexicographic order). Default priority can be overridden by providing a custom comparator when creating the `PriorityQueue`.

A priority queue does not permit `null` elements and is not thread-safe. If multiple threads access a `PriorityQueue` concurrently, and at least one of the threads modifies the queue, it must be synchronized externally.

A priority queue that relies on natural ordering also does not permit the insertion of non-comparable objects (doing so results in a `ClassCastException`).

The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily. The queue retrieval operations `poll`, `remove`, `peek`, and `element` access the element at the head of the queue.

A priority queue is unbounded but has an internal capacity governing the size of an array used to store the elements on the queue. It is always at least as large as the queue size. As elements are added to a priority queue, its capacity grows automatically. The details of the growth policy are not specified. In simple terms, the capacity grows by about 50% each time it needs to grow and the new capacity is at least large enough to hold the elements currently in the queue.

This class and its iterator implement all of the optional methods of the `Collection` and `Iterator` interfaces. The `Iterator` provided in method `iterator()` is not guaranteed to traverse the elements of the priority queue in any particular order. If you need ordered traversal, consider using `Arrays.sort(pq.toArray())`.

Note that this implementation is not synchronized. Multiple threads should not access a `PriorityQueue` instance concurrently if any of the threads modifies the queue. Instead, use the thread-safe `PriorityBlockingQueue` class.

#### PriorityQueue Features

Let's note a few important features of the `PriorityQueue` class:

- `PriorityQueue` is an unbounded queue that orders its elements based on their natural ordering or a specified comparator and grows dynamically as elements are added (Unbounded means that there is no fixed size limit for the queue; it can grow as needed).
- The default initial capacity of a `PriorityQueue` is 11, but it can be specified during instantiation.
- It does not allow `null` elements and is not thread-safe.
- The queue items must be `Comparable` to determine their priority, or a custom `Comparator` must be provided.
- By default, the items in the queue are ordered in natural ascending order (i.e., the smallest element has the highest priority).
- A `Comparator` can be provided to define a custom ordering for the elements in the queue.
- A priority queue relying on natural ordering does not permit the insertion of non-comparable objects (doing so results in a `ClassCastException`).
- The queue retrieval operations `poll`, `remove`, `peek`, and `element` access the element at the head of the queue, which is the least element with respect to the specified ordering.
- The head of the `PriorityQueue` is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily.
- It provides `O(log n)` time complexity for insertion and removal operations, making it efficient for priority-based processing.
- The `Iterator` provided in the `iterator()` method does not guarantee any specific order of traversal. If ordered traversal is needed, consider using `Arrays.sort(pq.toArray())`.

#### PriorityQueue Constructors

The `PriorityQueue` class provides several constructors to create a priority queue with different configurations:

- `PriorityQueue()`: Creates a priority queue with the default initial capacity (11) and natural ordering of elements.
- `PriorityQueue(Collection c)`: Creates a priority queue containing the elements of the specified collection, with the default initial capacity and natural ordering.
- `PriorityQueue(int initialCapacity)`: Creates a priority queue with the specified initial capacity and natural ordering.
- `PriorityQueue(int initialCapacity, Comparator<? super E> comparator)`: Creates a priority queue with the specified initial capacity and the specified comparator for ordering elements.
- `PriorityQueue(PriorityQueue<? extends E> c)`: Creates a priority queue containing the elements of the specified priority queue, with the same ordering.
- `PriorityQueue(SortedSet<? extends E> c)`: Creates a priority queue containing the elements of the specified sorted set, with the same ordering.
- `PriorityQueue(Comparator<? super E> comparator)`: Creates a priority queue with the specified comparator for ordering elements and the default initial capacity.

#### PriorityQueue Methods

The `PriorityQueue` class provides several methods to manipulate and access the elements in the queue:

- Adding items:
  - `boolean add(E e)`: Inserts the specified element into the priority queue. Throws an exception if the element cannot be added.
  - `boolean offer(E e)`: Inserts the specified element into the priority queue. Returns `true` if the element was added successfully, or `false` if it could not be added
- Accessing items:
  - `E peek()`: Retrieves, but does not remove, the head of the queue, or returns `null` if the queue is empty.
  - `E element()`: Retrieves, but does not remove, the head of the queue. Throws an exception if the queue is empty.
- Removing items:
  - `E poll()`: Retrieves and removes the head of the queue, or returns `null` if the queue is empty.
  - `E remove()`: Retrieves and removes the head of the queue. Throws an exception if the queue is empty.
  - `void clear()`: Removes all elements from the priority queue.
- Other methods:
  - `Comparator<? super E> comparator()`: Returns the comparator used to order the elements in the queue, or `null` if the queue uses natural ordering.
  - `boolean contains(Object o)`: Returns `true` if the queue contains the specified element.
  - `Iterator<E> iterator()`: Returns an iterator over the elements in the queue.
  - `int size()`: Returns the number of elements in the queue.
  - `Object[] toArray()`: Returns an array containing all elements in the queue.

### Real World Application

A `PriorityQueue` is different from a normal queue because instead of being FIFO (First In First Out), it serves elements based on their priority. Elements with higher priority are served before elements with lower priority, regardless of their insertion order. It is an abstract data type that captures the idea of a container whose elements have "priorities" associated with them. An element with high priority always appears at the front of the queue, while an element with low priority appears at the back of the queue. If that priority element is removed, the next highest priority element will be at the front of the queue.

A priority queue is typically implemented using a heap data structure, which allows for efficient insertion and removal of elements based on their priority. The most common implementation is a binary heap, where each parent node has a higher priority than its child nodes.

Here are some real world applications of `PriorityQueue`:

- **Dijkstra's Algorithm**: In graph algorithms like Dijkstra's algorithm for finding the shortest path, a priority queue is used to efficiently retrieve the next node with the smallest tentative distance.
- **Prim's Algorithm**: In Prim's algorithm for finding the minimum spanning tree of a graph, a priority queue is used to select the next edge with the smallest weight.
- **Data Compression**: In data compression algorithms like Huffman coding, a priority queue is used to build the Huffman tree by repeatedly merging the two nodes with the smallest frequencies.
- **Artificial Intelligence**: In AI applications, priority queues can be used in search algorithms like A\* to prioritize nodes based on their estimated cost to reach the goal.
- **Heap Sort**: The heap sort algorithm uses a priority queue to sort elements by repeatedly extracting the maximum (or minimum) element from the heap.
- **Operating Systems**: In operating systems, priority queues are used for scheduling tasks based on their priority levels, ensuring that high-priority tasks are executed before lower-priority ones.

### Implementation

The example below explains the following basic operations of a `PriorityQueue`:

- `boolean add(E e)`: Inserts the specified element into the priority queue. Throws an exception if the element cannot be added.
- `E peek()`: Retrieves, but does not remove, the head of the queue, or returns `null` if the queue is empty.
- `E poll()`: Retrieves and removes the head of the queue, or returns `null` if the queue is empty.

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Creating an empty PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        pq.add(5);
        pq.add(10);
        pq.add(15);

        // Displaying the PriorityQueue
        System.out.println("PriorityQueue: " + pq); // Output: [5, 10, 15]

        // Displaying the head of the PriorityQueue without removing it
        System.out.println("Head of PriorityQueue: " + pq.peek()); // Output: 5

        // Displaying and removing the head of the PriorityQueue
        System.out.println("Removed head of PriorityQueue: " + pq.poll()); // Output: 5

        // Displaying the head of the PriorityQueue after removal
        System.out.println("Head of PriorityQueue after removal: " + pq.peek()); // Output: 10
    }
}
```

#### Operations on a PriorityQueue

Let's see how to perform a few frequently used operations on a `PriorityQueue`:

##### Adding Elements

To add elements to a `PriorityQueue`, you can use the `add()` or `offer()` methods. Both methods insert the specified element into the priority queue. The insertion order is not retained; instead, elements are ordered based on their priority, which is ascending order by default.

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        for (int i = 0; i < 3; i++) {
            pq.add(i);
            pq.add(1);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // Output:
        // 0
        // 1
        // 1
        // 1
        // 2
    }
}
```

Note: we did not get the elements in the order we added them. The `PriorityQueue` orders them based on their natural ordering (ascending order for integers).

##### Removing Elements

In order to remove an element from a priority queue, we can use the `poll()` or `remove()` methods. Both methods remove and return the head of the queue, which is the element with the highest priority (the smallest element in natural ordering). If the queue is empty, `poll()` returns `null`, while `remove()` throws a `NoSuchElementException`.

```java
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        // Creating a PriorityQueue
        PriorityQueue<String> pq = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        pq.add("Apple");
        pq.add("Banana");
        pq.add("Apple"); // Duplicate element

        System.out.println("Initial PriorityQueue: " + pq); // Output: [Apple, Apple, Banana]

        // Removing elements from the PriorityQueue
        pq.remove("Apple"); // Removes one occurrence of "Apple"

        System.out.println("PriorityQueue after removing 'Apple': " + pq); // Output: [Apple, Banana]

        System.out.println("Polled element: " + pq.poll()); // Output: Apple

        System.out.println("PriorityQueue after polling: " + pq); // Output: [Banana]
    }
}
```

##### Accessing Elements

Since a queue follows the FIFO (First In First Out) principle, we can only access the head of the queue. To access the head of the queue without removing it, we can use the `peek()` or `element()` methods. Both methods return the head of the queue, but if the queue is empty, `peek()` returns `null`, while `element()` throws a `NoSuchElementException`.

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Creating a PriorityQueue
        PriorityQueue<String> pq = new PriorityQueue<>();

        // Adding elements to the PriorityQueue
        pq.add("Apple");
        pq.add("Banana");
        pq.add("Apple"); // Duplicate element

        System.out.println("Initial PriorityQueue: " + pq); // Output: [Apple, Apple, Banana]

        // Using peek() to access the head of the queue without removing it
        String element = pq.peek();
        System.out.println("Head of the queue using peek(): " + element); // Output: Apple
    }
}
```

##### Iterating Over a PriorityQueue

There are multiple ways to iterate over the elements of a `PriorityQueue`. However, it's important to note that the iterator does not guarantee any specific order of traversal. If ordered traversal is needed, consider using `Arrays.sort(pq.toArray())`. The most common way to iterate is to convert the queue to an array and then iterate over the array. However, the queue also has a built-in iterator.

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        // Create a PriorityQueue
        PriorityQueue<String> pq = new PriorityQueue<>();

        // Add elements to the PriorityQueue
        pq.add("Apple");
        pq.add("Banana");
        pq.add("Cherry");

        // Obtain an iterator for the PriorityQueue
        Iterator<String> iterator = pq.iterator();

        // Iterate through the PriorityQueue using the iterator
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
```

## Stacks and Vectors

#### Vector

The `Vector` class in Java is a part of the Java Collections Framework and implements a dynamic array that can grow or shrink in size as needed. It is similar to an `ArrayList`, but with some key differences.

Like an array, it contains elements that can be accessed using an integer index. However, unlike an array, a `Vector` can dynamically resize itself when elements are added or removed.

Each vector trues to optimize storage management by maintaining a capacity and a capacity increment. The capacity is always at least as large as the vector size; it is usually larger because as elements are added to a vector, the vector's capacity grows automatically. The capacity increment is the amount by which the capacity of the vector is increased when its size becomes greater than its capacity. If the capacity increment is not specified, it defaults to doubling the current capacity. An application can increase the capacity of a vector before inserting a large number of elements by calling the `ensureCapacity` method; this may reduce the number of incremental re-allocations.

The iterators returned by the `iterator` and `listIterator` methods of this class are fail-fast: if the vector is structurally modified at any time after the iterator is created, in any way except through the iterator's own `remove` or `add` methods, the iterator will throw a `ConcurrentModificationException`. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make any hard guarantees in the presence of unsynchronized concurrent modification. Fail-fast iterators throw `ConcurrentModificationException` on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should be used only to detect bugs.

As of Java 2 platform v1.2, this class was retrofitted to implement the `List` interface, making it a member of the Java Collections Framework. Unlike the new collection implementations, `Vector` is synchronized. If a thread-safe implementation is not needed, it is recommended to use `ArrayList` in place of `Vector`.

#### Stack

The `Stack` class in Java is a part of the Java Collections Framework and represents a last-in-first-out (LIFO) stack of objects. It extends the `Vector` class with five operations that allow a vector to be treated as a stack. The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, a method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it is from the top. When a stack is first created, it contains no items.

A more complete and consistent set of LIFO stack operations is provided by the `Deque` interface and its implementations, which should be used in preference to this class.

In the following example, we have created an instance of the `Stack` class.

```java
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        // Creating a Stack
        Stack<Integer> stack = new Stack<>();

        // Checking if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? " + isEmpty); // Output: true

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Displaying the stack
        System.out.println("Stack after pushing elements: " + stack); // Output: [10, 20, 30, 40]

        isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? " + isEmpty); // Output: false
    }
}
```

#### Stack `push()` and `pop()` Methods

The `push()` method is used to add an element to the top of the stack, while the `pop()` method is used to remove and return the top element from the stack. If the stack is empty, calling `pop()` will throw an `EmptyStackException`.

```java
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        // Creating a Stack
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        pushElement(stack, 10);
        pushElement(stack, 20);
        pushElement(stack, 30);
        pushElement(stack, 40);

        // Popping elements from the stack
        try {
            popElement(stack);
            popElement(stack);
            popElement(stack);
            popElement(stack);
            popElement(stack); // This will throw EmptyStackException
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Pushing elements onto the stack
    static void pushElement(Stack<Integer> stack, int element) {
        // Invoking the push() method
        stack.push(element);
        System.out.println("Pushed element: " + element);
        System.out.println("Stack after pushing element: " + stack);
    }

    // Popping elements from the stack
    static void popElement(Stack<Integer> stack) throws EmptyStackException {
        Integer poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after popping element: " + stack);
    }
}
```

### Real World Application

Here are some different application of the stack data structure:

- Memory management (function calls, local variables)
- Function calls, particularly recursive function calls
- String reversal
- Parenthesis checking
- Syntax parsing
- Matching HTML tags
- Arithmetic expression evaluation

### Implementation

Below we will implement a stack from scratch using an array.

```java
public class Stack {
    private int lastItem = 0;
    private int[] items = new int[0];

    // Add items to the stack
    public void push(int item) {

    }

    // Remove items from the stack
    public int pop() {

    }

    // View last item added to the stack
    public int peek() {

     }
}
```

We will use this basic structure to keep track of the last item added to the stack and an array to store the items in the stack. We will implement the `push()`, `pop()`, and `peek()` methods to add, remove, and view items in the stack, respectively.

Notice that we have initialized the `items` array to have a size of 0. This is because we will dynamically resize the array as we add items to the stack.

#### Implementing the `push()` Method

The first thing we'll do is implement the `push()` method. This method will add an item to the top of the stack. If the stack is full, we will resize the array to double its current size.

It will also track the last item added to the stack.

To add an item to the array, we will simply add the new item to the end of the array. But how do we know where the end of the array is? Since we initialized it with a length of zero, we can use the length property to find the end of the array. In addition to that, we must increase the length of the array by one to accommodate the new item. If we increase the length of the array by one, we will have an empty space at the end of the array where we can add the new item.

```java
public void push(int item) {
    int index = items.length; // Find the end of the array

    // Create a new array with an increased size
    int[] newItems = new int[index + 1];

    // Copy the old items to the new array
    // Parameters: source array, starting position in source array,
    // destination array, starting position in destination array, number of elements to copy
    System.arraycopy(items, 0, newItems, 0, index);

    newItems[index] = item; // Add the new item to the end of the array
    items = newItems; // Update the items array to the new array
    lastItem = item; // Update the last item added to the stack

    // Debugging output
    System.out.println("Updated Stack: " + java.util.Arrays.toString(items));
}
```

#### Implementing the `pop()` Method

Adding items to the stack is great, but we also need a way to remove items from the stack. This is where the `pop()` method comes in. This method will remove the last item added to the stack and return it.

You'll find that our current approach to a Stack may be challenging to support.

For instance, we have a reference to the last item added to the stack, but we cannot simply return that item. We need to remove it entirely from the array. Arrays are fixed-size objects in Java, so that means we'll have to copy over all of the elements to a new array, minus the last item.

```java
public int pop() {
    int temp = lastItem; // Store the last item to return later

    // Create a new array with a decreased size
    int[] newItems = new int[items.length - 1];

    // Copy the old items to the new array, excluding the last item
    // System.arraycopy(items, 0, newItems, 0, items.length - 1);
    for (int i = 0; i < newItems.length; i++) {
        newItems[i] = items[i];
    }

    items = newItems; // Update the items array to the new array
    lastItem = items[items.length - 1]; // Update the last item added to the stack

    return temp; // Return the last item
}
```

#### Testing Our Stack Implementation

Now that we have implemented the `push()` and `pop()` methods, let's test our stack implementation to ensure it works as expected.

```java
class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);

        int val = stack.pop(); // Should return 20

        System.out.println(val); // Output: 20
        System.out.println(val); // Output: 20
    }
}
```
