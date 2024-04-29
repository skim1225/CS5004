package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LunchEventTest {

  private LunchEvent testEvent;
  private String expectedClientName;
  private Integer expectedNumPeople;
  private Integer expectedNumSandwiches;

  @BeforeEach
  void setUp() {
    testEvent = new LunchEvent("Sooji", 50);
    expectedClientName = "Sooji";
    expectedNumPeople = 50;
    expectedNumSandwiches = 53;
  }

  @Test
  void getClientName() {
    assertEquals(expectedClientName, testEvent.getClientName());
  }

  @Test
  void getNumPeople() {
    assertEquals(expectedNumPeople, testEvent.getNumPeople());
  }

  @Test
  void getNumSandwiches() {
    assertEquals(expectedNumSandwiches, testEvent.getNumSandwiches());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testEvent.equals(testEvent));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testEvent.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testEvent.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameClientName() {
    LunchEvent otherEvent = new LunchEvent("Sooji", 20);
    assertNotEquals(testEvent, otherEvent);
  }

  @Test
  void testEquals_DifferentObjectSameNumPeople() {
    LunchEvent otherEvent = new LunchEvent("test", 50);
    assertNotEquals(testEvent, otherEvent);
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    LunchEvent otherEvent = new LunchEvent("Sooji" , 50);
    assertEquals(testEvent, otherEvent);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(Objects.hash(testEvent.getClientName(), testEvent.getNumPeople()), testEvent.getNumSandwiches());
    assertEquals(expectedHash, testEvent.hashCode());
  }
}