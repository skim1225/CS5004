package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduleTest {

  private Schedule testSchedule;
  private LunchEvent expectedLunchEvent;
  private DinnerEvent expectedDinnerEvent;

  @BeforeEach
  void setUp() {
    testSchedule = new Schedule();
  }

  @Test
  void bookLunchEventSuccess() {
    try {
      testSchedule.bookLunchEvent("Sooji", 20);
    } catch (InvalidNumberOfPeopleException | EventAlreadyExistsException e) {
      fail("Booking unsuccessful");
    }
    LunchEvent expectedLunchEvent = new LunchEvent("Sooji", 20);
    assertEquals(expectedLunchEvent, testSchedule.getLunchEvent());
  }

  @Test
  void bookLunchEventHeadcountFailure() {
    Assertions.assertThrows(InvalidNumberOfPeopleException.class, () -> {
      testSchedule.bookLunchEvent("Sooji", 100);
    });
  }

  @Test
  void bookLunchEventDoubleBookedFailure() {
    Assertions.assertThrows(EventAlreadyExistsException.class, () -> {
      testSchedule.bookLunchEvent("Sooji", 20);
      testSchedule.bookLunchEvent("Sooji", 20);
    });
  }

  @Test
  void bookDinnerEventSuccess() throws InvalidNumberOfPeopleException, EventAlreadyExistsException {
    try {
      testSchedule.bookDinnerEvent("Sooji", 20);
    } catch (InvalidNumberOfPeopleException | EventAlreadyExistsException e) {
      fail("Booking unsuccessful");
    }
    DinnerEvent expectedDinnerEvent = new DinnerEvent("Sooji", 20);
    assertEquals(expectedDinnerEvent, testSchedule.getDinnerEvent());
  }

  @Test
  void bookDinnerEventHeadcountFailure() {
    Assertions.assertThrows(InvalidNumberOfPeopleException.class, () -> {
      testSchedule.bookDinnerEvent("Sooji", 100);
    });
  }

  @Test
  void bookDinnerEventDoubleBookedFailure() {
    Assertions.assertThrows(EventAlreadyExistsException.class, () -> {
      testSchedule.bookDinnerEvent("Sooji", 20);
      testSchedule.bookDinnerEvent("Sooji", 20);
    });
  }

  @Test
  void getLunchEvent() {
    LunchEvent expectedLunchEvent = new LunchEvent("Sooji", 20);
    try {
      testSchedule.bookLunchEvent("Sooji", 20);
    } catch (InvalidNumberOfPeopleException | EventAlreadyExistsException e){
      fail("Booking unsuccessful");
    }
    assertEquals(expectedLunchEvent, testSchedule.getLunchEvent());
  }

  @Test
  void getDinnerEvent() {
    DinnerEvent expectedDinnerEvent = new DinnerEvent("Sooji", 20);
    try {
      testSchedule.bookDinnerEvent("Sooji", 20);
    } catch (InvalidNumberOfPeopleException | EventAlreadyExistsException e){
      fail("Booking unsuccessful");
    }
    assertEquals(expectedDinnerEvent, testSchedule.getDinnerEvent());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testSchedule.equals(testSchedule));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testSchedule.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testSchedule.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameLunchEvent() {
    Schedule otherSchedule = new Schedule();
    try {
      testSchedule.bookLunchEvent("Sooji", 20);
      otherSchedule.bookLunchEvent("Sooji", 20);
      testSchedule.bookDinnerEvent("Sooji", 20);
      otherSchedule.bookDinnerEvent("Sooji", 30);
    } catch (InvalidNumberOfPeopleException | EventAlreadyExistsException e){
      fail("Booking unsuccessful");
    }
    assertNotEquals(testSchedule, otherSchedule);
  }

  @Test
  void testEquals_DifferentObjectSameDinnerEvent() {
    Schedule otherSchedule = new Schedule();
    try {
      testSchedule.bookLunchEvent("Sooji", 15);
      otherSchedule.bookLunchEvent("Sooji", 20);
      testSchedule.bookDinnerEvent("Sooji", 20);
      otherSchedule.bookDinnerEvent("Sooji", 20);
    } catch (InvalidNumberOfPeopleException | EventAlreadyExistsException e){
      fail("Booking unsuccessful");
    }
    assertNotEquals(testSchedule, otherSchedule);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    Schedule otherSchedule = new Schedule();
    try {
      testSchedule.bookLunchEvent("Sooji", 20);
      otherSchedule.bookLunchEvent("Sooji", 20);
      testSchedule.bookDinnerEvent("Sooji", 20);
      otherSchedule.bookDinnerEvent("Sooji", 20);
    } catch (InvalidNumberOfPeopleException | EventAlreadyExistsException e){
      fail("Booking unsuccessful");
    }
    assertEquals(testSchedule, otherSchedule);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testSchedule.getLunchEvent(), testSchedule.getDinnerEvent());
    assertEquals(expectedHash, testSchedule.hashCode());
  }
}