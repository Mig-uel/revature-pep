# SQL Basic and JDBC - Day 1

## Overview of Sublanguages

Structured Query Language or SQL, is the standard language for working with RDBMS. SQL is used to administer and manipulate SQL servers. SQL is a scripting language that is interpreted by the database engine. SQL is used to:

- Define database structure
- Manipulate stored data
- Define data access permissions
- Control concurrent data access
- Query the database

To accommodate the operations above, SQL is divided into several sublanguages, each serving a specific purpose. The main sublanguages of SQL are:

| Sublanguage                        | Purpose                        |
| ---------------------------------- | ------------------------------ |
| DDL (Data Definition Language)     | Define database structure      |
| DML (Data Manipulation Language)   | Manipulate stored data         |
| DCL (Data Control Language)        | Define data access permissions |
| TCL (Transaction Control Language) | Control concurrent data access |
| DQL (Data Query Language)          | Query the database             |

Each sublanguage is responsible for a specific aspect of database management, allowing users to effectively interact with and manage relational databases.

### Real World Application

Consider a scenario where we have to use all five SQL sublanguage commands, so we have to be familiar with all the commands in each of DDL, DML, DCL, and DQL.

Their respective commands are as follows:

- **DDL**: CREATE, ALTER, DROP, TRUNCATE, RENAME
- **DML**: SELECT, INSERT, UPDATE, DELETE
- **DCL**: GRANT, REVOKE
- **TCL**: COMMIT, ROLLBACK, SAVEPOINT
- **DQL**: SELECT

### Implementation

#### DDL

DDL sublanguage is utilized to define and manage the structure of database objects. Here are some common DDL commands: `CREATE`, `ALTER`, `DROP`, `TRUNCATE`, and `RENAME`. Using DDL, the overall structure is modeled by creating objects like tables where specific columns are defined with their respective data types.

#### DML

DML sublanguage is utilized to manipulate the data stored in the database. Here are some common DML commands: `SELECT`, `INSERT`, `UPDATE`, and `DELETE`. Using DML, users can retrieve, add, modify, and remove data from database tables.

#### DQL

DQL sublanguage is utilized to query the database and retrieve data. The primary DQL command is `SELECT`, which allows users to specify the data they want to retrieve from one or more tables. DQL is essential for data retrieval and reporting in database applications.

DQL is the backbone for querying databases, enabling users to extract meaningful information from large datasets. The command set consists pf the single `SELECT` command but the sublanguage is built on a grammar structure that is used to:

- Search data
- Project record views
- Filter records
- Group values
- Offset result sets

The `SELECT` statement is the crux of DQL and is composed of clauses that define the query's structure and behavior. The primary clauses of the `SELECT` statement include:

| Phrase  | Clause 1             | Clause 2             |
| ------- | -------------------- | -------------------- |
| Search  | `FROM <table_name>`  |                      |
| Project | `SELECT <columns>`   | `ORDER BY <columns>` |
| Filter  | `WHERE <condition>`  |                      |
| Group   | `GROUP BY <columns>` | `HAVING <condition>` |
| Offset  | `LIMIT <number>`     | `OFFSET <number>`    |

#### DCL

DCL sublanguage is utilized to define data access permissions and control user access to the database. Here are some common DCL commands: `GRANT` and `REVOKE`. Using DCL, database administrators can manage user privileges and ensure data security.
