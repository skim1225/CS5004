package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;

class SeatTest {
  private Seat testSeat;
  private String expectedName;
  private String expectedReservedFor;

  @BeforeEach
  void setUp() {
    testSeat = new Seat("A");
    expectedName = "A";
    expectedReservedFor = null;
  }

  @Test
  void getName() {
    assertEquals(expectedName, testSeat.getName());
  }

  @Test
  void getName_InvalidName() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      testSeat = new Seat("a");
    });
  }

  @Test
  void getReservedFor() {
    assertEquals(expectedReservedFor, testSeat.getReservedFor());
  }

  @Test
  void setReservedFor() {
    testSeat.setReservedFor("tomato");
    expectedReservedFor = "tomato";
    assertEquals(expectedReservedFor, testSeat.getReservedFor());
  }

  @Test
  void testToString() {
    String expectedString = null;
    assertEquals(expectedString, testSeat.toString());
  }

  @Test
  void testToString_ReservedSeat() {
    String expectedString = "X ";
    testSeat.setReservedFor("tomato");
    assertEquals(expectedString, testSeat.toString());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testSeat.equals(testSeat));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testSeat.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testSeat.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameName() {
    testSeat.setReservedFor("a");
    Seat otherSeat = new Seat("A");
    otherSeat.setReservedFor("b");
    assertNotEquals(testSeat, otherSeat);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    testSeat.setReservedFor("a");
    Seat otherSeat = new Seat("A");
    otherSeat.setReservedFor("a");
    assertEquals(testSeat, otherSeat);
  }

  @Test
  void testEquals_DifferentObjectDifferentName() {
    Seat otherSeat = new Seat("B");
    assertNotEquals(testSeat, otherSeat);
  }

  @Test
  void testEquals_DifferentObjectDifferentReservedFor() {
    Seat otherSeat = new Seat("B");
    testSeat.setReservedFor("a");
    otherSeat.setReservedFor("b");
    assertNotEquals(testSeat, otherSeat);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testSeat.getName(), testSeat.getReservedFor());
    assertEquals(expectedHash, testSeat.hashCode());
  }
}
