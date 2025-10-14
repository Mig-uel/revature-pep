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
