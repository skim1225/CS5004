package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementNodeTest {

  private ElementNode testNode;
  private Integer expectedPriority;
  private String expectedValue;

  @BeforeEach
  void setUp() {
    testNode = new ElementNode(10, "test");
    expectedValue = "test";
    expectedPriority = 10;
  }

  @Test
  void getPriority() {
    assertEquals(expectedPriority, testNode.getPriority());
  }

  @Test
  void getValue() {
    assertEquals(expectedValue, testNode.getValue());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testNode.equals(testNode));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testNode.equals(null));
  }

  @Test
  void testEquals_DifferentTypeObject() {
    assertFalse(testNode.equals("string"));
  }


  @Test
  void testEquals_DifferentObjectSamePriority() {
    ElementNode other = new ElementNode(10, "other");
    assertNotEquals(other, testNode);
  }

  @Test
  void testEquals_DifferentObjectSameValue() {
    ElementNode other = new ElementNode(1, "test");
    assertNotEquals(other, testNode);
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    ElementNode other = new ElementNode(10, "test");
    assertEquals(other, testNode);
  }


  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(expectedPriority, expectedValue);
    assertEquals(expectedHash, testNode.hashCode());
  }
}