package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {

  Locker testLocker;
  Integer expectedMaxWidth;
  Integer expectedMaxHeight;
  Integer expectedMaxDepth;

  @BeforeEach
  void setUp() throws InvalidDimensionsException {
    try {
      testLocker = new Locker(15, 25, 10);
    } catch (InvalidDimensionsException e) {
      fail("Invalid mail item dimensions.");
    }
    expectedMaxWidth = 15;
    expectedMaxHeight = 25;
    expectedMaxDepth = 10;
  }

  @Test
  void constructorFailure() {
    Assertions.assertThrows(InvalidDimensionsException.class, () -> {
      Locker failLocker = new Locker(100, 100, 100);
    });
  }

  @Test
  void addMail() {
    MailItem expectedMailItem;
    try {
      expectedMailItem = new MailItem(1.5,2,1,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu"));
      try {
        testLocker.addMail(expectedMailItem);
        assertEquals(expectedMailItem, testLocker.getMailItem());
      } catch (LockerAlreadyOccupiedException | InvalidDimensionsException e) {
        fail("Unable to add mail to locker.");
      }
    } catch (InvalidDimensionsException e) {
      fail("Mail item dimensions exceed max allowed.");
    }
  }

  @Test
  void addMail_DimensionFailure() {
    Assertions.assertThrows(InvalidDimensionsException.class, () -> {
      testLocker.addMail(new MailItem(20.0, 25, 10, new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu")));
    });
  }

  @Test
  void addMail_OccupiedFailure() {
    Assertions.assertThrows(LockerAlreadyOccupiedException.class, () -> {
      testLocker.addMail(new MailItem(1.5,2,1,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu")));
      testLocker.addMail(new MailItem(1.5,2,1,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu")));
    });
  }

  @Test
  void pickupMail() {
    MailItem expectedMailItem;
    try {
      expectedMailItem = new MailItem(1.5,2,1,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu"));
      try {
        testLocker.addMail(expectedMailItem);
        try {
          assertEquals(expectedMailItem, testLocker.pickupMail(new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu")));
        } catch (NonMatchedRecipientException | NoMailItemException e) {
          fail("Unable to pick up mail.");
        }
      } catch (LockerAlreadyOccupiedException | InvalidDimensionsException e) {
        fail("Unable to add mail to locker.");
      }
    } catch (InvalidDimensionsException e) {
      fail("Mail item dimensions exceed max allowed.");
    }
  }

  @Test
  void pickupMail_RecipientFailure() {
    Assertions.assertThrows(NonMatchedRecipientException.class, () -> {
      testLocker.addMail(new MailItem(1.5, 2, 1, new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu")));
      testLocker.pickupMail(new Recipient("test", "test", "test"));
    });
  }

  @Test
  void pickupMail_NullFailure() {
    Assertions.assertThrows(NoMailItemException.class, () -> {
      testLocker.pickupMail(new Recipient("a","a","a"));
    });
  }

  @Test
  void getMaxWidth() {
    assertEquals(expectedMaxWidth, testLocker.getMaxWidth());
  }

  @Test
  void getMaxHeight() {
    assertEquals(expectedMaxHeight, testLocker.getMaxHeight());
  }

  @Test
  void getMaxDepth() {
    assertEquals(expectedMaxDepth, testLocker.getMaxDepth());
  }

  @Test
  void getMailItem() {
    MailItem expectedMailItem;
    try {
      expectedMailItem = new MailItem(1.5,2,1,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu"));
      try {
        testLocker.addMail(expectedMailItem);
        assertEquals(expectedMailItem, testLocker.getMailItem());
      } catch (LockerAlreadyOccupiedException | InvalidDimensionsException e) {
        fail("Unable to add mail to locker.");
      }
    } catch (InvalidDimensionsException e) {
      fail("Mail item dimensions exceed max allowed.");
    }
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testLocker.equals(testLocker));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testLocker.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testLocker.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectSameMaxWidth() {
    try {
      Locker otherLocker = new Locker(15, 1, 1);
      assertNotEquals(testLocker, otherLocker);
    } catch (InvalidDimensionsException e) {
      fail("Invalid mail item dimensions.");
    }
  }

  @Test
  void testEquals_DifferentObjectSameMaxHeight() {
    try {
      Locker otherLocker = new Locker(1, 25, 1);
      assertNotEquals(testLocker, otherLocker);
    } catch (InvalidDimensionsException e) {
      fail("Invalid mail item dimensions.");
    }
  }

  @Test
  void testEquals_DifferentObjectSameMaxDepth() {
    try {
      Locker otherLocker = new Locker(1, 1, 10);
      assertNotEquals(testLocker, otherLocker);
    } catch (InvalidDimensionsException e) {
      fail("Invalid mail item dimensions.");
    }
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    try {
      Locker otherLocker = new Locker(15, 25, 10);
      assertEquals(testLocker, otherLocker);
    } catch (InvalidDimensionsException e) {
      fail("Invalid mail item dimensions.");
    }
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testLocker.getMaxWidth(), testLocker.getMaxHeight(),
        testLocker.getMaxDepth(), testLocker.getMailItem());
    assertEquals(expectedHash, testLocker.hashCode());
  }
}