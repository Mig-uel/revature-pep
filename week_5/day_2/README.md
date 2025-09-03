# JDBC/SQL Intermediate - Day 2

## Composite Key

A composite key is a combination of two or more columns in a table that together uniquely identify a row. Composite keys are used when a single column is not sufficient to uniquely identify records.

- A composite key can also be a combination of candidate keys, which are sets of columns that can uniquely identify rows in a table.
- A group of all the foreign keys can also be used to uniquely identify a row in a table; in this scenario, it is also considered a composite key.

### Real World Application

Consider a scenario where there is a `student` table, a `mentor` table, and another table called `mentor_mentee`. A student can have multiple mentors, and a mentor can have multiple students. This is a many-to-many relationship. In this type of relationship, the `mentor_mentee` table stores pairings between a student and their mentor. The `mentor_mentee` table stores the `student_id` and `mentor_id` as foreign keys. The combination of these two columns can be used as a composite key to uniquely identify each pairing. Records in the `student` table can be uniquely identified by `student_id`, records in the mentor table can be uniquely identified by `mentor_id`, but the `mentor_mentee` table needs both `student_id` and `mentor_id` to uniquely identify a record. Both `student_id` and `mentor_id` are grouped together to form a composite key.

### Implementation

Below is an example of using a composite key.

First, we create the tables called `employee`, `client`, and `branch`:

```sql
CREATE TABLE employee (
  employee_id INT PRIMARY KEY,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  manager_id INT REFERENCES employee(employee_id) ON DELETE SET NULL -- self-referencing foreign key
);

CREATE TABLE client (
  client_id INT PRIMARY KEY,
  client_name VARCHAR(20),
  branch_id INT REFERENCES branch(branch_id) ON DELETE SET NULL
);

CREATE TABLE branch (
  branch_id INT PRIMARY KEY,
  client_name VARCHAR(40),
  manager_id INT REFERENCES employee(employee_id) ON DELETE SET NULL
);
```

Secondly, we create a table called `works_with`:

```sql
CREATE TABLE works_with (
  employee_id INT REFERENCES employee(employee_id) ON DELETE CASCADE, -- foreign key
  client_id INT REFERENCES client(client_id) ON DELETE CASCADE, -- foreign key
  sales INT,
  PRIMARY KEY (employee_id, client_id) -- composite key
)
```

In the above example, we have created a composite key in the `works_with` table using the combination of `employee_id` and `client_id`. This allows us to uniquely identify each record in the `works_with` table based on the specific employee-client relationship.
