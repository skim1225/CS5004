package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RowTest {
  private Row testRow;
  private Integer expectedRowNumber;
  private boolean expectedAccessible;

  @BeforeEach
  void setUp() {
    testRow = new Row(1, Boolean.TRUE);
    expectedRowNumber = 1;
    expectedAccessible = Boolean.TRUE;
  }

  @Test
  void seatsAvailable() {
    Seat seat1 = new Seat("A");
    Seat seat2 = new Seat("B");
    testRow.add(seat1);
    testRow.add(seat2);
    int expectedSeatsAvailable = 2;
    assertEquals(expectedSeatsAvailable, testRow.seatsAvailable());
  }

  @Test
  void seatsAvailable_OneTaken() {
    Seat seat1 = new Seat("A");
    seat1.setReservedFor("test");
    Seat seat2 = new Seat("B");
    testRow.add(seat1);
    testRow.add(seat2);
    int expectedSeatsAvailable = 1;
    assertEquals(expectedSeatsAvailable, testRow.seatsAvailable());
  }

  @Test
  void getRowNum() {
    assertEquals(expectedRowNumber, testRow.getRowNum());
  }

  @Test
  void getAccessible() {
    assertEquals(expectedAccessible, testRow.getAccessible());
  }

  @Test
  void testToString_AccessibleAllEmpty() {
    for (int i = 0; i < 10; i++) {
      Seat seat = new Seat("A");
      testRow.add(seat);
    }
    String expectedString = "1  = = = = = = = = = = ";
    assertEquals(expectedString, testRow.toString());
  }

  @Test
  void testToString_AccessibleAllFull() {
    for (int i = 0; i < 10; i++) {
      Seat seat = new Seat("A");
      seat.setReservedFor("a");
      testRow.add(seat);
    }
    String expectedString = "1  X X X X X X X X X X ";
    assertEquals(expectedString, testRow.toString());
  }

  @Test
  void testToString_NonAccessibleAllEmpty() {
    Row otherRow = new Row(10, Boolean.FALSE);
    for (int i = 0; i < 10; i++) {
      Seat seat = new Seat("A");
      otherRow.add(seat);
    }
    String expectedString = "10 _ _ _ _ _ _ _ _ _ _ ";
    assertEquals(expectedString, otherRow.toString());
  }
}