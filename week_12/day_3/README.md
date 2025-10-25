# TypeScript and Angular - Day 3

## Component Lifecycle

In Angular, components have a lifecycle managed by Angular itself. Understanding the component lifecycle is crucial for building efficient and effective applications. The lifecycle consists of several phases, each represented by specific lifecycle hooks that Angular provides for developers to tap into.

#### Component Lifecycle Hooks

Angular creates a component, renders it, creates and renders its children, checks it when its data-bound properties change, and destroys it before removing it from the DOM. These events are called **lifecycle hooks**. These hooks allow you to tap into key moments in a component's lifecycle to perform custom operations. They have eight different function calls which correspond to different phases of a component's lifecycle. Every Angular component has a lifecycle event carried out in two different phases: one linked to the component itself and the other linked to its view (and child views).

#### Eight Lifecycle Hooks

1. **constructor**: The constructor of the component class is called when the component is instantiated, before the execution of any other lifecycle hooks. If we need to inject any dependencies into the component, we do it here.
2. **ngOnChanges**: This hook is called whenever there is a change in the `@Input` properties of the component. It receives a `SimpleChanges` object that contains the current and previous values of the changed properties.
3. **ngOnInit**: This hook is called once, after the first `ngOnChanges`. It is typically used for component initialization, such as fetching data from a service or setting up initial state.
4. **ngDoCheck**: This hook is called during every change detection run, immediately after `ngOnChanges` and `ngOnInit`. It allows developers to implement custom change detection logic.
5. **ngAfterContentInit**: This hook is called once after Angular projects external content into the component's view (i.e., after `<ng-content>` has been initialized).
6. **ngAfterContentChecked**: This hook is called after every check of the component's content (i.e., after `<ng-content>` has been checked).
7. **ngAfterViewInit**: This hook is called once after the component's view (and its child views) have been initialized.
8. **ngAfterViewChecked**: This hook is called after every check of the component's view (and its child views).
9. **ngOnDestroy**: This hook is called just before Angular destroys the component. It is typically used for cleanup tasks, such as unsubscribing from observables or detaching event handlers.

## Sharing Data Between Child and Parent Components

In Angular, data can be shared between child and parent components using `@Input` and `@Output` decorators.

Angular uses `@Input` and `@Output` decorators to flow data between components. We can also use Angular Services to share data between components that do not have a direct parent-child relationship. If we have to pass data into a component, we use `@Input`. If we have to send/emit data out of a component, we use `@Output` with the `EventEmitter` API.

#### `@Input` Decorator

In Angular, the `@Input` decorator is used to define input properties in a child component. These properties allow data to be passed from a parent component to a child component. It marks a class field as an **input property** and supplies configuration metadata. The parent component can bind to these input properties using property binding syntax.

#### `@Output` Decorator

In Angular, a component can emit or send an event to its parent component using the `@Output` decorator along with the `EventEmitter` class. The `@Output` decorator marks a property in a child component as an output property, which means it can emit events that the parent component can listen to.

The child component creates an instance of `EventEmitter` and uses it to emit events. The parent component can then bind to these events using event binding syntax.

#### `EventEmitter` Class

An `EventEmitter` is used to emit custom events synchronously or asynchronously, and register handlers for those events by subscribing to an instance. It is commonly used in Angular components to create custom events that can be listened to by parent components.

## Event Emitters

In Angular, an `EventEmitter` is a class that is used to create custom events that can be emitted by a component and listened to by its parent component. It is part of the `@angular/core` package and is commonly used in conjunction with the `@Output` decorator to facilitate communication between child and parent components.

#### `@Output` with `EventEmitter`

To emit data and events out from a child component to a parent component, we create an instance of `EventEmitter` in the child component and decorate it with `@Output`. The parent component can then listen for these events using event binding syntax.

This instance calls the `emit()` method to send a payload (data) to the parent component when a specific event occurs, such as a button click or form submission, and can be received by an event object `$event` in the parent component's template.

## Component Styles

Angular applications can be styled using standard CSS, SCSS, or other preprocessor languages. CSS stylesheets, selectors, rules, and media queries can be directly applied to Angular components. Each component can have its own styles defined in the `styles` or `styleUrls` properties of the `@Component` decorator.

Ways to add styles to a component:

- `styles` or `styleUrls` properties in the `@Component` decorator.
- Inline styles using the `style` attribute in the component's template.
- CSS import statements in the component's stylesheet.

### Implementation

We can use Angular's CLI to create a component with empty styles:

```bash
ng g c component-name --inline-style
```

This command generates a new component with an empty styles array in the `@Component` decorator, allowing us to add styles directly within the component file.

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  template: `<h1>App Component</h1>
    <p>Styles is working</p>
    <p></p>`,
  styles: ["p { color: red,}"],
})
export class AppComponent {
  color = "white";
  title = "Sample";
  highlightColor(newColor: string): void {
    this.color = newColor;
  }
}
```

We can also add styles in a separate CSS file and link it using the `styleUrls` property:

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  color = "white";
  title = "Sample";
  highlightColor(newColor: string): void {
    this.color = newColor;
  }
}
```

And, we can also define styles directly in the template using the `style` attribute:

```html
<h1>App Component</h1>
<p style="color: red;">Styles is working</p>
<p [style.color]="color">This is a sample paragraph.</p>
<button (click)="highlightColor('yellow')">Yellow</button>
<button (click)="highlightColor('blue')">Blue</button>
<button (click)="highlightColor('green')">Green</button>
```
