# Programming Foundations with Java - Day 4

## Packages and Imports

**What is a package?**

A `package` is a `namespace` that organizes a set of related classes and interfaces. Conceptually similar to directories on your computer, packages help avoid name conflicts and can control access with protected and default access levels. In Java, packages are defined using the `package` keyword.

But what is a `namespace`? A namespace is a container that holds a set of identifiers (such as class names, variable names, etc.) and allows them to be organized and accessed in a controlled manner. In Java, packages serve as namespaces, helping to group related classes and interfaces together.

In simpler terms, a package is like a folder on your computer where you can store related files (classes and interfaces) to keep them organized and avoid naming conflicts. And, a namespace is like the folder itself, providing a way to access and manage the files within it.

(A package is a collection of classes, interfaces, and enums in a hierarchical structure. It helps to organize code and avoid naming conflicts.)

**Why use packages?**

- Organize code: Packages help to group related classes and interfaces together, making it easier to manage and maintain the codebase.
- Avoid naming conflicts: By placing classes in different packages, you can have multiple classes with the same name without causing conflicts.
- Control access: Packages can restrict access to classes and members, allowing you to implement encapsulation and protect your code.
- Packages allow you to distribute your classes to others in a structured way.

**Example of package declaration:**

```java
package com.example.myapp;
```

In this example, this line declares the `package` in which the class will reside, and:

- `com` is the top-level domain (TLD) of the organization.
- `example` is the domain name.
- `myapp` is the name of the application or module.
- This must always be the first line in your Java source file (excluding comments).
- Classes can be referenced anywhere in a program by their "fully qualified name" (e.g., `com.example.myapp.MyClass`).

Typically, we do not want to write out a verbose package declaration every time we reference a class. Instead, we can use the `import` statement to bring specific classes or entire packages into scope, allowing us to use shorter names.

```java
import com.example.myapp.MyClass;
```

With this import statement, we can now refer to `MyClass` directly without the package prefix.

By default, everything in the `java.lang` package is imported automatically, so you don't need to explicitly import classes like `String`, `System`, or `Math`.

However, other classes from different packages need to be imported explicitly using the `import` statement.

### Real World Application

Packages store and organize our Java class and/or interface files.

- Usually we separate them into areas of shared functionality
- In our class, we declare the package in which our class will reside.

Folders provide a good analogy for packages. Just as folders help us organize files on our computer, packages help us organize classes and interfaces in our Java projects.

- Typically, a class will be stored in packages within packages
- We indicate that one package is essentially a subfolder of another by separating the package names with dots (e.g., `com.example.myapp.subpackage`)

Packages follow a naming convention of lowercase characters separated by dots in the reverse domain name format (e.g., `com.example.myapp`).

Java packages must correspond to the directory structure of the project. For example, a class in the package `com.example.myapp` should be located in the directory `com/example/myapp/`.
