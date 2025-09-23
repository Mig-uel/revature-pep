# Java Collections and Algorithms - Day 4

## Linear Search

Linear search is a very simple search algorithm that checks each element in a list one by one until it finds the target value or reaches the end of the list. It is straightforward but can be inefficient for large datasets.

#### Algorithm Steps:

1. Get the length of the array.
2. Get the target element to be searched and store it in a named variable.
3. Compare each element of the array with the target element.
4. If a match is found, return the index of the element.
5. If no match is found after checking all elements, return -1 to indicate the element is not present in the array.

Although linear search is generally not the most efficient method for searching an array, it is the best method for searching an unsorted array.

### Real World Application

Suppose you use the Uber app as a rider and you request a ride to go from one place to another. YOur driver has just arrived at the parking lot of your location. The only detail you know about the ride is the license plate number of the car. How you find your Uber ride?

The obvious approach is to go to the parking lot and search all the cars one by one until you find the car with the license plate number that matches your Uber ride. This method of searching is called **linear search**, where we search through all possible options (brute force) until we find the one that matches our criteria. We use linear search in our daily lives, such as when finding a specific book, medicine, or item in a store.

### Implementation

Given an array `arr[]` of `n` elements, write a function to search for a given element `x` in `arr[]`. The function should return the index of `x` if it is present in `arr[]`, otherwise return -1.

Example of correct output:

```java
// Input: arr[] = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170}
// x = 110
// Output: 6
// Explanation: Element x is present at index 6 in arr[]

// Input: arr[] = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170}
// x = 175
// Output: -1
// Explanation: Element x is not present in arr[]
```

A simple approach is to perform a linear search, i.e., start from the leftmost element of the array and one by one compare `x` with each element of the array. If `x` matches with an element, return the index. If `x` doesn’t match with any of the elements, return -1.

```java
class Main {
  public static int linearSearch(int arr[], int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        return i; // Element found, return index
      }
    }
    return -1; // Element not found
  }

  public static void main(String[] args) {
    int arr[] = {2, 3, 4, 10, 40};
    int x = 10;

    // Function call
    int result = linearSearch(arr, x);
    if (result == -1) {
      System.out.println("Element not present in array");
    } else {
      System.out.println("Element found at index: " + result);
    }
  }
}
```

## Binary Search

Binary search is a highly efficient algorithm for finding a target value within a sorted array. It works by repeatedly dividing the search interval in half, significantly reducing the number of comparisons needed to locate the target.

If the elements in the array are known to be in increasing or decreasing order, then a much faster search algorithm than linear search can be used. An array in which the elements are in order is said to be sorted.

Binary search is a method for searching for a given item in a sorted array. Although the implementation is not trivial, the basic idea is simple: if you are searching for an items in a sorted list, then it is possible to eliminate half of the items in the list by performing just one comparison.

For example, suppose that you are looking for the number 42 in a sorted array of 1000 integers. Let's assume that the array is sorted in increasing order. Supposed you check the item number 500, which happens to be 93. Since 42 is less than 93, you can eliminate all items with indices greater than 500 from consideration. This leaves you with only 500 items to search. If you next check item number 250, which happens to be 17, you can eliminate all items with indices less than 250 from consideration. This leaves you with only 250 items to search. Continuing in this way, you can find the target item in at most log2(n) comparisons, where n is the number of items in the array.

This is a whole lot better than looking through every element in the array, which would require `n` comparisons in the worst case. For example, if `n` is 1,000,000, then `log2(n)` is about 20, whereas `n` is 1,000,000.

#### Time and Space Complexity

- The time complexity of binary search is O(log n) in the worst case, where n is the number of elements in the array. This is because with each comparison, the size of the search space is halved.
  - The best case time complexity is O(1), which occurs when the target element is found at the middle index of the array on the first comparison.
- The space complexity of binary search depends on the implementation of the algorithm:
  - In the iterative implementation, the space complexity is O(1) because it uses a constant amount of space for variables.
  - In the recursive implementation, the space complexity is O(log n) due to the call stack used for recursion.

### Real World Application

Some real world applications of binary search include:

- Dictionary Lookup: When you look up a word in a dictionary, you typically use a binary search approach by opening the dictionary to the middle and determining whether to search the left or right half based on alphabetical order.
- Debugging: Binary search can be used to find the point in a program where a bug occurs by repeatedly narrowing down the range of code to be tested.
- Semiconductor Manufacturing: In semiconductor manufacturing, binary search algorithms are used to optimize the process of finding defects in microchips by systematically narrowing down the search area.
- Database Indexing: Many database systems use binary search algorithms to quickly locate records in sorted indexes, improving query performance.

### Implementation

In order to create a binary search algorithm that searched an array, `A`, for an item, `N`, we have to keep track of the range of locations that could contain `N`. The basic operation is to look at the item in the middle of the range. If this item is greater than `N`, then we know that `N` must be in the lower half of the range. If the middle item is less than `N`, then we know that `N` must be in the upper half of the range. If the middle item is equal to `N`, then we have found `N` and can return its location. We repeat this process until we either find `N` or the range is empty.

```java
static int binarySearch(int[] A, int N) {
  // The lowest index in the array
  int low = 0;
  // The highest index in the array
  int high = A.length - 1;

  while (high >= low) {
    // Find the middle index
    int middle = (low + high) / 2;

    if (A[middle] == N) {
      // N has been found at this index
      return middle;
    }
    else if (A[middle] > N) {
      // N is in the lower half of the array
      high = middle - 1;
    }
    else {
      // N is in the upper half of the array
      low = middle + 1;
    }
  }

  // At this point, high < low, so N is not in the array
  return -1;
}
```

## Bubble Sort

Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The process is repeated until the list is sorted. The algorithm gets its name because smaller elements "bubble" to the top of the list.

#### Visualization

```plaintext
Initial array: [64, 34, 25, 12];
```

##### Iteration 1

Note: the numbers in bold indicate a swap.

| Swaps | Index 0 | Index 1 | Index 2 | Index 3 |
| ----- | ------- | ------- | ------- | ------- |
| 1     | **34**  | **64**  | 25      | 12      |
| 2     | 34      | **25**  | **64**  | 12      |
| 3     | 34      | 25      | **12**  | **64**  |

Array after 1st iteration: [34, 25, 12, 64]

This array is not yet sorted, however the largest element (64) is now in its correct position. If we repeat this process for the remaining elements, we will eventually sort the entire array.

##### Iteration 2

| Swaps | Index 0 | Index 1 | Index 2 | Index 3 |
| ----- | ------- | ------- | ------- | ------- |
| 1     | **25**  | **34**  | 12      | 64      |
| 2     | 25      | **12**  | **34**  | 64      |

Array after 2nd iteration: [25, 12, 34, 64]

##### Iteration 3

| Swaps | Index 0 | Index 1 | Index 2 | Index 3 |
| ----- | ------- | ------- | ------- | ------- |
| 1     | **12**  | **25**  | 34      | 64      |

Array after 3rd iteration: [12, 25, 34, 64]

The array is now sorted.

This algorithm is generally not used in practice do to it being inefficient on large lists, and generally performs worse than the similar insertion sort. The time complexity of bubble sort is `O(n^2)` in the average and worst case, where n is the number of items being sorted. This is because each element must be compared with every other element in the list. The best case time complexity is `O(n)`, which occurs when the list is already sorted, and only one pass through the list is needed to confirm this.

### Real World Application

While bubble sort is not commonly used in real world applications due to its inefficiency, it can still be found in certain scenarios where simplicity and ease of implementation are prioritized over performance. Some examples include:

- **Small Datasets**: In cases where the dataset is very small and performance is not critical, such as sorting a short list of names or numbers, bubble sort can be a quick and easy solution.
- **Embedded Systems**: In resource-constrained environments, such as microcontrollers or embedded systems, where memory and processing power are limited, bubble sort's simplicity can be advantageous.
- **Educational Purposes**: Bubble sort is often used in educational settings to teach the concepts of sorting algorithms and algorithmic thinking due to its straightforward implementation and easy-to-understand logic.

### Implementation

```java
public class Main {
  public static void main(String[] args) {
    int arr[] = {64, 34, 25, 12};

    // Loop through all elements in the array
    for (int i = 0; i < arr.length - 1; i++) {
      // Last i elements are already sorted, so we can skip them
      for (int j = 0; j < arr.length - i - 1; j++) {
        // Compare adjacent elements
        if (arr[j] > arr[j + 1]) {
          // Swap if they are in the wrong order
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}
```

## Merge Sort

Merge sort is an efficient, stable, and comparison-based sorting algorithm that follows the divide-and-conquer paradigm. It works by recursively dividing the array into two halves, sorting each half, and then merging the sorted halves back together.

#### Algorithm Steps:

1. **Divide**: Split the unsorted list into two approximately equal halves.
2. **Conquer**: Recursively sort both halves.
3. **Combine**: Merge the two sorted halves back together.

### Real World Application

Merge sort, known for its efficiency and stability, is widely used in various real-world applications, particularly when dealing with large datasets or when stability is a requirement. Here is a real world use case of merge sort:

- **Sorting large datasets stored on disk in a DBMS during query processing or building indexes**: In databases, especially scenarios where the dataset is too large to fit into memory, external sorting techniques like Merge Sort are employed. When sorting large datasets that exceed available memory, the data is divided into smaller chunks that can fit into memory, each chunk is sorted individually using an efficient in-memory sorting algorithm like Merge Sort, and then the sorted chunks are merged together in a way that maintains the overall order. Merge Sort's ability to efficiently merge already sorted arrays makes it well suited for this task. External sorting is commonly used in database systems for operations like sorting query results, building indexes, and creating sorted data files for efficient searching.

### Implementation

```java
public class Main {
  public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};

    // Call the mergeSort method
    mergeSort(arr, 0, arr.length - 1);

    // Print the sorted array
    System.out.println("Sorted array: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  // Method to merge two sub-arrays of arr[]
  public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;

      // Recursively sort the first half
      mergeSort(arr, left, mid);

      // Recursively sort the second half
      mergeSort(arr, mid + 1, right);

      // Merge the sorted halves
      merge(arr, left, mid, right);
    }
  }

  public static void merge(int[] arr, int left, int mid, int right) {
    // Find sizes of two sub-arrays to be merged
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Create temporary arrays
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copy data to temporary arrays
    for (int i = 0; i < n1; i++) {
      L[i] = arr[left + i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = arr[mid + 1 + j];
    }

    // Merge the temporary arrays

    // Initial indexes of first and second sub-arrays
    int i = 0, j = 0;

    // Initial index of merged sub-array
    int k = left;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[] if any
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    // Copy remaining elements of R[] if any
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
}
```

In this code, the `mergeSort` method recursively divides the array into halves until each sub-array contains a single element. The `merge` method then combines these sorted sub-arrays back together in the correct order. The final output is a sorted array printed to the console.
