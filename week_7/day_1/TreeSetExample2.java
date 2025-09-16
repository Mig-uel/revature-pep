import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample2 {
  public static void main(String[] args) {
    // Creating List of String type
    ArrayList<String> ll = new ArrayList<>();

    // Adding elements to ArrayList
    ll.add("Computer");
    ll.add("Science");

    // Creating TreeSet object of String type
    TreeSet<String> ts = new TreeSet<>(ll);

    // Adding elements to TreeSet
    ts.add("Portal");
    ts.add("Rev");

    // Iterating via iterators
    Iterator<String> iter = ts.iterator();

    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}
