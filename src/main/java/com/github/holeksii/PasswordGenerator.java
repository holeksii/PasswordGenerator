package com.github.holeksii;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

  private boolean hasLowercase;
  private boolean hasUppercase;
  private boolean hasDigits;
  private boolean hasSpecialCharacters;
  private boolean hasExtendedAscii;

  private List<Short> charset;
  private Random random;

  {
    charset = new ArrayList<>();
    random = new Random();
  }

  public PasswordGenerator() {
    hasLowercase = true;
    initCharset();
  }

  public PasswordGenerator(boolean hasLowercase, boolean hasUppercase, boolean hasDigits,
      boolean hasSpecialCharacters, boolean hasExtendedAscii) {
    this.hasLowercase = hasLowercase;
    this.hasUppercase = hasUppercase;
    this.hasDigits = hasDigits;
    this.hasSpecialCharacters = hasSpecialCharacters;
    this.hasExtendedAscii = hasExtendedAscii;
    initCharset();
  }

  public List<Short> getCharset() {
    return charset;
  }

  private void initCharset() {
    if (hasLowercase) {
      charset.addAll(CharsetUtils.LOWERCASE);
    }
    if (hasUppercase) {
      charset.addAll(CharsetUtils.UPPERCASE);
    }
    if (hasDigits) {
      charset.addAll(CharsetUtils.DIGITS);
    }
    if (hasSpecialCharacters) {
      charset.addAll(CharsetUtils.SPECIAL_CHARACTERS);
    }
    if (hasExtendedAscii) {
      charset.addAll(CharsetUtils.EXTENDED_ASCII);
    }
  }

  public String generate(int length) {
    var stringBuilder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      var randomIndex = random.nextInt(charset.size());
      var randomCharacter = (char) charset.get(randomIndex).intValue();
      stringBuilder.append(randomCharacter);
    }

    return stringBuilder.toString();
  }

  public static class Builder {

    private boolean hasLowercase;
    private boolean hasUppercase;
    private boolean hasDigits;
    private boolean hasSpecialCharacters;
    private boolean hasExtendedAscii;

    public Builder() {
      hasLowercase = true;
    }

    public Builder lowercase(boolean hasLowercase) {
      this.hasLowercase = hasLowercase;
      return this;
    }

    public Builder uppercase(boolean hasUppercase) {
      this.hasUppercase = hasUppercase;
      return this;
    }

    public Builder digits(boolean hasDigits) {
      this.hasDigits = hasDigits;
      return this;
    }

    public Builder specialCharacters(boolean hasSpecialCharacters) {
      this.hasSpecialCharacters = hasSpecialCharacters;
      return this;
    }

    public Builder extendedAscii(boolean hasExtendedAscii) {
      this.hasExtendedAscii = hasExtendedAscii;
      return this;
    }

    public PasswordGenerator build() {
      return new PasswordGenerator(hasLowercase, hasUppercase, hasDigits, hasSpecialCharacters,
          hasExtendedAscii);
    }
  }
}
