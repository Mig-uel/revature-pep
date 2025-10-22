# Week 11 - JavaScript and TypeScript - Day 5

## Casting

JavaScript does not have a concept of type casting like some other languages (e.g., C++, Java) because it is a dynamically typed language. However, every variable in TypeScript has a type, and TypeScript provides ways to perform type assertions (which are similar to type casting in other languages).

In TypeScript, you can use type assertions to tell the compiler to treat a variable as a different type. There are two syntaxes for type assertions:

1. Angle-bracket syntax:

   ```typescript
   let someValue: any = "this is a string";
   let strLength: number = (<string>someValue).length;
   ```

2. `as` syntax:
   ```typescript
   let someValue: any = "this is a string";
   let strLength: number = (someValue as string).length;
   ```

Type assertions do not perform any special checking or restructuring of data. They are purely a way to inform the TypeScript compiler about the type of a variable.

#### Type Casting Using the `as` Keyword

The following selects the first input element by using the `querySelector()` method:

```ts
let input = document.querySelector("input");
```

Since the returned type of the `document.querySelector()` method is the `Element` type, the following code causes a compilation error because the `Element` type does not have a `value` property:

```ts
console.log(input.value); // Error: Property 'value' does not exist on type 'Element'.
```

The reason is that the `value` property does not exist on all HTML elements, only on specific ones like `<input>`, `<textarea>`, and `<select>`. To fix this error, you can use "type casting" to specify that the `input` variable is of type `HTMLInputElement`, which does have a `value` property:

```ts
let input = document.querySelector("input") as HTMLInputElement;
console.log(input.value); // Now this works
```

Now, the `input` variable is treated as an `HTMLInputElement`, and you can access the `value` property without any compilation errors.

Another way to perform the same type casting is by casting it as soon as you access the `value` property:

```ts
let input = document.querySelector("input");
let enteredValue = (input as HTMLInputElement).value;
```

Note that the `HTMLInputElement` type extends the `HTMLElement` type, which in turn extends the `Element` type. This means that an `HTMLInputElement` is a more specific type of `Element`. When you cast the `HTMLElement` to `HTMLInputElement`, you are also "downcasting" it to a more specific type.

It is also possible to explicitly downcast:

```ts
let el: HTMLElement;

el = new HTMLInputElement(); // OK
```

In this example, the `el` variable is of type `HTMLElement`, and we are assigning it an instance of `HTMLInputElement`, which is a subtype of `HTMLElement`. This is allowed because an `HTMLInputElement` is a more specific type of `HTMLElement`. This reminds me of polymorphism in object-oriented programming, where a base class reference can point to a derived class object. Why does this remind me of that? Because in both cases, we are dealing with a hierarchy of types where a more general type can refer to a more specific type.

#### Type Casting Using Angle Brackets

Besides the `as` keyword, TypeScript also supports type casting using angle brackets (`<>`). The following code demonstrates how to use angle brackets for type casting:

```ts
let input = <HTMLInputElement>document.querySelector("input");
console.log(input.value); // Now this works
```

The syntax for type casting using angle brackets is:

```ts
<NewType>variable;
```

## Functions

Functions are the basic building blocks of any application, whether they are local functions, imported from another module, or methods on a class. They are also values, and just like any other value, TypeScript has many ways to describe how functions can be called.

#### Function Type Expressions

The simples way to describe a function type is with a function type expression. These are syntactically similar to arrow functions, but they only describe the type of the function, not its implementation.

```ts
function greeter(fn: (a: string) => void) {
  fn("Hello, World");
}

function printToConsole(s: string) {
  console.log(s);
}

greeter(printToConsole);
```

The syntax `(a: string) => void` describes a function that takes a single parameter of type `string` and does not return a value. The `greeter` function takes a parameter `fn` of this function type and calls it with the string "Hello, World". The `printToConsole` function matches this type, so it can be passed to `greeter`.

We cab use a type alias to make the code more readable:

```ts
type GreetFunction = (a: string) => void;

function greeter(fn: GreetFunction) {
  fn("Hello, World");
}

function printToConsole(s: string) {
  console.log(s);
}

greeter(printToConsole);
```

#### Call Signatures

In JavaScript, functions can have properties in addition to being callable. However, the function type expressions we have seen so far only describe the callable aspect of functions. If we want to describe something callable with properties, we can write a call signature in an object type:

```ts
type DescribableFunction = {
  description: string;
  (someArg: number): boolean;
};

function doSomething(fn: DescribableFunction) {
  console.log(fn.description + " returned " + fn(6));
}

let myFunc: DescribableFunction; = function (someArg: number) {
  return someArg > 3;
};

myFunc.description = "This function checks if a number is greater than 3";

doSomething(myFunc);
```

Note, the syntax is slightly different compared to a function type expression. We use `:` to separate the property from the call signature. The call signature itself does not have a name; it is just a list of parameters and the return type.

#### Construct Signatures

In JavaScript, functions can also be invoked with the `new` keyword to create new objects. TypeScript refers to these as constructors because they usually create a new object. To describe a constructor, we can use a construct signature in an object type:

```ts
type SomeConstructor = {
  new (s: string): SomeObject;
};

function fn(ctor: SomeConstructor) {
  return new ctor("hello");
}

class SomeObject {
  constructor(s: string) {
    console.log(s);
  }
}

fn(SomeObject);
```

Some objects, like JavaScript's built-in `Date` object, can be invoked with or without `new`. You can combine call and construct signatures in a single type:

```ts
interface CallOrConstruct {
  new (s: string): Date;
  (n?: number): number;
}
```

#### Generic Functions

It's common to write a function where the types of the input relate to the type of the output or where the types of the inputs relate to each other. In these cases, we can use generics to capture the relationship between the types.

```ts
function firstElement(arr: any[]) {
  return arr[0];
}
```

This function does its job but loses information about the type of the elements in the array. It would be better if the function returned the type of the array element.

In TypeScript, generics are used when we want to describe a relationship between types. We do this by declaring a type parameter in the function signature:

```ts
function firstElement<Type>(arr: Type[]): Type | undefined {
  return arr[0];
}
```

By adding a type parameter `Type` to this function and using it in two places, we have created a link between the input of the function (the array) and the output of the function (the first element of the array). Now, when we call `firstElement`, TypeScript can infer the type of the elements in the array and use that as the return type of the function:

```ts
// s is of type string
const s = firstElement(["a", "b", "c"]);

// n is of type number
const n = firstElement([1, 2, 3]);

// u is of type undefined
const u = firstElement([]);
```

#### Inference

Note that we did not have to specify the type parameter `Type` when we called `firstElement`. TypeScript was able to infer the type based on the type of the argument we passed in. This is called "type inference" and is a powerful feature of TypeScript that allows us to write generic functions without having to explicitly specify the types every time we call them.

We can use multiple type parameters to describe functions that relate multiple types. For example, a standalone version of the `map` method on arrays can be written like this:

```ts
function map<Input, Output>(
  arr: Input[],
  func: (arg: Input) => Output
): Output[] {
  return arr.map(func);
}
```

#### Constraints

We have written some generic functions that can work on any type. Sometimes, we want to relate two values but can only operate on a subset of types. In these cases, we can use "constraints" to limit the kinds of types that can be used as type arguments.

Let's write a function that returns the longer of two values. To do this, we need a length property that is a number. We can constrain the type parameter to types that have a `length` property by writing an `extends` clause on the type parameter:

```ts
function longest<Type extends { length: number }>(a: Type, b: Type): Type {
  if (a.length >= b.length) {
    return a;
  } else {
    return b;
  }
}
```

An argument of type `number` cannot be passed to this function because `number` does not have a `length` property. We allows TypeScript to infer the type of the return value based on the types of the arguments we pass in.

#### Specifying Type Arguments

TypeScript can usually infer the type arguments for generic functions, but sometimes we need to specify them explicitly. We can do this by providing the type arguments in angle brackets after the function name when we call the function:

```ts
function combine<Type>(arr1: Type[], arr2: Type[]): Type[] {
  return arr1.concat(arr2);
}
```

Normally, calling a function with mismatched types would result in a compilation error:

```ts
combine<string>(["a", "b"], ["c"]); // okay
combine<number>([1, 2], [3]); // okay
combine<string | number>([1, 2], ["a"]); // okay
combine<string>([1, 2], ["a"]); // Error: Argument of type 'number' is not assignable to parameter of type 'string'.
```

If you intended to do this, you could manually specify a union type as the type argument:

```ts
combine<string | number>([1, 2], ["a"]); // okay
```

## Classes

TypeScript supports object-oriented programming features like classes, interfaces, inheritance, and access modifiers. Classes in TypeScript are similar to classes in other object-oriented languages like Java or C#.

#### Class Members

```ts
class Point {}
```

#### Fields

A field declaration creates a public writable property on the class:

```ts
class Point {
  x: number;
  y: number;
}

const pt = new Point();
pt.x = 10;
pt.y = 20;
```

As with other locations, the type annotation is optional if TypeScript can infer the type. You can also provide an initializer to set the value of the field when an instance of the class is created:

```ts
class Point {
  x = 0;
  y = 0;
}
```

#### readonly Modifier

You can use the `readonly` modifier to mark a field as immutable. A `readonly` field can only be assigned during initialization or in the constructor of the class:

```ts
class Point {
  readonly x: number;
  readonly y: number;

  constructor(x: number, y: number) {
    this.x = x;
    this.y = y;
  }
}
```

Attempting to assign a value to a `readonly` field outside of these locations will result in a compilation error:

```ts
const pt = new Point(10, 20);
pt.x = 30; // Error: Cannot assign to 'x' because it is a read-only property.
```

#### Constructors

Class constructors are very similar to functions. You add parameters with type annotations, default values, and overloads:

```ts
class Point {
  x: number;
  y: number;

  // Normal signature with defaults
  constructor(x = 0, y = 0) {
    this.x = x;
    this.y = y;
  }
}
```

```ts
class Point {
  // Overloads
  constructor();
  constructor(x: number, y: string);
  constructor(s: string);
  constructor(xOrS: any, y?: any) {
    // Implementation
  }
}
```

#### Super Calls

Just as in JavaScript, if a class extends another class and has a constructor, it must call `super()` before referencing `this`:

```ts
class Base {
  k = 4;
}

class Derived extends Base {
  constructor() {
    super();
    console.log(this.k);
  }
}
```

#### Methods

A function property on a class is called a method. Methods can use all the same type annotations as functions and constructors:

```ts
class Point {
  x = 10;
  y = 10;

  scale(n: number): void {
    this.x *= n;
    this.y *= n;
  }
}
```

Other than the standard type annotations, TypeScript does not add any special syntax for methods.

#### Getters and Setters

Classes also support getters and setters as a way to intercept property access:

```ts
class C {
  _length = 0;

  get length(): number {
    return this._length;
  }

  set length(value: number) {
    this._length = value;
  }
}
```

TypeScript has some special inference rules for getters and setters:

- If `get` exists but no `set`, the property is inferred to be `readonly`.
- If the type of the setter parameter is not annotated, it is inferred from the getter's return type.
- Getter and setters must have the same member visibility (public, private, or protected).

#### Index Signatures

Classes can also have index signatures to describe properties that are accessed via an index:

```ts
class MyClass {
  // Key is a string
  [s: string]: boolean | ((s: string) => boolean); // Value can be a boolean or a function

  check(s: string) {
    return this[s] as boolean;
  }
}
```

What the above code does is define a class `MyClass` that has an index signature allowing it to have properties with string keys. The values of these properties can either be a boolean or a function that takes a string argument and returns a boolean. The `check` method takes a string argument `s` and returns the value associated with the key `s` in the class instance, casting it to a boolean.

How would this be used in practice? Here's an example:

```ts
const myInstance = new MyClass();
myInstance["isActive"] = true; // Assigning a boolean value
myInstance["isValid"] = (input: string) => input.length > 5;
console.log(myInstance.check("isActive")); // Outputs: true
console.log(myInstance["isValid"]("Hello, World!")); // Outputs: true
console.log(myInstance["isValid"]("Hi")); // Outputs: false
```

So does this assign multiple properties to the class instance dynamically? Yes, it does. The index signature allows you to add properties to instances of `MyClass` using string keys, and the values can be either booleans or functions that match the specified signature. This provides flexibility in how you can use instances of the class.

## Decorators

With the introduction of classes in TypeScript and ES6, certain design patterns now require additional features to support annotating or modifying classes and class members. Decorators provide a way to add both annotations and a meta-programming syntax for class declarations and members. Decorators are a stage 2 proposal for JavaScript and are available as an experimental feature of TypeScript.

To enable experimental support for decorators, you must enable the `experimentalDecorators` compiler option either on the command line or in your `tsconfig.json`.

```json
{
  "compilerOptions": {
    "experimentalDecorators": true
  }
}
```

---

A decorator is simply a function that is called on the class, method, accessor, property, or parameter declaration that it is attached to. The decorator function is called at runtime with information about the decorated declaration. Decorators use the form `@expression`, where `expression` must evaluate to a function that will be called at runtime with information about the decorated declaration.

For example, given the following decorator, `@sealed`, we might write the sealed function as follows:

```ts
function sealed(target) {
  // do something with 'target'
}
```

When the `@sealed` decorator is applied to a class, the `sealed` function is called at runtime with the constructor of the class as its only argument.

```ts
@sealed
class Greeter {
  greeting: string;
  constructor(message: string) {
    this.greeting = message;
  }
  greet() {
    return "Hello, " + this.greeting;
  }
}
```

The `sealed` decorator is applied to the `Greeter` class, and the `sealed` function is called with the constructor of the `Greeter` class as its argument. This allows the decorator to modify or augment the class in some way.

#### Decorator Factories

If we want to customize how a decorator is applied to a declaration, we can write a decorator factory. A decorator factory is simply a function that returns the expression that will be called by the decorator at runtime. For example, we might want to write a `@color` decorator that takes a string argument to specify the color to use:

```ts
function color(value: string) {
  return function (target) {
    // do something with 'target' and 'value'
  };
}
```

#### Decorator Composition

Multiple decorators can be applied to a single declaration. When multiple decorators apply to a single declaration, their evaluation is similar to function composition in mathematics. In this model, when composing functions `f` and `g`, the resulting composite `f ∘ g` is equivalent to `f(g(x))`.

Multiple decorators can be applied on a single line or on separate lines:

```ts
@first
@second
class C {}
```

As such, the following steps are performed when evaluating multiple decorators on a single declaration in TypeScript:

- The expressions for each decorator are evaluated top-to-bottom.
- The results are then called as functions from bottom-to-top.

In simple terms, the decorator that is closest to the class or method is called first.

If we were to use decorator factories, we can observe the order of evaluation and application:

```ts
function first() {
  console.log("first(): evaluated");
  return function (
    target: any,
    propertyKey: string,
    descriptor: PropertyDescriptor
  ) {
    console.log("first(): called");
  };
}

function second() {
  console.log("second(): evaluated");
  return function (
    target: any,
    propertyKey: string,
    descriptor: PropertyDescriptor
  ) {
    console.log("second(): called");
  };
}

class Example {
  @first()
  @second()
  method() {}
}

// Output:
// first(): evaluated
// second(): evaluated
// second(): called
// first(): called
```

#### Decorator Evaluation

There is a well defined order regarding how decorators are applied to various declarations within a class:

- Parameter decorators, followed by method, accessor, or property decorators are applied for each instance member.
- Parameter decorators, followed by method, accessor, or property decorators are applied for each static member.
- Parameter decorators are applied for the constructor.
- Class decorators are applied last.

#### Class Decorators

A class decorator is declared just before a class declaration. The class decorator is applied to the constructor of the class and can be used to observe, modify, or replace a class definition. A class decorator cannot be used in a declaration file, or in any other ambient context (such as in a `declare` class).

The expression for the class decorator will be called as a function at runtime, with the constructor of the decorated class as its only argument.

If the class decorator returns a value, it will replace the class declaration with the provided constructor function.

Note: Should you choose to return a new constructor function, it must be compatible with the original constructor function. This means that the new constructor must have the same parameters as the original constructor. The logic that applies decorators at runtime will not do this for you.

The following is an example of a class decorator, `@sealed`, applied to a `BugReport` class. The `@sealed` decorator seals the constructor of the class, preventing new properties from being added to it:

```ts
@sealed
class BugReport {
  type = "report";
  title: string;

  constructor(t: string) {
    this.title = t;
  }
}
```

We can define the `sealed` decorator as follows:

```ts
function sealed(constructor: Function) {
  Object.seal(constructor);
  Object.seal(constructor.prototype);
}
```

> `Note:` The `Object.seal` method seals an object, preventing new properties from being added to it and marking all existing properties as non-configurable.

When the `@sealed` decorator is applied to the `BugReport` class, it will seal both the constructor and its prototype, preventing any new properties from being added to them.

Next, we have an example of how to override the constructor to set new defaults:

```ts
function reportableClassDecorator<T extends { new (...args: any[]): {} }>(
  constructor: T
) {
  return class extends constructor {
    reportingURL = "http://www.example.com/report";
  };
}

@reportableClassDecorator
class BugReport {
  type = "report";
  title: string;

  constructor(t: string) {
    this.title = t;
  }
}

const bug = new BugReport("Needs dark mode");
console.log(bug.title); // Outputs: Needs dark mode
console.log(bug.type); // Outputs: report

// Note: 'reportingURL' property is added by the decorator
// The decorator does not change the TypeScript type
// so the new property is not known to exist on 'bug'.
console.log(bug.reportingURL); // Error: Property 'reportingURL' does not exist on type 'BugReport'.
```

#### Method Decorators

A method decorator is declared just before a method declaration. The method decorator is applied to the Property Descriptor for the method and can be used to observe, modify, or replace a method definition. A method decorator cannot be used in a declaration file, or in any other ambient context (such as in a `declare` class), on an overload, or on a constructor.

The expression for the method decorator will be called as a function at runtime, with the following three arguments:

- Either the constructor function of the class for a static member, or the prototype of the class for an instance member.
- The name of the member.
- The Property Descriptor for the member.

If the method decorator returns a value, it will be used as the Property Descriptor for the method. If the method decorator does not return a value, the existing Property Descriptor will be used.

> What is a Property Descriptor? A Property Descriptor is an object that describes a property on an object. It contains information about the property, such as its value, whether it is writable, enumerable, or configurable, and any getter or setter functions associated with the property.

The following is an example of a method decorator, `@enumerable`, applied to a `Greeter` class.

```ts
function enumerable(value: boolean) {
  return function (
    target: any,
    propertyKey: string,
    descriptor: PropertyDescriptor
  ) {
    descriptor.enumerable = value;
  };
}

class Greeter {
  greeting: string;

  constructor(message: string) {
    this.greeting = message;
  }

  @enumerable(false)
  greet() {
    return "Hello, " + this.greeting;
  }
}
```

The `@enumerable(false)` decorator is applied to the `greet` method of the `Greeter` class. The `enumerable` decorator function takes a boolean value as an argument and returns a function that modifies the Property Descriptor of the method to set its `enumerable` property to the specified value. In this case, the `greet` method will not be enumerable, meaning it will not show up in `for...in` loops or `Object.keys()` calls on instances of the `Greeter` class. For example, the following code demonstrates this behavior:

```ts
const greeter = new Greeter("world");
for (let key in greeter) {
  console.log(key); // 'greet' will not be logged
}
console.log(Object.keys(greeter)); // 'greet' will not be included in the array
```

So what will be logged? Only the `greeting` property will be logged, as it is the only enumerable property of the `Greeter` instance. The `greet` method will not be logged because it has been decorated with `@enumerable(false)`, making it non-enumerable.

#### Accessor Decorators

An accessor decorator is declared just before an accessor declaration. The accessor decorator is applied to the Property Descriptor for the accessor and can be used to observe, modify, or replace an accessor definition. An accessor decorator cannot be used in a declaration file, or in any other ambient context (such as in a `declare` class), on an overload, or on a constructor.

Note: TypeScript disallows decorating both the get and set accessors for a single member. Instead, all decorators for the member must be applied to the first accessor in the source order. This is because decorators apply to a Property Descriptor, and a single Property Descriptor describes both the get and set accessors.

The expression for the accessor decorator will be called as a function at runtime, with the following three arguments:

- Either the constructor function of the class for a static member, or the prototype of the class for an instance member.
- The name of the member.
- The Property Descriptor for the member.

If the accessor decorator returns a value, it will be used as the Property Descriptor for the accessor. If the accessor decorator does not return a value, the existing Property Descriptor will be used.

The following is an example of an accessor decorator, `@configurable`, applied to a `Point` class.

```ts
function configurable(value: boolean) {
  return function (
    target: any,
    propertyKey: string,
    descriptor: PropertyDescriptor
  ) {
    descriptor.configurable = value; // set the configurable property
  };
}

class Point {
  private _x: number;
  private _y: number;

  constructor(x: number, y: number) {
    this._x = x;
    this._y = y;
  }

  @configurable(false) // make the accessor non-configurable
  get x() {
    return this._x;
  }

  @configurable(false) // make the accessor non-configurable
  get y() {
    return this._y;
  }
}
```

What is an accessor? An accessor is a special type of property in an object that allows you to define custom behavior for getting and setting the value of that property. Accessors are defined using the `get` and `set` keywords in a class or object literal.

What does it mean to make an accessor non-configurable? When an accessor is non-configurable, it means that the property descriptor for that accessor cannot be changed or deleted. This means that you cannot change the attributes of the accessor, such as its `enumerable` or `writable` properties, nor can you delete the accessor from the object. This is useful when you want to ensure that certain properties of an object remain unchanged and cannot be modified or removed accidentally.

#### Property Decorators

A property decorator is declared just before a property declaration. The property decorator is applied to the Property Descriptor for the property and can be used to observe, modify, or replace a property definition. A property decorator cannot be used in a declaration file, or in any other ambient context (such as in a `declare` class), or on a constructor.

The expression for the property decorator will be called as a function at runtime, with the following two arguments:

- Either the constructor function of the class for a static member, or the prototype of the class for an instance member.
- The name of the member.

Note: There is no Property Descriptor provided as an argument to a property decorator because there is no mechanism to describe an instance property when defining members of a prototype, as properties are only created when an instance is created. The return value is also ignored. As such, property decorators can only be used to observe that a property of a specific name has been declared for a class.

We can use property decorators to record metadata about the properties of a class. For example, we might want to create a `@format` decorator that records a format string for a property:

```ts
function format(formatString: string) {
  return function (target: any, propertyKey: string) {
    // store the format string in metadata
    Reflect.defineMetadata("format", formatString, target, propertyKey);
  };
}

class Greeter {
  @format("Hello, %s")
  greeting: string;

  constructor(message: string) {
    this.greeting = message;
  }
}
```

The `@format` decorator is applied to the `greeting` property of the `Greeter` class. The `format` decorator function takes a format string as an argument and returns a function that stores the format string in metadata using the `Reflect.defineMetadata` method. This allows us to associate a format string with the `greeting` property, which can be retrieved later using the `Reflect.getMetadata` method.

#### Parameter Decorators

A parameter decorator is declared just before a parameter declaration. The parameter decorator is applied to the function for a method declaration or constructor declaration and can be used to observe, modify, or replace a parameter definition. A parameter decorator cannot be used in a declaration file, or in any other ambient context (such as in a `declare` class), or on a constructor overload.

The expression for the parameter decorator will be called as a function at runtime, with the following three arguments:

- Either the constructor function of the class for a static member, or the prototype of the class for an instance member.
- The name of the member.
- The ordinal index of the parameter in the function's parameter list.

The following is an example of a parameter decorator, `@required`, applied to a `Greeter` class.

```ts
function required(target: any, propertyKey: string, parameterIndex: number) {
  console.log(
    `Parameter at index ${parameterIndex} in method ${propertyKey} is required.`
  );
}

class Greeter {
  greeting: string;

  constructor(message: string) {
    this.greeting = message;
  }

  greet(@required name: string) {
    return `Hello, ${name}, ${this.greeting}`;
  }
}
```

The `@required` decorator is applied to the `name` parameter of the `greet` method in the `Greeter` class. The `required` decorator function takes three arguments: the target (either the constructor function or the prototype), the property key (the name of the method), and the parameter index (the position of the parameter in the method's parameter list). In this example, when the `greet` method is called, the decorator will log a message indicating that the parameter at index 0 (the `name` parameter) is required.

### Real World Application

Decorators are a way to decorate members of a class or a class itself with extra functionality. When you apply a decorator to a class or a class member, you are actually calling a function that is going to receive details of what is being decorated, and the decorator implementation will then be able to transform the code dynamically, adding extra functionality and reducing boilerplate code. They are a way to enable meta-programming in TypeScript, which is a programming technique that allows the programmer to create code that uses other code from the application itself as data.
