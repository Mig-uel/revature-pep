import java.util.function.Function;

public class MethodExample {
  // a static method to reference
  public static int triple(int num) {
    return num * 3;
  }

  public static void main(String[] args) {
    // reference to a static method
    Function<Integer, Integer> computation = MethodExample::triple;

    // use the implementation, print out the result
    int res = computation.apply(-3);
    System.out.println(res);

    // another example of referencing a static method
    computation = Math::abs;

    // printing out the new result
    res = computation.apply(-3);
    System.out.println(res);
  }
}
