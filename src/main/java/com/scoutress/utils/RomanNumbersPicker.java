package com.scoutress.utils;

public class RomanNumbersPicker {

  public String getRomanNumeral(int number) {
    String[] romanNumerals = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII" };
    return romanNumerals[number - 1];
  }
}
