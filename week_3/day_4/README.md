# OOP, Maven, and Developer Practices - Day 4

## What is a Database?

#### What is Data?

Data is information that is stored and used by applications. It can be anything from user information, product details, transaction records, to multimedia files. Data is essential for applications to function effectively and provide value to users.

In enterprise applications, data provides aggregated state information for the application. Businesses will use this data for various reasons including marketing, usage statistics, error reporting, and more. Data is specifically designed to provide insights and persistence information for the applications which they support.

#### What is a Database?

A database is an organized collection of data that is stored and managed in a way that allows for easy access, retrieval, and manipulation. Databases are used to store large amounts of information efficiently and securely.

It is a system of software and capabilities that make validating, storing, searching, filtering, aggregating, grouping, and administering data easier and more efficient. In enterprise applications, databases fall into two main categories: Relational Databases and NoSQL Databases.

#### SQL Databases

SQL (Structured Query Language) databases are a type of relational database that use a structured schema to define the organization of data. They are based on the relational model, which organizes data into tables (or relations) that can be linked—or related—based on data common to each. SQL databases are known for their ACID (Atomicity, Consistency, Isolation, Durability) properties, which ensure reliable transactions and data integrity.

#### NoSQL Databases

NoSQL (Not Only SQL) databases are a type of database that do not use a fixed schema and are designed to handle unstructured or semi-structured data. They are often used for big data applications and real-time web applications. NoSQL databases can be categorized into several types, including document stores, key-value stores, column-family stores, and graph databases. They are known for their scalability and flexibility.

### Real World Application

From the start of digital revolution, we have witnessed the utmost requirement for storing data effectively and efficiently. Data is the lifeblood of business solutions and having an accurate DBMS (Database Management System) is crucial for the success of any application.

Each DBMS has its own strengths and weaknesses, and the choice of which one to use depends on the specific needs of the application. Factors to consider include the type of data being stored, the volume of data, the required performance, and the complexity of the data relationships. By understanding the different types of databases and their use cases, developers can make informed decisions about how to best store and manage their application's data.

### Implementation

The general syntax for creating a `DATABASE` in **MySQL** is:

```sql
CREATE DATABASE database_name;
```

```sql
CREATE DATABASE employees_db;
```

The general syntax to use a newly created schema:

```sql
USE database_name;
```

```sql
USE employees_db;
```

## What is SQL?

SQL (Structured Query Language) is a standard programming language specifically designed for managing and manipulating relational databases. It provides a way to interact with the data stored in a database, allowing users to perform various operations such as querying, inserting, updating, and deleting data.

SQL is used to:

- Define database structure
- Manipulate stored data
- Define relationships between data
- Define data access controls
- Control concurrent access to data
- Query data

To accommodate these operations, SQL is broken into five main categories:

1. Data Query Language (DQL): Used for querying data from the database.

- Search, filter, group, aggregate data, etc.

2. Data Definition Language (DDL): Used for defining and managing database structures.

- Define tables, schemas, indexes, etc.

3. Data Manipulation Language (DML): Used for manipulating and managing data within the database.

- Insert, update, delete data, etc.

4. Data Control Language (DCL): Used for defining access controls and permissions.

- Grant, revoke permissions, etc.

5. Transaction Control Language (TCL): Used for managing transactions within the database.

- Commit, rollback transactions, etc.

Each category serves a specific purpose and provides a set of commands and functionalities tailored to that purpose.

SQL itself is generally case-insensitive, meaning that commands can be written in uppercase or lowercase without affecting their execution. However, it is common practice to write SQL keywords, table names, and column names in uppercase for better readability and to distinguish them from other elements in the query.

### Real World Application

SQL is used to administer SQL based RDBMS. Below is a short list of some databases and their enterprise users:

- Oracle
  - Wells Fargo
  - Verizon
  - Citi
  - ADP
  - FEMA
- MySQL
  - Wordpress
  - NASA
  - Netflix
  - YouTube
  - Bank of America
- PostgreSQL
  - Twitch
  - Apple
  - Spotify
  - Reddit
  - IMDb
- Microsoft SQL Server
  - Fisher Investments
  - Penske
  - Alarm.com
  - Citi
  - Humana
- MariaDB
  - Moodle
  - Samsung
  - Nokia
  - Red Hat
  - Select Quote
  - Walgreens
- MongoDB
  - Adobe
  - eBay
  - Expedia
  - Lyft
  - Square

### Implementation

SQL is developed based on the ANSI SQL Standard. However, there a lot of different vendor specific implementations available.
