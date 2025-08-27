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

## Referential Integrity

Referential integrity is a property of data stating that all its references are valid. In the context of relational databases, it ensures that relationships between tables remain consistent. When one table (the child table) references another table (the parent table) through a foreign key, referential integrity ensures that the foreign key value in the child table always corresponds to a valid primary key value in the parent table.

When a primary key from one table appears in another table, it is called a foreign key. The foreign key establishes a link between the data in the two tables.

Referential integrity does not allow the addition of any record in a table that contains a foreign key unless the record containing the primary key being referred to exists. It also does not allow the deletion of a record containing a primary key if there are matching foreign key records in another table.

To delete a record in the parent table, you must first delete any corresponding records in the child table that reference the primary key in the parent table. To solve this problem, you can use cascading actions like `ON DELETE CASCADE` or `ON UPDATE CASCADE` when defining foreign key constraints. These actions automatically propagate changes from the parent table to the child table, ensuring referential integrity is maintained without manual intervention.

Other options are to set the `FOREIGN KEY` to `NULL` or to a default value when the referenced primary key is deleted or updated. This can be done using `ON DELETE SET NULL` or `ON UPDATE SET DEFAULT`.

### Real World Application

Consider a database with two tables: `Orders` and `Customers`. The `Orders` table has a foreign key that references the primary key in the `Customers` table. Referential integrity ensures that every order is associated with a valid customer.

```sql
CREATE TABLE Customers (
  customerId INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE Orders (
  orderId INT PRIMARY KEY,
  orderDate DATE NOT NULL,
  customerId INT,
  FOREIGN KEY (customerId) REFERENCES Customers(customerId)
);
```

Any changes made to the `Customers` table will be reflected in the `Orders` table, ensuring that all orders always reference valid customers. If a customer is deleted from the `Customers` table, any associated orders in the `Orders` table will also be deleted if `ON DELETE CASCADE` is specified.

### Implementation

Step 1: Create a table named `Student`

```sql
CREATE TABLE Student (
  student_id INT PRIMARY KEY,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  major VARCHAR(20)
)
```

---

Step 2: Create a table named `InternationalStudent`

```sql
CREATE TABLE InternationalStudent (
  country_id INT PRIMARY KEY,
  name VARCHAR(20),
  student_id INT REFERENCES Student(student_id) ON DELETE CASCADE -- Foreign Key referencing Student table
)
```

The above example demonstrates referential integrity by ensuring that the `student_id` in the `InternationalStudent` table references a valid `student_id` in the `Student` table. The `ON DELETE CASCADE` option ensures that if a student is deleted from the `Student` table, any corresponding records in the `InternationalStudent` table will also be automatically deleted, maintaining data consistency across both tables.

---

Step 3: Insert values into `Student` table and `InternationalStudent` table

```sql
INSERT INTO Student VALUES (1, "Taylor", "Swift", "English Literature"), (2, "Stephen", "Hawking", "Physics");

INSERT INTO InternationalStudent VALUES (1, "USA", 1), (2, "UK", 2);
```

```sql
SELECT * FROM InternationalStudent;
```

Result:

```
+------------+--------+------------+
| country_id | name   | student_id |
+------------+--------+------------+
| 1          | USA    | 1          |
| 2          | UK     | 2          |
+------------+--------+------------+
```

---

Step 4: Delete a record from the `Student` table

```sql
DELETE FROM Student WHERE major = "English Literature";
```

Now the record in the child table `InternationalStudent` is also deleted because of the `ON DELETE CASCADE` option.

```sql
SELECT * FROM InternationalStudent;
```

Result:

```
+------------+--------+------------+
| country_id | name   | student_id |
+------------+--------+------------+
| 2          | UK     | 2          |
+------------+--------+------------+
```

## FOREIGN KEY

A `FOREIGN KEY` is a field (or collection of fields) in one table that uniquely identifies a row of another table. In other words, it is a reference to the primary key in another table, establishing a link between the two tables. This relationship helps maintain referential integrity within the database.

### Real World Application

Consider a company database with two tables: `Employees` and `Departments`. Each employee belongs to a department, and this relationship can be represented using a foreign key.

```sql
CREATE TABLE Departments (
  departmentId INT PRIMARY KEY,
  departmentName VARCHAR(100) NOT NULL
);

CREATE TABLE Employees (
  employeeId INT PRIMARY KEY,
  employeeName VARCHAR(100) NOT NULL,
  departmentId INT,
  FOREIGN KEY (departmentId) REFERENCES Departments(departmentId)
);
```

In this example, the `departmentId` column in the `Employees` table is a foreign key that references the `departmentId` column in the `Departments` table. This ensures that every employee is associated with a valid department, maintaining referential integrity between the two tables.

### Implementation

Step 1: Create a `Branch` and `Employee` table.

```sql
CREATE TABLE Branch(
    id INT PRIMARY KEY,
    name VARCHAR(20)
);

CREATE TABLE Employee(
    id INT PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(50)
);
```

---

Step 2: Add `branch_id` as a `FOREIGN KEY` in the `Employee` table.

```sql
-- Adding branch_id column to Employee table
ALTER TABLE Employee
ADD branch_id INT;

-- Adding FOREIGN KEY constraint to branch_id column
ALTER TABLE Employee
ADD FOREIGN KEY (branch_id) REFERENCES Branch(id);
```

```sql
DESC Employee; -- To describe the structure of the Employee table
```

Result:

```
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| id         | int(11)     | NO   | PRI | NULL    |       |
| name       | varchar(20) | NO   |     | NULL    |       |
| address    | varchar(50) | NO   |     | NULL    |       |
| branch_id  | int(11)     | YES  | MUL | NULL    |       |
+------------+--------------+------+-----+---------+-------+
```

The `id` column in the `branch` table is the primary key, and the `branch_id` column in the `Employee` table is a foreign key that references the `id` column in the `Branch` table. This establishes a relationship between the two tables, ensuring that each employee is associated with a valid branch.

## CASCADE

In SQL, `CASCADE` is a keyword used in conjunction with foreign key constraints to define how changes to the parent table should be propagated to the child table. It is commonly used with `ON DELETE` and `ON UPDATE` actions.

`CASCADE` is appended to the foreign key definition to specify that when a record in the parent table is deleted or updated, the corresponding records in the child table should also be automatically deleted or updated.

---

`ON DELETE`

Appending `ON DELETE CASCADE` to the foreign key definition ensures that when a record in the parent table (e.g., `Branch`) is deleted, all corresponding records in the child table (e.g., `Employee`) are also automatically deleted. Otherwise, due to referential integrity, the deletion would be prevented if there are dependent records in the child table.

---

`ON UPDATE`

Appending `ON UPDATE CASCADE` to the foreign key definition ensures that when a record in the parent table (e.g., `Branch`) is updated, all corresponding records in the child table (e.g., `Employee`) are also automatically updated. This is useful in scenarios where the primary key in the parent table may change, and you want to ensure that all related records in the child table reflect this change.

### Real World Application

Imagine students enrolled in courses at college, but some students drop out mid-way through the semester, and the school is not required to keep records of students who drop out. In this example, we would want to structure our tables such that the foreign keys have an `ON DELETE CASCADE` to maintain referential integrity when removing those students' records from the `Enrollments` table.

Continuing with the student examples, imagine the students in the database need their primary key IDs reset to account for the students that dropped out and make room for the freshmen. This could be achieved by by adding `ON UPDATE CASCADE` to the foreign key constraint in the `Enrollments` table. This way, when the primary key in the `Students` table is updated, all corresponding records in the `Enrollments` table are automatically updated to reflect the new student IDs.

### Implementation

Sticking with the college student theme, let us look at students in a college course and use `CASCADE` to handle deletions and updates.

---

**Define the table for students**

```sql
CREATE TABLE students(
    student_id INT PRIMARY KEY,
    student_name VARCHAR(40),
    email VARCHAR(20) UNIQUE
);
```

---

**Define the table for courses**

```sql
CREATE TABLE courses(
    course_id INT PRIMARY KEY,
    course_name VARCHAR(20),
    course_length_weeks INT,
    credits INT
);
```

---

**Finally, let's define a junction table to handle enrollment and use `CASCADE`**

```sql
CREATE TABLE enrollments(
    course_id INT,
    student_id INT,
    grade INT,
    completion_status BOOLEAN,
    PRIMARY KEY(course_id, student_id), -- Composite Primary Key
    FOREIGN KEY(course_id) REFERENCES courses(course_id) ON DELETE CASCADE, -- If a course is deleted, remove all enrollments for that course
    FOREIGN KEY(student_id) REFERENCES students(student_id) ON DELETE CASCADE ON UPDATE CASCADE -- If a student is deleted, remove all enrollments for that student; if a student ID is updated, update all corresponding enrollments
);
```

The above example demonstrates the use of `CASCADE` in a college enrollment scenario. The `enrollments` table has foreign keys referencing both the `courses` and `students` tables. The `ON DELETE CASCADE` option ensures that if a course or student is deleted, all corresponding records in the `enrollments` table are also automatically deleted. The `ON UPDATE CASCADE` option ensures that if a student's ID is updated, all corresponding records in the `enrollments` table are also automatically updated to reflect the new student ID. This maintains referential integrity across the related tables.

## Unique Key

The `UNIQUE` constraint is used to ensure that every value in a column is different and unique. This means that each row must have a distinct value in the specified column.

The `UNIQUE` key interacts with `NULL` values somewhat unintuitively.

- A `UNIQUE` key allows for `NULL` column values in records.

There is often confusion around how many `NULL` values a `UNIQUE` constraint can have in a column. Each database may have slight differences in the number of `NULL` values that are allows with a `UNIQUE` constraint. Some databases allow only a single `NULL` value; however, many databases allow multiple of them.

In other words, when a column is declared as `UNIQUE` and allows `NULL`, the `UNIQUE` constraint applies only to the non-null values. Rows with `NULL` values in that column are not considered duplicates in terms of the `UNIQUE` constraint.
This is because `NULL` represents the absence of a value. However, keep in ming that each non-null value must still be unique across all rows.

It's essential to consult the documentation of the specific database system you are using to understand its behavior regarding UNIQUE constraints and NULL values. Always consider the unique constraints enforced by your database to ensure the correct behavior based on your requirements.

Keep in mind that a column can have multiple constraints applied to it. The `UNIQUE` constraint ensures that all values in the column are distinct. However, in most databases, `UNIQUE` does not prevent multiple `NULL` values since `NULL` is treated as an unknown value. To ensure that no `NULL` values exist in a column, use the `NOT NULL` constraint in combination with `UNIQUE`.

### Real World Application

- **Primary Keys**: The primary key of a table is often enforced using a `UNIQUE` constraint to ensure that each record can be uniquely identified. This ensures that each record in the table has a unique identifier, helping to maintain data integrity and providing a reliable way to reference and link records across different tables.
- **Email Addresses and Usernames**: In user management systems, it is common to enforce `UNIQUE` constraints on email addresses and usernames to prevent duplicate entries. This ensures that each user has a distinct email address and username, which is crucial for authentication and communication purposes.
- **Product Codes or SKUs**: In inventory management systems, product codes or SKUs (Stock Keeping Units) are often enforced with `UNIQUE` constraints to ensure that each product can be uniquely identified. This helps prevent confusion and errors in inventory tracking and management.
- **Reference Codes in Relationships**: In relational databases, foreign keys often reference primary keys in other tables. Enforcing `UNIQUE` constraints on these reference codes ensures that each reference is valid and corresponds to a unique record in the related table, maintaining referential integrity.
- **Phone Numbers (if used as identifiers)**: In some systems, phone numbers may be used as unique identifiers for users or contacts. Enforcing a `UNIQUE` constraint on phone numbers ensures that each phone number is associated with only one user or contact, preventing duplicate entries and ensuring accurate communication.
- **URLs or Website Addresses**: In content management systems or web applications, URLs or website addresses may be enforced with `UNIQUE` constraints to ensure that each URL is distinct. This prevents duplicate entries and ensures that each webpage or resource can be uniquely identified and accessed.
- **License Plates**: In vehicle registration systems, license plates are often enforced with `UNIQUE` constraints to ensure that each vehicle has a distinct license plate number. This helps prevent confusion and errors in vehicle identification and registration.

There are just a few examples of why developers may want to use the `UNIQUE` constraint in their database schema. The `UNIQUE` constraint is a powerful tool for maintaining data integrity and ensuring that each record in a table can be uniquely identified. It prevents duplicate or conflicting information, which is crucial for reliable and effective database management.

### Implementation

```sql
-- Create a table with a UNIQUE constraint allowing NULL values
CREATE TABLE students (
  studentId INT UNIQUE,
  firstName VARCHAR(255),
  lastName VARCHAR(255)
)

-- Insert rows with unique non-null values and multiple NULLs
INSERT INTO students (studentId, firstName, lastName)
VALUES (1, 'John', 'Doe'), (2, 'Jane', 'Smith'), (NULL, 'Alice', 'Johnson'), (NULL, 'Bob', 'Brown');
-- This is valid because NULLs are not considered duplicates
```

In the example above, we can see the use of the `UNIQUE` constraint on the `studentId` column. The table allows multiple `NULL` values, but all non-null values must be unique. The insertion of two rows with `NULL` values is valid, while any attempt to insert a duplicate non-null value would result in an error.
