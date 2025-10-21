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

## Node As A Runtime

Scalability, latency, and throughput are critical factors in server-side applications. Keeping latency low and throughput high while scaling up and out is not easy. Node.js is a JavaScript runtime built on Chrome's V8 JavaScript engine that achieves this by using an event-driven, non-blocking I/O model. In other words, Node.js can handle multiple requests simultaneously without blocking the execution of other requests. This makes it well-suited for building scalable and high-performance server-side applications.

In the traditional approach to creating web servers, for each incoming request or connection, the server spawns a new thread of execution or even forks a new process to handle that request and send a response back to the client. Conceptually, this makes perfect sense, but in practice, it incurs a great deal of overhead.

While spawning threads incurs less memory and CPU overhead than forking processes, it can still be inefficient, especially when handling a large number of concurrent connections. The presence of a large number of threads can cause a heavily loaded system to spend precious cycles on thread scheduling and context switching, which can lead to poor performance and increased latency.

Node.js takes a different approach. It runs a single-thread event loop registered with the system to handle connections, and each new connection causes a JavaScript callback function to be invoked. The callback function can handle requests with non-blocking I/O operations, and if necessary, can spawn threads from a pool to execute blocking or CPU-intensive operations. Node's approach to scaling with callback functions requires less memory to handle more connections than most competitive architectures that scale with threads or processes, including Apache HTTP Server, various Java EE application servers, Microsoft's IIS, and Ruby on Rails.

### Real World Application

#### Node.js Advantages

- High performance for real-time applications.
- Easy scalability for modern applications.
- Cost-effective with full-stack JS.
- Community support to simplify development.
- Easy to learn and quick to adapt.
- Helps in building cross-functional teams.
- Improves app response time and boosts performance.
- Reduces time-to-market for your applications.
- Extensibility to meet customized requirements.
- Reduces loading time with quick caching.
- Helps in building cross-platform applications.

## TS Config Basics

The presence of a `tsconfig.json` file in a directory indicates that the directory is the root of a TypeScript project. The `tsconfig.json` file specifies the root files and the compiler options required to compile the project.

JavaScript projects can use a `jsconfig.json` file to specify the root files and compiler options for the project. The `jsconfig.json` file is similar to the `tsconfig.json` file used in TypeScript projects, but it is specifically designed for JavaScript projects.

A project is "compiled" in one of the following ways:

- Using a `tsconfig.json` file to specify the root files and compiler options for a TypeScript project.
- Using a `jsconfig.json` file to specify the root files and compiler options for a JavaScript project

By invoking `tsc` with no input files, the compiler searches for a `tsconfig.json` file in the current directory. If no `tsconfig.json` file is found, the compiler searches in the parent directory, and so on, until it finds a `tsconfig.json` file or reaches the root directory.

By invoking `tsc -p <path-to-config-file>`, the compiler uses the specified configuration file instead of searching for one.

When input files are specified on the command line, the compiler ignores the `tsconfig.json` file and only compiles the specified files.

Example using files property:

```json
{
  "compilerOptions": {
    "module": "commonjs",
    "noImplicitAny": true,
    "removeComments": true,
    "preserveConstEnums": true,
    "sourceMap": true
  },
  "files": [
    "core.ts",
    "sys.ts",
    "types.ts",
    "scanner.ts",
    "parser.ts",
    "utilities.ts",
    "binder.ts",
    "checker.ts",
    "emitter.ts",
    "program.ts",
    "commandLineParser.ts",
    "tsc.ts",
    "diagnosticInformationMap.generated.ts"
  ]
}
```

Example using include and exclude properties:

```json
{
  "compilerOptions": {
    "module": "commonjs",
    "noImplicitAny": true,
    "removeComments": true,
    "preserveConstEnums": true,
    "sourceMap": true
  },
  "include": ["src/**/*"],
  "exclude": ["node_modules", "**/*.spec.ts"]
}
```

#### TSConfig Bases

Depending on the JavaScript runtime environment (browser, Node.js, etc.) in which you intend to run your code, there may be a base configuration you can use at [https://www.github.com/tsconfig/bases](https://www.github.com/tsconfig/bases). These base configurations can be extended in your own `tsconfig.json` file using the `extends` property. By extending a base configuration, you can inherit its settings and customize them as needed for your specific project.

For example, if you were writing a project that uses Node.js version 12 and above, the you could use the npm module `@tsconfig/node12` as your base configuration:

```json
{
  "extends": "@tsconfig/node12/tsconfig.json",
  "compilerOptions": {
    // Your custom compiler options here
  },
  "include": ["src/**/*"],
  "exclude": ["node_modules", "**/*.spec.ts"]
}
```

This approach allows you to leverage pre-defined configurations that are optimized for specific environments, reducing the amount of boilerplate configuration you need to write and maintain.

This lets your tsconfig.json focus on the unique choices for your project, rather than all of the runtime mechanics.

### Real World Application

TypeScript allows us to add types to regular JavaScript code. It also checks for syntax errors even before runtime. It even provides tooltips that show you why some code might throw an error. There are so many great features that come by default. Even with all these great features, TypeScript recognizes the need for flexibility.

Sometimes, you do not want all the default rules that TypeScript enforces and that is totally okay. That's one reason why providing a `tsconfig.json` file is so important. It allows you to customize the behavior of the TypeScript compiler to fit the specific needs of your project. You get perks like telling the TypeScript compiler what files to run and more!

#### Sample `tsconfig.json` File and Breakdown

The `tsconfig.json` file is always placed in the root of your project, and you can customize what rules you want the TypeScript compiler to enforce. Here is a sample `tsconfig.json` file:

```json
{
  "compilerOptions": {
    "target": "es2017",
    "module": "commonjs",
    "strictNullChecks": true
  },
  "include": ["src/**/*"]
}
```

In this `tsconfig.json` file:

- The `compilerOptions` is a nest object that contains various settings for the TypeScript compiler.
  - The `target` option specifies the version of JavaScript that the TypeScript code will be transpiled to. In this case, it is set to `es2017`, which means that the TypeScript code will be transpiled to ECMAScript 2017.
  - The `module` option specifies the module system that will be used in the transpiled JavaScript code. In this case, it is set to `commonjs`, which is the module system used in Node.js.
  - The `strictNullChecks` option is set to `true`, which means that the TypeScript compiler will enforce strict null checking rules. This helps catch potential null or undefined value errors at compile time.
- The `include` option specifies the files that should be included in the TypeScript project. In this case, it includes all files in the `src` directory and its subdirectories.

Another neat addition is that by including a `tsconfig.json` file, you can now use the command `tsc` without any additional arguments in your terminal. The compiler will automatically look for the `tsconfig.json` file in the current directory and use the settings specified in it to compile your TypeScript code.

### Implementation

The tsconfig.json file is a file in JSON format which allows us to specify the root level files and different compiler options required to set up a TypeScript-based project. The existence of this file in a project specifies that the given directory is the root of the TypeScript project folder.

Here is a simple example of a tsconfig.json file:

```json
{
  "compileOnSave": true,
  "compilerOptions": {
    "module": "system",
    "noImplicitAny": true,
    "removeComments": true,
    "allowUnreachableCode": false,
    "strictNullChecks": true,
    "outFile": "../JS/TypeScript/HelloWorld.js",
    "sourceMap": true
  },
  "files": ["program.ts", "sys.ts"],
  "include": ["src/**/*"],
  "exclude": ["node_modules", "src/**/*.spec.ts"]
}
```

- `compileOnSave`: When set to true, this option allows the TypeScript compiler to automatically compile the TypeScript files whenever they are saved.
- `compilerOptions`: This section contains various options that control the behavior of the TypeScript compiler.
  - `module`: Specifies the module system to be used in the generated JavaScript code. In this case, it is set to "system".
  - `noImplicitAny`: When set to true, this option raises an error when a variable is implicitly assigned the "any" type.
  - `removeComments`: When set to true, this option removes all comments from the generated JavaScript code.
  - `allowUnreachableCode`: When set to false, this option raises an error when unreachable code is detected.
  - `strictNullChecks`: When set to true, this option enables strict null checking, which helps catch potential null or undefined value errors at compile time.
  - `outFile`: Specifies the output file for the generated JavaScript code. In this case, it is set to "../JS/TypeScript/HelloWorld.js".
  - `sourceMap`: When set to true, this option generates source map files that allow debugging of the original TypeScript code in the browser.
- `files`: This section specifies the list of TypeScript files to be included in the compilation process. In this case, it includes "program.ts" and "sys.ts".
- `include`: This section specifies the files or directories to be included in the compilation process. In this case, it includes all files in the "src" directory and its subdirectories.
- `exclude`: This section specifies the files or directories to be excluded from the compilation process. In this case, it excludes the "node_modules" directory and any TypeScript files in the "src" directory that end with ".spec.ts".

## Compiler Options

The `tsconfig.json` file specifies compilation options for the TypeScript compiler. These options include which version of JavaScript our TypeScript code will be transpiled to, what the output directory will be, whether to include source maps, and more.

### Implementation

#### Nested `tsconfig.json` Files

The TypeScript compiler supports the use of nested `tsconfig.json` files. This means that you can have multiple `tsconfig.json` files in different directories within your project, each with its own set of compiler options.

When the TypeScript compiler encounters a nested `tsconfig.json` file, it will merge the options from the parent `tsconfig.json` file with the options from the nested file. The options in the nested file will take precedence over the options in the parent file.

For example, consider the following project structure:

```
├── dist
└── src
├── tsconfig.json
├── backend
│ ├── index.ts
│ └── tsconfig.json
└── frontend
├── index.ts
└── tsconfig.json
```

Here, we have a project with a root `tsconfig.json` file in the `src` directory, and two nested `tsconfig.json` files in the `backend` and `frontend` directories.

Both subdirectories contain their own `tsconfig.json` files and a TypeScript file (`index.ts`).

The `tsconfig.json` file in the `src` directory might look like this:

```json
{
  "compilerOptions": {
    "target": "es5",
    "module": "commonjs",
    "rootDir": ".",
    "outDir": "../dist/"
  },
  "files": [],
  "references": [{ "path": "./backend" }, { "path": "./frontend" }]
}
```

- We have specified the `outDir` option to output the compiled JavaScript files to the `dist` directory.
- We have also specified the `references` option to reference the `backend` and `frontend` subdirectories. `references` allow us to create a project structure where multiple TypeScript projects can depend on each other.

The whole project can be compiled by running the following command:

```bash
tsc -b src
```

This command tells the TypeScript compiler to build the project starting from the `src` directory, taking into account the nested `tsconfig.json` files in the `backend` and `frontend` directories.

The `tsconfig.json` file in the `backend` directory might look like this:

```json
{
  "compilerOptions": {
    "rootDir": ".",
    "outDir": "../../dist/backend"
  }
}
```

- Here, we have specified the `outDir` option to output the compiled JavaScript files to the `dist/backend` directory.

The frontend subdirectory can be built independently by running the following command:

```bash
tsc -b src/frontend
```

Let's take a loot at the `tsconfig.json` file in the `frontend` directory:

```json
{
  "compilerOptions": {
    "rootDir": ".",
    "outDir": "../../dist/frontend"
  },
  "references": [{ "path": "../backend" }, { "composite": true }]
}
```

- Here, we have specified the `outDir` option to output the compiled JavaScript files to the `dist/frontend` directory.
- We have also specified the `references` option to reference the `backend` subdirectory.
- The `composite` option is set to `true`, indicating that this project is a composite project. Composite projects allow for faster builds and better incremental compilation by enabling the TypeScript compiler to understand the dependencies between different projects.

The backend subdirectory can be built independently by running the following command:

```bash
tsc -b src/backend
```

---

`strictPropertyInitialization`: When set to true, this option ensures that class properties are initialized in the constructor, helping to prevent runtime errors related to uninitialized properties.

```ts
class NoInitProperties {
  name: string; // Error: Property 'name' has no initializer and is not definitely assigned in the constructor.

  constructor() {
    // this.name is not initialized here
  }
}
```

The first method to fix this error is to initialize the property in the constructor:

```ts
class InitProperties {
  name: string;

  constructor() {
    this.name = "Default Name";
  }
}
```

The second method is to use a type union with `undefined`:

```ts
class InitPropertiesWithUndefined {
  name: string | undefined; // No error, as 'name' can be undefined

  constructor() {
    // this.name is not initialized here
  }
}
```

The third method is to use the definite assignment assertion operator (`!`):

```ts
class DefiniteAssignment {
  name!: string; // No error, as we assert that 'name' will be assigned
}
```

The fourth method is to assign a value directly to the property at the point of declaration:

```ts
class DirectAssignment {
  name: string = "Default Name"; // No error, as the property is initialized
}
```

`noImplicitThis`: When set to true, this option raises an error when the `this` keyword is used in a way that is not explicitly typed. This helps catch potential errors related to the `this` context in functions and methods.

```ts
class NoImplicitThis {
  name: string = "TypeScript";

  logToConsole() {
    let callback = function () {
      console.log(this.name); // Error: 'this' implicitly has type 'any' because it does not have a type annotation.
    };

    setTimeout(callback, 1000);
  }
}
```

What happens here is that the `this` context inside the `callback` function is not referencing the instance of the `NoImplicitThis` class, but rather the function's own context, which is `undefined` in strict mode or the global object in non-strict mode. In JavaScript, the `this` scope inside methods is not bound to the class instance by default.

To fix this error, we can use an arrow function for the `callback`, which lexically binds the `this` context to the surrounding scope (the class instance in this case):

```ts
class ImplicitThisFixed {
  name: string = "TypeScript";

  logToConsole() {
    let callback = () => {
      console.log(this.name); // No error, 'this' correctly refers to the class instance
    };

    setTimeout(callback, 1000);
  }
}
```

This error can also be fixed by passing the `this` property into the callback function:

```ts
let callback = function (_this) {
  console.log(_this.name); // No error, '_this' correctly refers to the class instance
};

setTimeout(callback, 1000, this); // setTimeout takes additional parameters to pass to the callback
```

`noImplicitReturns`: When set to true, this option raises an error when a function does not have a return statement in all code paths. This helps catch potential errors related to missing return values in functions.

```ts
function noImplicitReturns(value: number): number {
  if (value > 0) return value;
  // Error: Not all code paths return a value.
}
```

Here, the function `noImplicitReturns` has a return type of `number`, but it does not return a value in all code paths. If the input `value` is less than or equal to 0, the function will reach the end without returning anything, which violates the expected return type.

To fix this error, we need to ensure that all code paths in the function return a value. We can add an `else` clause to handle the case when `value` is less than or equal to 0:

```ts
function implicitReturnsFixed(value: number): number {
  if (value > 0) {
    return value;
  } else {
    return 0; // Return a default value when value is less than or equal to 0
  }
}
```

`strictNullChecks`: When set to true, this option enables strict null checking, which helps catch potential null or undefined value errors at compile time.

```ts
function strictNullChecksExample(name: string | null): string {
  return "Hello, " + name.toUpperCase(); // Error: Object is possibly 'null'.
}
```

In this example, the function `strictNullChecksExample` takes a parameter `name` that can be either a `string` or `null`. When we try to call the `toUpperCase()` method on `name`, TypeScript raises an error because `name` could be `null`, and calling a method on `null` would result in a runtime error.

To fix this error, we need to add a check to ensure that `name` is not `null` before calling the `toUpperCase()` method:

```ts
function strictNullChecksFixed(name: string | null): string {
  if (name === null) {
    return "Hello, Guest!";
  } else {
    return "Hello, " + name.toUpperCase();
  }
}
```

## Strict

The `strict` option in the `tsconfig.json` file is a shorthand way to enable a set of TypeScript's strict type-checking options. Yo can turn off individual strict options if needed, but enabling `strict` is a good way to ensure that your code adheres to best practices and catches potential errors early in the development process.

#### Strict Bind Call Apply

When the `strictBindCallApply` option is enabled, TypeScript performs stricter type checking for the `bind`, `call`, and `apply` methods on functions. This helps catch potential errors related to incorrect argument types or counts when using these methods.

```ts
function greet(this: { name: string }, greeting: string) {
  return `${greeting}, ${this.name}`;
}

const person = { name: "Alice" };
console.log(greet.call(person, "Hello")); // No error, correct usage
console.log(greet.call(person, 42)); // Error: Argument of type 'number' is not assignable to parameter of type 'string'.
```

In this example, the `greet` function expects a `this` context with a `name` property of type `string` and a single argument of type `string`. When we use the `call` method to invoke the function, TypeScript checks that the argument types match the expected types. If we pass an argument of the wrong type, TypeScript raises an error.

#### Strict Function Types

When the `strictFunctionTypes` option is enabled, TypeScript performs stricter type checking for function types. This helps catch potential errors related to incompatible function types when assigning functions to variables or passing them as arguments.

```ts
type StringToNumber = (input: string) => number;
type NumberToString = (input: number) => string;
let func: StringToNumber;

func = (input: number) => input.toString(); // Error: Type '(input: number) => string' is not assignable to type 'StringToNumber'.
```

In this example, we define two function types: `StringToNumber` and `NumberToString`. When we try to assign a function of type `NumberToString` to a variable of type `StringToNumber`, TypeScript raises an error because the function types are incompatible. The parameter types and return types must match for the assignment to be valid.

When the `useUnknownInCatchVariables` option is enabled, TypeScript treats the type of variables declared in `catch` clauses as `unknown` instead of `any`. This helps catch potential errors related to handling exceptions in a type-safe manner.

```ts
try {
  // Some code that may throw an error
} catch (error) {
  console.log(error.message); // Error: Object is of type 'unknown'.
}
```

In this example, the `error` variable in the `catch` clause is treated as `unknown`. When we try to access the `message` property of `error`, TypeScript raises an error because it cannot guarantee that `error` has a `message` property. To safely access properties of an `unknown` type, we need to perform type checks or assertions.

`strictPropertyInitialization` and `strictNullChecks` were covered in the previous section on Compiler Options.

## Target

The `target` option in the `tsconfig.json` file specifies the version of JavaScript that the TypeScript code will be transpiled to. This option determines the set of JavaScript features that will be available in the generated code.

You might choose a lower target version if you need to support older browsers or environments that do not support the latest JavaScript features. Conversely, you might choose a higher target version if you want to take advantage of newer JavaScript features and your target environment supports them.

Changing the `target` also changes the default `lib` option, which specifies the built-in type definitions that are included in the compilation. You may "mix and match" different `lib` options regardless of the `target` setting but you could just set the `target` for convenience.

The special `esnext` value for the `target` option indicates that the TypeScript code should be transpiled to the latest version of JavaScript that is currently supported by the TypeScript compiler. This means that the generated code will include the most recent JavaScript features and syntax available at the time of compilation.

## TSC

TypeScript files are transpiled into JavaScript files using the TypeScript compiler. The compiler can be installed as the typescript package from `npm`. As with any `npm` package, you can install it either globally or locally to your project.

#### Input Files Location

The TS compiler accepts a list of files to compile as arguments:

```bash
tsc file1.ts file2.ts file3.ts
```

However, most of the time, we do not specify the list of files directly. Instead, we use a `tsconfig.json` file to specify the root files and compiler options for the project. When we run the `tsc` command without any arguments, the compiler looks for a `tsconfig.json` file in the current directory and uses the settings specified in it to compile the project.

A `tsconfig.json` file can be created automatically by running the following command in the terminal:

```bash
tsc --init
```

But it generates the config file with default settings. For our purposes, we will create the empty `tsconfig.json` file and run the `tsc` command to generate the necessary files based on our project structure and requirements:

```bash
echo {} > tsconfig.json && tsc
```

This command creates an empty `tsconfig.json` file and then runs the TypeScript compiler, which will generate the necessary files based on the default settings. You can then customize the `tsconfig.json` file to specify your desired compiler options and input files.

At the moment, TS recursively searches for all files in the root directory and subdirectories and compiles them. However, we can control where the compiler will be looking for files by using the `files` config option in the `tsconfig.json` file.

So to tell the compiler to only ocmpile the files, `main.ts` and `router/b.ts`, and leave out everything else, we can set up the `tsconfig.json` file like this:

```json
{
  "compilerOptions": {},
  "files": ["main.ts", "router/b.ts"]
}
```

Note: The TS compiler will also compile files that are referenced by the files listed in the `files` option, even if those referenced files are not explicitly listed.

Instead of listing each file manually, we can use the `include` option to specify a pattern that matches the files we want to include in the compilation. For example, we can compile all files inside the `router` directory by setting up the `tsconfig.json` file like this:

```json
{
  "compilerOptions": {},
  "include": ["router/**/*"]
}
```

This configuration tells the compiler to include all files in the `router` directory and its subdirectories. The `**/*` pattern matches all files recursively.

### Real World Application

`tsc` Compile Options

| Flag            | Type    | Description                                          |
| --------------- | ------- | ---------------------------------------------------- |
| --all           | boolean | Show all compiler options.                           |
| --generateTrace | string  | Output a trace file for performance analysis.        |
| --help          | boolean | Gives help information.                              |
| --init          | boolean | Initializes a tsconfig.json file.                    |
| --listFilesOnly | boolean | Lists files that would be compiled.                  |
| --locale        | string  | The locale to use for error messages.                |
| --project       | string  | Compile the project given the path to tsconfig.json. |
| --showConfig    | boolean | Show the resolved tsconfig.json file.                |
| --version       | boolean | Print the compiler's version.                        |

`tsc` Build Options

| Flag      | Type    | Description                    |
| --------- | ------- | ------------------------------ |
| --build   | boolean | Build one or more projects.    |
| --clean   | boolean | Deletes the output of a build. |
| --dry     | boolean | Show what would be built.      |
| --force   | boolean | Rebuild all projects.          |
| --verbose | boolean | Enable verbose logging.        |

## Simple or Variable Types

The following are the most commonly used primitives in TypeScript:

- `boolean`: Represents a logical value that can be either `true` or `false`.
- `number`: Represents numeric values, including integers and floating-point numbers.
- `string`: Represents textual data, enclosed in single or double quotes.

#### Type Assignment

When creating a variable, there are two main ways TypeScript can infer its type:

- Implicit Type Assignment: If you assign a value to a variable without explicitly specifying its type, TypeScript infers the type based on the assigned value.

```ts
let isDone = false; // TypeScript infers the type as boolean
let decimal = 6; // TypeScript infers the type as number
let color = "blue"; // TypeScript infers the type as string
```

- Explicit Type Assignment: You can explicitly specify the type of a variable using type annotations.

```ts
let isDone: boolean = false; // Explicitly specifying the type as boolean
let decimal: number = 6; // Explicitly specifying the type as number
let color: string = "blue"; // Explicitly specifying the type as string
```

#### Null

`null` is a special type in TypeScript that represents the intentional absence of any object value. It is one of the two primitive values in JavaScript that represent "no value" or "empty value," the other being `undefined`. It is treated as a falsy value in boolean contexts.

## Special Types

#### `any`

The `any` type in TypeScript is a special type that allows a variable to hold any value, regardless of its type. When a variable is declared with the `any` type, TypeScript does not perform any type checking on that variable, and it can be assigned values of any type without raising any errors.

```ts
let randomValue: any = 10; // randomValue is of type any
randomValue = "Hello"; // No error, randomValue can hold a string
randomValue = true; // No error, randomValue can hold a boolean
```

`any` can be useful to get past errors since it disables type checking, but it also removes the benefits of using TypeScript's type system. It is generally recommended to avoid using `any` whenever possible and to use more specific types to take advantage of TypeScript's type checking capabilities.

#### `unknown`

The `unknown` type in TypeScript is a special type that represents a value that could be of any type, similar to `any`. However, unlike `any`, the `unknown` type is safer because it requires explicit type checking or type assertions before performing operations on the value.

```ts
let randomValue: unknown = 10; // randomValue is of type unknown
randomValue = "Hello"; // No error, randomValue can hold a string
randomValue = true; // No error, randomValue can hold a boolean
```

To perform operations on a variable of type `unknown`, you need to first check its type or use a type assertion:

```ts
let randomValue: unknown = "Hello";
if (typeof randomValue === "string") {
  console.log(randomValue.toUpperCase()); // No error, randomValue is treated as a string
}
let anotherValue: unknown = 10;
let valueAsNumber: number = anotherValue as number; // Type assertion to treat anotherValue as a number
console.log(valueAsNumber.toFixed(2)); // No error, valueAsNumber is treated as a number
```

### Real World Application

#### Why Use `unknown` Over `any`?

Using `unknown` over `any` is generally recommended because it provides better type safety and helps catch potential errors at compile time. Here are some reasons why you might choose `unknown` over `any`:

1. Type Safety: `unknown` forces you to perform type checks or assertions before using the value, which helps prevent runtime errors that can occur when using values of unknown types.
2. Intentionality: Using `unknown` indicates that you are aware of the uncertainty of the value's type and are taking steps to handle it safely, whereas `any` can lead to careless usage of values without considering their types.
3. Maintainability: Code that uses `unknown` is often easier to maintain and understand, as it makes the developer's intentions clear and encourages proper type handling.

#### Why `unknown`?

The `unknown` type was introduced in TypeScript 3.0 as a safer alternative to `any`. TypeScript does not allow you to use a variable of type `unknown` unless you either cast the variable to a known type or narrow its type. Type narrowing is the process of moving a less precise type to a more precise type. The `unknown` type forces you to determine what a variable typed as `unknown` actually is, either through type casting or type narrowing. This helps prevent errors that can occur when using values of unknown types.

## Object Types

In TypeScript, object types are used to define the shape of an object, including its properties and methods. Object types can be defined using interfaces or type aliases.

If you write a class in JavaScript, you are actually creating an object type. It has a name and certain properties and methods. In TypeScript, there are several ways to define object types. Keep in mind that after TypeScript introduces these features, which JavaScript lacked, JavaScript later adopted them as well.

#### Defining Types

There are several ways to define a type in TypeScript. In each of the below examples, we have a function that should only take in a particular type, a `Person`, which is made up of two `string` properties: `firstName` and `lastName`.

We can define a type **anonymously** , where the type is not given a name. This is useful for defining a type in an ad-hoc manner, such as when passing an object as an argument to a function, but this definition cannot be reused elsewhere in the code.

```ts
function greet(person: { firstName: string; lastName: string }) {
  console.log(`Hello, ${person.firstName} ${person.lastName}`);
}
greet({ firstName: "John", lastName: "Doe" });
```

TypeScript support **interfaces**, where we set forth a "promise" or "contract" that an object must adhere to. That is, we define the shape of the object by specifying its properties and their types.

```ts
interface Person {
  firstName: string;
  lastName: string;
}
```

Now we can use the `Person` interface to type our function parameter:

```ts
function greet(person: Person) {
  console.log(`Hello, ${person.firstName} ${person.lastName}`);
}
greet({ firstName: "Jane", lastName: "Smith" });
```

We can also define a type using a **type alias**, which allows us to create a new name for a type. Type aliases can be used to define primitive types, union types, intersection types, and more.

```ts
type Person = {
  firstName: string;
  lastName: string;
};
```

Now we can use the `Person` type alias to type our function parameter:

```ts
function greet(person: Person) {
  console.log(`Hello, ${person.firstName} ${person.lastName}`);
}
greet({ firstName: "Alice", lastName: "Johnson" });
```

#### Property Modifiers

Objects in TypeScript, just like in JavaScript, are made up of key-value pairs called properties. There are several ways to modify these properties to change their behavior, including specifying a type, making them optional, or making them read-only.

Optional properties are those that may or may not be present on an object. In TypeScript, we can define optional properties using the `?` modifier.

```ts
type Person = {
  firstName: string;
  lastName: string;
  age?: number; // Optional property
};
```

Read-only properties are those that cannot be modified after they are initialized. In TypeScript, we can define read-only properties using the `readonly` modifier.

```ts
type Person = {
  readonly firstName: string; // Read-only property
  readonly lastName: string; // Read-only property
  age?: number; // Optional property
};
```

## Union Types

We can compose new types from existing ones when needed. Union types allows us to create a new type out of the common parts of two or more existing types. The name "union" comes from the set theory concept of union, where the union of two sets contains all elements that are in either set.

#### Defining a Union Type

We use the pipe (`|`) symbol to define a union type. For example, we can define a type that can be either a `string` or a `number` like this:

```ts
type StringOrNumber = string | number;
```

We can then use this union type to type a variable or function parameter:

```ts
let value: StringOrNumber;
value = "Hello"; // No error, value can be a string
value = 42; // No error, value can be a number

function printValue(value: StringOrNumber) {
  console.log(value);
}
printValue("Hello"); // No error, value can be a string
printValue(42); // No error, value can be a number
```

#### Working with Union Types

Above, we specified that a function parameter must be one of two types. So, inside the function, we need to handle both cases. For example, strings have the `toUpperCase()` method, while numbers have the `toFixed()` method. To work with union types, we can use type guards to narrow down the type of a variable at runtime.

```ts
function logValue(value: StringOrNumber) {
  if (typeof value === "string") {
    console.log(value.toUpperCase()); // value is treated as a string
  } else {
    console.log(value.toFixed(2)); // value is treated as a number
  }
}
```
