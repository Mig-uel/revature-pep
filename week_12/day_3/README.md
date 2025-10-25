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
