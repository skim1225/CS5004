package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonEmptyPriorityQueueTest {

  private NonEmptyPriorityQueue testNonEmptyPQ;
  private ElementNode expectedHead;
  private PriorityQueue expectedRest;
  private String expectedPeekValue;

  @BeforeEach
  void setUp() {
    testNonEmptyPQ = new NonEmptyPriorityQueue(new ElementNode(10, "test"), new NonEmptyPriorityQueue(new ElementNode(9, "test"), new EmptyPriorityQueue()));
    expectedHead = new ElementNode(10, "test");
    expectedRest = new NonEmptyPriorityQueue(new ElementNode(9, "test"), new EmptyPriorityQueue());
    expectedPeekValue = "test";
  }

  @Test
  void getHead() {
    assertEquals(expectedHead, testNonEmptyPQ.getHead());
  }

  @Test
  void getRest() {
    assertEquals(expectedRest, testNonEmptyPQ.getRest());
  }

  @Test
  void isEmpty() {
    assertFalse(testNonEmptyPQ.isEmpty());
  }

  @Test
  void add() {
    PriorityQueue other = new NonEmptyPriorityQueue(new ElementNode(10, "test"), new EmptyPriorityQueue());
    other.add(9, "test");
    assertEquals(other, testNonEmptyPQ);
  }

  @Test
  void peek() throws EmptyPriorityQueueException {
    assertEquals(expectedPeekValue, testNonEmptyPQ.peek());
  }

  @Test
  void pop() throws EmptyPriorityQueueException {
    assertEquals(expectedRest, testNonEmptyPQ.pop());
  }
}