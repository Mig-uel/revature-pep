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
