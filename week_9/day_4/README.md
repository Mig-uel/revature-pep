# Spring and Spring Boot Basics - Day 4

## Controllers and `@Controller` Annotation

In Spring Web, a **Controller** is a class that acts as the entry point for handling HTTP requests. Controllers are responsible for processing incoming requests, preparing a model, and returning the appropriate view to be rendered.

Controllers follow the Model-View-Controller (MVC) design pattern, separating business logic, user interface, and request handling.

#### `@Controller`

The `@Controller` annotation is used to define a controller class in Spring. It marks a class as a Spring MVC controller, allowing it to handle web requests and typically returns a view name to be rendered.

Example:

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello";
    }
}
```

In this example, `MyController` is a controller class that handles GET requests to the `/hello` endpoint. It adds a message to the model and returns the view name `hello`, which corresponds to a template (e.g., `hello.html`).

#### `@RestController`

The `@RestController` annotation is a convenience annotation that combines `@Controller` and `@ResponseBody`. It is used to create RESTful web services where the controller methods return data directly (usually in JSON or XML format) instead of rendering a view.

Example:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, Spring REST!");
        return response;
    }
}
```

In this example, `MyRestController` is a REST controller that handles GET requests to the `/api/hello` endpoint. It returns a JSON response containing a message.

#### Key Annotations

- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: These annotations are used to map HTTP methods to specific controller methods.
- `@RequestParam`: Used to bind request parameters to method parameters.
- `@PathVariable`: Used to bind URI template variables to method parameters (e.g., `/users/{id}`).
- `@RequestBody`: Used to bind the body of a request to a method parameter, typically for POST or PUT requests.
- `@ResponseBody`: Indicates that the return value of a method should be used as the response body, typically in RESTful services.
- `@RequestMapping`: A more general annotation that can be used to map HTTP requests to handler methods, supporting multiple HTTP methods and paths (e.g., `@RequestMapping(value = "/path", method = RequestMethod.GET)`).
