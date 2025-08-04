# Programming Foundations with Java

## What is an Operating System?

An operating system (OS) is a software that communicates with the hardware and allows other programs to run. It is comprised of system software, or the fundamental files your computer needs to boot up and operate.

## Process and Process Management

### Process

A process is an instance of a program that is being executed. The process should be executed sequentially, meaning one instruction at a time.

When you write a computer program in a text file and run it, it becomes a process in your system.

A process generally passes through several states during its lifetime:

- **New**: The process is being created.
- **Ready**: The process is waiting to be assigned to a processor.
- **Running**: Instructions are being executed.
- **Waiting**: The process is waiting for some event to occur (like I/O completion).
- **Terminated**: The process has finished execution.

These states may have different names or additional states depending on the operating system.

### Threads

A thread can be defined as a flow of execution within a process. A process can have multiple threads, all of which share the same memory space but can execute independently. The threads keep track of all instructions that need to execute next in the program counter.
Also, the thread contains system resources like registers and stack. Register hold the current working variables of the thread, while the stack contains the history of function calls and local variables.

### Scheduling

Scheduling is the method by which work specified by some means is assigned to resources that complete the work. In the context of operating systems, it refers to the way processes are managed and executed by the CPU.

The process manager takes the responsibility to remove the running process from the CPU and assign it to another process based on a specific scheduling algorithm. For multiprocessing operating systems, scheduling is crucial to ensure that all processes get a fair share of CPU time and resources.

More than one process can be loaded into the executable memory at the same time.
The processes share the CPU using time multiplexing once they are loaded into memory. This means that the CPU switches between processes, giving each one a small amount of time to execute before moving on to the next.

### Memory Management

Memory management is the process of controlling and coordinating computer memory, allocating portions called blocks to various running programs to optimize overall system performance. It involves keeping track of each byte in a computer's memory and managing the allocation and deallocation of memory spaces as needed.

This refers to the functionality of an operating system that handles and manages the primary memory or RAM. Processes move back and forth between the main memory and disk storage, which is slower than RAM. The operating system must ensure that processes have enough memory to execute while also managing the limited resources available.

## Fullstack the Big Picture

Fullstack development refers to the development of both front-end (client-side) and back-end (server-side) portions of a web application. A fullstack developer is someone who is comfortable working with both the front-end and back-end technologies.

## What is a Full Stack Developer?

Full stack technology refers to the entire depth of a computer system application, and full stack developers straddle two separate development areas: front end and back end.

- The frontend includes everything that a client, or site viewer, can see and interact with. This includes the design, structure, behavior, and content of a website or web application.
- By contrast, the backend refers to all the servers, databases, and other internal architecture that drives the application; usually, the end-user never sees this part of the application.
- Frontend developers work to optimize the visible parts of an application for web browsers and mobile devices.
  - Frontend platforms are usually built with HTML, CSS, and JavaScript. However, they can be made via pre-packaged software, such as WordPress or Wix.
- Backend developers refine the software code that communicates with servers, databases, or other proprietary software that conveys information to frontend interfaces.
  - Backend platforms are usually built with programming languages such as Java, Python, Ruby, and PHP. They also use database management systems like MySQL, PostgreSQL, and MongoDB.

## Language Overview

## Who invented Java?

Java was invented at Sun Microsystems in 1991 by a team led by James Gosling. It was initially designed for interactive television, but it was too advanced for the digital cable television industry at that time. The language was originally called Oak, named after an oak tree that stood outside Gosling's office. Later, it was renamed Java, inspired by Java coffee.
It was officially released in 1995 as a core component of Sun Microsystems' Java platform.

## Who currently owns Java?

In 2010, Oracle Corporation acquired Sun Microsystems, and with it, the ownership of Java. Since then, Oracle has been responsible for the development and maintenance of the Java programming language and its associated technologies.

## Why Java?

Java is a high-level, compiled, strongly typed object-oriented programming language.

The advantages of Java are many:

- it is platform-independent, meaning that Java code can run on any device that has a Java Virtual Machine (JVM) installed. This is often summarized by the phrase "write once, run anywhere."
- has a C-language inspired syntax
- proves automatic memory management and garbage collection, which helps in efficient memory usage and reduces memory leaks.
- has a rich standard library that provides a wide range of pre-built classes and methods for various tasks, making development faster and easier.
- has a rich open-source ecosystem with a vast number of libraries, frameworks, and tools available for developers.
- is widely used in enterprise environments, web applications, mobile applications (especially Android), and large systems.

## What is "object-oriented"?

Object-oriented programming (OOP) is a programming paradigm that uses "objects" to design software. An object is an instance of a class, which can contain both data (attributes or properties) and methods (functions or behaviors). OOP focuses on the concept of encapsulating data and behavior within objects, promoting code reusability, modularity, and maintainability.

When we say Java is object-oriented, we mean that it has the construct of classes and objects built into the language. It also allows us to use various principles of OOP. An object in code can represent a real-world entity, or a conceptual entity, with its own attributes and behaviors.

Classes are the blueprints for how to create objects that contain certain **state** - which represented by fields (variables) - and **behavior** - which is defined by methods (functions).

Objects are instances of class definitions. However, Java is not a "pure" object-oriented language because it also supports primitive data types (like int, char, etc.) that are not objects.

The primitive data types in Java are:

| Primitive Type | Size    | Description                                         |
| -------------- | ------- | --------------------------------------------------- |
| boolean        | 1 bit   | Represents true or false values.                    |
| byte           | 8 bits  | Represents whole numbers from -128 to 127.          |
| short          | 16 bits | Represents whole numbers from -32,768 to 32,767.    |
| char           | 16 bits | Represents a single 16-bit Unicode character.       |
| int            | 32 bits | Represents whole numbers from -2^31 to 2^31-1.      |
| long           | 64 bits | Represents whole numbers from -2^63 to 2^63-1.      |
| float          | 32 bits | Represents single-precision floating-point numbers. |
| double         | 64 bits | Represents double-precision floating-point numbers. |

## What is the Java Language Specification (JLS)?

The Java Language Specification (JLS) is a technical document that defines the syntax, semantics, and core libraries of the Java programming language. It serves as the authoritative reference for Java developers, providing detailed information about how the language works and how to use its features correctly.

It is the **syntax** and **semantics** of the Java programming language. The JLS is maintained by Oracle Corporation, the company that currently owns Java.

### Real World Applications of Java

Java is a widely used programming language that has found applications in various domains. Some of the real-world applications of Java include:

- **Desktop GUI Applications**: Java is used to create cross-platform desktop applications using frameworks like Swing and JavaFX.
  - We use APIs like AWT (Abstract Window Toolkit), Swing, and JavaFX to build graphical user interfaces (GUIs) for desktop applications.
  - Examples: Acrobat Reader, ThinkFree, Media Player, Antivirus Software, etc.
- **Mobile Applications**: Java is the primary language for Android app development.
  - A mobile application is a software application designed to run on mobile devices such as smartphones and tablets. The majority of phones and smart devices have AndroidOS and Android development is not possible without Java.
  - Examples: Photo and video gallery apps, Simple Calendar, Netflix, Tinder, QRReader, Google Earth, User, etc.
- **Enterprise Applications**: Java is widely used in large-scale enterprise applications, especially in server-side development.
  - Enterprise applications are large-scale software systems designed to support the needs of an organization. They often involve complex business logic, data management, and integration with other systems.
  - Examples: Banking systems, Inventory management systems, Customer relationship management (CRM) systems, etc.
- **Scientific Applications**: Java is used in scientific computing, simulations, and data analysis.
  - Scientific applications are software programs designed to perform complex calculations, simulations, and data analysis in various scientific fields.
  - Examples: MATLAB, Apache Commons Math, JScience, etc.
- **Web-based Applications**: Java is used for server-side development in web applications, often with frameworks like Spring and JavaServer Faces (JSF).
  - Web-based applications are software programs that run on web servers and can be accessed through web browsers. They often involve dynamic content generation and user interaction.
  - Examples: Online banking systems, E-commerce platforms, Social media websites, etc.
- **Embedded Systems**: Java is used in embedded systems and Internet of Things (IoT) devices.
  - Embedded systems are specialized computing devices designed to perform specific tasks within larger systems. They often have limited resources and require efficient programming.
  - Examples: Smart home devices, Industrial automation systems, Automotive control systems, etc.
- **Big Data Technologies**: Java is used in big data frameworks like Apache Hadoop and Apache Spark.
  - Big data technologies are software frameworks and tools designed to process and analyze large volumes of data efficiently. They often involve distributed computing and parallel processing.
  - Examples: Apache Hadoop, Apache Spark, Apache Flink, etc.
- **Distributed Systems**: Java is used in distributed systems and microservices architectures.
  - Distributed systems are collections of independent computing nodes that work together to achieve a common goal. They often involve communication between nodes over a network.
  - Examples: Apache Kafka, Apache ZooKeeper, Spring Cloud, etc.
- **Cloud-based Applications**: Java is used in cloud computing platforms and services.
  - Cloud-based applications are software programs that run on cloud infrastructure and can be accessed over the internet. They often involve scalability, reliability, and resource management.
  - Examples: Amazon Web Services (AWS), Google Cloud Platform (GCP), Microsoft Azure, etc.
- **Web Servers and Application Servers**: Java is used to build web servers and application servers that host web applications.
  - Web servers are software programs that handle HTTP requests and serve web content. Application servers provide additional functionality for running web applications, such as session management and database connectivity.
  - Examples: Apache Tomcat, Jetty, JBoss, GlassFish, etc.
- **Software Development Tools**: Java is used to build various software development tools and IDEs.
  - Software development tools are applications that assist developers in writing, testing, and maintaining code. They often provide features like code editing, debugging, and version control.
  - Examples: Eclipse, IntelliJ IDEA, NetBeans, etc.
- **Game Development**: Java is used in game development, especially for Android games.
  - Game development involves creating interactive software applications that provide entertainment or educational experiences. Java is often used for developing games on Android devices due to its portability and performance.
  - Examples: Minecraft, Runescape, and various Android games.

## Compilation Process

Compilation is the process of transforming a program written in a high-level programming from source code into object code or machine code that can be executed by a computer. Programmer write programs in a form called source code. Source code must go through several steps before it becomes an executable program.

The compilation process in Java involves several steps to convert Java source code into executable bytecode that can run on the Java Virtual Machine (JVM). The main steps in the Java compilation process are:

1. **Writing Source Code**: The programmer writes the Java source code in a text file with a `.java` extension. This code contains classes, methods, and other constructs defined by the Java language.
2. **Compilation**: The Java compiler (`javac`) takes the source code and compiles it into bytecode, which is an intermediate representation of the code. The bytecode is stored in a file with a `.class` extension. This step checks for syntax errors and ensures that the code adheres to the rules of the Java language.
3. **Bytecode Verification**: The JVM verifies the bytecode to ensure that it is valid and does not violate any security constraints. This step helps prevent malicious code from executing.
4. **Execution**: The JVM interprets or compiles the bytecode into machine code that can be executed by the underlying hardware. The JVM provides a runtime environment for executing Java programs, allowing them to run on any platform that has a compatible JVM installed. This is what makes Java platform-independent, as the same bytecode can run on different operating systems without modification.
5. **Garbage Collection**: During execution, the JVM manages memory allocation and deallocation. It automatically reclaims memory that is no longer in use by the program, a process known as garbage collection. This helps prevent memory leaks and ensures efficient memory usage.
6. **Output**: The program produces output based on the logic defined in the source code. This output can be displayed on the console, written to files, or sent over a network, depending on the program's functionality.

Java, being a platform-independent language, doesn't just have a single compilation step. Instead, it involves a two-step process execution. First, through an OS-independent compiler; and second, in a virtual machine (JVM) that is custom-built for each operating system. This allows Java programs to run on any device that has a JVM installed, regardless of the underlying hardware or operating system.

### Real World Application of Compilation Process

The two principle stages of the compilation process are explained below:

**Stage 1: Compilation**

First, the source `.java` file is passed through the compiler, which then encodes the source code into a machine-independent encoding, known as bytecode. The content of each class contained in the source file is stored in a separate `.class` file. While converting the source into the bytecode, the compiler follows the following steps:

- Parse
  - Reads a set of `*.java` source files and maps the resulting token sequence into an abstract syntax tree (AST) nodes.
- Enter
  - Enters symbols for the definitions into the symbol table, which is a data structure that stores information about symbols (like variables, methods, and classes) used in the program.
- Process Annotations
  - If requested, processes annotations found in the specified compilation units.
- Attribute
  - Attributes the Syntax Trees. This step includes name resolution, type checking, and constant folding.
- Flow
  - Performs dataflow analysis on the trees from the previous step. This includes checks for assignments and reachability.
- Generate
  - Generates `.class` files from the trees. This step involves converting the abstract syntax tree into bytecode that can be executed by the JVM.

**Stage 2: Execution**

The `.class` files generated by the compiler are independent of the machine or operating system. To run, the main class file (the class that contains the main method) is passed to the Java Virtual Machine (JVM) and then goes through the three main stages before the final machine code is executed:

- **ClassLoader**: The main class is loaded into the memory by passing its `.class` file to the JVM, through invoking the latter. All the other classes referenced in the program are loaded through the class loader as well.
- **Bytecode Verifier**: After the bytecode of a class is loaded by the class loader, it has to be inspected by the bytecode verifier, whose job is to check that the instructions in the bytecode are valid and do not violate any security constraints. The following are some of the checks performed by the bytecode verifier:
  - Variables are initialized before they are used.
  - Method calls match the types of object references.
  - Rules for accessing private data and methods are not violated.
  - Local variable accesses fall within the runtime stack limits.
  - The runtime stack does not overflow.
- **Just-In-Time (JIT) Compiler**: The JIT compiler compiles the bytecode into native machine code for the host system. This step is performed at runtime, allowing the JVM to optimize the execution of the code based on the current environment and usage patterns. The compiled machine code is then executed by the CPU.
  - This is the final stage encountered by the Java program, and its job is to convert the loaded bytecode into machine code.
  - When using a JIT compiler, the hardware can execute the native code, as opposed to having the JVM interpret the same sequence of instructions repeatedly.
  - This can lead to performance gains in the execution of Java programs, especially for long-running applications or those with performance-critical sections.

## JMV, JRE, and JDK

Programs that are written in Java are executed utilizing the Java Virtual Machine (JVM). The JVM is a special program that knows how to execute the programs that you write in Java. It is a part of the Java Runtime Environment (JRE), which provides the necessary libraries and components to run Java applications.

The Java Virtual Machine (JVM) is able to run our code because it runs our compiled bytecode. This is unique as it odes this in a virtual environment that is the same across all operating systems. This is known as the "write once, run anywhere" principle of Java. However, the JVM that you use is specific to the operating system that you are using. For example, if you are using Windows, you will use a Windows JVM, and if you are using macOS, you will use a macOS JVM.

In order to run our code it has something called the Just-In-Time (JIT) compiler. The JIT compiler is a part of the JVM that compiles the bytecode into machine code at runtime, allowing for faster execution of Java programs. The JIT turns your bytecode into machine code, in most instances on a line-by-line basis, so that it can be executed by the CPU. This allows Java programs to run efficiently on any platform that has a compatible JVM.

Thus, programs in Java are technically compiled twice: first into bytecode, and then into machine code by the JIT compiler at runtime.

In order to run Java code, you also need a Java Runtime Environment (JRE). This contains all the runtime libraries that your code wil be calling and using. The JRE contains the JVM within it, so if you want to run a Java program, all you need is the JRE. The JRE is a subset of the Java Development Kit (JDK), which is a complete development environment for Java programming.

But how do we actually compile the Java code? For that, we need a JDK - the Java Development Kit. The JDK provides developer tools like a compiler (`javac`), debugger, documentation tools, and other command-line utilities that are necessary for developing Java applications. The JDK includes the JRE, so you can run Java programs as well as develop them.

To put this in perspective:

- **JDK**: Contains everything needed to develop Java applications, including the compiler and JRE.
- **JRE**: Contains the JVM and libraries needed to run Java applications.
- **JVM**: The virtual machine that executes Java bytecode.

## Entities of Java

The 3 core entities that you will see in any Java file are:

- **Classes**: A class is a blueprint for creating objects. It defines the properties (attributes) and behaviors (methods) that the objects created from the class will have. In Java, every application must have at least one class, and the class name must match the filename.
  - Because real world entities have both state and behavior, classes in Java encapsulate both data (fields) and methods (functions) that operate on that data.
  - When naming a class, it is a convention to follow the PascalCase naming convention, where the first letter of each word is capitalized (e.g., `MyFirstClass`).
- **Methods**: A method is a block of code that performs a specific task. It is defined within a class and can be called to execute the code it contains. Methods can take parameters (inputs) and can return values (outputs). The `main` method is a special method in Java that serves as the entry point for the program.
  - When we talk about objects having behavior, we are referring to methods. Methods define what an object can do, and they can be called to perform actions or calculations.
  - Methods in Java usually represent some sort of action or behavior that the class can perform. They can take parameters and return values, allowing for interaction with the object's state.
  - Methods follow the camelCase naming convention, where the first letter of the first word is lowercase, and the first letter of subsequent words is capitalized (e.g., `calculateTotal`, `printDetails`).
- **Variables**: A variable is a named storage location in memory that holds a value. Variables can be of different data types, such as integers, floating-point numbers, characters, and booleans. In Java, variables must be declared with a specific data type before they can be used.
  - Variables represent the state of an object. They hold data that can be accessed and modified by methods within the class.
  - Variables in Java are declared with a specific data type, such as `int`, `double`, `String`, etc. The variable name follows the camelCase naming convention, similar to methods (e.g., `totalAmount`, `userName`).
  - When naming variables, it is important to choose descriptive names that convey the purpose of the variable.
  - They are usually written in camelCase, where the first letter of the first word is lowercase, and the first letter of subsequent words is capitalized (e.g., `totalAmount`, `userName`).
