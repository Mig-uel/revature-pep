# TypeScript and Angular - Day 4

## Route Guards

Angular Route Guards are interfaces that allow you to control navigation to and from routes in your application. They can be used to prevent unauthorized access to certain routes, confirm navigation away from a route, or preload data before a route is activated.
In simpler terms, an Angular Route Guard is used to secure routes and manage navigation based on certain conditions.

Uses of Route Guards:

- To confirm navigation away from a route (e.g., unsaved changes).
- Asking whether to save data before moving away from the view.
- Allow access to certain parts of the application to specific users (e.g., admin routes).
- Validating the route parameters before navigating to the route.
- Fetching some data before you display the component view.

#### Types of Route Guards:

- `CanActivate`: Decides if a route can be activated.
- `CanDeactivate`: Decides if a route can be deactivated (e.g., unsaved changes).
- `Resolve`: Pre-fetches data before activating a route.
- `CanLoad`: Prevents the application from loading entire modules lazily.
- `CanActivateChild`: Decides if child routes can be activated.
- `CanMatch`: Decides if a route can be matched.

### Real World Application

- `CanActivate` is commonly used for authentication and authorization checks.
- `CanDeactivate` is useful for forms where users might have unsaved changes.
- `Resolve` is often used to fetch data required for a component before it is displayed.
- `CanLoad` is used to prevent loading of feature modules based on user roles or permissions.
- `CanActivateChild` is useful for protecting child routes within a parent route.
- `CanMatch` is used to determine if a route should be matched based on custom logic.

### Implementation

#### Step 1

We create a guard service using Angular CLI:

```bash
ng generate guard auth
```

#### Step 2

The guard service should implement any of the guard interfaces based on the requirement. For example, to implement `CanActivate`:

```typescript
import { CanActivate } from "@angular/router";

export class AuthGuard implements CanActivate {
  canActivate(): boolean {
    // Logic to determine if the route can be activated
    return true; // or false based on the condition
  }
}
```

#### Step 3

The guard service should implement the method defined in the interface. For `CanActivate`, it is `canActivate`. It should return a boolean or an Observable/Promise that resolves to a boolean. It it returns `true`, the route is activated; if it returns `false`, the route is not activated.

```typescript
import {
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  UrlTree,
} from "@angular/router";
import { Observable } from "rxjs";

export class RouteGuardService implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    return true;
  }
}
```

#### Step 4

Finally, we need to register the guard service in the routing module for the routes we want to protect.

```typescript
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AuthGuard } from "./auth.guard";
import { ProtectedComponent } from "./protected/protected.component";

const routes: Routes = [
  {
    path: "protected",
    component: ProtectedComponent,
    canActivate: [AuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
```

## Services and Dependency Injection

A service in Angular is a class that provides specific functionality that can be shared across components. Services are typically used for tasks such as data fetching, business logic, and state management.

Dependency Injection (DI) is a design pattern used in Angular to provide components with their dependencies rather than having the components create them. This promotes loose coupling and makes the code more modular and testable.

A service can be created and injected in the following way:

- Create a class and decorate it with `@Injectable()`.
- Register the service in a module or component using the `providers` array.
- We can add the service tho the `providers` array property in either:
  - The `@NgModule` decorator of a module (e.g., `AppModule`) which makes the service available application-wide.
  - The `@Component` decorator of a component which makes the service available only to that component and its child components.
- Inject the service into a component or another service using the constructor.
  - We achieve dependency injection by adding the service as a parameter in the constructor of the component or service where it is needed.

```typescript
export class MyComponent {
  constructor(private myService: MyService) {}
}
```
