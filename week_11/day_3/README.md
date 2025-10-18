# JavaScript and Typescript: Week 11, Day 3

## JSON

JSON (JavaScript Object Notation) is a lightweight data interchange format that is easy for humans to read and write, and easy for machines to parse and generate. It is commonly used for transmitting data in web applications.

A JSON object is a collection of key-value pairs, where keys are strings and values can be strings, numbers, arrays, booleans, or other JSON objects.

- A key is a string enclosed in double quotes.
- A value can be a string, number, array, boolean, or another JSON object.
- A key-value pair is separated by a colon (`:`).

```json
{
  "name": "John Doe",
  "age": 30,
  "isStudent": false,
  "courses": ["Math", "Science", "History"],
  "address": {
    "street": "123 Main St",
    "city": "Anytown",
    "zip": "12345"
  }
}
```

## Promises

Promises are objects that represent the eventual completion (or failure) of an asynchronous operation and its resulting value. They provide a way to handle asynchronous operations in a more manageable way compared to traditional callback functions.

The function passed to `new Promise()` is called the executor. It takes two arguments: `resolve` and `reject`. You call `resolve` when the asynchronous operation is successful, and `reject` when it fails.

When a promise object is created, the executor function runs automatically. It contains the logic that will eventually produce a value or an error.

The arguments `resolve` and `reject` are callback functions provided by the JavaScript engine. You call `resolve` with the value you want to pass when the operation is successful, and `reject` with an error message or object when it fails.

- `resolve(value)`: This function is called when the asynchronous operation completes successfully. The `value` parameter is the result of the operation.
- `reject(error)`: This function is called when the asynchronous operation fails. The `error` parameter is an error message or object that describes the failure.

The `Promise.status()` property gives information about the state of the promise object. It can have one of three values:

- `pending`: The initial state, neither fulfilled nor rejected.
- `fulfilled`: The operation completed successfully.
- `rejected`: The operation failed.

A Promise object establishes a connection between the producer of an asynchronous operation and the consumer of its result. The producer creates the promise and performs the asynchronous task, while the consumer uses the promise to handle the result or error once the operation is complete.

By using methods like `.then()`, `.catch()`, and `.finally()`, consuming code can react to the outcome of the asynchronous operation without blocking the main execution thread. These methods provide a way to register callbacks that will be executed when the promise is fulfilled or rejected, allowing for a more organized and readable approach to handling asynchronous code.

### Implementation

The syntax for creating a promise is as follows:

```javascript
const promise = new Promise((resolve, reject) => {
  // Asynchronous operation
  if (/* operation successful */) {
    resolve(value); // Pass the result to the consumer
  } else {
    reject(error); // Pass the error to the consumer
  }
});
```

> Example:

```javascript
const promise = new Promise((resolve, reject) => {
  const x = 10;
  const y = 20;

  if (x + y === 30) {
    resolve("The sum is correct!");
  } else {
    reject("The sum is incorrect.");
  }
});

promise
  .then((message) => {
    console.log("Success:", message);
  })
  .catch((error) => {
    console.log("Error:", error);
  });
```
