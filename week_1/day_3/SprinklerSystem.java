public class SprinklerSystem {
  public static void main(String[] args) {
    int precipitation = 0;
    int waterOutput = 0;

    if (precipitation < 20) {
      waterOutput = 30; // Set water output to 30 liters
    } else if (precipitation <= 30) {
      waterOutput = 10; // Set water output to 10 liters
    } else {
      waterOutput = 0; // Set water output to 0 liters for 31% and above
    }

    System.out.println("Water output: " + waterOutput + " liters");
  }
}