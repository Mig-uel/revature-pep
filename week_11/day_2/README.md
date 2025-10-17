# JavaScript and Typescript: Week 11, Day 2

## Object Literals

Object literals in JavaScript are a way to define and create objects using a simple and concise syntax. They are a convenient way to represent structured data, organize related properties and methods, and encapsulate functionality within a single entity.

#### Object Literals vs Object Constructor

> Object Literals

An object literal is a comma separated list of key-value pairs wrapped in curly braces `{}`. This method is straightforward and easy to read.

```javascript
const person = {
  name: "John",
  age: 30,
  greet: function () {
    console.log("Hello, my name is " + this.name);
  },
};

person.greet(); // Output: Hello, my name is John
```

**Benefits of Object Literals:**

- Simple and quick to create, small static objects.
- Easy to read and understand.
- Convenient for defining objects with a fixed structure.

**Cons of Object Literals:**

- Not suitable for creating multiple instances of similar objects.
- Lacks a clear blueprint for creating objects with similar properties and methods.

> Object Constructor

A constructor function is used to create multiple instances of an object with the same properties and methods. Constructors provide a more scalable way to create objects especially when you need multiple instances.

```javascript
function Person(name, age) {
  this.name = name;
  this.age = age;
  this.greet = function () {
    console.log("Hello, my name is " + this.name);
  };
}

const person1 = new Person("John", 30);
person1.greet(); // Output: Hello, my name is John
```

**Benefits of Object Constructors:**

- Suitable for creating multiple instances of similar objects.
- Provides a clear blueprint for object creation.
- Can include methods that are shared across instances.

**Cons of Object Constructors:**

- Slightly more complex syntax compared to object literals.
- Requires the use of the `new` keyword to create instances.
- Can become cumbersome for small, static objects.

### Real World Application

Object literals are commonly used in various scenarios, such as:

- **Data Modeling:** They are used to model real-world entities, such as users, products, or orders, by encapsulating related properties and behaviors.
- **API Responses:** When working with APIs, JSON responses are often represented as object literals, making it easy to parse and manipulate the data.
- **Configuration Objects:** They are used to define configuration settings for applications, libraries, or frameworks, allowing for easy customization and flexibility.
- **State Management:** In front-end frameworks like React, object literals are used to manage component state, storing and updating data that affects the UI.
- **Utility Functions:** Object literals can encapsulate utility functions and methods, providing a namespace for related functionality.

## Template Literals

Template literals are a feature in JavaScript that allows for easier string interpolation and multi-line strings. They are enclosed by backticks (`` ` ``) instead of single or double quotes and allow you to include variables or execute expressions within the string using `${}` syntax.

### Implementation

#### Multi-line Strings

We use the escape character, `\n`, to create a new line for a multi-line string. In template literals, there is no need for the escape character. Template literals preserve the formatting, including line breaks and indentation.

```javascript
console.log(`This is a multi-line
string using template literals.`);
// Output: This is a multi-line
//         string using template literals.
```

#### String Interpolation

In JavaScript, template literals support string interpolation, allowing you to embed expressions within the string using `${}` syntax.

```javascript
function sayHello() {
  return "Hello";
}

let x = 1;
let y = 2;

console.log(`${sayHello()}, the sum of ${x} and ${y} is ${x + y}.`);
// Output: Hello, the sum of 1 and 2 is 3.
```

#### Tagged Templates

Tagged templates are a more advanced feature of template literals that allow you to customize the processing of template literals by using a function (tag) to manipulate the string and its interpolated values.

Tagged templates allow us to parse template literals with a function. The first argument of a tag function contains an array of string values. The subsequent arguments are the values of the placeholders.

```javascript
tagFunction`Hello ${firstName} ${lastName}`;
```

Putting a function name in front of a template literal calls that function, with the processed template literal passed as arguments.

The above example is equivalent to:

```javascript
tagFunction(["Hello ", " ", ""], firstName, lastName);
```

This, the name before the template literal is the name of the function that will be called. The first argument of the tag function contains an array of string values like `["Hello ", " ", ""]`. The remaining arguments are the values of the placeholders, in this case, `firstName` and `lastName`.

```javascript
function printAll(literalArray, ...substitutions) {
  console.log(literalArray); // ["Hello ", " ", ""]
  console.log(substitutions); // ["John", "Doe"]
}

printAll`Hello ${"John"} ${"Doe"}`; // Calls printAll with the processed template literal
// Output:
// ["Hello ", " ", ""]
// ["John", "Doe"]
```

#### Raw Strings

The template literal raw method allows you to access the raw string form of a template literal, preserving escape sequences like `\n` and `\t`.

`String.raw` is a built-in method that accepts a template literal argument and returns a string where escape sequences are not processed.

```javascript
let a = 3;
let b = 4;
let string = String.raw`The sum of ${a} and ${b} is \n${a + b}.`;
console.log(string);
// Output: The sum of 3 and 4 is \n7.
```
