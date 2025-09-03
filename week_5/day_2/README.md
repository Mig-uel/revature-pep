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

## Normalization

Normalization is the process of organizing data in a database to reduce redundancy and improve data integrity. It involves breaking down a large table into smaller, related tables and defining relationships between them. The main goals of normalization are to eliminate data anomalies, ensure data consistency, and optimize storage.

#### Normal Forms

First, second, and third normal forms are stepping stones to the Boyce-Codd normal form and, when appropriate, the higher normal forms.

#### First Normal Form (1NF)

The first normal form (1NF) is the most basic level of normalization and is a requirement for all relational databases. If we consider a database as relational, then all relations in the database must be in 1NF.

A table is in 1NF if it meets the following criteria:

- Each column contains atomic (indivisible) values (no repeating groups or arrays).
- Each column contains values of a single type.
- Each column has a unique name.
- The order in which data is stored does not matter.

1NF does not allow hierarchical or nested data structures.

#### Second Normal Form (2NF)

Second normal form (2NF) builds on the requirements of 1NF. 2NF deals with the elimination of circular dependencies from a relation. We say a relation is in 2NF if it is in 1NF and all non-key attributes are fully functionally dependent on the primary key. A non-key attribute is any column that cannot be used to uniquely identify a row in a table.

A table is in 2NF if it meets the following criteria:

- It is in 1NF.
- All non-key attributes are fully functionally dependent on the primary key.

In simpler terms, if a table has a composite primary key, then all non-key attributes must depend on the entire primary key, not just part of it. An example of this is the `works_with` table we created earlier. The composite key is made up of `employee_id` and `client_id`, and the non-key attribute `sales` depends on both parts of the composite key.

### Third Normal Form (3NF)

Third normal form (3NF) builds on the requirements of 2NF. A relation is in 3NF if it is in 2NF and all the attributes are functionally dependent only on the primary key.

3NF deals with the elimination of non-key attributes that do not describe the primary key. This means that all attributes in a table should be directly related to the primary key and not to other non-key attributes.

For a relation to be in 3NF, the relationship between any two non-key attributes, or groups of non-key attributes, must not be in a one-to-one relation.

The attributes should be mutually independent, which means that none of the attributes should depend on any other non-key attribute. This mutual independence ensures that any update, insert, or delete operation on one attribute does not affect the other attributes.

In simpler terms, a table is in 3NF if it meets the following criteria:

- It is in 2NF.
- All non-key attributes are functionally dependent only on the primary key.

In smaller terms, if a non-key attribute depends on another non-key attribute, it violates 3NF. For example, if we had a table with columns `employee_id`, `employee_name`, and `department_name`, and `department_name` depended on `employee_name`, then this table would not be in 3NF. To bring it to 3NF, we would need to create a separate table for departments and link it to the employee table using a foreign key.

#### Boyce-Codd Normal Form (BCNF)

Boyce-Codd Normal Form (BCNF) is an extension of the third normal form (3NF) and is known as 3.5NF. A relation is in BCNF if it is in 3NF and for every functional dependency (X -> Y), X is a super key.

In layman's terms, BCNF is a stricter version of 3NF. While 3NF allows for some redundancy, BCNF eliminates all redundancy caused by functional dependencies. This means that if a non-key attribute depends on a part of a composite key, the table is not in BCNF. To bring it to BCNF, we would need to decompose the table into smaller tables that eliminate the partial dependency.

For example, consider a table with columns `course_id`, `instructor_id`, and `instructor_name`. If `instructor_name` depends on `instructor_id`, and `instructor_id` is not a super key, then this table is not in BCNF. To bring it to BCNF, we would need to create a separate table for instructors and link it to the course table using a foreign key.

### Real World Application

Normalization is an essential concept in database design and plays a crucial role in ensuring data integrity and efficiency. Here are several key reasons why normalization is important:

- **Data Integrity**: Normalization reduces data redundancy and eliminates anomalies such as insertion, update, and deletion anomalies. By organizing data into well-structured tables and relationships, normalization helps maintain data integrity and consistency.
- **Query Performance**: Normalized databases typically have better query performance because they require fewer joins and provide efficient access paths to the data. Well designed normalized databases allow for faster query execution, resulting in improved application performance.
- **Ease of Maintenance**: Normalization makes databases easier to maintain and modify over time. It simplifies database schema changes, such as adding new tables or modifying existing ones, without affecting the overall database structure or compromising data integrity.

In summary, normalization is a fundamental concept in database design that helps ensure data integrity, improves query performance, and simplifies maintenance. By following the principles of normalization and applying the appropriate normal forms, database designers can create efficient and reliable databases that meet the needs of their applications.

### Implementation

Let's demonstrate normalizing an unnormalized table. In our example, we have a `zookeepers` table. Zookeepers can be responsible for more than one exhibit, and each exhibit can contain more than one animal for which they take care, and each exhibit can be taken care of by more than one zookeeper.

#### Unnormalized Table

```sql
CREATE TABLE zookeepers (
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  exhibit VARCHAR(100),
  animal_type1 VARCHAR(100),
  animal_type2 VARCHAR(100),
  animal_type3 VARCHAR(100),
  salary INT,
  position_title VARCHAR(100)
)
```

This table is unnormalized because it does not have a primary key, and some columns are redundant. For example, `animal_type1`, `animal_type2`, and `animal_type3` are repeating groups.

#### First Normal Form (1NF)

```sql
CREATE TABLE zookeepers (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  exhibit VARCHAR(100),
  animal_type VARCHAR(100), -- Changed to a single column to eliminate repeating groups
  salary INT,
  position_title VARCHAR(100)
)
```

This table is now in 1NF because it has a primary key (`id`), and all columns contain atomic values. However, it is not in 2NF because `exhibit` and `animal_type` depend on the combination of `first_name` and `last_name`, which is not a primary key.

#### Second Normal Form (2NF)

```sql
CREATE TABLE zookeepers(
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  salary INT,
  position_title VARCHAR(100)
);
CREATE TABLE exhibits(
  id SERIAL PRIMARY KEY,
  exhibit_name VARCHAR(100),
);
CREATE TABLE animals(
  id SERIAL PRIMARY KEY,
  exhibit_id INT REFERENCES exhibits(id) ON DELETE SET NULL,
  species VARCHAR(100)
);
CREATE TABLE zookeepers_exhibits(
  zookeeper_id INT REFERENCES zookeepers(id) ON DELETE CASCADE,
  exhibit_id INT REFERENCES exhibits(id) ON DELETE CASCADE,
  PRIMARY KEY (zookeeper_id, exhibit_id)
);
```

This design is now in 2NF because all non-key attributes are fully functionally dependent on the primary key. Because there is a many-to-many relationship between zookeepers and exhibits, we created a bridge or join table that represents the pairing between the two entities. However, it is not in 3NF because `position_title` may depend on `salary`, which is a non-key attribute.

#### Third Normal Form (3NF)

```sql
CREATE TABLE zookeepers(
  id SERIAL PRIMARY KEY,
  position_title_id INT REFERENCES position_titles(id) ON DELETE SET NULL,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
);
CREATE TABLE position_titles(
  id SERIAL PRIMARY KEY,
  position_title_name VARCHAR(100),
  salary INT
);
```

Lastly, we needed to remove the transitive dependency so we can move our `zookeepers` table into 3NF. The two columns `salary` and `position_title` do describe the `zookeeper` entity; however, if a change is made to the `position_title` column, it would require multiple updates to the `zookeepers` table. For example, if one was promoted from `junior zookeeper` to `senior zookeeper`, we would need to update the `position_title` column for every zookeeper with that title as well as the `salary` column. To resolve this, we created a new table called `position_titles` that contains the `position_title_name` and `salary`. The `zookeepers` table now references the `position_titles` table using a foreign key. This design is now in 3NF because all non-key attributes are functionally dependent only on the primary key.
