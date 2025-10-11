# Spring, HTML/CSS, JavaScript Intro - Day 2

## Spring Boot Actuator

Spring Boot Actuator is a sub-project of Spring Boot Framework that provides production-ready features to help you monitor and manage your application. It offers a set of built-in endpoints that expose various metrics, health checks, and other useful information about your application.

#### Key Features of Spring Boot Actuator

- **Endpoints**: Actuator provides several built-in endpoints that can be accessed via HTTP or JMX. Some common endpoints include:
  - `/actuator/health`: Displays the health status of the application.
  - `/actuator/info`: Provides general information about the application.
  - `/actuator/metrics`: Exposes various metrics about the application, such as memory usage, CPU usage, and request counts.
  - `/actuator/env`: Shows the current environment properties and configurations.
  - `/actuator/loggers`: Allows you to view and modify the logging levels of your application at runtime.
- **Health Checks**: Provides endpoints to check the health of your application, including database connectivity, disk space, and custom health indicators.
- **Metrics**: Collects and exposes various metrics about your application, such as memory usage, garbage collection, web request statistics, and more. These metrics can be integrated with monitoring systems like Prometheus, Grafana, etc and be used to identify performance bottlenecks and optimize resource usage.
- **Application Info**: Provides detailed information about the application, including version, build time, and other custom metadata.
- **Loggers**: Actuator provided the ability to view and modify the logging levels of your application at runtime, which can be useful for debugging and troubleshooting.
- **Auditing**: It automatically audits events in your application, which can be accessed through the `/actuator/auditevents` endpoint.
- **HTTP Tracing**: Actuator provides HTTP tracing capabilities, allowing you to trace incoming HTTP requests and responses up to the last 100 requests. This can be useful for debugging and monitoring purposes.

#### Security

Actuator endpoints expose sensitive information about your application, so it's important to secure them properly.

---

Spring Boot Actuator is an essential tool for monitoring and managing Spring Boot applications in production environments. It provides valuable insights into the health, performance, and behavior of your application, helping you ensure its reliability and stability. This is a must-have tool for any serious Spring Boot developer.

### Real World Application

Here are some real-world application of Spring Boot Actuator:

- **Continuous Monitoring**: Operations teams can continuously monitor the health and performance of Spring Boot applications in production environments using Actuator endpoints. This helps identify issues early and ensures the application is running smoothly.
- **Integration with Monitoring Systems**: Health checks provided by Spring Boot Actuator can be integrated with external monitoring systems like Prometheus, Grafana, or New Relic. This allows for centralized monitoring and alerting based on the health status of the application.
- **Performance Optimization**: Developers can use metrics to identify performance bottlenecks and optimize resource usage. For example, if memory usage is consistently high, developers can investigate and optimize memory-intensive operations.
- **Capacity Planning**: Operations teams can use metrics to plan for capacity upgrades based on trends in resource usage over time. This helps ensure that the application can handle increased traffic and workload.
- **Debugging and Troubleshooting**: Developers and operations teams can use logging endpoints to troubleshoot issues in production environments and debug problems quickly.
- **Compliance and Security**: Audit endpoints provide insights into security-related events, helping organizations meet compliance requirements and enhance security measures.
- **Configuration Management**: Operations teams can use environment information to troubleshoot configuration-related issues in production environments.
- **Troubleshooting Configuration Issues**: Developers can use environment information to troubleshoot configuration-related issues in production environments.
- **Business-specific Monitoring**: Developers can create custom endpoints to monitor business-specific metrics and events, providing insights into application-specific behavior.
- **Operational Tasks**: Operations teams can create custom endpoints to perform operational tasks, such as clearing caches or triggering specific actions in the application.

### Implementation

This is an example of setting up Spring Boot Actuator in a Spring Boot application and monitoring its basic endpoints. Let's say we have a simple Spring Boot application that includes: Spring Web and Spring Boot Actuator dependencies.

#### Step 1: Enable Actuator Endpoints

Spring Boot Actuator comes with several built-in endpoints, but some of them are disabled by default for security reasons. To enable specific endpoints, you can configure them in the `application.properties` or `application.yml` file.

```bash
management.endpoints.web.exposure.include=* # Enable all endpoints
# or
management.endpoints.web.exposure.include=health,info,metrics # Enable specific endpoints
```

This configuration will expose all Actuator endpoints over HTTP. However, exposing all endpoints in a production environment is not recommended for security reasons. For the sake of this example and testing purposes, we will enable all endpoints but in a production environment, you should only enable the necessary endpoints.

#### Step 2: Access Actuator Endpoints

Once the application is running, we can access the Actuator endpoints via HTTP.

The most basic endpoint is the `/actuator/health` endpoint, which provides information about the health status of the application.

```bash
curl http://localhost:8080/actuator/health # Access health endpoint
```

We should see a response like this:

```json
{
  "status": "UP"
}
```
