# APIs and Testing - Day 2

## Introduction to REST

**REpresentational State Transfer (REST)** is an architectural style for designing networked applications. It defines a set of constraints and principles for creating web services that are scalable, stateless, and easy to maintain.

A **RESTful API** is a way of accessing web services using standard HTTP methods such as GET, POST, PUT, DELETE, etc. RESTful APIs are designed to be simple, lightweight, and easy to use.

REST technology is generally preferred to the more robust Simple Object Access Protocol (SOAP) technology because REST is easier to use and more flexible. REST uses less bandwidth, making it suitable for internet usage. It is used to fetch or modify resources from a web service. All RESTful APIs are HTTP-based, but not all HTTP-based APIs are RESTful.

In HTTP, there are several methods that are commonly used in a RESTful architecture:

- **GET**: Retrieves data from a server. It is used to fetch resources without modifying them.
- **POST**: Sends data to a server to create a new resource. It is used to submit data for processing.
- **PUT**: Updates an existing resource on the server. It is used to modify or replace a resource.
- **DELETE**: Removes a resource from the server. It is used to delete a resource.
- **PATCH**: Partially updates an existing resource on the server. It is used to modify specific fields of a resource.

These correspond to the CRUD operations:

| CRUD Operation | HTTP Method |
| -------------- | ----------- |
| Create         | POST        |
| Read           | GET         |
| Update         | PUT/PATCH   |
| Delete         | DELETE      |

#### REST Constraints

There are some key constraints to consider when considering if a RESTful API is the right choice for your application:

- **Client-Server**: This constraint operates on the concept that the client and server should be separate entities and allows to evolve independently.
- **Stateless**: REST APIs are stateless, meaning that each request from a client to a server must contain all the information needed to understand and process the request. The server does not store any client context between requests.
- **Cacheable**: Because a stateless API can increase request overhead by handling large loads of incoming and outbound calls, a RESTful API should be able to encourage and cache responses to improve performance.
- **Uniform Interface**: RESTful APIs should have a consistent and uniform interface, making it easy for clients to interact with the API. This includes using standard HTTP methods, URIs, and media types.
- **Layered System**: A RESTful API can be composed of multiple layers, each with its own responsibilities. This allows for scalability and flexibility in the architecture.
- **Code on Demand (optional)**: This constraint allows servers to extend the functionality of a client by sending executable code, such as JavaScript, to be executed on the client side.

#### Using RESTful APIs

- You access data via endpoints (URIs) that represent resources.
  - For example, `/users/Ada` lets you access the user resource for Ada.
- You use HTTP methods to perform actions on those resources.
  - For example, you'd view Ada's information with a GET request to `/users/Ada`. You could modify her info with a POST or PUT request to the same endpoint.
  - You can use the other HTTP methods as needed (DELETE, PATCH, etc.).
- You can represent data however you want.
  - For example, that GET request to `/users/Ada` could return Ada's info in JSON string format. The POST request to modify her info could take a JSON string in the request body.
  - You could also use XML or another format, but JSON is the most common.
- Each request should be standalone/stateless.
  - For example, the GET request to `/users/Ada` should include all the information needed to process the request. The server shouldn't need to remember anything about previous requests from the client.

### Real World Application

Understanding REST (REpresentational State Transfer) is crucial for modern software development for several reasons:

- **Standardization**: REST has become the de facto standard for designing web APIs. Many popular services, such as Twitter, Facebook, and Google, use RESTful APIs to allow developers to interact with their platforms. Understanding REST allows developers to adhere to industry best practices and standards when designing and implementing APIs, promoting consistency and interoperability across different systems.
- **Statelessness**: RESTful APIs are stateless, meaning that each request from a client to a server must contain all the information needed to understand and process the request. This statelessness simplifies server design, improves scalability, and allows for easier caching of responses, leading to better performance and reduced latency.
- **Uniform Interface**: RESTful APIs have a uniform interface, which means that they use standard HTTP methods (GET, POST, PUT, DELETE) and URIs to interact with resources. This uniformity makes it easier for developers to understand and use APIs, as they can rely on familiar patterns and conventions.
- **Flexibility**: Data is not tied to resources or methods, allowing for a more flexible and adaptable architecture. This flexibility enables developers to evolve their APIs over time without breaking existing clients.
- **Interoperability**: RESTful APIs can be consumed by a wide range of clients, including web browsers, mobile apps, and server-side applications. This interoperability allows developers to create applications that can interact with various services and platforms, enhancing the overall user experience.

In summary, understanding REST is essential for modern software development as it enables developers to create scalable, flexible, and interoperable web APIs that adhere to industry standards and best practices.

### Implementation

REST stands for REpresentational State Transfer, which is a set of rules and conventions for building web services. RESTful APIs use standard HTTP methods (GET, POST, PUT, DELETE) to perform operations on resources, which are identified by URIs (Uniform Resource Identifiers).

Let's consider an example of a website that provides access to book data. Programming languages have many different libraries and frameworks that can be used to create RESTful APIs. When you access a REST API's data, you do not need to know how the REST API works, you just need to know the interface (the endpoints, the data format, etc.) it provides.

Let's say the book website provides the following API:

The API will allow clients to perform CRUD (Create, Read, Update, Delete) operations on book resources using its interface, which is by sending HTTP requests to specific endpoints.

| HTTP Method | Endpoint        | Description                        |
| ----------- | --------------- | ---------------------------------- |
| GET         | /api/books      | Retrieve a list of all books       |
| GET         | /api/books/{id} | Retrieve a specific book by its ID |
| POST        | /api/books      | Create a new book                  |
| PUT         | /api/books/{id} | Update an existing book by its ID  |
| DELETE      | /api/books/{id} | Delete a book by its ID            |

You can send these requests from a web browser or an application you develop. An example request/response exchange might look like this:

Make the request on a terminal:

```bash
curl -X GET http://example.com/api/books
```

Data returned from the server:

```json
[
  {
    "id": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "published_year": 1925
  },
  {
    "id": 2,
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "published_year": 1960
  }
]
```

This response is in JSON format, which is a common data format used in RESTful APIs. The client can then parse this JSON data and use it as needed.
