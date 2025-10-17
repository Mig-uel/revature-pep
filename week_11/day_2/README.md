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

## Object-Oriented Programming (OOP) in JavaScript

Object-oriented programming (OOP) is a programming paradigm that revolves around the concept of objects, which can contain data and methods to manipulate that data. JavaScript is a multi-paradigm language that supports OOP principles, allowing developers to create reusable and modular code.

#### Prototypal Inheritance

Inheritance is a fundamental concept in OOP that allows objects to inherit properties and methods from other objects. JavaScript uses prototypal inheritance, where objects can directly inherit from other objects. Each object has a prototype, or parent object, that defines properties and methods that the child object can access. To access an object's prototype, we can use the `Object.getPrototypeOf()` method or the `__proto__` property.

The default prototype for object literals is `Object.prototype`, which provides built-in methods like `toString()`, `hasOwnProperty()`, and `valueOf()`.

```javascript
const obj = {};
const prototype = Object.getPrototypeOf(obj);
console.log(prototype === Object.prototype); // Output: true
console.log(Object.getPrototypeOf(prototype)); // Output: null // Why? // Because Object.prototype is the top of the prototype chain
```

The JavaScript class is a feature that is built on top of prototypes to emulate class-based OOP. if we were to create an object from a class, then the class would be the prototype of the object, and its prototype would be `Object.prototype`. We can use the `extends` keyword to have a class inherit from another class.

```javascript
class Person {}

class Student extends Person {}
```

#### Polymorphism

Polymorphism is another key principle of OOP that allows objects of different types to be treated as instances of the same class through a common interface. In JavaScript, polymorphism can be achieved through method overriding, where a subclass provides a specific implementation of a method that is already defined in its superclass.

```javascript
class Animal {
  speak() {
    console.log("The animal makes a sound");
  }
}

class Dog extends Animal {
  speak() {
    console.log("The dog barks");
  }
}

class Cat extends Animal {
  speak() {
    console.log("The cat meows");
  }
}

const animals = [new Dog(), new Cat()];
animals.forEach((animal) => animal.speak());
```

#### Encapsulation

Encapsulation is the principle of bundling data and methods that operate on that data within a single unit, or class. In JavaScript, we can achieve encapsulation by creating private properties and methods using closures or the `#` syntax for private class fields.

```javascript
class Person {
  #name; // Private field

  constructor(name) {
    this.#name = name;
  }

  getName() {
    return this.#name;
  }

  setName(name) {
    this.#name = name;
  }
}
```

### Real World Application

Object-Oriented Programming (OOP) in JavaScript is beneficial for structuring code in a modular and organized manner. Here are some common use cases for OOP in JavaScript:

- **Creating Classes for UI Components**: Use OOP to create classes for UI components such as buttons, forms, modals, etc. Each class can encapsulate the behavior and appearance of the component, making it easier to reuse and maintain.
- **Modeling Real-World Entities**: OOP allows you to model real-world entities as objects. For example, you can create classes for users, products, orders, etc., with properties and methods that represent their attributes and behavior.
- **Building Libraries and Frameworks**: OOP is useful for building libraries and frameworks that provide reusable functionalities. Classes can serve as building blocks for defining modules, utilities, and components.
- **Implementing Design Patterns**: OOP enables the implementation of design patterns such as Factory, Singleton, Observer, and MVC (Model-View-Controller). Classes provide a structured way to organize code according to these patterns.
- **Managing State in Applications**: OOP facilitates state management in applications by organizing data and behavior into objects. Classes can represent different states of an application, and methods can handle state transitions and updates.
- **Encapsulating Data and Behavior**: OOP allows you to encapsulate data and behavior within objects, providing a clear interface for interacting with them. This helps in hiding implementation details and reducing code complexity.
- **Inheritance and Code Reusability**: OOP supports inheritance, allowing you to create subclasses that inherit properties and methods from parent classes. This promotes code reuse and helps in extending functionality without duplicating code.
- **Creating APIs and Interfaces**: OOP is useful for defining APIs and interfaces that specify how different parts of a system interact with each other. Classes can serve as contracts that define expected behavior and communication protocols.

By leveraging OOP principles in JavaScript, developers can create scalable, maintainable, and extensible applications that meet the requirements of modern web development.

## `this` Keyword

In JavaScript, the `this` keyword refers to the context in which a function is executed. The value of `this` can vary depending on how a function is called, and it is determined at runtime.

When used in a function, `this` keyword refers to an object to which it is bound. The bound object is generally the object that is calling the function.

```javascript
function alert() {
  console.log(this.message); // 'this' refers to the object that calls the function
}
```

In the example above, `this` refers to the object that calls the `alert` function.

#### Types of Binding

- Default Binding: When a function is called in the global context, `this` refers to the global object (e.g., `window` in browsers or `global` in Node.js). In strict mode, `this` will be `undefined`.

```javascript
function show() {
  console.log(this); // In non-strict mode: global object, In strict mode: undefined
}
show();
// Output: [object Window] (in browsers) or undefined (in strict mode)
```

- Implicit Binding: When a function is called as a method of an object, `this` refers to the object that the method is called on.

```javascript
const obj = {
  message: "Hello, World!",
  show: function () {
    console.log(this.message); // 'this' refers to 'obj'
  },
};
obj.show(); // Output: Hello, World!
```

- Explicit Binding: You can explicitly set the value of `this` using `call()`, `apply()`, or `bind()` methods.

```javascript
function greet() {
  console.log(this.message); // 'this' refers to the object passed as an argument
}

const obj = { message: "Hello, World!" };

greet.call(obj); // Output: Hello, World!
greet.apply(obj); // Output: Hello, World!

const boundGreet = greet.bind(obj);
boundGreet(); // Output: Hello, World!
```

- Constructor Binding: When a function is used as a constructor with the `new` keyword, `this` refers to the newly created object.

```javascript
function Person(name) {
  this.name = name; // 'this' refers to the new object being created
}
const person1 = new Person("Alice");
console.log(person1.name); // Output: Alice
```

### Implementation

`this` in Event Handlers refers to the HTML element that received the event.

```javascript
<button onclick="this.style.backgroundColor='red'">Click Me</button>
```

In the example above, `this` refers to the button element that was clicked and changes its background color to red.
