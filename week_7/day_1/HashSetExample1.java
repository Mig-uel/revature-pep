import java.util.HashSet;

public class HashSetExample1 {
  public static void main(String[] args) {
    // Creating a HashSet object of String type
    HashSet<String> hashSet = new HashSet<>();

    // Adding elements to HashSet
    hashSet.add("People");
    hashSet.add("for");
    hashSet.add("practice");
    hashSet.add("contribute");

    // Duplicate removed
    hashSet.add("People");

    // Printing HashSet elements using for-each loop
    System.out.println("HashSet elements: ");
    for (String e : hashSet) {
      System.out.println(e);
    }
  }
}
