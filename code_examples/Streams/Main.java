import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();

    people.add(new Person("Warren", 120));
    people.add(new Person("Jeff", 150));
    people.add(new Person("Bull", 100));
    people.add(new Person("Mark", 50));

    // List<Person> hundredClub = new ArrayList<>();

    List<Person> hundredClub = people.stream()
    .filter(person -> person.billions >= 100)
        .collect(Collectors.toList());

    // for (Person p : people) {
    //   if (p.billions >= 100) {
    //     hundredClub.add(p);
    //   }
    // }

    hundredClub.forEach(p -> System.out.println(p.name));
  }

  static class Person {
    String name;
    int billions;

    public Person(String name, int billions) {
      this.billions = billions;
      this.name = name;
    }
  }
}