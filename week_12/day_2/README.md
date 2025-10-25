# TypeScript and Angular - Day 2

## `@component` Decorator

Components are the building blocks of Angular applications.

A component consists of:

- **Selector**: A CSS selector that identifies this component in a template.
- **Template**: The HTML that defines the view for the component.
- **Styles**: CSS styles specific to this component.
- **Class**: The TypeScript class that contains the logic for the component.

Example:

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "my-app";
}
```

#### Advantages of Angular Components

- Single page applications can be created using components.
- Components are independent and reusable. So, if an error occurs with one component, the functionality of other components is not affected.
- Angular components support lazy loading (only components necessary for the current view are loaded), which improves performance.
- Components can be nested within other components to create complex UIs.

#### Component Decorator

The `@Component` decorator is a function that takes a metadata object, which tells Angular how to process, instantiate, and use the component. This decorator marks the class as an Angular component and provides configuration metadata that determines how the component should be processed, instantiated, and used at runtime.

- Every Angular project has a default root component called `AppComponent`.
- `app.component.css` holds all the styles for the root component.
- `app.component.html` holds the HTML template for the root component.
- `app.component.ts` holds the TypeScript code for the root component.

`app.component.ts` file structure:

```typescript
import { Component } from "@angular/core";
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "my first angular app";
}
```

In this file, we export the `AppComponent` class, which is decorated with the `@Component` decorator. The metadata object passed to the decorator specifies the selector, template URL, and style URLs for the component.

- `selector`: A CSS selector that identifies this component in a template and triggers instantiation of the component.
- `templateUrl`: The location of the component's template file. Alternatively, you can use the `template` property to define an inline template.
- `styleUrls`: An array of URLs to stylesheets to be applied to this component's view. Alternatively, you can use the `styles` property to define inline styles.

A component must belong to the `NgModule` to be usable within an Angular application. The `NgModule` is a decorator that defines a module in Angular, which is a cohesive block of code dedicated to an application domain, a workflow, or a closely related set of capabilities.

#### Creating A Component

To create a new component in Angular, you can use the Angular CLI command:

```bash
ng generate component component-name
# or
ng g c component-name
```
