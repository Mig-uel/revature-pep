# Week 11 - JavaScript and Typescript - Day 4

## What is TypeScript?

#### What is JavaScript?

JavaScript (JS or ECMAScript) started as a simple scripting language for web browsers. At the time it was invented, it was expected tp be used for short snippets of code embedded in HTML pages -- writing more than a few dozen lines of JavaScript was considered bad practice. Due to this, early web browsers executed JavaScript code slowly, and the language itself was not designed for large-scale software development. Over time, JavaScript became more and more popular, and web developers started using it to create interactive experiences. Web browser developers responded to this increase in popularity by expanding the capabilities of JavaScript, which in turn led to even more widespread adoption. On modern websites, your browser is frequently running applications written almost entirely in JavaScript.

JS has become popular enough to be used outside the context of browsers, such as implementing JavaScript runtimes like Node.js, which allow developers to write server-side applications in JavaScript. The "run anywhere" nature of JavaScript has also led to its use in a variety of other contexts, such as desktop applications (using frameworks like Electron), mobile applications (using frameworks like React Native), and even embedded systems.

#### What is TypeScript and How Does It Relate to JavaScript?

TypeScript (TS) is a programming language developed and maintained by Microsoft. It is a strict syntactical superset of JavaScript, which means that any valid JavaScript code is also valid TypeScript code. TypeScript does not consider any JavaScript code to be invalid, but it adds additional features to the language that are not present in JavaScript.

Since TypeScript is a superset of JavaScript, it adds rules about how different kinds of values can be used together.

TypeScript preserves the runtime behavior of JavaScript, meaning that TypeScript code is transpiled (or compiled) into JavaScript code before it is executed. For example, dividing by zero in JavaScript results in `Infinity` instead of throwing an error, and this behavior is preserved in TypeScript.

### Real World Application

Here is a short list of companies that use TypeScript in their tech stack:

- Slack
- Airbnb
- Google
- Angular
- Accenture
- Medium.com

## JavaScript vs TypeScript

When JavaScript was developed, the JavaScript development team introduced JavaScript as a clint-side scripting language. However, as developers began using JavaScript, they realized that it could also be used for server-side programming. As JavaScript evolved, the code became more complex and heavy. This complexity prevented JavaScript from fulfilling the requirements of an Object-Oriented Programming (OOP) language, hindering its success at the enterprise level as a server-side technology. To bridge this gap, TypeScript was created to add features that would make JavaScript more suitable for large-scale applications.

#### Features of TypeScript

- TypeScript code is converted into plain JavaScript code using a process called transpilation. TypeScript code cannot be natively interpreted by web browsers or Node.js (although new Node.js updates are making this possible in some environments). Therefore, if the code is written in TypeScript, it must first be transpiled into JavaScript before it can be executed.
- JavaScript is TypeScript. Any valid JavaScript code is also valid TypeScript code. This means that developers can gradually adopt TypeScript in their existing JavaScript projects without having to rewrite the entire codebase.
- TypeScript can be used anywhere JavaScript is used, including web development, server-side programming with Node.js, mobile app development with frameworks like React Native, and desktop application development with frameworks like Electron.
- TypeScript supports JavaScript libraries and frameworks. Developers can use popular JavaScript libraries and frameworks, such as React, Angular, and Vue.js, in their TypeScript projects without any issues.

#### Differences Between JavaScript and TypeScript

- TypeScript has static typing, which means that variable types are known at compile time. This allows developers to catch type-related errors before the code is executed. In contrast, JavaScript is dynamically typed, meaning that variable types are determined at runtime, which can lead to type-related errors that are only discovered during execution.
- TypeScript supports interfaces and generics, which are not available in JavaScript. Interfaces allow developers to define the structure of objects and classes, while generics enable the creation of reusable components that can work with different data types.

#### JavaScript Isn't Typed?

This line of code highlights one of the fundamental misconceptions about JavaScript and TypeScript:

```javascript
if (typeof a !== "number" || typeof b !== "number") {
  throw new Error("Both a and b must be numbers");
}
```

JavaScript is already typed in the sense that every value has a type (e.g., number, string, boolean, object, etc.). However, JavaScript is dynamically typed, meaning that types are determined at runtime and can change during execution. This can lead to situations where type-related errors are only discovered when the code is executed. TypeScript enforces strict typing, meaning a variable is assigned a type that cannot be changed, allowing developers to catch type-related errors at compile time rather than at runtime.

### Real World Application

Some advantages of using TypeScript over JavaScript include:

- TypeScript points out compilation errors at the time of development (pre-runtime). As a result, runtime errors are reduced, leading to more robust and reliable code.
- TypeScript offers better code structuring and greater support for object-oriented programming (OOP) principles, making it easier to manage and maintain large codebases.
