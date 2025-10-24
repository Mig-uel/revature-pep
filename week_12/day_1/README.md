# TypeScript and Angular - Day 1

## Utility Types

TypeScript provides several built-in utility types that help with common type transformations. These utilities are available globally and can be used without any additional imports.

`Awaited<T>`

This type is meant to model operations like `await` in async functions or the `then` method of Promises. It recursively unwraps the type of a Promise.

```typescript
type A = Awaited<Promise<string>>; // string
type B = Awaited<Promise<Promise<number>>>; // number
type C = Awaited<boolean | Promise<number>>; // boolean | number
```

`Partial<T>`

Constructs a type with all properties of `T` set to optional. This utility will return a type that represents all subsets of a given type.

```typescript
interface Todo {
  title: string;
  description: string;
}

function updateTodo(todo: Todo, fieldsToUpdate: Partial<Todo>) {
  return { ...todo, ...fieldsToUpdate };
}

const todo1 = {
  title: "organize desk",
  description: "clear clutter",
};

const todo2 = updateTodo(todo1, {
  description: "throw out trash",
});
```

`Required<T>`

Constructs a type consisting of all properties of `T` set to required. The opposite of `Partial<T>`.

```typescript
interface Props {
  a?: number;
  b?: string;
}

const obj: Props = { a: 5 }; // OK

const obj2: Required<Props> = { a: 5 }; // Error: Property 'b' is missing
```

`Readonly<T>`

Constructs a type with all properties of `T` set to `readonly`, meaning the properties of the constructed type cannot be reassigned.

```typescript
interface Todo {
  title: string;
}

const todo: Readonly<Todo> = {
  title: "Delete inactive users",
};

todo.title = "Hello"; // Error: cannot reassign a readonly property
```

This utility is useful for representing assignment expressions that will fail at runtime (i.e. when attempting to reassign properties of a frozen object).

`Record<K, T>`

Constructs an object type whose property keys are `K` and whose property values are `T`.
This utility can be used to map the properties of one type to another type.

```typescript
interface CatInfo {
  age: number;
  breed: string;
}

type CatName = "miffy" | "boris" | "mordred";

const cats: Record<CatName, CatInfo> = {
  miffy: { age: 10, breed: "Persian" },
  boris: { age: 5, breed: "Maine Coon" },
  mordred: { age: 16, breed: "British Shorthair" },
};

cats.boris; // { age: 5, breed: "Maine Coon" }
```

`Pick<T, K>`

Constructs a type by picking a set of properties `K` from `T`.

```typescript
interface Todo {
  title: string;
  description: string;
  completed: boolean;
}

type TodoPreview = Pick<Todo, "title" | "completed">;

const todo: TodoPreview = {
  title: "Clean room",
  completed: false,
};
```

`Omit<T, K>`

Constructs a type by omitting a set of properties `K` from `T`.

```typescript
interface Todo {
  title: string;
  description: string;
  completed: boolean;
  createdAt: number;
}

type TodoPreview = Omit<Todo, "description">;

const todo: TodoPreview = {
  title: "Clean room",
  completed: false,
  createdAt: 1615544252770,
};
```

`Exclude<T, U>`

Constructs a type by excluding from `T` all union members that are assignable to `U`.

```typescript
type T0 = Exclude<"a" | "b" | "c", "a">; // "b" | "c"
type T1 = Exclude<"a" | "b" | "c", "a" | "b">; // "c"
type T2 = Exclude<string | number | (() => void), Function>; // string | number
```

`Extract<T, U>`

Constructs a type by extracting from `T` all union members that are assignable to `U`.

```typescript
type T0 = Extract<"a" | "b" | "c", "a" | "f">; // "a"
type T1 = Extract<string | number | (() => void), Function>; // () => void
```

`NonNullable<T>`

Constructs a type by excluding `null` and `undefined` from `T`.

```typescript
type T0 = NonNullable<string | number | undefined>; // string | number
type T1 = NonNullable<string[] | null | undefined>; // string[]
```

`Parameters<T>`

Constructs a tuple type from the types used in the parameters of a function type `T`.

```typescript
type T0 = Parameters<() => string>; // []
type T1 = Parameters<(s: string) => void>; // [s: string]
type T2 = Parameters<<T>(arg: T) => T>; // [arg: unknown]
type T3 = Parameters<any>; // unknown[]
type T4 = Parameters<never>; // never
```

`ConstructorParameters<T>`

Constructs a tuple or array type from the types used in the parameters of a constructor function type `T`.

```typescript
type T0 = ConstructorParameters<ErrorConstructor>; // [message?: string]
type T1 = ConstructorParameters<FunctionConstructor>; // [...args: string[]]
```

`ReturnType<T>`

Constructs a type consisting of the return type of function `T`.

```typescript
type T0 = ReturnType<() => string>; // string
type T1 = ReturnType<(s: string) => void>; // void
type T2 = ReturnType<<T>() => T>; // unknown
type T3 = ReturnType<any>; // any
type T4 = ReturnType<never>; // never
```

`InstanceType<T>`

Constructs a type consisting of the instance type of a constructor function `T`.

```typescript
class C {
  x = 0;
  y = 0;
}
type T0 = InstanceType<typeof C>; // C

type T1 = InstanceType<any>; // any
type T2 = InstanceType<never>; // never
```

`ThisParameterType<T>`

Constructs a type consisting of the type of the `this` parameter for function `T`. If `T` has no `this` parameter, the resulting type is `unknown`.

```typescript
function toHex(this: Number) {
  return this.toString(16);
}
type T0 = ThisParameterType<typeof toHex>; // Number
type T1 = ThisParameterType<() => void>; // unknown
```

`OmitThisParameter<T>`

Constructs a type by removing the `this` parameter from function `T`. If `T` has no `this` parameter, the resulting type is just `T`.

```typescript
function toHex(this: Number) {
  return this.toString(16);
}
type T0 = OmitThisParameter<typeof toHex>; // () => string
```

`ThisType<T>`

This utility does not return a transformed type. Instead, it serves as a marker for contextual `this` types. When using `ThisType<T>`, the type checker will understand that within the context where `ThisType<T>` is applied, `this` should be of type `T`.

```typescript
interface Box {
  contents: string;
}

type Boxed = ThisType<Box>; // Marker interface

let box: Boxed = {
  contents: "hello",
};

function setContents(this: Box, value: string) {
  this.contents = value;
}
setContents.call(box, "world");
console.log(box.contents); // "world"
```

## Array Generics

In TypeScript, an array is a data type that store multiple values of different data types simultaneously. Similar to JavaScript, TypeScript supports array declaration, and there are multiple ways to declare arrays using generics.

### Real World Application

The main reason to use generics in arrays is to enable types, classes, or interfaces to act as parameters when defining arrays. This allows for greater flexibility and reusability of code.

Some benefits of generics are:

- Defining a relationship between input and output types. For example, the function `test<T>(input: T): T` allows you to make sure input and output use the same type, where input is an array of type `T` and output is also of type `T`.
- Stronger type checks at compile time will be available. In the case of the above example, the compiler lets you know that array methods are available for input and not any other methods.
- You can remove unnecessary type casts. For example, you have `const list: Array<Item> = []`, going over array elements, you will have access to all the properties of `Item` without needing to cast each element to `Item`.

### Implementation

#### How to Declare Generic Arrays

##### Declaring and Initializing On Separate Lines

```typescript
let ArrayName: Array<dataType>; // Declaration
ArrayName = [value1, value2, value3]; // Initialization
```

```typescript
let fruits: Array<string>; // Declaration
fruits = ["Apple", "Banana", "Orange"]; // Initialization

let digits: Array<number>; // Declaration
digits = [1, 2, 3, 4, 5]; // Initialization
```

##### Declaring and Initializing On the Same Line

```typescript
let fruits: string[] = ["Apple", "Banana", "Orange"];
let fruitsGeneric: Array<string> = ["Apple", "Banana", "Orange"];
let digits: number[] = [1, 2, 3, 4, 5];
let digitsGeneric: Array<number> = [1, 2, 3, 4, 5];
```

##### Declaring MultiType Arrays

```typescript
let Capital: (string | string)[] = [
  "USA",
  "Washington D.C.",
  "India",
  "New Delhi",
];

let CapitalGeneric: Array<string | string> = [
  "USA",
  "Washington D.C.",
  "India",
  "New Delhi",
];
```

## KeyOf

In JavaScript, we often use `Object.keys()` to get a list of keys from an object. In TypeScript, the equivalent concept is the `keyof` operator, which is used to obtain the keys of a type as a union of string literal types.

Although they are similar, `keyof` only works on the type level and returns a literal union type of the keys, while `Object.keys()` works at runtime and returns an array of strings.

#### Defining the Keyof Operator

> The `keyof` operator takes an object type and produces a string or numeric literal union of its keys.

```typescript
type Staff = {
  name: string;
  salary: number;
};
type StaffKeys = keyof Staff; // "name" | "salary"
```

We apply the `keyof` operator to the `Staff` type, which results in a union type of its keys: `"name" | "salary"`.

`keyof` can also be used for non-object types, including primitive types like `string`, `number`, and `boolean`.

```typescript
type BooleanKeys = keyof boolean; // "toString" | "valueOf" | ...
type NumberKeys = keyof number; // "toString" | "valueOf" | ...
type SymbolKeys = keyof symbol; // "toString" | "valueOf" | ...
```

This is less useful in practice, but it demonstrates that `keyof` can be applied to any type.

#### Using Keyof with Generics

The `keyof` operator can be used to apply constraints to generic types. This is particularly useful when you want to ensure that a generic type parameter is limited to the keys of a specific type.

```typescript
function getProperty<T, K extends keyof T>(obj: T, key: K): T[K] {
  return obj[key];
}
```

If you are new to TypeScript, this example may look complex. Let's break it down:

- `T` is a generic type parameter representing the type of the object.
- `K` is another generic type parameter constrained to the keys of `T` using `K extends keyof T`.
- The function takes an object of type `T` and a key of type `K`, and returns the value of the property at that key, which is of type `T[K]`.
- `extends` means "is a subtype of" or "is assignable to" instead of "inherits from" in this context.

This ensures that the `key` parameter is always a valid key of the object `obj`, providing type safety and preventing runtime errors.

```typescript
const developer: Staff = {
  name: "Alice",
  salary: 70000,
};

const nameType = getProperty(developer, "name"); // type is string
const salaryType = getProperty(developer, "pay"); // Error: Argument of type '"pay"' is not assignable to parameter of type '"name" | "salary"'
```

##### Using Keyof with Mapped Types

A common use for the `keyof` operator is in conjunction with mapped types. Mapped types allow you to transform existing types into new ones by iterating over their keys, often via the `keyof` operator.

```typescript
type OptionsFlags<T> = {
  [K in keyof T]: boolean;
}; // Mapped type

type FeatureFlags = {
  darkMode: () => void;
  newUserProfile: () => void;
}; // Original type

type FeatureOptions = OptionsFlags<FeatureFlags>; // Mapped type result

/* Resulting type:
type FeatureOptions = {
  darkMode: boolean;
  newUserProfile: boolean;
}
```

In this example:

- We define a mapped type `OptionsFlags<T>` that takes a type `T` and creates a new type where each property key `K` in `T` is mapped to a `boolean` type.
- We then define an original type `FeatureFlags` with two properties, each being a function.
- Finally, we create a new type `FeatureOptions` by applying the `OptionsFlags` mapped type to `FeatureFlags`, resulting in a type where each property is now a `boolean`.

This pattern is useful for creating types that represent configurations or options based on existing types, leveraging the power of `keyof` and mapped types in TypeScript.

##### Using Keyof with Conditional Mapped Types

In the previous example, we created a mapped type that transformed all properties of a type to `boolean`. We can go one step further by using conditional types within mapped types to create more complex transformations based on the original property types.

```typescript
type OptionsFlags<T> = {
  [K in keyof T]: T[K] extends Function ? T[K] : boolean; // Conditional mapped type
};

type Features = {
  darkMode: () => void;
  newUserProfile: () => void;
  userManagement: string;
  resetPassword: string;
};

type FeatureOptions = OptionsFlags<Features>; // Mapped type result

/* Resulting type:
type FeatureOptions = {
  darkMode: () => void;
  newUserProfile: () => void;
  userManagement: boolean;
  resetPassword: boolean;
}
```

In this example:

- We define a mapped type `OptionsFlags<T>` that iterates over each key `K` in type `T`.
- For each property, we use a conditional type to check if the property type `T[K]` extends `Function`. If it does, we keep the original type; otherwise, we map it to `boolean`.
- We then define a `Features` type with a mix of function and string properties.
- Finally, we create a new type `FeatureOptions` by applying the `OptionsFlags` mapped type to `Features`, resulting in a type where function properties remain unchanged, while string properties are transformed to `boolean`.

This approach allows for more nuanced type transformations based on the characteristics of the original property types, providing greater flexibility in type definitions.

### Real World Application

The `keyof` operator is also known as indexed type query operator, and it yields the union that contains property names and keys of its operand type. It is commonly used in scenarios where you want to create functions or types that operate on the keys of an object type, ensuring type safety and preventing errors.

## Readonly Interface

TypeScript provides the `readonly` modifier, which can be applied to properties of an interface to make them immutable. Once a property is marked as `readonly`, it cannot be reassigned after the initial assignment.

```typescript
interface IEmployee {
  readonly id: number;
  name: string;
  position: string;
}

let employee: IEmployee = {
  id: 1,
  name: "John Doe",
  position: "Software Engineer",
};

employee.name = "Jane Smith"; // Allowed
employee.position = "Senior Software Engineer"; // Allowed
employee.id = 2; // Error: Cannot assign to 'id' because it is a read-only property.
```

### Real World Application

> Why would we want to have an interface being readonly?

Some properties should not be changed after they are set initially. For example, an employee's ID should remain constant throughout their tenure at a company. By marking the `id` property as `readonly`, we ensure that it cannot be accidentally modified, thus maintaining data integrity.

### Implementation

```typescript
class Employee {
  readonly id: number;
  name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
}
```

Since `readonly` properties cannot be changed outside the class, they can only be assigned a value during declaration or within the constructor of the class.

In the same way, you can yse `Readonly<T>` utility type to make all properties of an interface or type `T` readonly.

```typescript
interface IEmployee {
  id: number;
  name: string;
  position: string;
}

let employee: Readonly<IEmployee> = {
  id: 1,
  name: "John Doe",
  position: "Software Engineer",
};

employee.name = "Jane Smith"; // Error: Cannot assign to 'name' because it is a read-only property.
employee.position = "Senior Software Engineer"; // Error: Cannot assign to 'position' because it is a read-only property.
```

## `as const` Assertion

The `as const` assertion in TypeScript is used to indicate that the value should be treated as a constant, meaning that its type will be inferred as the most specific literal type possible.

When we use `as const`, we tell TypeScript to infer the narrowest type for the value, making all properties `readonly` and inferring literal types for strings, numbers, and booleans.

- No literal types in that expression should be widened (e.g., `string` instead of `"hello"`).
- Object literals get inferred as `readonly` types.
- Array literals get inferred as `readonly` tuples.

```typescript
// Type "hello"
let greeting = "hello" as const; // Type "hello"

// Type "readonly [10, 20, 30]"
let numbers = [10, 20, 30] as const; // Type "readonly [10, 20, 30]"

// Type "{ readonly name: "Alice"; readonly age: 30; }"
let person = { name: "Alice", age: 30 } as const; // Type "{ readonly name: "Alice"; readonly age: 30; }"
```

Outside of `.tsx` files, the angle, `<>`, syntax can also be used for `as const` assertions:

```typescript
// Type "hello"
let greeting = <const>"hello"; // Type "hello"

// Type "readonly [10, 20, 30]"
let numbers = <const>[10, 20, 30]; // Type "readonly [10, 20, 30]"

// Type "{ readonly name: "Alice"; readonly age: 30; }"
let person = <const>{ name: "Alice", age: 30 }; // Type "{ readonly name: "Alice"; readonly age: 30; }"
```

This can even be used to enable enum-like behavior in plain JavaScript if you choose not to use TypeScript's `enum` feature:

```typescript
export const Colors = {
  red: "red",
  green: "green",
  blue: "blue",
} as const;
```

### Real World Application

> Where to use `const` assertions?

The `const` assertion comes particularly handy when mixing with object literals. Imagine a function designed to obtain some sort of data from the backend:

```typescript
function fetchData(mode: "CREATE" | "EDIT") {
  // Implementation here
}
```

This function expects a specific set of string literals as its argument. It us a union of string literals, which can be tedious to type out every time we want to call the function.

In such cases, it is common practice to declare an enum-like object to hold these string literals and pass one of its properties to the function:

```typescript
const Modes = {
  CREATE: "CREATE",
  EDIT: "EDIT",
};
```

Interestingly, the compiler will notify us that the argument passed to `fetchData` is not assignable to the expected parameter type. This happens because the properties of the `Modes` object are inferred as type `string`, not as the specific string literals `"CREATE"` or `"EDIT"`.

To resolve this, we can use the `as const` assertion when defining the `Modes` object. This way, the properties will be inferred as their literal types, allowing us to pass them directly to the `fetchData` function without any type errors.

```typescript
const Modes = {
  CREATE: "CREATE",
  EDIT: "EDIT",
} as const;

fetchData(Modes.CREATE); // Now works correctly
```

## Type Guards

#### Type Guards and Differentiating Types

Union types are useful for modeling situations where values can overlap in the types they can take on. What happens if we need to know specifically whether we have a `Fish` or some other type in a union? A common idiom in JavaScript is to check for the presence of a property that only one of the types has.

```javascript
let pet = getSmallPet();

// You can use 'in' to check for the presence of a property
if ("swim" in pet) {
  pet.swim();
}

// However, you cannot use property access directly without a type guard
if (pet.fly) {
  // Property 'fly' does not exist on type 'Fish | Bird'
  pet.fly();
}
```

To get the same code working via property access, we can use type assertion.

```typescript
let pet = getSmallPet();

let fish = pet as Fish;
let bird = pet as Bird;
```

However, this is not the sort of code we want to write all the time.

#### User-Defined Type Guards

It would be much better if, once we performed the check, we could know the type of pet within each branch of our conditional.

TypeScript allows us to define our own type guards using functions that return a type predicate. A type guard is an expression that performs a runtime check that guarantees the type in some scope.

##### Using Type Predicates

To define a type guard, we simply need to write a function that returns a type predicate. A type predicate takes the form `parameterName is Type`. Here is how we can define a type guard for our `Fish` type:

```typescript
function isFish(pet: Fish | Bird): pet is Fish {
  return (pet as Fish).swim !== undefined;
}
```

Anytime we call `isFish`, TypeScript will narrow the type of `pet` to `Fish` within the true branch of an `if` statement.

```typescript
let pet = getSmallPet();

if (isFish(pet)) {
  pet.swim(); // pet is of type Fish here
} else {
  pet.fly(); // pet is of type Bird here
}
```

Notice that TypeScript not only knows that `pet` is a `Fish` in the true branch, but it also knows that `pet` must be a `Bird` in the false branch. This is because the type guard function has excluded `Fish` from the type of `pet` in that branch.

You can use type guards to filter arrays as well:

```typescript
const pets: (Fish | Bird)[] = [getSmallPet(), getSmallPet(), getSmallPet()];

const fishPets: Fish[] = pets.filter(isFish); // fishPets is of type Fish[]
const fishPets2: Fish[] = pets.filter((pet) => isFish(pet)); // fishPets2 is of type Fish[]
```

#### Using the `in` Operator

The `in` operator can also be used as a type guard to check for the presence of a property in an object and narrow the type accordingly.

```typescript
function move(pet: Fish | Bird) {
  if ("swim" in pet) {
    pet.swim(); // pet is of type Fish here
  } else {
    pet.fly(); // pet is of type Bird here
  }
}
```

#### Using `typeof` Type Guards

The `typeof` operator can be used as a type guard to check the type of a variable at runtime and narrow its type accordingly.

```typescript
function isNumber(x: any): x is number {
  return typeof x === "number";
}

function isString(x: any): x is string {
  return typeof x === "string";
}

function padLeft(value: string, padding: string | number) {
  if (isNumber(padding)) {
    return Array(padding + 1).join(" ") + value;
  }
  if (isString(padding)) {
    return padding + value;
  }
  throw new Error(`Expected string or number, got '${padding}'.`);
}
```

However, TypeScript has built-in support for `typeof` type guards, so we can simplify the above code without needing to define our own type guard functions:

```typescript
function padLeft(value: string, padding: string | number) {
  if (typeof padding === "number") {
    return Array(padding + 1).join(" ") + value;
  }
  if (typeof padding === "string") {
    return padding + value;
  }
  throw new Error(`Expected string or number, got '${padding}'.`);
}
```

#### `instanceof` Type Guards

The `instanceof` operator can be used as a type guard to check if an object is an instance of a specific class and narrow its type accordingly.

```typescript
class Dog {
  bark() {
    console.log("Woof!");
  }
}

class Cat {
  meow() {
    console.log("Meow!");
  }
}

function speak(animal: Dog | Cat) {
  if (animal instanceof Dog) {
    animal.bark(); // animal is of type Dog here
  } else {
    animal.meow(); // animal is of type Cat here
  }
}
```

#### Nullable Types

TypeScript has two special types, `null` and `undefined`, which represent the absence of a value.

By default, the type checker considers `null` and `undefined` to be valid values for all types. This means that you can assign `null` or `undefined` to any variable, regardless of its declared type. Effectively, this means that all types are nullable by default.

However, when the `--strictNullChecks` flag is enabled, `null` and `undefined` are only assignable to `any`, `unknown`, `void`, and their respective types. This means that you cannot assign `null` or `undefined` to a variable of a different type unless you explicitly include them in a union type.

#### Optional Parameters and Properties

With `strictNullChecks` enabled, optional parameters and properties are treated as potentially `undefined`. This means that if a parameter or property is marked as optional, its type is effectively a union of its declared type and `undefined`.

```typescript
function greet(name?: string) {
  if (name) {
    console.log(`Hello, ${name.toUpperCase()}!`);
  } else {
    console.log("Hello!");
  }
}
greet(); // "Hello!"
greet("Alice"); // "Hello, ALICE!"
```

## Angular Intro

Angular is a framework built on TypeScript that is used for building web applications. It provides a robust set of tools and features for developing single-page applications (SPAs) with a focus on performance, scalability, and maintainability.

Angular includes:

- A component-based framework to create single-page and scalable web applications.
- A collection of well-defined libraries that include many features such as routing, forms management, client-server communication, and more.
- Tools to develop, build, test, and deploy applications.

Angular should be preferred as a front-end framework when:

- Developing large scale dynamic web applications.
- Developing PWAs (Progressive Web Applications) or SPAs (Single Page Applications).
- Developing cross-platform applications (web, mobile, desktop) using a single codebase.
- You have a massive project with a large development team that requires a structured framework with strong typing and modularity.

### Real World Application

Angular is widely used in the industry for building complex web applications. Some notable companies that use Angular include Google, Microsoft, IBM, and PayPal. Angular's robust features and scalability make it a popular choice for enterprise-level applications.

## Video - Angular 2+ Intro

- Angular is a Model-View-Whatever (MVW) framework.
- Define models to represent data, views to present data to users, and controllers to handle user interactions and update models and views accordingly (in TypeScript).
- The view is defined using HTML templates, which can include Angular-specific syntax for data binding and directives.
- Angular will manage the rest of the application lifecycle, including rendering views, handling user input, and updating models.

### Main Angular Files

- There are 3 main files in an Angular application that reside inside the `src` directory:
  - `app-component.ts` - This file contains the TypeScript code for the main component of the application. It defines the component's behavior, properties, and methods.
  - `app-module.ts` - This file defines the main module of the application. It imports necessary modules, declares components, and sets up the application's structure.
  - `main.ts` - This file is the entry point of the application. It bootstraps the main module and starts the application.

## Video - Angular Setup

Angular has core features that are essential for building applications:

- Directives - Special markers in the HTML that tell Angular to do something with a DOM element (e.g., show/hide elements, repeat elements, etc.).

  ```html
  <!-- ng-app directive initializes the Angular application -->
  <body ng-app="myApp">
    <div ng-controller="myCtrl">
      <h1>{{ greeting }}</h1>
    </div>
  </body>
  <!-- ng-controller directive binds the controller to the div element -->
  ```

- Controllers - Provide a way to communicate between the view and the model. They contain the business logic and handle user interactions.

  ```javascript
  // Define an Angular module and controller
  var app = angular.module("myApp", []);
  app.controller("myCtrl", function ($scope) {
    $scope.greeting = "Hello, World!";
  });
  ```

- Modules - Containers for different parts of the application, such as controllers, services, directives, etc. They help organize the code and manage dependencies.
- Services - Reusable components that provide specific functionality (e.g., data fetching, authentication, etc.) and can be injected into controllers and other components.
- Expressions and Filters - Allow you to bind data to the view and format it as needed.
- Routing - Enables navigation between different views and components in a single-page application.
