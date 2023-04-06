package com.github.holeksii;

import lombok.NonNull;

public class Entropy {

  private short charsetLength;

  public Entropy(short charsetLength) {
    this.charsetLength = charsetLength;
  }

  private static float log2(double x) {
    return (float) (Math.log(x) / Math.log(2));
  }

  public float get(@NonNull String message) {
    return message.length() * log2(charsetLength);
  }
}
