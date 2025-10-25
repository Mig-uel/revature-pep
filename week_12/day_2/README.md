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

## Video - Angular Templates

### Data Binding

- Template support data injection via interpolation, property binding, class binding, style binding, two-way binding, and event binding.

### Template Expressions

```html
<img [src]="imageSrc" alt="Image" />
```

- Property binding is used to bind the value of a property in the component class to an HTML element property.
- In this case, the `src` attribute of the `<img>` tag is bound to the `imageSrc` property in the component class.

```html
<li *ngFor="let item of items">{{ item }}</li>
```

- The `*ngFor` directive is used to iterate over a list of items and create an `<li>` element for each item in the list.
- The `let item of items` syntax defines a template input variable `item` that represents each item in the `items` array.
- The `{{ item }}` syntax is used for interpolation to display the value of each item in the list.

```html
<div #myDiv>This is a sentence</div>
<p>The above div says: {{ myDiv.innerText }}</p>
```

- Template reference variables are used to reference HTML elements within the template.
- In this example, `#myDiv` creates a template reference variable that refers to the `<div>` element.
- The `{{ myDiv.innerText }}` syntax is used to access the `innerText` property of the referenced `<div>` element and display its content in the `<p>` element.

### Template Input vs. Reference Variables

- Template input variables are used with structural directives like `*ngFor` to represent data items in a collection.
- Template reference variables are used to reference HTML elements within the template for accessing their properties and methods.
- Template input variables are defined using the `let` keyword, while template reference variables are defined using the `#` symbol.
- A template reference variable can be uses anywhere within the template, while a template input variable is only accessible within the scope of the structural directive where it is defined.

### Event Binding

```html
<button (click)="handleClick()">Click Me</button>
```

- Event binding is used to bind an event handler method in the component class to an HTML element event.
- In this example, the `(click)` event binding listens for click events on the button element and calls the `handleClick()` method defined in the component class when the button is clicked.

## One Way Data Binding

The data transfer between the template and the model (component) is called data binding.

Binding is used to synchronize the view and model using Angular's change detection mechanism.

#### One Way Data Binding

1 Way Data Binding allows data to flow in one direction, either from the component to the template (view) or from the template (view) to the component.

- **From Component to Template (View)**: This is typically done using interpolation (`{{ }}`) or property binding (`[property]="value"`). Changes in the component's data will automatically update the view.
- **From Template (View) to Component**: This is typically done using event binding (`(event)="handler()"`). User interactions in the view can trigger methods in the component to update its data.

Other types of binding include:

- **Attribute Binding**: Binds an attribute of an HTML element to a property in the component.
- **Class Binding**: Binds a CSS class to an element based on a condition in the component.
- **Style Binding**: Binds a style property to an element based on a condition in the component.

### Real World Application

- **Text Interpolation**: Displaying dynamic data in the UI, such as user names, product details, etc.
- **Property Binding**: Dynamically setting properties of HTML elements, such as disabling/enabling buttons based on certain conditions.
- **Event Binding**: Handling user interactions, such as button clicks, form submissions, etc.

### Implementation

#### Text Interpolation

> Text interpolation is used to display dynamic data from the component in the template.

`app.component.html`

```html
<p><b>{{title}}</b></p>
```

`app.component.ts`

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "Angular Data Binding Example";
}
```

By using text interpolation, the data from the TypeScript component is displayed in the HTML template.

#### Property Binding

> Property binding is used to bind the value of a property in the component class to an HTML element property.

`app.component.html`

```html
<img [src]="imageSrc" alt="Angular Logo" />
```

`app.component.ts`

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  imageSrc = "https://angular.io/assets/images/logos/angular/angular.svg";
}
```

By using property binding, the `src` attribute of the `<img>` tag is dynamically set based on the `imageSrc` property in the component class.

#### Event Binding

> Event binding is used to bind an event handler method in the component class to an HTML element event.

`app.component.html`

```html
<button (click)="showAlert()">Save</button>
```

`app.component.ts`

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  showAlert() {
    alert("Button clicked!");
  }
}
```

By using event binding, the `showAlert()` method in the component class is called when the button is clicked, triggering an alert message.

## Two Way Data Binding

Two Way Data Binding allows data to flow in both directions, from the component to the template (view) and from the template (view) back to the component. This is typically achieved using the `ngModel` directive or the `[(ngModel)]` syntax.

Two-way data binding is commonly used to listen for events and update the data model accordingly, while also reflecting changes in the data model back to the view.

### Real World Application

- While settings a new password, based on the password rules, dynamic feedback can be provided to the user as they type.

### Implementation

To implement two-way data binding in Angular, you can use the `ngModel` directive or the `[(ngModel)]` syntax.

`app.component.html`

```html
<label>Enter text:</label>
<br />
<input type="text" name="textInput" [(ngModel)]="value" />
<p>You entered: {{ value }}</p>
<button (click)="clearValue()">Clear</button>
```

This HTML template includes an input field bound to the `value` property in the component class using two-way data binding. The entered text is displayed below the input field, and a button is provided to clear the input.

`app.component.ts`

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  value = "";

  clearValue() {
    this.value = "";
  }
}
```

In this TypeScript component, the `value` property is initialized as an empty string. The `clearValue()` method sets the `value` property to an empty string when the "Clear" button is clicked, effectively clearing the input field.

By using two-way data binding, any changes made in the input field are automatically reflected in the `value` property of the component class, and vice versa.

`app.module.ts`

```typescript
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms"; // Import FormsModule
import { AppComponent } from "./app.component";
@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, FormsModule], // Add FormsModule to imports
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
```

In this module, the `FormsModule` is imported from `@angular/forms` and added to the `imports` array of the `NgModule` decorator. This is necessary to use the `ngModel` directive for two-way data binding.

Note: Make sure to import the `FormsModule` in your Angular module to use two-way data binding with `ngModel`.

## Video - Data Binding

- Data binding syncs data between the component (model) and the template (view).
- Angular supports one-way and two-way data binding.
- One-way data binding allows data to flow in one direction, either from the component to the template or from the template to the component.
- Two-way data binding allows data to flow in both directions, from the component to the template and from the template back to the component.
  - Any changes made in the model or the view are automatically reflected in the other instantly.
