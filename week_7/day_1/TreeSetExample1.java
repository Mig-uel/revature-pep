import java.util.TreeSet;

public class TreeSetExample1 {
  public static void main(String[] args) {
    // Create empty TreeSet
    TreeSet<String> ts = new TreeSet<>();

    // Adding elements to TreeSet
    ts.add("People");
    ts.add("for");
    ts.add("practice");
    ts.add("contribute");

    // Duplicate elements are removed
    ts.add("People");

    // Printing out TreeSet elements
    System.out.println("TreeSet elements:");
    for (String temp : ts) {
      System.out.println(temp);
    }
  }
}
