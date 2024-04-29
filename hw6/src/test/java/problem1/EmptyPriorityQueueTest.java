package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyPriorityQueueTest {

  private EmptyPriorityQueue testEmptyPQ;

  @BeforeEach
  void setUp() {
    testEmptyPQ = new EmptyPriorityQueue();
  }

  @Test
  void createEmpty() {
    PriorityQueue emptyQueue = PriorityQueue.createEmpty();
    assertEquals(testEmptyPQ, emptyQueue);
  }

  @Test
  void isEmpty() {
    assertTrue(testEmptyPQ.isEmpty());
  }

  @Test
  void add() {
    NonEmptyPriorityQueue newQ = new NonEmptyPriorityQueue(new ElementNode(1, "t"), new EmptyPriorityQueue());
    assertEquals(testEmptyPQ.add(1, "t"), newQ);
  }

  @Test
  void peek() {
    Assertions.assertThrows(EmptyPriorityQueueException.class, ()-> {
      testEmptyPQ.peek();
    });
  }

  @Test
  void pop() {
    Assertions.assertThrows(EmptyPriorityQueueException.class, ()-> {
      testEmptyPQ.pop();
    });
  }
}