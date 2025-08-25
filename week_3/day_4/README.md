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

## Consistency

#### Database Consistency

Database consistency is the property that ensures that a database remains in a valid state before and after a transaction. It guarantees that any changes made to the database will not violate any predefined rules or constraints, such as data types, relationships, and integrity constraints.

In the context of ACID (Atomicity, Consistency, Isolation, Durability) properties, consistency ensures that:

- All data must be valid according to the defined rules and constraints.
- Any transaction that violates these rules will be rolled back, leaving the database in its previous valid state.
- The database will always transition from one valid state to another valid state.

Maintaining consistency is crucial for ensuring the reliability and integrity of the data stored in a database, especially in multi-user environments where concurrent transactions may occur.

While database consistency helps ensure the appropriate format for data written to the database, it does not account for what the data actually represents or its meaning within the application context. This means that information entered may match the expected data type and format, but it may not be accurate or relevant to the application's needs.

These rules applied to our data is what keeps databases working smoothly by ensuring that all data adheres to the defined structure and constraints.

#### Database Inconsistency

Database inconsistency occurs when the data in a database does not adhere to the defined rules, constraints, or integrity conditions.

Database consistency also applies to any changes of the data within the system. If one particular object in the database is updated, but also is present in another table in the database, it can lead to inconsistencies if the changes are not propagated correctly. This can result in conflicting or outdated information being displayed to users or applications, undermining the reliability of the database.

Database inconsistency can arise from various factors, including:

- **Concurrent Updates**: When multiple transactions attempt to update the same data simultaneously without proper locking mechanisms, it can lead to conflicting changes.
- **Application Bugs**: Errors in application logic can result in invalid data being written to the database, violating integrity constraints.
- **Data Migration Issues**: During data migration or integration processes, inconsistencies can occur if the data is not transformed or mapped correctly.

This mostly happens when any portion of the information in the table is updated, but the corresponding information in related tables is not updated accordingly.

### Real World Application

#### Database Consistency

Image working at the New York DMV and you have been asked to work on the database for the new Driver's License. Due to growing population sizes, they have required a new Driver's License number to help identify individuals. Your team has determined that every individuals driver's license number must include the following:

- 1 Alpha Character
- 6 Numeric Characters
- 1 Alpha Character

All driver license numbers are now required to follow this rule, such that "P123456A" is a valid driver's license number, while "1234567A" is not. Any entry that does not fit those requirements would result in error for inconsistent data.

#### Database Inconsistency

Keeping the driver's license example, imagine a driver's home address changes. This update must be represented across all tables where that prior address existed. If any table is not updated, then the database is now inconsistent. This could lead to issues such as:

- The individual not receiving important mail at their new address.
- Legal documents being sent to the wrong address.
- Inability to verify the individual's identity due to mismatched information.

### Implementation

Database consistency implementation, which involves specific constraints, triggers, variables, cascades, etc., will be covered in detail in the database section of this course. These elements are established based on the rules set by you as a developer. Always keep in mind, "how is this affecting my data's consistency?" when designing your database.
