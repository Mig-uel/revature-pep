# JDBC/SQL Intermediate - Day 4

## HTTP Verbs

#### HTTP Methods

HTTP defines a set of request methods to indicate the desired action to be performed for a given resource. Although these methods can also be nouns, they are often referred to as HTTP verbs. Each of them implements a different semantic, but some common features are shared by a group of them:

- **Safe methods**: `GET`, `HEAD`, `OPTIONS`, and `TRACE` are considered safe, meaning that they are intended only for information retrieval and should not change the state of the server.
- **Idempotent methods**: `GET`, `HEAD`, `PUT`, `DELETE`, `OPTIONS`, and `TRACE` are idempotent, meaning that multiple identical requests should have the same effect as a single request. For example, making the same `DELETE` request multiple times will result in the same state as making it once (the resource is deleted). Note that idempotent does not imply safe: `PUT` and `DELETE` are idempotent but can change server state, while `GET`, `HEAD`, `OPTIONS`, and `TRACE` are both safe and idempotent.
- **Cacheable methods**: `GET` and `HEAD` responses are cacheable by default, while other methods like `POST` can be made cacheable if the server explicitly indicates it.

Having a basic understanding of the different HTTP methods, or verbs, an API can use is essential for working with APIs.

#### GET

`GET` requests are the most common and widely used HTTP methods in RESTful APIs and web services. Simply put, the `GET` method is used to retrieve data from a server at the specified resource. When a client sends a `GET` request, it is asking the server to return the requested data without making any changes to the server's state.

For example, say you have an API with an endpoint of `/users`. Making a `GET` request to this endpoint would typically return a list of users in the system.

Since a `GET` request is only used to retrieve data and does not modify any resources on the server, it is considered a safe and idempotent method. This means that making multiple identical `GET` requests will have the same effect as making a single request, and it will not change the state of the server.

#### POST

In web services, `POST` requests are used to send data to the server to create or update a resource. When a client sends a `POST` request, it typically includes data in the request body that the server will use to create a new resource or update an existing one.

The simplest example of a `POST` request is a contact form on a website. When you fill out the inputs in a form and hit submit, the browser sends a `POST` request to the server with the form data in the request body. This may be `JSON`, `XML`, query string parameters, or plenty of other formats.

`POST` requests are not idempotent, meaning that making the same `POST` request multiple times may result in different outcomes. For example, if you submit a form multiple times, it may create multiple entries in a database.

#### PUT

Similar to `POST`, `PUT` requests are used to send data to the server to create or update a resource. However, there are some key differences between the two methods. `PUT` requests are typically used to update an existing resource, while `POST` requests are used to create a new resource. Additionally, `PUT` requests are idempotent, meaning that making the same `PUT` request multiple times will have the same effect as making it once.
In contrast, `POST` requests are not idempotent, meaning that making the same `POST` request multiple times may result in different outcomes.

Generally, when a `PUT` request creates a resource, the sever will respond with a `201 Created` status code. If the `PUT` request updates an existing resource, the server will typically respond with a `200 OK` or `204 No Content` status code.

#### PATCH

A `PATCH` request is used to apply partial modifications to a resource on the server. Unlike `PUT`, which typically requires the entire resource representation to be sent in the request body, `PATCH` allows you to send only the changes you want to make. This makes `PATCH` more efficient for updating resources when only a few fields need to be modified.

The difference between a `PUT` and a `PATCH` is that a `PATCH` request is typically non-idempotent, meaning that making the same `PATCH` request multiple times may result in different outcomes. In contrast, `PUT` requests are idempotent, meaning that making the same `PUT` request multiple times will have the same effect as making it once.

For example, let's say you have an endpoint of `/users/{{userId}}` that represents a user resource. With a `PATCH` request, you can update just the user's email address without affecting other fields like their name or age. You can send the updated email address in the request body, and the server will apply the change to the existing user resource.

#### DELETE

The `DELETE` request method is exactly what it sounds like: it deletes a specified resource from the server. When a client sends a `DELETE` request, it is asking the server to remove the specified resource. This method is one of the more common HTTP methods used in RESTful APIs and web services.

If a new user is created with a `POST` request to the `/users` endpoint, and it can be retrieved with a `GET` request to `/users/{{userId}}`, then a `DELETE` request to `/users/{{userId}}` would remove that user from the system.

`DELETE` requests are idempotent, meaning that making the same `DELETE` request multiple times will have the same effect as making it once. For example, if you send a `DELETE` request to remove a user, sending the same request again will not result in an error; the user will simply remain deleted.

When a resource is successfully deleted, the server typically responds with a `200 OK` status code along with a message confirming the deletion, or a `204 No Content` status code indicating that the request was successful but there is no content to return. If the resource to be deleted does not exist, the server may respond with a `404 Not Found` status code.

#### HEAD

The `HEAD` request method is similar to the `GET` method, but without the response body. When a client sends a `HEAD` request, it is asking the server to return the headers of the specified resource without the actual content. This method is useful for checking if a resource exists, retrieving metadata, or checking for modifications without downloading the entire resource.

For example, if you want to check if a specific user exists in the system, you can send a `HEAD` request to the `/users/{{userId}}` endpoint. The server will respond with the headers, including status codes like `200 OK` if the user exists or `404 Not Found` if the user does not exist.

`HEAD` requests are considered safe and idempotent, meaning that they do not change the state of the server and making multiple identical `HEAD` requests will have the same effect as making a single request.

It's worth pointing out that not every endpoint that supports `GET` will also support `HEAD`, although it is common practice to implement both methods for the same resource.

#### OPTIONS

The `OPTIONS` request method is used to describe the communication options for the target resource. When a client sends an `OPTIONS` request, it is asking the server to return the HTTP methods that are supported for the specified resource. This method is useful for discovering the capabilities of a web server or API endpoint.

For example, if you want to know which HTTP methods are supported for the `/users` endpoint, you can send an `OPTIONS` request to that endpoint. The server will respond with the allowed methods in the `Allow` header, such as `GET`, `POST`, `PUT`, `DELETE`, etc.

`OPTIONS` requests are considered safe and idempotent, meaning that they do not change the state of the server and making multiple identical `OPTIONS` requests will have the same effect as making a single request.

#### TRACE

The `TRACE` request method is used to perform a message loop-back test along the path to the target resource. When a client sends a `TRACE` request, it is asking the server to return the exact request message that was received, allowing the client to see how the request was modified or processed by intermediate servers. This method is primarily used for diagnostic purposes and debugging.

For example, if you want to see how your request is being handled by the server and any intermediate proxies, you can send a `TRACE` request to a specific endpoint. The server will respond with the original request message, including any modifications made along the way.

`TRACE` requests are considered safe and idempotent, meaning that they do not change the state of the server and making multiple identical `TRACE` requests will have the same effect as making a single request. However, due to security concerns, many servers disable the `TRACE` method to prevent potential cross-site tracing attacks.

### Real World Application

#### Why Do We Need HTTP Methods?

Through the HTTP protocol, resources are exchanged between client devices and servers over the internet. Client devices send requests to servers for the resources needed to load a web page; the servers send responses back to the clients to fulfill those requests. Requests and responses share subdocuments such as data on images, text, text layout, and more, which are pieced together by a browser to render a web page.

The resource exchanges described above are made possible by HTTP methods, also known as HTTP verbs. HTTP methods are a set of request methods that indicate the desired action to be performed on a given resource. Each method implements a different semantic, but some common features are shared by a group of them.

Knowledge of HTTP methods is essential to understanding HTTP and how the web works. It is also important for web developers, as they need to know which methods to use when building web applications and APIs.

### Implementation

We will be using `cURL` to demonstrate the different HTTP methods. `cURL` is a command-line tool used to transfer data to or from a server using various protocols, including HTTP, HTTPS, FTP, and more. It is widely used for testing and interacting with APIs, as it allows you to send requests and receive responses directly from the command line.

#### GET Request

Use the following command in your CLI to make a `GET` request to the specified URL:

```bash
curl -X GET "https://regres.in/api/users/2"
```

This command sends a `GET` request to the URL `https://regres.in/api/users/2`, which retrieves information about the user with ID 2. The `-X GET` option specifies that the request method is `GET`.

The server will respond with the following JSON data:

```json
{
  "data": {
    "id": 2,
    "email": "janet.weaver@reqres.in",
    "first_name": "Janet",
    "last_name": "Weaver",
    "avatar": "https://reqres.in/img/faces/2-image.jpg"
  },
  "support": {
    "url": "https://reqres.in/#support-heading",
    "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
  }
}
```

What we get back is the response body, or the data sent back from the server. In this case, we get back a JSON object containing information about the user with ID 2, including their email, first name, last name, and avatar URL.

We can learn more about the response by adding the `-i` flag to our `cURL` command, which includes the response headers in the output:

```bash
curl -i -X GET "https://regres.in/api/users/2"
```

This will give us additional information about the response, such as the status code, content type, and more:

```bash
HTTP/1.1 200 OK
Date: Thu, 18 Apr 2024 14:01:59 GMT
Content-Type: application/json; charset=utf-8
Content-Length: 280
Connection: keep-alive
# ... more output omitted

{
    "data":
    {
        "id":2,
        "email":"janet.weaver@reqres.in",
        "first_name":"Janet",
        "last_name":"Weaver",
        "avatar":"https://reqres.in/img/faces/2-image.jpg"
    },
    "support":
    {
        "url":"https://reqres.in/#support-heading",
        "text":"To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
```

This response returns information about the request, including the HTTP version, status code, date, content type, and more. The status code `200 OK` indicates that the request was successful.

#### POST Request

Use the following command in your CLI to make a `POST` request to the specified URL with a JSON payload:

```bash
curl -X POST -d "{\"first_name\": \"Kendra\", \"last_name\": \"Jackson\"}" -H "Content-Type: application/json" https://reqres.in/api/users/2
```

This command sends a `POST` request to the URL `https://reqres.in/api/users/2`, which creates a new user with the specified first and last name. The `-d` option is used to specify the data to be sent in the request body, and the `-H` option is used to set the `Content-Type` header to `application/json`, indicating that the data being sent is in JSON format.

The server will respond with the following JSON data:

```json
{
  "first_name": "Kendra",
  "last_name": "Jackson",
  "id": "123",
  "createdAt": "2024-04-18T14:05:00.000Z"
}
```

This response indicates that a new user has been created with the specified first and last name, along with a unique ID and a timestamp of when the user was created.

#### PUT Request

Use the following command in your CLI:

```bash
curl -X PUT -d "{\"first_name\": \"Kendra\", \"last_name\": \"Jackson\"}" -H "Content-Type: application/json" https://reqres.in/api/users/2
```

This command sends a `PUT` request to the URL `https://reqres.in/api/users/2`, which updates the user with ID 2 to have the specified first and last name.

The server will respond with the following JSON data:

```json
{
  "first_name": "Kendra",
  "last_name": "Jackson",
  "id": "2",
  "updatedAt": "2024-04-18T14:05:00.000Z"
}
```

This response indicates that the user with ID 2 has been updated with the new first and last name, along with a timestamp of when the user was updated.

#### DELETE Request

Use the following command in your CLI:

```bash
curl -X DELETE https://reqres.in/api/users/2
```

This command sends a `DELETE` request to the URL `https://reqres.in/api/users/2`, which deletes the user with ID 2.

The server will respond with the following JSON data:

```json
{
  "id": "2",
  "deletedAt": "2024-04-18T14:05:00.000Z"
}
```

This response indicates that the user with ID 2 has been successfully deleted, along with a timestamp of when the user was deleted.
