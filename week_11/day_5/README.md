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
