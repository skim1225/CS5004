package problem3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmountTest {

  private Amount testAmount;
  private Integer expectedDollars;
  private Integer expectedCents;

  @BeforeEach
  void setUp() {
    testAmount = new Amount(10,99);
    expectedDollars = 10;
    expectedCents = 99;
  }

  @Test
  void getDollars() {
    assertEquals(expectedDollars, testAmount.getDollars());
  }

  @Test
  void getCents() {
    assertEquals(expectedCents, testAmount.getCents());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testAmount.equals(testAmount));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testAmount.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testAmount.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameDollars() {
    Amount otherAmount = new Amount(10,0);
    assertNotEquals(testAmount, otherAmount);
  }

  @Test
  void testEquals_DifferentObjectSameCents() {
    Amount otherAmount = new Amount(0,99);
    assertNotEquals(testAmount, otherAmount);
  }

  @Test void testEquals_DifferentObjectSameValues() {
    Amount otherAmount = new Amount(10, 99);
    assertEquals(testAmount, otherAmount);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testAmount.getDollars(), testAmount.getCents());
    assertEquals(expectedHashCode, testAmount.hashCode());
  }
}