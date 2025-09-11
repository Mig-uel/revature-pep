# APIs and Testing - Day 3

## Authorization vs Authentication

The distinction between authorization and authentication is important in understanding how RESTful APIs work and why connection attempts are either accepted or denied.

- **Authentication** is the process of verifying the identity of a user or system. It answers the question, "Who are you?" Common methods of authentication include usernames and passwords, tokens, and biometric data. In the context of APIs, authentication ensures that the entity making a request is who they claim to be.
- **Authorization**, on the other hand, is the process of determining what an authenticated user or system is allowed to do. It answers the question, "What are you allowed to do?" Authorization typically occurs after authentication and involves checking permissions and access levels. In APIs, authorization ensures that the authenticated entity has the necessary rights to perform specific actions or access certain resources.

### Real World Application

There are several common ways to authenticate a user's credentials in a web application:

- **Username and Password**: The most basic common method where users provide a unique identifier (username) and a secret (password), which are then verified against stored credentials in a database. Passwords are typically hashed for security.
- **Token-Based Authentication**:
  - **JWT (JSON Web Tokens)**: After a user logs in with their credentials, the server generates a JWT, which is a compact, URL-safe token that contains claims about the user. The client stores this token (usually in local storage or cookies) and includes it in the Authorization header of subsequent requests. The server verifies the token to authenticate the user.
  - **OAuth 2.0**: Users authenticate using OAuth providers (like Google, Facebook), which issue access tokens that grant permissions to access protected resources without sharing credentials. OAuth 2.0 provides a flexible authentication framework for both web and mobile applications.
- **Two-Factor Authentication (2FA)**: Users authenticate using two different factors/methods, typically something they know (password) and something they have (a mobile device for receiving a code). This adds an extra layer of security by requiring additional verification beyond just a password.
- **Single Sign-On (SSO)**: Users authenticate once and gain access to multiple applications or services without needing to log in again. SSO is often implemented using protocols like SAML (Security Assertion Markup Language) or OpenID Connect, allowing users to use a single set of credentials across various platforms.

After authentication, there are several common ways to authorize a user's access to resources:

- **Role-Based Access Control (RBAC)**: Users are assigned roles (e.g., admin, user, guest), and each role has specific permissions associated with it. When a user attempts to access a resource, the system checks their role and determines if they have the necessary permissions to perform the requested action.
- **Claim-Based Authorization**: This method uses claims (attributes about the user) to determine access rights. Claims can include information such as user ID, email, or group membership. The system evaluates these claims against the resource's access policies to decide whether to grant or deny access.
- **Permission-Based Access Control**: Instead of assigning roles, users are granted specific permissions directly. Each resource has a set of permissions (e.g., read, write, delete), and the system checks if the user has the required permissions to access or modify the resource.
- **Attribute-Based Access Control (ABAC)**: This method uses a combination of user attributes, resource attributes, and environmental conditions to make authorization decisions. For example, access might be granted based on the user's department, the sensitivity of the data, and the time of day.
- **Policy-Based Access Control**: Access decisions are made based on predefined policies that specify who can access what resources under which conditions. Policies can be complex and may involve multiple factors, such as user roles, resource types, and contextual information.

Each authentication and authorization method has its own use cases, advantages, disadvantages, and security considerations. The choice of method depends on the specific requirements of the application, the sensitivity of the data being protected, and the user experience desired.

### Implementation

Let's consider an example of how authentication and authorization might be implemented fr a user trying to access a book website.

#### Authentication

- When a user visits the book website, they are prompted to log in with their username and password.
- The user enters their credentials, which are sent to the server for verification.
- The server checks the provided credentials against the stored user data in the database.
- If the credentials are valid, the server generates a JWT (JSON Web Token) that contains the user's ID and role (e.g., "user" or "admin").
- The JWT is sent back to the client and stored in local storage or a cookie for future requests.

#### Authorization

- Once authenticated, the user attempts to access various resources on the website, such as viewing books or adding a book to their reading list.
- Each time the user makes a request to access a resource, the server checks their authorization by examining the JWT included in the request headers.
- The server decodes the JWT to extract the user's role and permissions.
- Based on the user's role, the server determines what actions they are allowed to perform:
  - If the user has the "user" role, they can view books and add books to their reading list.
  - If the user has the "admin" role, they can also add new books to the website or manage user accounts.
- If the user tries to perform an action they are not authorized for (e.g., a "user" trying to add a new book), the server responds with a "403 Forbidden" status, indicating that they do not have permission to access that resource.
