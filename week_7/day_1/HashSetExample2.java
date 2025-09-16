import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetExample2 {
  public static void main(String[] args) {
    // Creating an ArrayList of String type
    List<String> ll = new ArrayList<>();

    // Adding elements to ArrayList
    ll.add("Computer");
    ll.add("Science");

    // Creating HashSet object of String type
    HashSet<String> hs = new HashSet<>(ll);

    // Adding elements to HashSet
    hs.add("Portal");
    hs.add("Rev");

    // Iterating via iterators
    Iterator<String> iter = hs.iterator();

    // Condition holds true until single element is reached
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}
