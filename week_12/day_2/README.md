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

## Template Overview

Angular templates are HTML files that define the view for a component. They can include Angular-specific syntax for data binding, directives, and pipes to create dynamic and interactive user interfaces.

- A template is a blueprint for a part of the user interface.
- Templates can be considered as HTML files with additional Angular syntax.
- A special syntax can be used in templates to add additional functionality to HTML elements.
- As Angular templates are only a part of the UI, some tags like `<html>`, `<head>`, and `<body>` are not used in Angular templates.
- Angular templates are associated with components, and each component has its own template.
- Angular templates is directly related to the component's view.

### Implementation

> Inline Templates

Inline templates are defined directly within the `@Component` decorator using the `template` property. This approach is useful for small components with simple templates.

```typescript
import { Component } from "@angular/core";
@Component({
  selector: "app-inline-template",
  template: `<h1>Hello, {{ name }}!</h1>`,
  styles: [
    `
      h1 {
        color: blue;
      }
    `,
  ],
})
export class InlineTemplateComponent {
  name: string = "Angular";
}
```

> External Templates

External templates are defined in separate HTML files and linked to the component using the `templateUrl` property. This approach is preferred for larger components with more complex templates.

```typescript
import { Component } from "@angular/core";
@Component({
  selector: "app-external-template",
  templateUrl: "./external-template.component.html",
  styleUrls: ["./external-template.component.css"],
})
export class ExternalTemplateComponent {
  name: string = "Angular";
}
```

The `external-template.component.html` file would contain:

```html
<h1>Hello, {{ name }}!</h1>
```

In this example, the `ExternalTemplateComponent` uses an external HTML file for its template, allowing for better organization and separation of concerns.

## Template Statements

Template statements are used to handle user events in Angular templates. They allow you to bind event handlers to HTML elements, enabling interactivity in your application.

- Template statements use a language similar to JavaScript but the parser for the template statements is not similar to template expressions.
- The following JavaScript and template expressions are not allows in template statements:
  - `new`
  - `this`
  - `throw`
  - `return`
  - `break`
  - `continue`
  - `++` and `--` operators
  - `=`, `+=`, `-=`, `*=`, `/=`, and `%=` operators
  - Bitwise operators

Syntax:

```html
<!-- HTML Element -->
<button (click)="onClick()">Click Me</button>
<!-- Event Binding -->
```

In this example, the `(click)` event binding listens for click events on the button element and calls the `onClick()` method defined in the component class when the button is clicked.

### Real World Application

- Submitting data after the submit button is clicked can be implemented using template statements.
- Incrementing or decrementing a value when a button is clicked can be handled using template statements.

### Implementation

Consider a text which dynamically displays the number of times a button has been clicked.

```html
<button (click)="countClicks()">Click Me</button>
<p>You have clicked the button {{ count }} times.</p>
```

In the component class, you would define the `count` property and the `countClicks()` method:

```typescript
import { Component } from "@angular/core";
@Component({
  selector: "app-click-counter",
  templateUrl: "./click-counter.component.html",
  styleUrls: ["./click-counter.component.css"],
})
export class ClickCounterComponent {
  title = "Click Counter";
  count: number = 0;

  countClicks() {
    this.count++;
  }
}
```

In this example, each time the button is clicked, the `countClicks()` method increments the `count` property, and the updated count is displayed in the paragraph element.
