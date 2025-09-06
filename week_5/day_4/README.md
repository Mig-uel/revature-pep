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

## HTTP Status Codes

HTTP status codes are issued by a server in response to a client's request made to the server. They are part of the HTTP protocol and are used to indicate the outcome of the request. Status codes are grouped into five classes, based on the first digit of the code:

- **1xx (Informational)**: These status codes indicate that the request has been received and is being processed. They are provisional responses and are rarely used in practice. Examples include `100 Continue` and `101 Switching Protocols`.
- **2xx (Successful)**: These status codes indicate that the request was successfully received, understood, and accepted. Common examples include:
  - `200 OK`: The request was successful, and the server returned the requested data.
  - `201 Created`: The request was successful, and a new resource was created as a result.
  - `204 No Content`: The request was successful, but there is no content to return.
- **3xx (Redirection)**: These status codes indicate that further action is needed to complete the request. They are used for URL redirection and other similar purposes. Common examples include:
  - `301 Moved Permanently`: The requested resource has been permanently moved to a new URL.
  - `302 Found`: The requested resource is temporarily located at a different URL.
  - `304 Not Modified`: The resource has not been modified since the last request, so the client can use its cached version.
- **4xx (Client Error)**: These status codes indicate that the client made an error in the request. Common examples include:
  - `400 Bad Request`: The server could not understand the request due to invalid syntax.
  - `401 Unauthorized`: The client must authenticate itself to get the requested response.
  - `403 Forbidden`: The client does not have access rights to the content.
  - `404 Not Found`: The server could not find the requested resource.
- **5xx (Server Error)**: These status codes indicate that the server encountered an error while processing the request. Common examples include:
  - `500 Internal Server Error`: The server encountered an unexpected condition that prevented it from fulfilling the request.
  - `502 Bad Gateway`: The server received an invalid response from an inbound server while acting as a gateway or proxy.
  - `503  Service Unavailable`: The server is not ready to handle the request, often due to being overloaded or down for maintenance.

The term "HTTP status code" is actually the common term for the HTTP status line that includes the status code, a textual phrase describing the status code, and the HTTP version being used. For example, a typical HTTP status line might look like this:

```HTTP/1.1 200 OK

```

In this example, `HTTP/1.1` is the HTTP version, `200` is the status code, and `OK` is the textual phrase describing the status code.

### Real World Application

#### How Are HTTP Status Codes Used?

HTTP status code (aka browser/internet error codes) are three-digit numbers that indicate the result of a client's request to a server. They are used by web servers to communicate the status of a request to the client, and they can provide valuable information about the success or failure of the request.

When a client makes a request to a server, the server responds with an HTTP status code in the response header. The status code indicates whether the request was successful, whether there was an error, or whether further action is needed.

These codes help identify the cause of an issue when a web page or other resource does not load correctly. For example, if a user tries to access a web page that does not exist, the server will respond with a `404 Not Found` status code, indicating that the requested resource could not be found.

### Implementation

The following below is a list of HTTP status codes with their meanings.

#### 1xx Informational

- `100 Continue`: The server has received the request headers and the client should proceed to send the request body.
- `101 Switching Protocols`: The requester has asked the server to switch protocols and the server has agreed to do so. This code is sent in response to an `Upgrade` request header from the client.
- `102 Processing`: The server has received and is processing the request, but no response is available yet.
- `103 Early Hints`: Used to return some response headers before the final HTTP message. This can be useful to allow the user agent to start preloading resources while the server is still preparing a response.

#### 2xx Success

- `200 OK`: The request was successful, and the server returned the requested data. The result meaning of "success" varies depending on the HTTP method used:
  - `GET`: The resource has been fetched and is transmitted in the message body.
  - `HEAD`: The entity headers are in the message body.
  - `POST`: The resource describing the result of the action is transmitted in the message body.
  - `TRACE`: The message body contains the request message as received by the server.
- `201 Created`: The request was successful, and a new resource was created as a result. This is typically the response to a `POST` request that creates a new resource.
- `202 Accepted`: The request has been received but not yet acted upon. It is non-committal, meaning that there is no way for the server to send an asynchronous response indicating the outcome of the request. This status code is typically used for batch processing or long-running requests.
- `203 Non-Authoritative Information`: The request was successful, but the returned metadata is not exactly the same as available from the origin server. This status code is typically used when a proxy or intermediary modifies the response.
- `204 No Content`: The request was successful, but there is no content to return. This status code is typically used for `DELETE` requests or when the server has fulfilled the request but does not need to return any content.
- `205 Reset Content`: The server has fulfilled the request and the user agent should reset the document view that caused the request to be sent. This status code is typically used in response to a `PUT` or `POST` request that modifies a resource.
- `206 Partial Content`: The server is delivering only part of the resource due to a range header sent by the client. This status code is typically used for resuming interrupted downloads or for streaming media.
- `207 Multi-Status`: The message body that follows is an XML message and can contain a number of separate response codes, depending on how many sub-requests were made. This status code is typically used in WebDAV applications.
- `208 Already Reported`: The members of a DAV binding have already been enumerated in a previous reply to this request, and are not being included again. This status code is typically used in WebDAV applications.
- `226 IM Used`: The server has fulfilled a `GET` request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.

#### 3xx Redirection

- `300 Multiple Choices`: The request has more than one possible response. The user agent or user should choose one of them. There is no standardized way of choosing one of the responses.
- `301 Moved Permanently`: The requested resource has been permanently moved to a new URL. The response should include the new URL in the `Location` header.
- `302 Found`: The requested resource is temporarily located at a different URL. The response should include the temporary URL in the `Location` header. Note that this status code is often used for temporary redirects, but it can also be used for permanent redirects in some cases.
- `303 See Other`: The response to the request can be found under a different URL and should be retrieved using a `GET` request. This status code is typically used after a `POST` request to redirect the client to a confirmation page.
- `304 Not Modified`: The resource has not been modified since the last request, so the client can use its cached version. This status code is typically used in response to a `GET` or `HEAD` request with an `If-Modified-Since` or `If-None-Match` header.
- `305 Use Proxy`: The requested resource is only available through a proxy, the address for which is provided in the response. This status code is deprecated and should not be used.
- `306 Switch Proxy`: No longer used. Originally meant "Subsequent requests should use the specified proxy."
- `307 Temporary Redirect`: The requested resource is temporarily located at a different URL, and the client should use the same HTTP method for the subsequent request. The response should include the temporary URL in the `Location` header.
- `308 Permanent Redirect`: The requested resource has been permanently moved to a new URL, and the client should use the same HTTP method for the subsequent request. The response should include the new URL in the `Location` header.

#### 4xx Client Error

- `400 Bad Request`: The server could not understand the request due to invalid syntax. This status code is typically used when the client sends malformed or invalid data in the request.
- `401 Unauthorized`: The client must authenticate itself to get the requested response. This status code is typically used when the client tries to access a protected resource without providing valid authentication credentials.
- `402 Payment Required`: This status code is reserved for future use and is not currently used in practice. It was originally intended to be used for digital payment systems, but it has not been widely adopted.
- `403 Forbidden`: The client does not have access rights to the content, so the server is refusing to fulfill the request. This status code is typically used when the client is authenticated but does not have the necessary permissions to access the resource.
- `404 Not Found`: The server could not find the requested resource. This status code is typically used when the client tries to access a resource that does not exist on the server.
- `405 Method Not Allowed`: The request method is known by the server but is not supported by the target resource. For example, a `GET` request on a form that requires data to be presented via `POST`, or a `PUT` request on a read-only resource.
- `406 Not Acceptable`: The server cannot produce a response matching the list of acceptable values defined in the request's proactive content negotiation headers, and the server is unwilling to supply a default representation.
- `407 Proxy Authentication Required`: The client must first authenticate itself with the proxy. This status code is similar to `401 Unauthorized`, but it indicates that the client must authenticate with a proxy server rather than the origin server.
- `408 Request Timeout`: The server timed out waiting for the request. This status code is typically used when the client takes too long to send the request or when the server is overloaded and cannot process the request in a timely manner.
- `409 Conflict`: The request could not be completed due to a conflict with the current state of the resource. This status code is typically used when the client tries to update a resource that has been modified by another client since it was last retrieved.
- `410 Gone`: The requested resource is no longer available and will not be available again. This status code is typically used when a resource has been permanently deleted from the server.
- `411 Length Required`: The server refuses to accept the request without a defined `Content-Length` header. This status code is typically used when the client sends a request with a body but does not include the `Content-Length` header.
- `412 Precondition Failed`: The server does not meet one of the preconditions that the requester put on the request. This status code is typically used when the client sends a request with conditional headers, such as `If-Match` or `If-Unmodified-Since`, and the condition is not met.
- `413 Payload Too Large`: The request is larger than the server is willing or able to process. This status code is typically used when the client sends a request with a large body that exceeds the server's limits.
- `414 URI Too Long`: The URI provided was too long for the server to process. This status code is typically used when the client sends a request with a long URL that exceeds the server's limits.
- `415 Unsupported Media Type`: The request entity has a media type which the server or resource does not support. This status code is typically used when the client sends a request with a body in a format that the server does not understand or support.
- `416 Range Not Satisfiable`: The client has asked for a portion of the file (byte serving), but the server cannot supply that portion. For example, if the client requests a range that is outside the size of the target resource.
- `417 Expectation Failed`: The server cannot meet the requirements of the `Expect` request-header field. This status code is typically used when the client sends a request with an `Expect` header that the server cannot fulfill.
- `418 I'm a teapot`: This code was defined in 1998 as an April Fools' joke in RFC 2324, Hyper Text Coffee Pot Control Protocol, and is not expected to be implemented by actual HTTP servers. The code is used to indicate that the server is a teapot and cannot brew coffee.
- `421 Misdirected Request`: The request was directed at a server that is not able to produce a response. This can be sent by a server that is not configured to produce responses for the combination of scheme and authority that are included in the request URI.
- `422 Unprocessable Entity`: The request was well-formed but was unable to be followed due to semantic errors. This status code is typically used in WebDAV applications.
- `423 Locked`: The resource that is being accessed is locked. This status code is typically used in WebDAV applications
- `424 Failed Dependency`: The request failed because it depended on another request and that request failed. This status code is typically used in WebDAV applications.
- `425 Too Early`: Indicates that the server is unwilling to risk processing a request that might be replayed. This status code is typically used to prevent replay attacks.
- `426 Upgrade Required`: The client should switch to a different protocol such as TLS/1.0, given in the `Upgrade` header field. This status code is typically used when the server requires a secure connection.
- `428 Precondition Required`: The origin server requires the request to be conditional. This status code is typically used to prevent the "lost update" problem, where a client might overwrite changes made by another client.
- `429 Too Many Requests`: The user has sent too many requests in a given amount of time ("rate limiting"). This status code is typically used to prevent abuse or overloading of the server.
- `431 Request Header Fields Too Large`: The server is unwilling to process the request because its header fields are too large. The request may be resubmitted after reducing the size of the request header fields.
- `451 Unavailable For Legal Reasons`: The user-agent requested a resource that cannot legally be provided, such as a web page censored by a government.

#### 5xx Server Error

- `500 Internal Server Error`: The server encountered an unexpected condition that prevented it from fulfilling the request. This status code is typically used when the server encounters an error that is not covered by any other status code.
- `501 Not Implemented`: The server does not support the functionality required to fulfill the request. This status code is typically used when the server does not recognize the request method or lacks the ability to fulfill the request.
- `502 Bad Gateway`: The server, while acting as a gateway or proxy, received an invalid response from the upstream server it accessed in attempting to fulfill the request. This status code is typically used when the server is acting as a reverse proxy or load balancer.
- `503 Service Unavailable`: The server is not ready to handle the request. Common causes are a server that is down for maintenance or that is overloaded. This status code is typically used when the server is temporarily unable to handle the request.
- `504 Gateway Timeout`: The server, while acting as a gateway or proxy, did not receive a timely response from the upstream server specified by the `URI` (e.g., HTTP, FTP, LDAP) or some other auxiliary server (e.g., DNS) it needed to access in order to complete the request. This status code is typically used when the server is acting as a reverse proxy or load balancer.
- `505 HTTP Version Not Supported`: The server does not support the HTTP protocol version used in the request. This status code is typically used when the client sends a request with an unsupported HTTP version.
- `506 Variant Also Negotiates`: The server has an internal configuration error: the chosen variant is configured to engage in transparent content negotiation itself, and is therefore not a proper end point in the negotiation process.
- `507 Insufficient Storage`: The server is unable to store the representation needed to complete the request. This status code is typically used in WebDAV applications.
- `508 Loop Detected`: The server detected an infinite loop while processing the request. This status code is typically used in WebDAV applications.
- `510 Not Extended`: Further extensions to the request are required for the server to fulfill it. This status code is typically used when the server requires additional information or extensions to process the request.
- `511 Network Authentication Required`: The client needs to authenticate to gain network access. This status code is typically used by captive portals that require users to authenticate before accessing the internet.
