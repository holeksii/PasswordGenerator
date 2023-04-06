package com.github.holeksii;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntropyTest {
  Entropy entropy;

  @BeforeEach
  public void beforeEach() {
    entropy = new Entropy((short) 26);
  }

  @Test
  public void testGet() {
    String message = "test";
    float expected = 18.0f;

    float actual = entropy.get(message);

    assertEquals((int) expected, (int) actual);
  }

  @Test
  public void testGetWithEmptyMessage() {
    String message = "";
    float expected = 0.0f;

    float actual = entropy.get(message);

    assertEquals((int) expected, (int) actual);
  }

  @Test
  public void testGetWithNullMessage() {
    String message = null;

    assertThrows(NullPointerException.class, () -> entropy.get(message));
  }

}
