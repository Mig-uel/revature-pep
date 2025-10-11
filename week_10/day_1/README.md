# Spring, HTML/CSS, JavaScript Introduction

## Spring Data Overview

Spring Data is a part of the larger Spring Framework that focuses on simplifying data access and manipulation in Java applications. It provides a consistent programming model for various data stores, including relational databases, NoSQL databases, and other types of data sources.

It aims to simplify database access and persistence in Spring applications by providing a set of abstractions and utilities that reduce boilerplate code and improve developer productivity. It provides a unified and consistent programming model for working with various data access technologies, including relational databases, NoSQL databases, and other types of data stores.

Key features of Spring Data include:

- **Abstraction Layers**: Spring Data provides a unified abstraction layer for different data stores, allowing developers to work with various databases using a consistent API. This abstraction layer allows developers to focus on application logic rather than low-level database interactions.
- **Repository Pattern**: At the core Spring Data is the Repository pattern, which offers a high-level interface for performing CRUD (Create, Read, Update, Delete) operations on entities. Developers can define repository interfaces, and Spring Data automatically generates the implementation at runtime.
- **Automatic Query Generation**: Spring Data can automatically generate queries based on method names in repository interfaces. You can also use the `@Query` annotation to define custom queries using JPQL (Java Persistence Query Language) or native SQL. This reduces the need for boilerplate code and makes it easier to perform complex queries.
- **Support for Various Data Stores**: Spring Data supports a wide range of data stores, including relational databases (e.g., MySQL, PostgreSQL), NoSQL databases (e.g., MongoDB, Cassandra), key-value stores (e.g., Redis), and more. This allows developers to choose the most suitable data store for their application needs.

### Real World Application

Knowing how to use Spring Data is crucial for building robust and efficient Java applications that interact with databases. Knowing how to use Spring Data is important for several reasons:

- **Rapid Development**: Spring Data accelerates development by reducing boilerplate code and providing a high-level abstraction for data access. This allows developers to focus on business logic rather than low-level database interactions.
- **Consistency**: Spring Data ensures a consistent approach to data access across teams and projects through its repository pattern and unified API. This consistency improves code maintainability and collaboration among developers.
- **Flexibility**: Spring Data supports various data stores, allowing developers to choose the most suitable database for their application needs. This flexibility is essential in modern applications that may require different types of data storage.
- **Testability**: Spring Data provides built-in support for testing data access layers, making it easier to write unit tests and integration tests for database interactions. This improves the overall quality of the application.
- **Performance and Scalability**: Spring Data includes features like pagination and sorting, which help optimize database queries and improve application performance. This is especially important for applications that handle large datasets.

### Implementation

#### Spring Data Commons

Spring Data Commons is a foundational module that provides shared infrastructure and utilities for various Spring Data projects. It includes core components such as the Repository abstraction, query derivation mechanisms, and support for pagination and sorting. Basically, it provides shared infrastructure and interfaces that are used to connect to different types of databases.

#### CrudRepository

`CrudRepository` is the most essential interface in Spring Data Commons. It provides basic CRUD (Create, Read, Update, Delete) operations for managing entities in a data store. By extending `CrudRepository`, you can easily perform common database operations without writing boilerplate code.

```java
public interface CrudRepository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    Optional<T> findById(ID id);
    boolean existsById(ID id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<ID> ids);
    long count();
    void deleteById(ID id);
    void delete(T entity);
    void deleteAll(Iterable<? extends T> entities);
    void deleteAll();
}
```

- `T`: The type of the entity to be managed.
- `ID`: The type of the entity's identifier (primary key).
- `Iterable<T>`: A collection of entities.

#### PagingAndSortingRepository

`PagingAndSortingRepository` extends `CrudRepository` and adds additional methods for pagination and sorting. This interface is useful when you need to retrieve large datasets in a paginated manner or sort results based on specific criteria.

```java
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
    Iterable<T> findAll(Sort sort);
    Page<T> findAll(Pageable pageable);
}
```

#### Custom Repositories

You can create custom repository interfaces by extending interfaces like `CrudRepository`, `PagingAndSortingRepository`, etc. This allows you to define your own methods for specific queries or operations that are not covered by the standard CRUD methods.

```java
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(String lastName);
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findStudentsOlderThan(@Param("age") int age);
}
```

In this example, `StudentRepository` extends `CrudRepository` and defines custom query methods to find students by their last name, first name and last name, and a custom query to find students older than a specified age.

So, based on the method's name, will Spring Data automatically generate the necessary query to fetch the data from the database? Yes, Spring Data will automatically generate the necessary query to fetch the data from the database based on the method's name. This feature is known as "query derivation" and is one of the key features of Spring Data.

When you define a method in a repository interface with a specific naming convention, Spring Data analyzes the method name and generates the corresponding query at runtime. The method name is parsed to determine the entity properties involved in the query and the type of operation (e.g., find, count, delete).

Can you override the automatically generated query with a custom query? Yes, you can override the automatically generated query with a custom query by using the `@Query` annotation. This allows you to define your own JPQL (Java Persistence Query Language) or native SQL queries for more complex scenarios that cannot be easily expressed through method names.

#### Spring Data Modules

##### Spring Data JPA

Spring Data JPA is a module of Spring Data that provides integration with the Java Persistence API (JPA). It simplifies the implementation of data access layers for relational databases by providing a repository abstraction and support for JPA entities.

##### Dependency

```xml
<dependency>
  <groupId>org.springframework.data</groupId>
  <artifactId>spring-data-jpa</artifactId>
</dependency>
```

##### JpaRepository Interface

`JpaRepository` is a sub-interface of `PagingAndSortingRepository` that provides additional JPA-specific methods for managing entities. It includes methods for flushing the persistence context, deleting entities in batches, and more.

```java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
    <S extends T> saveAndFlush(S entity); // Saves an entity and flushes changes instantly
    void deleteInBatch(Iterable<T> entities); // Deletes the given entities in a batch
    void deleteAllInBatch(); // Deletes all entities in a batch
}
```

##### Spring Data MongoDB

Spring Data MongoDB provides integration with MongoDB, a popular NoSQL database. It offers a repository abstraction and support for MongoDB documents.

##### MongoRepository Interface

`MongoRepository` is a sub-interface of `PagingAndSortingRepository` that provides additional methods specific to MongoDB. It includes methods for working with MongoDB documents and collections.

```java
public interface MongoRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
    <S extends T> List<S> findAll(Example<S> example); // Finds all entities matching the given example
    <S extends T> List<S> findAll(Example<S> example, Sort sort); // Finds all entities matching the given example with sorting
}
```

##### Spring Data REST

Spring Data REST is a module that automatically exposes Spring Data repositories as RESTful web services. It allows you to create RESTful APIs for your data models without writing any additional code.

```java
@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByLastName(@Param("name") String name);
}
```

So now with this annotation, Spring Data REST will automatically create RESTful endpoints for the `Student` entity, allowing you to perform CRUD operations and query the data using HTTP methods. You can access the endpoints at `/students` and use query parameters to filter results, such as `/students/search/findByLastName?name=Smith`.

## Video - Spring Data

- Spring Data is a powerful tool for simplifying the process of working with databases in Java applications.
- It automates common tasks such as creating, reading, updating, and deleting records, allowing developers to focus on business logic rather than boilerplate code.

### Working with Data in Java Using JPA, Hibernate, and Spring Data JPA

- JPA (Java Persistence API): Rules for working with relational data in Java
  - JPA is a specification that described the management of relational data in Java applications. Basically, it provides a set of interfaces and annotations for mapping Java objects to database tables and performing CRUD operations.
- Hibernate: An implementation of JPA
  - Hibernate is a popular open-source ORM (Object-Relational Mapping) framework that implements the JPA specification to allow developers to map plain old Java objects (POJOs) to database tables and vice versa.
- Spring Data JPA: Simplifies work with databases in Spring applications

  - Spring Data JPA is a part of the larger Spring Data project that provides a high-level abstraction for working with JPA and Hibernate in Spring applications. It simplifies the process of creating repositories, performing CRUD operations, and executing queries.`

- JPA, Hibernate, and Spring Data JPA are all related technologies that work together to simplify the process of working with relational data in Java applications. Each tool has its own unique features and benefits, and they can be used together to create robust and efficient data access layers in Java applications.

### Creating a Repository Interface with Spring Data JPA

- A repository interface is a powerful tool for accessing data in a Spring Data JPA application. It provides basic operations to create, read, update, and delete data for specific entity types.

```java
@Entity
@Table(name = "employees")
public class Employee {
  @Id
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  // Getters and setters
}
```

- To create a repository interface for the `Employee` entity, you would define an interface that extends the `JpaRepository` interface provided by Spring Data JPA.

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
```

- The `EmployeeRepository` interface extends `JpaRepository`, which provides a set of standard CRUD operations for the `Employee` entity. The first generic parameter is the entity type (`Employee`), and the second parameter is the type of the entity's primary key (`Long`).
- By extending `JpaRepository`, the `EmployeeRepository` interface automatically inherits methods for common database operations, such as `save()`, `findById()`, `findAll()`, `deleteById()`, and more. This allows you to perform these operations without writing any additional code.

### Benefits of Using JpaRepository for Data Access Layers

- What is `JpaRepository`?
  - `JpaRepository` is a part of the Spring Data JPA framework that provides a set of standard methods for performing CRUD (Create, Read, Update, Delete) operations on entities in a relational database. It extends the basic `Repository` interface and adds additional methods for common database operations.
- Benefits of Using `JpaRepository`:
  - By extending `JpaRepository`, your custom Repository interfaces automatically inherit a wide range of methods for performing common database operations, such as saving, finding, updating, and deleting entities. This reduces the amount of boilerplate code you need to write and allows you to focus on your application's business logic.

### Custom Query Methods in Spring Data JPA

- Spring Data JPA allows you to define custom query methods in your repository interfaces by following a specific naming convention. This feature is known as "query derivation" and enables you to create queries based on the names of the methods you define.
- These methods are automatically implemented by Spring Data JPA at runtime based on their naming conventions. This means you don't have to write the actual query logic; Spring Data JPA generates it for you based on the method name.

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByLastName(String lastName); // Finds employees by their last name
  List<Employee> findByFirstNameAndLastName(String firstName, String lastName); // Finds employees by their first and last names
}
```

- In this example, the `EmployeeRepository` interface defines two custom query methods: `findByLastName` and `findByFirstNameAndLastName`. Spring Data JPA will automatically generate the necessary queries to fetch employees based on the provided criteria.

### Using Spring Data JPA to Create Complex Queries Easily

- We can use these keywords to create complex queries by combining multiple conditions in a single method name.

Some commonly used keywords include:

- `AND`
  - Combines two conditions, both must be true.
- `OR`
  - Combines two conditions, at least one must be true.
- `IS`
  - Checks if a given condition is true.
- `EQUALS`
  - Checks for equality.
- `GreaterThan`
  - Checks if a value is greater than another.
- `LessThan`
  - Checks if a value is less than another.
- `LIKE`
  - Used for pattern matching in strings.
- `NotLike`
  - Used for negating pattern matching in strings.
- `IN`
  - Checks if a value is within a specified set of values.
- `NotIn`
  - Checks if a value is not within a specified set of values.

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByLastNameAndFirstName(String lastName, String firstName);
  List<Employee> findByAgeGreaterThan(int age);
  List<Employee> findByFirstNameLike(String pattern);
  List<Employee> findByDepartmentIn(List<String> departments);
```

### Exploring Advanced Features of JpaRepository

- Pagination
  - Pagination is the process of dividing a large dataset into smaller, more manageable chunks or pages. In Spring Data JPA, pagination is supported through the `Pageable` interface, which allows you to specify the page number, page size, and sorting criteria for your queries.

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  Page<Employee> findByLastName(String lastName, Pageable pageable);
}
```

- `findByLastName` method retrieves a paginated list of employees with the specified last name. The `Pageable` parameter allows you to specify the page number, page size, and sorting criteria.

- Sorting
  - Sorting is the process of arranging data in a specific order based on one or more attributes. In Spring Data JPA, sorting is supported through the `Sort` class, which allows you to specify the sorting criteria for your queries.

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);
}
```

- `findByLastNameOrderByFirstNameAsc` method retrieves a list of employees with the specified last name, sorted in ascending order by their first name. You can also use `Desc` to sort in descending order.
- How does it work?
  - When you define a method in a repository interface with a specific naming convention, Spring Data JPA analyzes the method name and generates the corresponding query at runtime. The method name is parsed to determine the entity properties involved in the query and the type of operation (e.g., find, count, delete).

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  long countByLastName(String lastName); // Counts the number of employees with the specified last name
}
```

- `countByLastName` method counts the number of employees with the specified last name. Spring Data JPA generates the necessary query to perform the count operation based on the method name.

### Getting Started with Spring Data JPA

- Configure your Data Source
  - To use Spring Data JPA, you need to configure a data source in your Spring application. This typically involves specifying the database connection details, such as the URL, username, password, and driver class name.

```bash
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update # Options: validate | update | create | create-drop
spring.jpa.show-sql=true # Show SQL statements in the console
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect # Specify the Hibernate dialect for your database
spring.jpa.properties.hibernate.format_sql=true # Format SQL statements for better readability
spring.jpa.properties.hibernate.jdbc.batch_size=50 # Enable JDBC batch processing for performance optimization
```

## Relationship Between JPA, Hibernate, and Spring Data JPA

The Java Persistence API (JPA), Hibernate, and Spring Data JPA are all related technologies that work together to simplify the process of working with relational data in Java applications.

#### Java Persistence API (JPA)

JPA is a specification that defines a standard for Object-Relational Mapping (ORM) in Java. It outlines the mapping between Java classes and database tables, as well as the management of entity lifecycle and queries. This allows developers to interact with relational databases using Java objects, rather than writing raw SQL queries. JPA provides a set of annotations and APIs for defining how Java objects are mapped to database tables, define relationships between entities, and perform CRUD operations.

#### Hibernate

Hibernate is a popular open-source ORM framework that provides an implementation of the JPA specification. It is one of the most widely used JPA providers and offers additional features beyond the JPA standard. It goes beyond the standard specifications and offers additional features such as caching, lazy loading, dirty checking, and more. Hibernate converts Java objects into SQL statements and executes them against the database, handling the complexities of database interactions. This allows developers to interact with databases using high-level Java APIs and objects rather than writing low-level SQL queries.

#### Spring Data JPA

Spring Data JPA is a part of the larger Spring Data project that provides a high-level abstraction for working with JPA and Hibernate in Spring applications. It makes it easier to implement JPA-based repositories by providing a set of interfaces and annotations that simplify the creation of data access layers. It is a data access abstraction that works on top of the ORM framework (like Hibernate) and provides a way to reduce boilerplate code when working with databases in Spring applications. With Spring Data JPA, developers can define repository interfaces that extend the `JpaRepository` interface, which provides a set of standard CRUD operations and query methods. Spring Data JPA also supports custom query methods based on method names, pagination, sorting, and more. It provides ready-to-use interfaces and allows developers to define custom query methods based on method names, reducing the need for boilerplate code. Developers can perform complex database operations with minimal code.

#### The Relationship

In a typical Spring Data JPA setup, JPA provides the standard specification for ORM, Hibernate provides the implementation of that specification, and Spring Data JPA provides a higher-level abstraction for working with JPA and Hibernate in Spring applications. Together, these technologies enable developers to build robust and efficient data access layers in Java applications with minimal effort.

### Real World Application

In enterprise-level applications, the integration of JPA, Hibernate, and Spring Data JPA is crucial for building robust and efficient data access layers. Here are a few real-world examples of how these technologies are used together:

#### eCommerce Platforms

Consider large eCommerce platforms like Amazon or eBay. These platforms have complex data models with numerous relationships between entities such as users, products, orders, reviews, etc. The use of JPA and Hibernate allows these complex relationships to be handled smoothly, mapping entities to database tables and managing their lifecycle. Spring Data JPA simplifies the data access layer, making it easier to implement the repositories needed to perform CRUD operations on these entities.

#### Content Management Systems (CMS)

Content Management Systems like WordPress or Drupal also benefit from these technologies. They need to manage a variety of content types such as posts, comments, tags, and users. JPA and Hibernate handle the mapping of these entities to the underlying database, while Spring Data JPA reduces the boilerplate code required to implement the data access layer, allowing developers to focus on business logic.

#### Banking and Financial Systems

Banking and financial systems deal with many entities like customers, accounts, transactions, and loans. These systems require robust and efficient data access mechanism to ensure data integrity and consistency. The combination of JPA, Hibernate, and Spring Data JPA allows these systems to manage their data effectively, with transactions and concurrency control provided by JPA and Hibernate, and simplified repository implementations provided by Spring Data JPA. Spring Data JPA's easy-to-use repository streamline the development of the data access layer.

#### Enterprise Resource Planning (ERP) Systems

ERP systems like SAP or Oracle ERP manage vast amounts of data across different domains such as finance, HR, sales, and procurement. JPA, Hibernate, and Spring Data JPA can model the complex relationships between these entities and manage them efficiently. The abstraction provided by Spring Data JPA significantly reduces code complexity, making it easier to maintain and extend the data access layer as the system evolves.

In all these scenarios, the use of JPA, Hibernate, and Spring Data JPA reduces the amount of code needed, simplifies the data access layer, and ensures efficient and reliable interactions with the database.

### Implementation

This example demonstrates a Spring Data JPA project with Hibernate as the JPA provider. Assume the following dependencies are used in the project: Spring Web, Spring Data JPA, and a database driver (e.g., H2, MySQL, PostgreSQL).

##### Database Configuration

In the `application.properties` file, configure the datasource and JPA properties:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

##### Entity Class

To represent a database entity, create a new class annotated with `@Entity`. For example, in a simple book management system, you might have a `Book` entity:

```java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Primary key with auto-generation
    private Long id;
    private String title;
    private String author;

    // Getters and Setters
}
```

The `@Table` annotation is optional. If you don't specify it, JPA will use the class name as the table name by default. However, if you want to customize the table name or specify additional table properties (like schema), you can use the `@Table` annotation.

##### Creating a Repository

Create a new interface that extends `JpaRepository` to manage the `Book` entity:

```java
public interface BookRepository extends JpaRepository<Book, Long> {}
```

#### Using the Repository in a Service

`Autowire` the `BookRepository` in a service class to perform CRUD operations:

```java
@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }
}
```

These steps show how to set up a basic Spring Data JPA project with Hibernate as the JPA provider. You can further extend this example by adding more entities, custom query methods, and RESTful endpoints using Spring Web.

## JpaRepository vs CrudRepository

In Spring Data JPA, both `JpaRepository` and `CrudRepository` are interfaces that automatically provide CRUD (Create, Read, Update, Delete) operations for managing entities in a database. They provide an abstraction layer over the underlying data persistence system, enabling developers to interact with the database using high-level Java APIs rather than writing low-level SQL queries.

#### CrudRepository

`CrudRepository` is a simple interface provided by Spring Data JPA that defines basic CRUD operations for managing entities. It includes methods such as `save()`, `findById()`, `findAll()`, `deleteById()`, and more. It is a generic interface that takes two parameters: the entity type and the type of the entity's identifier (primary key).

```java
public interface CrudRepository<T, ID> extends Repository<T, ID> {}
```

#### JpaRepository

`JpaRepository` is an interface that extends `CrudRepository` and `PagingAndSortingRepository`. It contains all the methods provided by these two interfaces, along with additional JPA-specific methods such as:

- Pagination and sorting support (`findAll(Pageable pageable)`, `findAll(Sort sort)`)
- Flushing the persistence context (`flush()`)
- Refreshing entities (`refresh(T entity)`)
- Saving and flushing an entity in a single call (`saveAndFlush(S entity)`)
- Locking instances for concurrent access (`lock(T entity, LockModeType lockMode)`)
- Creating `TypedQuery` or `Query` instances for JPQL or native SQL queries

```java
public interface PersonRepository extends JpaRepository<Person, Long> {}
```

`JpaRepository` is generally more feature rich than `CrudRepository`, making it suitable for complex applications that require advanced data access capabilities. However, these additional features can add complexity compared to the simpler `CrudRepository`.

#### Comparison

- `CrudRepository`: Best for simple applications requiring only basic CRUD operations.
- `JpaRepository`: Ideal for complex applications that require advanced JPA features, pagination, sorting, and more.

### Real World Application

#### Web Applications

Web applications that require persistent data storage (e.g., e-commerce sites, content management systems) benefit from Spring Data JPA's simplicity and efficiency in handling database operations.

#### Microservices

Each microservice often maintains its own database. Spring Data JPA helps handle persistence efficiently at the service level, simplifying data access and manipulation.

#### Enterprise Applications

Enterprise applications with complex business logic benefit from Spring Data JPA's robust ORM capabilities, especially when combined with Hibernate.

#### Use Cases

- **User Management Systems**: Manage relationships between users, roles, and permissions efficiently.
- **E-commerce Applications**: Handle products, orders, and customer records more cleanly that with raw SQL.
- **Content Management Systems**: Simplify frequent database interactions by reducing boilerplate code.
- **Data Analytics Platforms**: Manage large transactions and complex queries with strong transaction management support.

Spring Data JPA is a robust framework but it is best suited for relational database interactions that require maintainability, flexibility, and scalability. It is not ideal for applications that require low-level database access or complex queries that cannot be easily expressed through JPA.

### Implementation

Example process for implementing `JpaRepository` or `CrudRepository` using Spring Data JPA.

#### Step 1: Create a Spring Boot Project

Use [Spring Initializr](https://start.spring.io/) to create a new Spring Boot project with the following dependencies:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- Example: H2 in-memory database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

#### Step 2: Configure the DataSource

In the `application.properties` file, configure the datasource and JPA properties:

```bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

#### Step 3: Create an Entity

Example `Person` entity:

```java
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
```

#### Step 4: Create a Repository Interface

Example using `JpaRepository`:

```java
public interface PersonRepository extends JpaRepository<Person, Long> {}
```

#### Step 5: Use the Repository in a Service

```java
@Service
public class PersonService {
  @Autowired
  private final PersonRepository personRepository;

  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  public Person savePerson(Person person) {
    return personRepository.save(person);
  }
}
```

#### Step 6: Example in `main` method (for testing purposes)

Although not typical in production code, you can test the repository in the `main` method:

```java
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Application.class, args);
    PersonService personService = context.getBean(PersonService.class);

    Person person = new Person();
    person.setName("John Doe");
    person.setEmail("john.doe@example.com");

    personService.savePerson(person);

    List<Person> persons = personService.getAllPersons();

    persons.forEach(p -> System.out.println(p.getName() + " - " + p.getEmail()));
  }
}
```

With these steps, you now have a basic Spring Data JPA application using `JpaRepository`. You can easily switch to `CrudRepository` by changing the repository interface to extend `CrudRepository` instead of `JpaRepository`, but you will lose the additional features provided by `JpaRepository`.

## Property Expression

In Spring Data JPA, property expressions are used to define query methods in repository interfaces based on the names of the entity's properties. This feature allows developers to create queries by simply defining method names that follow a specific naming convention, without the need to write explicit JPQL or SQL queries.

They are an integral part of the query derivation mechanism in Spring Data JPA, which automatically generates queries based on the method names defined in repository interfaces.

#### What are Property Expressions?

Property expressions are parts of method names in repository interfaces that correspond to the properties (fields) of the entity class. They are used to specify the criteria for querying the database.

Property expressions refer to the chaining of properties within method names. These expression form the `findBy`, `readBy`, `getBy`, `queryBy`, `countBy`, and `deleteBy` keywords followed by the property names of the entity.

For example, if we have a `User` entity with properties `name` and `age`, and want to find users by their name, we could define a method in the repository interface like this:

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByName(String name); // Finds users by their name
}
```

In this example, `findByName` is a method that uses the property expression `Name`, which corresponds to the `name` property of the `User` entity. Spring Data JPA will automatically generate the necessary query to fetch users with the specified name.

#### Handling Nested Properties

Property expressions can also handle or reference nested properties of related entities. Suppose our `User` entity has a relationship with an `Address` entity, and we want to find users based on their city. We can define a method like this:

```java
@Entity
public class User {
  // Other properties/fields
  private Address address; // Relationship with Address entity
}
```

Supposed the `Address` entity has a property `country`. In that case, we can find users based on their address's country using a nested property expression:

```java
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByAddress_Country(String country); // Finds users by their address's country
}
```

In this example, `findByAddress_Country` uses the nested property expression `Address_Country`, which corresponds to the `country` property of the related `Address` entity. Spring Data JPA will generate the necessary query to fetch users based on their address's country.

#### Resolving Ambiguities

Sometimes, a property expression can match more than one property in the entity (e.g. when properties have similar names but exist in different nested entities). In such cases, Spring Data JPA allows the use of `@Param` annotation in method parameters to explicitly specify which property to use in the query.

```java
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByAddress_Country(@Param("country") String country); // Explicitly specify the parameter name
}
```

Property expressions are a powerful feature of Spring Data JPA that simplifies the process of creating queries based on entity properties. By following the naming conventions and using property expressions, developers can easily define query methods in repository interfaces without writing explicit queries, making data access more efficient and maintainable.

### Real World Application

Property expressions in Spring Data JPA offer a concise and readable way to define queries based on method names and entity properties in repository interfaces. This feature is widely applicable in real-world scenarios where querying based on entity properties is required.

#### E-commerce Applications

Consider an e-commerce application with entities like `User`, `Product`, and `Order`. Users can place orders for a variety of products. Property expressions can be used to define query methods in repository interfaces to retrieve orders based on user information or product details. The `Order` entity might look like this:

```java
@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private User user; // Relationship with User entity
  private Product product; // Relationship with Product entity
  private LocalDate orderDate;

  // Getters and Setters
}
```

We cab define queries in an `OrderRepository` interface using property expressions:

```java
public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findByUser_Name(String name); // Finds orders by user's name
  List<Order> findByProduct_Category(String category); // Finds orders by product's category
  List<Order> findByOrderDate(LocalDate orderDate); // Finds orders by order date
}
```

- `findByUser_Name`: Retrieves orders placed by users with a specific name.
- `findByProduct_Category`: Retrieves orders for products in a specific category.
- `findByOrderDate`: Retrieves orders placed on a specific date.

This approach simplifies writing complex queries in large applications with multiple entities and relationships.

### Implementation

Property expressions in Spring Data JPA allow you to create complex queries by defining methods in repository interfaces based on the names of entity properties.

#### Step 1: Define the Entity

Example `User` entity with nested `Address` entity:

```java
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  @Embedded // Embedded annotation marks Address as a value type
  private Address address; // Relationship with Address entity

  // Getters and Setters
}
```

#### Step 2: Define the Repository Interface

```java
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByName(String name); // Finds users by their name
  List<User> findByAddress_Country(String country); // Finds users by their address's country
}
```

- `findByName`: Finds users based on the `name` property.
- `findByAddress_Country`: Finds users based on the `country` property of the nested `Address` entity.

#### Step 3: Use the Repository in a Service

```java
@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getUsersByName(String name) {
    return userRepository.findByName(name);
  }

  public List<User> getUsersByCountry(String country) {
    return userRepository.findByAddress_Country(country);
  }
}
```

And that's it! You can easily create complex queries using property expressions in Spring Data JPA by defining methods in repository interfaces based on entity properties. This approach simplifies the process of querying data and reduces boilerplate code.
