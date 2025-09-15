package com.example;

public class Palindrome {
  public boolean isPalindrome(String word) {
    // if string is not provided, return false
    if (word == null)
      return false;

    /**
     * Compare first and last character
     * Then the second and second to last, etc...until all of the
     * character are checked
     * If character do not match, then return false
     */

    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) != word.charAt(word.length() - 1 - i))
        return false;
    }

    return true;
  }
}
