import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  imports: [],
  templateUrl: './child.html',
  styleUrl: './child.css',
})
export class Child {
  // Input property to receive data from parent component
  @Input() count = 0;

  // Output property to emit events to parent component
  @Output() change: EventEmitter<number> = new EventEmitter<number>();

  increment() {
    this.count++;
    this.change.emit(this.count);
    console.log(
      'Incrementing count from the child component... ' + this.count + ' - passing to AppComponent'
    );
  }

  decrement() {
    this.count--;
    this.change.emit(this.count);
    console.log(
      'Decrementing count from the child component... ' + this.count + ' - passing to AppComponent'
    );
  }
}
