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

## Selecting Elements from the DOM

JavaScript is used to get or modify the content or value of HTML elements on a webpage. To perform any action on an HTML element, we first need to select it from the Document Object Model (DOM). The DOM is a programming interface for web documents that represents the structure of a webpage as a tree of objects.

There are several methods to select elements from the DOM:

- Selecting by ID: The `getElementById()` method is used to select an element by its unique ID.

```javascript
const element = document.getElementById("myElement");
console.log(element);
// Output: <div id="myElement">...</div>
```

- Selecting by Class Name: The `getElementsByClassName()` method is used to select elements by their class name. This method returns a live HTMLCollection of elements.
- Is a collection an array? No, but it is array-like. It has a length property and can be accessed using an index, but it does not have array methods like `forEach`, `map`, or `filter`. To convert an HTMLCollection to an array, you can use `Array.from()` or the spread operator (`...`).

```javascript
const elements = document.getElementsByClassName("myClass");
console.log(elements);
// Output: HTMLCollection(2) [div.myClass, div.myClass]
```

- Selecting by Tag Name: The `getElementsByTagName()` method is used to select elements by their tag name. This method also returns a live HTMLCollection of elements.

```javascript
const elements = document.getElementsByTagName("div");
console.log(elements);
// Output: HTMLCollection(3) [div, div, div]
```

- Selecting by CSS Selector: The `querySelector()` method is used to select the first element that matches a specified CSS selector. The `querySelectorAll()` method is used to select all elements that match a specified CSS selector. This method returns a static NodeList of elements.

```javascript
const element = document.querySelector(".myClass");
console.log(element);
// Output: <div class="myClass">...</div>
const elements = document.querySelectorAll(".myClass");
console.log(elements);
// Output: NodeList(2) [div.myClass, div.myClass]
```

### Implementation

#### Example: Selecting Elements by Class Name

```html
<!-- ... -->
<div class="test">This is a div element with class "test".</div>

<p>
  <h1 class="test">This is a h1 element with class "test".</h1>
</p>

<p class="test">This is a p element with class "test".</p>

<script>
  const elements = document.getElementsByClassName("test");
  console.log(elements);
  // Output: HTMLCollection(3) [div.test, h1.test, p.test]

  for (let e of elements) {
    e.style.color = "red"; // Change text color to red for all elements with class "test"
  }
```

## Traversing the DOM

The DOM allows us to do anything with elements and their contents, but first, we need to reach the corresponding DOM object. The properties used to traverse the DOM or to get a particular DOM object are listed below:

> Topmost nodes, the document object, is the root of every node in the DOM.

- `document.documentElement`: This property returns the root element of the document, which is typically the `<html>` element.
- `document.head`: This property returns the `<head>` element of the document, which contains metadata and links to external resources.
- `document.body`: This property returns the `<body>` element of the document, which contains the visible content of the webpage.

> Parent nodes, the parent of any node, is the node that is one level above it in the DOM tree.

- `element.parentNode`: This property returns the parent node of the specified element.
- `element.parentElement`: This property returns the parent element of the specified element. It is similar to `parentNode`, but it only returns element nodes.

> Child nodes, the children of any node, are the nodes that are one level below it in the DOM tree.

- `element.childNodes`: This property returns a live NodeList of all child nodes of the specified element, including text nodes and comment nodes.
- `element.firstChild`: This property returns the first child node of the specified element.
- `element.lastChild`: This property returns the last child node of the specified element.
- `element.children`: This property returns a live HTMLCollection of all child elements of the specified element, excluding text nodes and comment nodes.

> Sibling nodes, the siblings of any node, are the nodes that share the same parent node.

- `element.previousSibling`: This property returns the previous sibling node of the specified element.
- `element.nextSibling`: This property returns the next sibling node of the specified element.

## Events and Listeners

An event is an action or occurrence that happens in the system you are programming, which the system tells you about so your code can respond to it as needed. Examples of events include user interactions (like clicks, key presses, and mouse movements), changes to the DOM, and network requests.

In web development, events are signals that indicate that something has happened or changed in the browser. These events can be triggered by user actions (like clicking a button or typing in a text field), changes to the DOM (like adding or removing elements), or other system events (like loading a page or receiving data from a server).

Events allow JavaScript to respond to user interactions and changes in the web page, enabling dynamic and interactive web applications. When an event occurs, it typically triggers a function or a block of code to execute, allowing developers to define how the application should behave in response to that event. These functions are called event handlers or event listeners and are responsible for handling the event and performing the desired actions.

Events are fundamental to creating interactive and dynamic web applications, as they enable developers to respond to user input and changes in the application state.

Below are common types of events in web development:

- Mouse Events: These events are triggered by mouse actions, such as clicking, double-clicking, hovering, and dragging. Examples include `click`, `dblclick`, `mouseover`, `mouseout`, `mousemove`, and `mousedown`.
- Keyboard Events: These events are triggered by keyboard actions, such as pressing or releasing keys. Examples include `keydown`, `keyup`, and `keypress`.
- Form Events: These events are triggered by interactions with form elements, such as submitting a form, changing input values, or focusing on an input field. Examples include `submit`, `change`, `focus`, and `blur`.
- Window Events: These events are triggered by actions related to the browser window, such as resizing, scrolling, or loading a page. Examples include `load`, `resize`, `scroll`, and `unload`.
- Window Events: These events are triggered by actions related to the browser window, such as resizing, scrolling, or loading a page. Examples include `load`, `resize`, `scroll`, and `unload`.

When working with events, we follow these steps:

- Select the DOM node associated with an event.
- Attach an event listener to the node.
- Write the handler logic.

Example syntax using an anonymous function handler:

```javascript
// get the specific element to use
let node = document.getElementById("myButton");

// add an event listener and handler
node.addEventListener("click", () => {
  // logic to be executed when the event occurs
});
```

Example syntax using a named function handler:

```javascript
// get the specific element to use
let node = document.getElementById("myButton");

// add an event listener and handler
node.addEventListener("click", handleClick);

// because of hoisting, this function can be defined after the listener is added
function handleClick() {
  // logic to be executed when the event occurs
}
```

You'll notice in the example that we are working with three objects: the `document` object, the `node` or `element` object, and the `event` object. The `document` object represents the entire HTML document, the `node` or `element` object represents a specific HTML element, and the `event` object contains information about the event that occurred.

The document object is a global object that represents the entire HTML document and provides methods and properties to interact with the document's structure and content. We use the `getElementById()` method of the document object to select a specific HTML element by its ID.

The object returned from calling `getElementById()` is the `node` or `element` object, which represents the specific HTML element we selected. This object provides methods and properties to manipulate the element, such as adding event listeners.

Once we have an element object, we can attach an event listener to it using the `addEventListener()` method. This method takes two arguments: the type of event to listen for (e.g., "click") and the event handler function that will be executed when the event occurs.

When the specified event occurs (e.g., when the user clicks the button), the event handler function is called, and it automatically receives an `event` object as an argument. The `event` object contains information about the event, such as the target element, the type of event, and other relevant details.

### Real World Application

Events and event listeners are crucial in web development for creating dynamic and interactive user interfaces. They are widely used in various real-world applications across different domains. Here are some examples:

- **Web Forms**: When users interact with web forms by clicking submit buttons or entering data into input fields, events such as "click" and "change" are triggered. Event listeners attached to these elements handle these events, validate user input, update form fields dynamically, or submit form data to servers.
- **User Interface Widgets**: Interactive widgets like sliders, date pickers, and accordions often rely on events and event listeners to respond to user interactions. For instance, a slider widget may use events like "mousemove" and "mouseup" to update its value in real-time as the user drags the slider handle.
- **Single Page Applications (SPAs)**: SPAs, which dynamically update content without reloading the entire page, heavily rely on events and event listeners to manage navigation, handle user interactions, and update views. Libraries like React, Angular, and Vue.js use events extensively for component communication and state management.
- **Real-Time Collaboration Tools**: Applications like collaborative document editors, chat applications, and multiplayer games utilize events to provide real-time updates to multiple users simultaneously. Events triggered by user actions are broadcasted to all connected clients, and event listeners on each client handle these events to update the UI and synchronize data.
