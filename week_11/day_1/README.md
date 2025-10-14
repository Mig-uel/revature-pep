# JavaScript and Typescript: Week 11, Day 1

## Type Coercion

#### Type Conversion

Type conversion is the process of converting a value from one type to another (such as a string to a number, or an object to a boolean) in JavaScript. This can happen explicitly (when you manually convert a value) or implicitly (when JavaScript automatically converts a value).

- **Explicit Conversion**: This occurs when you manually convert a value from one type to another using functions like `String()`, `Number()`, or `Boolean()`.

  ```javascript
  let num = 5;
  let str = String(num); // Explicitly converting number to string
  console.log(str); // "5"
  ```

- **Implicit Conversion**: This happens when JavaScript automatically converts a value to another type during operations. For example, when using the `+` operator with a string and a number, JavaScript converts the number to a string.

  ```javascript
  let result = "The answer is " + 42; // Implicitly converting number to string
  console.log(result); // "The answer is 42"
  ```

#### Type Coercion

Type coercion is similar to type conversion, but it specifically refers to the automatic or implicit conversion of values from one type to another by JavaScript during operations. This can lead to unexpected results if not understood properly.

#### Difference Between `==` and `===`

`==` (loose equality) checks for equality after performing type coercion, meaning it converts the values to a common type before comparing them.

```javascript
console.log(5 == "5"); // true (number 5 is coerced to string "5")
console.log(null == undefined); // true (both are considered equal)
```

`===` (strict equality) checks for equality without performing type coercion, meaning the values must be of the same type and value to be considered equal.

```javascript
console.log(5 === "5"); // false (different types: number vs string)
console.log(null === undefined); // false (different types)
```

#### Truthy and Falsy Values

In JavaScript, any expression or value that results in a boolean context can be classified as either "truthy" or "falsy".

- **Falsy Values**: These are values that evaluate to `false` in a boolean context. The following values are considered falsy:

  - `false`
  - `0` (zero)
  - `""` (empty string)
  - `null`
  - `undefined`
  - `NaN` (Not-a-Number)

- **Truthy Values**: These are values that evaluate to `true` in a boolean context. Any value that is not falsy is considered truthy. Examples of truthy values include:
  - `true`
  - Non-zero numbers (e.g., `1`, `-1`, `3.14`)
  - Non-empty strings (e.g., `"hello"`, `"0"`, `"false"`)
  - Objects (e.g., `{}`, `[]`)
  - Functions (e.g., `function() {}`)
  - Dates (e.g., `new Date()`)
  - Any other value that is not in the falsy list

### Implementation

#### String Conversion

To explicitly convert values to a string, apply the `String()` function.
Implicit coercion is triggered when using the `+` operator with a string and a number.

```js
String(5); // "5"
"5" + 5; // "55"
```

#### Boolean Conversion

To explicitly convert values to a boolean, apply the `Boolean()` function.
Implicit coercion is triggered in conditional statements.

```js
Boolean(1); // true
if (1) {
} // true
7 || "hello"; // 7
```

#### Number Conversion

To explicitly convert values to a number, apply the `Number()` function.
Implicit coercion is triggered by:

- Mathematical operators (`+`, `-`, `*`, `/`, `%`)
- Comparison operators (`<`, `>`, `<=`, `>=`)
- Bitwise operators (`&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`)
- Loose equality operator (`==`)
- The unary plus operator (`+`)

```js
Number("5"); // 5
"5" * 2; // 10
+"5"; // 5
123 == "123"; // true
```

#### `toString()` Method

To convert a value to a string, you can also use the `toString()` method. This method is available on most data types in JavaScript.

```js
let num = 42;
let str = num.toString(); // Converts number to string
console.log(str); // "42"
```

## Functions

A function is a reusable block of code that performs a specific task. Functions can take inputs (parameters) and can return an output (return value). They help in organizing code, making it more readable, and avoiding repetition.

```js
function greet(name) {
  return "Hello, " + name + "!";
}

console.log(greet("Alice")); // "Hello, Alice!"
```

#### Callback Functions

A callback function is a function that is passed as an argument to another function and is executed after some operation has been completed. Callbacks help us develop asynchronous code, allowing us to perform actions after a task is finished without blocking the main thread.

JavaScrip runs the code in sequential order (from top to bottom). If there is a situation where code runs after some execution, which is not happening in sequential order, it is called asynchronous code. All functions in JavaScript are objects, and a JavaScript function can be passed as an argument to another function.

```js
function fetchData(callback) {
  setTimeout(() => {
    const data = { name: "John", age: 30 };
    callback(data); // Call the callback function with the fetched data
  }, 2000); // Simulate a 2-second delay
}
```

### Implementation

#### Function Expression/Anonymous Function

Function Expressions are also known as named or anonymous functions. An anonymous function is a function that does not have a name and is assigned to a variable.

```js
const add = function (a, b) {
  return a + b;
};
console.log(add(2, 3)); // 5
```

#### Self-Invoking Function/ Immediately Invoked Function Expression (IIFE)

A self-invoking function, also known as an Immediately Invoked Function Expression (IIFE), is a function that is executed immediately after it is defined. It is often used to create a new scope and avoid polluting the global namespace.

```js
(function () {
  console.log("This function runs immediately upon definition!");
})();
```

#### Callback Function

A callback function is a function that is passed as an argument to another function and is executed after some operation has been completed. Callbacks help us develop asynchronous code, allowing us to perform actions after a task is finished without blocking the main thread.

```js
function fetchData(callback) {
  setTimeout(() => {
    const data = { name: "John", age: 30 };
    callback(data); // Call the callback function with the fetched data
  }, 2000); // Simulate a 2-second delay
}
```

## Default Parameters

Default parameters allow you to set default values for function parameters. If no value or `undefined` is passed for a parameter, the default value will be used.

```js
function greet(name = "Guest") {
  return "Hello, " + name + "!";
}
console.log(greet()); // "Hello, Guest!"
console.log(greet("Alice")); // "Hello, Alice!"
```

Default parameters can be placed anywhere in the parameter list but parameters with default values should be placed after parameters without default values to avoid confusion.

```js
function createUser(name, age = 18, country = "USA") {
  return {
    name: name,
    age: age,
    country: country,
  };
}
console.log(createUser("Alice")); // { name: 'Alice', age: 18, country: 'USA' }
console.log(createUser("Bob", 25)); // { name: 'Bob', age: 25, country: 'USA' }
console.log(createUser("Charlie", 30, "Canada")); // { name: 'Charlie', age: 30, country: 'Canada' }
```

## Strict Mode

JavaScript is a loosely typed scripting language, which means you don't have to declare variable types explicitly. However, this flexibility can lead to potential issues and bugs in your code. To help mitigate these issues, JavaScript provides a feature called "Strict Mode."

Strict Mode can be enabled by adding the following line at the beginning of your JavaScript file or function:

```js
"use strict";
```

When Strict Mode is enabled, it enforces a stricter set of rules for your code, which can help catch common mistakes and improve the overall quality of your code. Some of the key features of Strict Mode include:

- Prevents the use of undeclared variables
- Prevents the use of reserved keywords as variable names
- Disallows duplicate parameter names in functions
- Throws errors for assignments to non-writable properties
- Disallows the use of `with` statements
- Makes `this` in functions default to `undefined` instead of the global object
- Prevents modifying the arguments object
- Prevents deleting an undeletable property

## Arrow Functions

Arrow functions are a more concise syntax for writing functions in JavaScript. They were introduced in ES6 (ECMAScript 2015) and provide a shorter way to write function expressions. Arrow functions also have some differences in behavior compared to traditional function expressions, particularly with regard to the `this` keyword.

### Implementation

**Syntax:**

```js
const functionName = (parameters) => {
  // function body
};

// Single parameter (no parentheses needed)
const square = (x) => x * x;

// No parameters (empty parentheses needed)
const greet = () => "Hello, World!";
```
