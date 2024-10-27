package com.scoutress.utils;

public class AlphabetLetter {

  public String getLetterByNumber(int number) {
    if (number < 1 || number > 26) {
      throw new IllegalArgumentException("Skaičius turi būti nuo 1 iki 26");
    }
    return String.valueOf((char) ('A' + number - 1));
  }
}
