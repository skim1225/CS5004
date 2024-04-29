package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailItemTest {

  private MailItem testMailItem;
  private Double expectedWidth;
  private Integer expectedHeight;
  private Integer expectedDepth;
  private Recipient expectedRecipient;

  @BeforeEach
  void setUp() {
    try {
      testMailItem = new MailItem(1.5,2,1,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu"));
    } catch (InvalidDimensionsException e) {
      fail("Mail item dimensions exceed max allowed.");
    }
    expectedWidth = 1.5;
    expectedHeight = 2;
    expectedDepth = 1;
    expectedRecipient = new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu");
  }

  @Test
  void getWidth() {
    assertEquals(expectedWidth, testMailItem.getWidth());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testMailItem.getHeight());
  }

  @Test
  void getDepth() {
    assertEquals(expectedDepth, testMailItem.getDepth());
  }

  @Test
  void getRecipient() {
    assertEquals(expectedRecipient, testMailItem.getRecipient());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testMailItem.equals(testMailItem));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testMailItem.equals(null));
  }

  @Test
  void testEquals_DifferentTypes() {
    assertFalse(testMailItem.equals("string"));
  }

  @Test
  void testEquals_DifferentObjectsSameWidth() {
    try {
      MailItem otherMailItem = new MailItem(1.5, 3, 2,
          new Recipient("test", "test", "test"));
      assertFalse(testMailItem.equals(otherMailItem));
    } catch (InvalidDimensionsException e) {
      fail("Mail item is smaller than minimum dimensions.");
    }
  }

  @Test
  void testEquals_DifferentObjectsSameHeight() {
    try {
      MailItem otherMailItem = new MailItem(2.0, 2, 2,
          new Recipient("test", "test", "test"));
      assertFalse(testMailItem.equals(otherMailItem));
    } catch (InvalidDimensionsException e) {
      fail("Mail item is smaller than minimum dimensions.");
    }
  }

  @Test
  void testEquals_DifferentObjectsSameDepth() {
    try {
      MailItem otherMailItem = new MailItem(2.0, 3, 1,
          new Recipient("test", "test", "test"));
      assertFalse(testMailItem.equals(otherMailItem));
    } catch (InvalidDimensionsException e) {
      fail("Mail item is smaller than minimum dimensions.");
    }
  }

  @Test
  void testEquals_DifferentObjectsSameRecipient() {
    try {
      MailItem otherMailItem = new MailItem(2.0, 3, 2,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu"));
      assertFalse(testMailItem.equals(otherMailItem));
    } catch (InvalidDimensionsException e) {
      fail("Mail item is smaller than minimum dimensions.");
    }
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    try {
      MailItem otherMailItem = new MailItem(1.5, 2, 1,
          new Recipient("Sooji", "Kim", "kim.sooji1@northeastern.edu"));
      assertTrue(testMailItem.equals(otherMailItem));
    } catch (InvalidDimensionsException e) {
      fail("Mail item is smaller than minimum dimensions.");
    }
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testMailItem.getWidth(), testMailItem.getHeight(),
        testMailItem.getDepth(), testMailItem.getRecipient());
    assertEquals(expectedHashCode, testMailItem.hashCode());
  }
}