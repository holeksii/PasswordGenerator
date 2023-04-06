package com.github.holeksii;

import java.util.ArrayList;
import java.util.List;

public class CharsetUtils {

  public static final List<Short> LOWERCASE;
  public static final List<Short> UPPERCASE;
  public static final List<Short> DIGITS;
  public static final List<Short> SPECIAL_CHARACTERS;
  public static final List<Short> EXTENDED_ASCII;

  static {
    LOWERCASE = getLowercase();
    UPPERCASE = getUppercase();
    DIGITS = getDigits();
    SPECIAL_CHARACTERS = getSpecialCharacters();
    EXTENDED_ASCII = getExtendedAscii();
  }

  private static List<Short> getLowercase() {
    var lowercase = new ArrayList<Short>('z' - 'a' + 1);
    for (char c = 'a'; c <= 'z'; c++) {
      lowercase.add((short) c);
    }

    return lowercase;
  }

  private static List<Short> getUppercase() {
    var uppercase = new ArrayList<Short>('Z' - 'A' + 1);
    for (char c = 'A'; c <= 'Z'; c++) {
      uppercase.add((short) c);
    }

    return uppercase;
  }

  private static List<Short> getDigits() {
    var digits = new ArrayList<Short>('9' - '0' + 1);
    for (char c = '0'; c <= '9'; c++) {
      digits.add((short) c);
    }

    return digits;
  }

  private static List<Short> getSpecialCharacters() {
    var specialCharacters = new ArrayList<Short>();
    for (char c = '!'; c <= '/'; c++) {
      specialCharacters.add((short) c);
    }
    for (char c = ':'; c <= '@'; c++) {
      specialCharacters.add((short) c);
    }
    for (char c = '['; c <= '`'; c++) {
      specialCharacters.add((short) c);
    }
    for (char c = '{'; c <= '~'; c++) {
      specialCharacters.add((short) c);
    }

    return specialCharacters;
  }

  private static List<Short> getExtendedAscii() {
    var extendedAscii = new ArrayList<Short>(255 - 161 + 1);
    for (char c = 161; c <= 255; c++) {
      extendedAscii.add((short) c);
    }

    return extendedAscii;
  }

}
