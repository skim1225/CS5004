package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DinnerEventTest {

  private DinnerEvent testEvent;
  private Integer expectedNonVegEntree;
  private Integer expectedVegEntree;

  @BeforeEach
  void setUp() {
    testEvent = new DinnerEvent("Sooji", 50);
    expectedNonVegEntree = 40;
    expectedVegEntree = 10;
  }

  @Test
  void getNumNonVegEntree() {
    assertEquals(expectedNonVegEntree, testEvent.getNumNonVegEntree());
  }

  @Test
  void getNumVegEntree() {
    assertEquals(expectedVegEntree, testEvent.getNumVegEntree());
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
  void testEquals_DifferentObjectSameFields() {
    DinnerEvent otherEvent = new DinnerEvent("Sooji", 50);
    assertEquals(testEvent, otherEvent);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(Objects.hash(testEvent.getClientName(), testEvent.getNumPeople()),
        testEvent.getNumNonVegEntree(), testEvent.getNumVegEntree());
    assertEquals(expectedHash, testEvent.hashCode());
  }
}