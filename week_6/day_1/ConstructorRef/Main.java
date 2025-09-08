package week_6.day_1.ConstructorRef;

import java.util.function.Supplier;

class Dog {
  String name;
  int age;

  @Override
  public String toString() {
    return "Dog[name: " + this.name + " age: " + age + ']'; 
  }
}

public class Main {
  public static void main(String[] args) {
    // reference to a constructor
    Supplier<Dog> dogGetter = Dog::new;

    // use Supplier's get() method to retrieve and use an object
    Dog d = dogGetter.get();
    d.age = 3;
    d.name = "Charlie";
    System.out.println(d);
  }
}
