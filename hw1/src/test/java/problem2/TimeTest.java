package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;

class TimeTest {

  Time testTime;
  private Integer expectedHours;
  private Integer expectedMins;
  private Integer expectedSecs;

  @BeforeEach
  void setUp() {
    testTime = new Time(8, 15, 40);
    expectedHours = 8;
    expectedMins = 15;
    expectedSecs = 40;
  }

  @Test
  void getHours() {
    assertEquals(expectedHours, testTime.getHours());
  }

  @Test
  void getMins() {
    assertEquals(expectedMins, testTime.getMins());
  }

  @Test
  void getSecs() {
    assertEquals(expectedSecs, testTime.getSecs());
  }

  @Test
  void timeToSecs() {
    int expectedTotalSecs = 29740;
    assertEquals(expectedTotalSecs, testTime.timeToSecs());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testTime.equals(testTime));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testTime.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testTime.equals("String"));
  }
//     testTime = new Time(8, 15, 40);
  @Test
  void testEquals_DifferentObjectsSameHours() {
    Time otherTime = new Time(8,0,0);
    assertNotEquals(testTime, otherTime);
  }

  @Test
  void testEquals_DifferentObjectsSameMins() {
    Time otherTime = new Time(0,15,0);
    assertNotEquals(testTime, otherTime);
  }

  @Test
  void testEquals_DifferentObjectsSameSecs() {
    Time otherTime = new Time(0,0,40);
    assertNotEquals(testTime, otherTime);
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    Time otherTime = new Time(8,15,40);
    assertEquals(testTime, otherTime);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testTime.getHours(), testTime.getMins(), testTime.getSecs());
    assertEquals(expectedHashCode, testTime.hashCode());
  }
}