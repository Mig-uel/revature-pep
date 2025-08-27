# SQL Basics and JDBC - Day 2

## Constraints

SQL constraints are used to help validate data beyond just a simple data type. Below is a set of commonly used SQL constraints:

| Constraint    | Use                                                                                                                                        |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| `NOT NULL`    | Ensures that a column cannot have a NULL value.                                                                                            |
| `UNIQUE`      | Ensures that all values in a column are different.                                                                                         |
| `PRIMARY KEY` | Uniquely identifies each record in a table. Combines `NOT NULL` and `UNIQUE` constraints.                                                  |
| `FOREIGN KEY` | Establishes a relationship between two tables by referencing the primary key of another table. Prevents destruction of the linked records. |
| `DEFAULT`     | Sets a default value for a column if no value is specified during insertion.                                                               |
| `CHECK`       | Ensures that all values in a column satisfy a specific condition.                                                                          |

Each column of a table can use a combination of these constraints, but some are mutually exclusive in some vendors or contexts (e.g., a column cannot be both `PRIMARY KEY` and `FOREIGN KEY`). For instance:

- Although it is possible to define a column as both `NOT NULL` and `DEFAULT`, they serve different purposes. `NOT NULL` ensures that a value is always provided, while `DEFAULT` provides a fallback value if none is given. Using both together ensures that the column always contains a valid value.
- `DEFAULT` can be used with `CHECK` to ensure that the default value adheres to the specified condition but it can also lead to conflicting requirements if not managed carefully.
- Since a `FOREIGN KEY` constraint establishes a relationship between two tables based on the values of a column in both tables, using a `CHECK` constraint to enforce similar conditions on the foreign key column can lead to redundancy and potential conflicts.
- Lastly, a `PRIMARY KEY` constraint implies that a column (or a set of columns) is both `NOT NULL` and `UNIQUE`, so explicitly defining these constraints alongside a primary key is unnecessary and could lead to confusion.

Constraints are used to define a database schema and are the backbone for defining `integrity constraints`, which ensure the accuracy and consistency of the data within the database.

`Integrity constraints` are rules or conditions defined on a database schema to maintain the accuracy, consistency, and reliability of data within a database. It collectively helps maintain the quality of the data by preventing invalid data entry and ensuring that relationships between tables remain consistent. They play a crucial role in upholding the overall integrity of the data model and supporting data accuracy and reliability.

### Real World Application

Constraints are tied directly to the table and define the integrity of the data as part of the schema. Administrators can use these constraints to enforce business rules at the database level, ensuring that the data remains accurate and consistent. For example, a `CHECK` constraint could be used to ensure that a column representing an employee's age only contains values greater than zero, while a `FOREIGN KEY` constraint could be used to ensure that all orders in an `Orders` table reference valid customers in a `Customers` table.

Table 1: Vendor

```sql
CREATE TABLE Vendor (
  vendorID CHAR(2) NOT NULL,
  vendorName VARCHAR(25) UNIQUE NOT NULL,
  PRIMARY KEY (vendorID)
)
```

This table demonstrates the `NOT NULL`, `UNIQUE`, and `PRIMARY KEY` constraints. The `vendorID` column cannot be null and serves as the primary key, ensuring each vendor has a unique identifier. The `vendorName` column must also be unique and cannot be null, preventing duplicate vendor names.

Table 2: Sales Transaction

```sql
CREATE TABLE SalesTransaction (
  transactionID VARCHAR(8) PRIMARY KEY,
  customerID CHAR(7) NOT NULL REFERENCES Customer(customerID),
  storeId INT NOT NULL REFERENCES Store(storeId),

  -- Using DEFAULT to default the current date
  -- Date cannot be null because a default value is provided
  transactionDate DATE DEFAULT NOW()
)
```

This table demonstrates the use of `NOT NULL`, `FOREIGN KEY`, and `DEFAULT` constraints. The `transactionID` column is the primary key and cannot be null. The `customerID` and `storeId` columns are foreign keys that reference the `Customer` and `Store` tables, respectively, ensuring referential integrity. The `transactionDate` column has a default value of the current date, ensuring that it always contains a valid date.

### Implementation

Adding constraints to a column can be done when the table is created or afterward if the requirements should change. Specific discussion on the command associated with creating or altering tables will be covered in a later lesson.

```sql
-- Adding constraints when creating a table
CREATE TABLE <table_name> (
  column_name data_type CONSTRAINT constraint_name
)
```

```sql
-- Adding constraints after creating a table
ALTER TABLE <table_name> ADD CONSTRAINT constraint_name CHECK (condition);
```

## Auto Incrementing

`AUTO INCREMENT`

- Used to generate a unique number when a new record is inserted into a table.

---

`SERIAL`

- A data type in PostgreSQL that auto-increments integer values.

---

`IDENTITY`

- A property in SQL Server that auto-increments integer values.

---

Most often, `AUTO INCREMENT` or `SERIAL` acts as a primary key field that is created automatically every time a new record is inserted.

The dialect of SQL you are using will determine if you use the `AUTO INCREMENT` or `SERIAL` keyword.

While the concepts are the same, different databases may have different syntax or keywords for implementing auto-incrementing fields. It is important to refer to the documentation of the specific database system you are using to understand the correct syntax and options available for auto-incrementing fields.

- **PostgreSQL**: Use `SERIAL` or `BIGSERIAL` data types.
  - Implicitly creates a sequence object to generate unique values.
- **MySQL**: Use `AUTO_INCREMENT` attribute.
  - Automatically increments the value for each new row.
- **SQL Server**: Use `IDENTITY` property.
  - Automatically increments the value for each new row.

### Real World Application

Consider a table where we want to keep track of users. Users should not have the same identifier, so as a new user is added to the database, we want to auto-increment their ID.

```sql
CREATE TABLE users (
  user_id SERIAL PRIMARY KEY, -- Auto-incrementing user ID
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(100),
  city VARCHAR(50),
  state CHAR(2),
  zip CHAR(5),
  social_security CHAR(11),
  username VARCHAR(20),
  password VARCHAR(20),
  email VARCHAR(50)
)
```

### Implementation

Syntax to create a table with `employee_id` as an auto-incrementing primary key:

```sql
CREATE TABLE table_name(
variable_name variable_datatype AUTO_INCREMENT
);
```

Example:

```sql
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(50),
    department_id INT
);
```

This same table written using `SERIAL` would look like this:

```sql
CREATE TABLE table_name (
    variable_name SERIAL PRIMARY KEY
);
```

Example:

```sql
CREATE TABLE employees (
    employee_id SERIAL PRIMARY KEY,
    employee_name VARCHAR(50),
    department_id INT
);
```

Notice that the syntax for defining an auto-incrementing primary key differs between MySQL and PostgreSQL. In MySQL, we use `AUTO_INCREMENT`, while in PostgreSQL, we use `SERIAL`. Always refer to the documentation for the specific SQL dialect you are using to ensure correct syntax.

You can modify auto-incremented values, but it is generally not recommended as it can lead to data integrity issues. If you need to reset or change the auto-increment value, use the appropriate command for your database system.

```sql
-- MySQL
ALTER TABLE employees AUTO_INCREMENT = 100;

-- PostgreSQL
ALTER SEQUENCE employees_employee_id_seq RESTART WITH 100;
```

## CHECK

The `CHECK` constraint is used to limit the value range that can be placed in a column. If you define a `CHECK` constraint on a single column, it allows only certain values for this column.

It determines whether the value associated with the column is valid or not based on the given condition. And, it helps to check what types of values are to be stored in a table's column.

### Real World Application

The `CHECK` constraint in SQL is use to enforce specific conditions on the data being inserted or updated in a table. This constraint ensures that values in a column meet a certain condition, helping to maintain data integrity and accuracy by preventing invalid data entries.

- **Data Validation**: Developers might use `CHECK` to validate values that can be entered into a column. For example, ensuring that an age column only contains values greater than 0.

- **Date and Time Constraints**: Developers can use `CHECK` constraints to ensure that date and time values fall within a specific range. For example, a `CHECK` constraint could be used to ensure that a `start_date` is always before an `end_date`.

- **Enum-like Behavior**: While SQL does not have a built-in enum type, developers can use `CHECK` constraints to simulate this behavior. For example, a `CHECK` constraint could be used to ensure that a `status` column only contains specific values like 'active', 'inactive', or 'pending'.

An aquarium database may use the `CHECK` constraint to ensure that the tank size and temperature values for a fish tank are within acceptable ranges.

```sql
CREATE TABLE FishTank (
  FishID INT PRIMARY KEY,
  Species VARCHAR(50),
  -- Ensure tank size is positive and not too large
  TankSize DECIMAL CHECK(TankSize > 0 AND TankSize <= 100),
  -- Ensure temperature is within a suitable range for most fish
  Temperature DECIMAL CHECK(Temperature >= 0 AND Temperature <= 30)
)
```

In this example, the `CHECK` constraints ensure that the `TankSize` is a positive value and does not exceed 100, and that the `Temperature` is within a range suitable for most fish (0 to 30 degrees Celsius). This helps maintain the integrity of the data in the `FishTank` table by preventing invalid entries.

### Implementation

An example table for the `CHECK` constraint is as follows:

```sql
CREATE TABLE products (
  productId INT PRIMARY KEY,
  productPrice DECIMAL CHECK (productPrice >= 0
)
```

In this example, the `CHECK` constraint ensures that the `productPrice` is always a non-negative value, preventing the insertion of negative prices into the `products` table.

## DEFAULT

The `DEFAULT` constraint is used to provide a default value for a column when no value is specified during an insert operation. This ensures that the column will always have a valid value, even if the user does not provide one.

The `DEFAULT` values are typically literal constants; however an exception for timestamps and datetime can be made to use the current date and time. Many databases allow the use of functions like `NOW()` or `CURRENT_TIMESTAMP` to set the default value to the current date and time. This feature is commonly used for columns that track creation or modification timestamps.

To create a `DEFAULT` constraint for an existing column in a table:

```sql
ALTER TABLE table_name
ALTER COLUMN column_name SET DEFAULT default_value;
```

To delete a `DEFAULT` constraint from an existing column in a table:

```sql
ALTER TABLE table_name
ALTER COLUMN column_name DROP DEFAULT;
```

### Real World Application

The `DEFAULT` keyword in SQL can apply to scenarios where you want to ensure that a certain column always has a value, even if it is not explicitly provided during an insert operation. This is particularly useful for maintaining data integrity and consistency. For example, you might use a `DEFAULT` value for timestamp columns to automatically record the creation or modification time of a record.

Some examples of when you may want to use `DEFAULT` include:

- **Timestamps for Record Creation**: When creating a table to store user information, you might want to automatically record the date and time when each user was created. You can use the `DEFAULT` keyword to set the default value of a `created_at` column to the current timestamp.

```sql
CREATE TABLE users (
  user_id SERIAL PRIMARY KEY,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

- **Boolean Values**: In some cases, you may want to ensure that a boolean column has a default value. For example, when creating a table to store user preferences, you might want to set a default value for a `notifications_enabled` column to `true`.

```sql
CREATE TABLE user_preferences (
  user_id SERIAL PRIMARY KEY,
  notifications_enabled BOOLEAN DEFAULT TRUE
);
```

- **Numeric Defaults**: When creating a table to store product information, you might want to set a default value for a `stock_quantity` column to ensure that new products start with a certain stock level.

```sql
CREATE TABLE products (
  product_id SERIAL PRIMARY KEY,
  stock_quantity INT DEFAULT 0
);
```

- **Categorization or Status**: When creating a table to store orders, you might want to set a default value for a `status` column to ensure that new orders start with a specific status.

```sql
CREATE TABLE orders (
  order_id SERIAL PRIMARY KEY,
  status VARCHAR(20) DEFAULT 'pending'
);
```

- **Default Text Values**: When creating a table to store blog posts, you might want to set a default value for a `visibility` column to ensure that new posts are public by default.

```sql
CREATE TABLE blog_posts (
  post_id SERIAL PRIMARY KEY,
  visibility VARCHAR(20) DEFAULT 'public'
);
```

### Implementation

It is important to refer to the documentation of the specific database management system (DBMS) you are using, as the syntax and capabilities for defining constraints can vary between systems. However, the general principles outlined in this guide should apply to most relational databases.

```sql
CREATE TABLE UserOnline(
  ID INT PRIMARY KEY,
  UserName VARCHAR(100) NOT NULL,
  IsOnline BOOLEAN DEFAULT FALSE
)
```

```sql
-- Inserting a user with online status not specified (defaults to FALSE)
INSERT INTO UserOnline (ID, UserName) VALUES (1, 'Alice');
```

```sql
-- Inserting a user with online status specified (overrides default)
INSERT INTO UserOnline (ID, UserName, IsOnline) VALUES (2, 'Bob', TRUE);
```

In the first example, when inserting a user without specifying the `IsOnline` status, it defaults to `FALSE`. In the second example, the `IsOnline` status is explicitly set to `TRUE`, overriding the default value. This demonstrates how the `DEFAULT` constraint works in practice.

## PRIMARY KEY

The `PRIMARY KEY` constraint is used to uniquely identify each record in a table. A primary key must contain unique values and cannot contain NULL values. Each table can have only one primary key, which may consist of single or multiple columns (fields).

Note: Primary keys should not contain sensitive information such as Social Security Numbers or email addresses, as this can lead to security and privacy concerns.

### Real World Application

Almost every table has a `PRIMARY KEY` constraint. A few examples are:

- Employee ID in an Employee table
- Student ID in a Student table
- Branch ID of any company with multiple branches

All these are used to uniquely identify a record in the table.

### Implementation

Below in an example of creating a table named `employee` with `employee_id` as the primary key:

```sql
CREATE TABLE employee (
  employeeId INT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE
);
```

```sql
DESC employee; -- To describe the structure of the employee table
```

Result:

```
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| employeeId   | int          | NO   | PRI | NULL    |       |
| first_name   | varchar(100) | NO   |     | NULL    |       |
| last_name    | varchar(100) | NO   |     | NULL    |       |
| email        | varchar(100) | NO   | UNI | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
```
