package com.github.holeksii;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordGeneratorTest {

  static PasswordGenerator generator;
  static PasswordGenerator lowercaseGenerator;
  static PasswordGenerator uppercaseGenerator;
  static PasswordGenerator digitGenerator;
  static PasswordGenerator specialCharacterGenerator;
  static PasswordGenerator extendedAnsiiGenerator;

  int length;
  String password;

  @BeforeEach
  public void beforeEach() {
    length = 8;
  }

  @Test
  public void testLength() {
    int zeroLength = 0;
    int negativeLength = -1;

    password = generator.generate(length);
    assertEquals(password.length(), length);

    password = lowercaseGenerator.generate(zeroLength);
    assertEquals(password.length(), zeroLength);

    password = lowercaseGenerator.generate(negativeLength);
    assertEquals(password.length(), zeroLength);
  }

  @Test
  public void testLowercase() {
    password = lowercaseGenerator.generate(length);

    assertEquals(password, password.toLowerCase());
  }

  @Test
  public void testUppercase() {
    password = uppercaseGenerator.generate(length);

    assertEquals(password, password.toUpperCase());
  }

  @Test
  public void testDigits() {
    password = digitGenerator.generate(length);

    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      assertEquals(Character.isDigit(c), true);
    }
  }

  @Test
  public void testSpecialCharacters() {
    password = specialCharacterGenerator.generate(length);

    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      assertEquals(Character.isLetterOrDigit(c), false);
    }
  }

  @Test
  public void testExtendedAscii() {
    password = extendedAnsiiGenerator.generate(length);

    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      boolean isExtendedAscii = ((int) c > 127) && ((int) c < 256);
      assertTrue(isExtendedAscii);
    }
  }

  @BeforeAll
  public static void beforeAll() {
    generator = new PasswordGenerator.Builder()
        .lowercase(true)
        .uppercase(true)
        .digits(true)
        .specialCharacters(true)
        .build();

    lowercaseGenerator = new PasswordGenerator.Builder()
        .lowercase(true)
        .build();

    uppercaseGenerator = new PasswordGenerator.Builder()
        .lowercase(false)
        .uppercase(true)
        .build();

    digitGenerator = new PasswordGenerator.Builder()
        .lowercase(false)
        .digits(true)
        .build();

    specialCharacterGenerator = new PasswordGenerator.Builder()
        .lowercase(false)
        .specialCharacters(true)
        .build();

    extendedAnsiiGenerator = new PasswordGenerator.Builder()
        .lowercase(false)
        .extendedAscii(true)
        .build();
  }
}
