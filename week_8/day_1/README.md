# Advanced SQL and Java

## DCL

The **Data Control Language (DCL)** is a subset of SQL commands used to control access (rights and permissions) to data within a database.

#### Common DCL Commands:

- `GRANT`: Used to give users access privileges to the database.
- `REVOKE`: Used to take back permissions granted to users.

#### Grant

The `GRANT` command is used to provide specific privileges to users or roles.

#### Revoke

The `REVOKE` command is used to remove previously granted privileges from users or roles.

### Real World Application

The DCL subset of SQL is used to control access to databases and objects. In large scale applications, databases could be providing data to numerous applications. In practice, each of these applications would represent a distinct user. Each of those applications could have different set of access privileges to the different databases on the server and to different objects within those databases.

In general, these privileges are granted before the database is accessed by the user, so the DBA would be responsible for setting up user access prior to the user attempting to login to the database.

### Implementation

The DCL sublanguage provides a means of defining access control to a database and its objects. Privileges can be granted or revoked to users or roles. A role is a named group of related privileges that can be assigned to users or other roles.

#### Privileges

A database can have numerous privileges that can be permitted to users or roles. Below is a summary of the most common privileges:

| Privilege | Description                                                                       |
| --------- | --------------------------------------------------------------------------------- |
| `SELECT`  | Allows reading data from a table or view.                                         |
| `INSERT`  | Allows inserting new rows into a table.                                           |
| `DELETE`  | Allows deleting rows from a table.                                                |
| `UPDATE`  | Allows modifying existing rows in a table.                                        |
| `INDEX`   | Allows creating and dropping indexes on a table.                                  |
| `CREATE`  | Allows creating new database objects like tables and views.                       |
| `ALTER`   | Allows modifying the structure of existing database objects.                      |
| `DROP`    | Allows deleting database objects like tables and views.                           |
| `ALL`     | Grants all available privileges on a database object except `GRANT` and `REVOKE`. |
| `GRANT`   | Allows granting privileges to other users or roles.                               |

#### GRANT

The `GRANT` command is used to provide specific privileges to users or roles. To grant privileges, the user executing the command must have the `GRANT` option for the specified privileges.

```sql
GRANT privilege1, privilege2, ... ON object TO user_or_role [WITH GRANT OPTION];
```

- `privilege1, privilege2, ...`: The privileges to be granted (e.g., `SELECT`, `INSERT`, `ALL`)
- `object`: The database object (e.g., table, view) on which the privileges are being granted
- `user_or_role`: The user or role to whom the privileges are being granted
- `WITH GRANT OPTION`: Optional clause that allows the user to grant the same privileges to other users or roles

To `GRANT` a simple privilege like `SELECT` on a table named `posts` to a user named `alice`, the command would be:

```sql
GRANT SELECT ON posts TO alice;
```

To `GRANT` all of the CRUD privileges on a table named `posts` to a user named `community.manager`, the command would be:

```sql
GRANT SELECT, INSERT, UPDATE, DELETE ON posts TO community.manager;
```

#### REVOKE

The `REVOKE` command is used to remove previously granted privileges from users or roles.

```sql
REVOKE privilege1, privilege2, ... ON object FROM user_or_role;
```

To `REVOKE` the `SELECT` privilege on a table named `posts` from a user named `alice`, the command would be:

```sql
REVOKE SELECT ON posts FROM alice;
```

To `REVOKE` all of the CRUD privileges on a table named `posts` from a user named `community.manager`, the command would be:

```sql
REVOKE SELECT, INSERT, UPDATE, DELETE ON posts FROM community.manager;
```

## TCL

The **Transaction Control Language (TCL)** is a subset of SQL commands used to manage transactions within a database. A transaction is a sequence of one or more SQL operations (e.g., `INSERT`, `UPDATE`, `DELETE`) that are treated as a single unit of work. Transactions ensure data integrity and consistency, especially in multi-user environments.

Transaction are managed using TCL commands to ensure that a series of operations either complete successfully as a whole or fail without making any changes to the database.

#### Common TCL Commands

- `START TRANSACTION` or `BEGIN`: Initiates a new transaction.
- `COMMIT`: Saves all changes made during the transaction to the database. Whenever we perform any of the DML commands (INSERT, UPDATE, DELETE), the changes can be rolled back if the data is not stored permanently. To be on the safe side, we can use the `COMMIT` command to save the changes permanently.
- `ROLLBACK`: Undoes all changes made during the transaction, reverting the database to its previous state before the transaction began.
- `SAVEPOINT`: Sets a savepoint within a transaction, allowing partial rollbacks to that point.
- `SET TRANSACTION`: Configures transaction properties, such as isolation level and access mode.

### Real World Application

Here is why TCL is important in real world applications:

- **Data Integrity**: TCL commands like `COMMIT`, `ROLLBACK`, and `SAVEPOINT` help maintain data integrity by ensuring that a series of related operations are treated as a single unit. If any operation fails, the entire transaction can be rolled back to prevent partial updates that could lead to inconsistent data.
- **ACID Properties**: Transactions adhere to the ACID properties (Atomicity, Consistency, Isolation, Durability), which are crucial for reliable database operations. TCL commands help enforce these properties, ensuring that transactions are processed reliably. TCL ensures that transactions are atomic (all or nothing), consistent (data remains valid), isolated (concurrent transactions do not interfere), and durable (once committed, changes are permanent).
- **Error Handling**: In complex applications, errors can occur during database operations. TCL commands allow developers to handle errors gracefully by rolling back transactions when necessary, preventing data corruption.

Overall, TCL is essential for managing transactions in a way that ensures data integrity, reliability, and consistency in real-world applications.

### Implementation

Consider an example of a transaction where you tried to add a new bank account, ACC3, and set the funds to $10,000. In that same transaction, you tried to create another account, ACC4, and set the funds to $900,000, when it was supposed to be $9,000. If the entire transaction is rolled back, the step of creating ACC3 would also be rolled back. To avoid this, you can set a savepoint after creating ACC3. This way, if there is an error while creating ACC4, you can roll back to the savepoint and keep ACC3 intact.

```sql
START TRANSACTION;
INSERT INTO bank_accounts (account_id, balance) VALUES ('ACC3', 10000);
SAVEPOINT after_ACC3;
INSERT INTO bank_accounts (account_id, balance) VALUES ('ACC4', 900000);
-- Oops! There was an error in the amount for ACC4
ROLLBACK TO after_ACC3; -- Rollback to the savepoint, keeping ACC3 intact
INSERT INTO bank_accounts (account_id, balance) VALUES ('ACC4', 9000); -- Correct the amount
COMMIT; -- Commit the transaction, making both ACC3 and ACC4 permanent
```

## What is a Transaction?

Transactions are a fundamental concept in database management systems (DBMS) that allow you to group multiple SQL operations into a single, atomic unit of work. Transactions ensure the integrity, consistency, and reliability of database operations, especially in multi-user environments.

### Real World Application

An example of a transaction in a banking application could involve transferring funds from one account to another. This operation typically consists of two main steps: debiting the amount from the sender's account and crediting the same amount to the recipient's account. Both steps must be completed successfully for the transaction to be valid. If either step fails (e.g., due to insufficient funds), the entire transaction should be rolled back to maintain data integrity.

### Implementation

Consider an example where there's a `bank_accounts` table, and we are doing an intra-bank transfer of some amount from one account to another. The transaction would look something like this:

#### Create the `bank_accounts` Table

```sql
CREATE TABLE bank_accounts (
    account_no VARCHAR(20) PRIMARY KEY,
    funds DECIMAL(15, 2)
)
```

#### Add Two Accounts

```sql
INSERT INTO bank_accounts (account_no, funds) VALUES ('ACC1', 1000.00);
INSERT INTO bank_accounts (account_no, funds) VALUES ('ACC2', 1000.00);
```

#### Perform the Transaction

```sql
START TRANSACTION;
UPDATE bank_accounts SET funds = funds - 100.00 WHERE account_no = 'ACC1';
UPDATE bank_accounts SET funds = funds + 100.00 WHERE account_no = 'ACC2;
COMMIT;
```

## ACID Properties

The ACID properties are a set of principles that ensure reliable processing of database transactions. ACID stands for Atomicity, Consistency, Isolation, and Durability. These properties are essential for maintaining the integrity and reliability of data in a database management system (DBMS).

#### Atomicity

A transaction is considered atomic if it cannot be divided into smaller parts, and all of the operations that occur within the transaction either complete successfully or none of them do as a single unit. If any part of the transaction fails, the entire transaction is rolled back, and the database remains unchanged.

#### Consistency

A transaction is consistent if it takes the database from one valid state to another valid state, maintaining all predefined rules and constraints. This means that any data written to the database must adhere to all integrity constraints, such as unique keys, foreign keys, and data types.

#### Isolation

Isolation ensures that the operations of one transaction are isolated from the operations of other concurrent transactions. This means that the intermediate state of a transaction is not visible to other transactions until the transaction is committed. Isolation levels can be configured to balance performance and consistency, with common levels including Read Uncommitted, Read Committed, Repeatable Read, and Serializable.

#### Durability

Durability guarantees that once a transaction has been committed, it will remain committed even in the event of a system failure. This means that the changes made by the transaction are permanently recorded in the database, and any subsequent failures will not affect the committed data.

### Real World Application

Database transactions are the backbone of many real-world applications. It may be difficult at first to see how each of the ACID properties are applied in practice. Here are some examples of how each property is used in real-world applications:

- **Atomicity**: In an e-commerce application, when a customer places an order, the transaction includes multiple operations such as updating the inventory, creating an order record, and processing payment. If any of these operations fail (e.g., payment processing fails), the entire transaction is rolled back to ensure that the order is not partially processed.
- **Consistency**: In a banking application, when transferring funds between accounts, the transaction must ensure that the total balance of both accounts remains consistent. If a transfer of $100 is made from Account A to Account B, the system must ensure that Account A's balance decreases by $100 and Account B's balance increases by $100, maintaining the overall consistency of the bank's total funds.
- **Isolation**: In a multi-user database system, multiple users may be accessing and modifying the same data concurrently. Isolation ensures that each user's transaction is processed independently, preventing issues such as dirty reads or lost updates. For example, if User A is updating a record while User B is reading the same record, User B will not see the uncommitted changes made by User A until User A's transaction is committed.
- **Durability**: In a financial application, once a transaction is committed (e.g., a deposit or withdrawal), the changes must be permanent and recoverable even in the event of a system crash. This is typically achieved through the use of transaction logs and backup mechanisms that ensure that committed data is not lost.

### Implementation

For the following examples, consider a banking application that allows funds to be transferred between accounts.

#### Atomicity

Consider transferring $50 from an account, `ACC1`, to another account, `ACC2`, where we check if `ACC1` has sufficient funds before proceeding with the transfer.

```sql
START TRANSACTION;
UPDATE bank_accounts SET funds = funds - 50.00 WHERE account_no = 'ACC1' AND funds >= 50.00; -- Deduct $50 from ACC1 if sufficient funds
UPDATE bank_accounts SET funds = funds + 50.00 WHERE account_no = 'ACC2'; -- Add $50 to ACC2
COMMIT; -- If either update fails, the transaction is rolled back, ensuring atomicity.
```

#### Consistency

Building off the previous example, let's examine `ACC1` and `ACC2`:

```sql
SELECT * FROM bank_accounts;
```

| account_no | funds   |
| ---------- | ------- |
| ACC1       | 850.00  |
| ACC2       | 1150.00 |

From the above table, we can conclude that the sum of funds in both accounts before and after the transaction remains consistent at $2000.00.

#### Isolation

Expanding on the previous example, consider the following steps:

We will create a new bank account, `ACC3`, with $1000.00.

```sql
INSERT INTO bank_accounts (account_no, funds) VALUES ('ACC3', 1000.00);
```

We will now start a transaction to add $1000.00 to `ACC3`. During this transaction, if another transaction tries to read the funds in `ACC3`, it will not see the uncommitted changes until the transaction is committed.

```sql
START TRANSACTION;
UPDATE bank_accounts SET funds = funds + 1000.00 WHERE account_no = 'ACC3';
-- Before committing, if another transaction tries to read ACC3, it will not see the uncommitted changes.
COMMIT;
```

We will now start a transaction to deduct $100.00 from `ACC2` to `ACC1`. During this transaction, if another transaction tries to read the funds in `ACC2`, it will not see the uncommitted changes until the transaction is committed.

```sql
START TRANSACTION;
UPDATE bank_accounts SET funds = funds - 100.00 WHERE account_no = 'ACC2';
UPDATE bank_accounts SET funds = funds + 100.00 WHERE account_no = 'ACC1';
COMMIT;
```

In the above example, the isolation property ensures that concurrent transactions do not interfere with each other, maintaining data integrity.

#### Durability

Let's look at the database state after committing the previous transactions:

```sql
SELECT * FROM bank_accounts;
```

| account_no | funds   |
| ---------- | ------- |
| ACC1       | 950.00  |
| ACC2       | 1050.00 |
| ACC3       | 2000.00 |

From the above table, we can conclude that the changes made by the committed transactions are permanent and will persist even in the event of a system failure, ensuring durability.
