package week_6.day_1.ArbitraryRef;

import java.util.function.BiPredicate;

public class Main {
  public static void main(String[] args) {
    // reference to an arbitrary object of the String type
    BiPredicate<String, String> eval = String::startsWith;

    // use the BiPredicate's test() method and print the results
    boolean res = eval.test("hello world", "he");
    System.out.println("Result 1: " + res);

    // another example
    eval = String::equalsIgnoreCase;
    res = eval.test("goodbye!", "gOoDbYe!");
    System.out.println("Result 2: " + res);
  }
}
