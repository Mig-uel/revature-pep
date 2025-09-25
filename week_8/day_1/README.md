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
