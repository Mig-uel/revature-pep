package com.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PalindromeTest {
  public static Palindrome palindrome;

  @BeforeClass
  public static void setUp() {
    palindrome = new Palindrome();
    System.out.println("BeforeClass executed");
  }

  @Test
  public void isPalindromeStringNull() {
    boolean expected = false;
    boolean actual = palindrome.isPalindrome(null);

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void isPalindromeValidPalindrome() {
    boolean expected = true;
    boolean actual = palindrome.isPalindrome("racecar");

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void isPalindromeNotPalindrome() {
    boolean expected = false;
    boolean actual = palindrome.isPalindrome("hello");

    Assert.assertEquals(expected, actual);
  }
}
