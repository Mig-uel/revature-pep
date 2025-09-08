package week_6.day_1.ParticularRef;

import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
      // provide an object to use as a reference
      String str = "hello world";

      // reference to a particular object's instance method
      Predicate<String> evaluation = str::startsWith;
      
      // use the predicate's test() method and print the result
      boolean res = evaluation.test("he");
      System.out.println("Result 1: " + res);

      evaluation = str::equalsIgnoreCase;
      res = evaluation.test("HeLlo WoRlD");
      System.out.println("Result 2: " + res);
  }
}