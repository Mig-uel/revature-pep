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
