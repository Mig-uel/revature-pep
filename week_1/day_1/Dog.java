class Dog {
  int age;

  String bark() {
    return "Woof!";
  }

  public static void main(String[] args) {
    Dog myDog = new Dog();

    System.out.println(myDog.bark());
  }
}