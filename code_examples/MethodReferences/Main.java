package code_examples.MethodReferences;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // 1. Reference to a static method

    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    
    // numbers.forEach(n -> System.out.println(n));
    numbers.forEach(System.out::println);

    // 2. Reference to an instance method of a particular object
    Greeter greeter = new Greeter();
    List<String> family = List.of("Dan", "Jen", "Isabella", "Juliana");

    // family.forEach(n -> greeter.greet(n));
    family.forEach(greeter::greet);

    // 3. Reference to an instance method of an arbitrary object of a particular type
    List<String> team = Arrays.asList("Tasha", "Dan", "Josh", "DaShaun", "Cora", "Whitney", "Cote");

    // team.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
    team.sort(String::compareToIgnoreCase);
    System.out.println(team);

    // 4. Reference a constructor
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    // List<Person> people = names.stream()
    //       .map(n -> new Person(n))
    //       .toList();
    List<Person> people = names.stream()
                          .map(Person::new)
        .toList();
                          
    System.out.println(people);
  }
}