public class Lambdas {

  public static void main(String[] args) {
    Printable lambdaPrintable = (p, s) -> p + "meow" + s;

    printThing(lambdaPrintable);
  }

  // Takes in any object that implements the Printable interface
  static void printThing(Printable thing) {
    thing.print("-", "!");
  }
}