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
