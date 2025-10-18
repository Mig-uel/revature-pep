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

## Fetch API

The Fetch API provides a modern way to make network requests in JavaScript. It is built into most modern browsers and is designed to be more powerful and flexible than the older XMLHttpRequest (XHR) API.

The Fetch API uses promises to handle asynchronous operations, making it easier to work with network requests and responses. It provides a global `fetch()` function that can be used to make HTTP requests.

#### The `fetch()` Function

The `fetch()` function is a global function that takes a URL as its first argument and an optional options object as its second argument. It returns a promise that resolves to the `Response` object representing the response to the request. The promise will be rejected if there is a network error or if the request is blocked. Otherwise, it will be resolved successfully even for HTTP error status codes (like 404 or 500). It is customary to check the `ok` property of the `Response` object to determine if the request was successful.

```javascript
fetch("https://api.example.com/data");
```

A promise object is returned by the `fetch()` function, which resolves to the `Response` object representing the response to the request. We can use the `.then()` or `await` syntax to handle the promise and access the response data, which is a Response object. The `Response` object provides methods to read the response body in various formats, such as `.json()`, `.text()`, and `.blob()`.

You can also optionally provide an options object as the second argument to the `fetch()` function. This object allows you to customize the request by specifying properties such as the HTTP method, headers, body, and more.

```javascript
fetch("https://api.example.com/data", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify({ key: "value" }),
});
```

#### Response

The `Response` object represents the response to a request made using the Fetch API. It contains information about the response, such as the status code, headers, and body. The `Response` object provides several methods to read the response body in different formats, such as `.json()`, `.text()`, and `.blob()`. These methods return promises that resolve to the corresponding data format. These also need to be handled using `.then()` or `await` syntax.

```javascript
fetch("https://api.example.com/data")
  .then((response) => {
    if (!response.ok) {
      throw new Error("Network response was not ok " + response.statusText);
    }
    return response.json(); // Parse the response body as JSON
  })
  .then((data) => {
    console.log(data); // Handle the parsed data
  })
  .catch((error) => {
    console.error("There was a problem with the fetch operation:", error);
  });
```

#### Headers

The `Headers` object represents the headers of a request or response. It provides methods to manipulate and access the headers, such as `.get()`, `.set()`, `.append()`, and `.delete()`. You can create a new `Headers` object or use the headers from an existing request or response.

```javascript
const headers = new Headers();
headers.append("Authorization", "Bearer token");
headers.append("Content-Type", "application/json");
headers.append("X-Custom-Header", "CustomValue");

// add headers to options object
const options = {
  method: "GET",
  headers,
};

const response = await fetch("https://api.example.com/data", options);
```

#### Request

The `Request` type represnets a resource request. It contains information about the request, such as the URL, method, headers, and body. You can create a new `Request` object using the `Request` constructor or by passing a URL and options object to the `fetch()` function.

```javascript
const options = {
  method: "POST",
  headers,
  body: JSON.stringify({ key: "value" }),
};

// create a new Request object
const request = new Request("https://api.example.com/data", options);

// use the Request object with fetch
const response = await fetch(request);
```

## Async/Await Keywords

The `async` and `await` keywords in JavaScript provide a way to work with asynchronous code in a more synchronous-looking manner. They are built on top of promises and help to simplify the process of writing and reading asynchronous code.

- `async` keyword: When you declare a function as `async`, it means that the function will always return a promise even if it does not explicitly return a promise object. Inside an `async` function, you can use the `await` keyword to pause the execution of the function until a promise is resolved or rejected. When an `async` function is called, it returns a promise that resolves to the value returned by the function or rejects with an error if an exception is thrown.
- `await` keyword: The `await` keyword can only be used inside an `async` function. It is used to pause the execution of the function until a promise is resolved or rejected. When you use `await` with a promise, it waits for the promise to settle and then returns the resolved value. If the promise is rejected, it throws an error that can be caught using a `try...catch` block.

While `async` and `await` make asynchronous code look more like synchronous code, they do not change the underlying asynchronous nature of JavaScript. The event loop still handles the execution of asynchronous operations, and the main thread remains non-blocking. Under the hood, `async` and `await` are syntactic sugar for working with promises, making it easier to read and write asynchronous code without deeply nested callbacks or complex promise chains.

### Implementation

```javascript
// create a promise to use
const promise = new Promise((resolve, reject) => {
  // asynchronous operation
  setTimeout(() => {
    const randomNumber = Math.random();
    if (randomNumber > 0.5) resolve(randomNumber);
    else reject(new Error("Number is less than or equal to 0.5"));
  }, 2000);
});

// async function to use await
async function fetchRandomNumber() {
  try {
    const result = await promise; // wait for the promise to resolve
    console.log("Resolved value:", result);
  } catch (error) {
    console.error("Error:", error.message); // handle any errors
  }
}
```
