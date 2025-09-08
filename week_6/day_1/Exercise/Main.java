package week_6.day_1.Exercise;

import java.util.function.BiFunction;

public class Main {

  public static int addition(int a, int b) {
    return a + b;
    }
  public static void main(String[] args) {
    BiFunction<Integer, Integer, Integer> add = Main::addition;
    int sum = add.apply(10, 20);
    System.out.println(sum);
  }
}
