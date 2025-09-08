import java.util.function.Function;

public class LambdaExample {
  // a static method to reference
  public static int triple(int num) {
    return num * 3;
  }

  public static void main(String[] args) {
    // using a lambda to implement the Function function interface
    Function<Integer, Integer> computation = num -> triple(num);

    System.out.println(computation.apply(3));
  }
}