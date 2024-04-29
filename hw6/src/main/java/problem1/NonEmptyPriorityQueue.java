package problem1;

import java.util.Objects;

/**
 * Class NonEmptyPriorityQueue stores elements which have a priority and value. Elements are stored
 * in the order of decreasing priority.
 */

public class NonEmptyPriorityQueue implements PriorityQueue {

  private ElementNode head;
  private PriorityQueue rest;

  /**
   * Constructor for creating a new NonEmptyPriorityQueue with the given head node and pointer to
   * the rest of the nodes.
   * @param head - The head element node to be set, as an ElementNode.
   * @param rest - The rest of the NonEmptyPriorityQueue, as a PriorityQueue
   */
  public NonEmptyPriorityQueue(ElementNode head, PriorityQueue rest) {
    this.head = head;
    this.rest = rest;
  }

  /**
   * Returns the head.
   * @return the head.
   */
  public ElementNode getHead() {
    return head;
  }

  /**
   * Returns the rest.
   * @return the rest.
   */
  public PriorityQueue getRest() {
    return rest;
  }

  /**
   * Returns whether the priority queue is empty
   * @return whether the priority queue is empty
   */
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Adds the given element to the priority queue according to its priority level. Duplicates allowed.
   * @param priority - The priority of the element to be added, as an Integer.
   * @param value - The value of the element to be added, as a String.
   * @return a non-empty priority queue with the element added in the correct position.
   */
  public PriorityQueue add(Integer priority, String value) {
    if (priority > this.head.getPriority()) {
      return new NonEmptyPriorityQueue(new ElementNode(priority, value), this);
    } else {
      return new NonEmptyPriorityQueue(this.head, this.rest.add(priority, value));
    }
  }

  /**
   * Returns the value of the element with the highest priority in the queue. If multiple elements
   * have the same priority, the value of the element added first chronologically will be returned.
   * @return the value of the element with the highest priority in the
   * @throws EmptyPriorityQueueException  if called on an empty priority queue.
   */
  public String peek() throws EmptyPriorityQueueException  {
    return this.head.getValue();
  }

  /**
   * Returns a copy of the priority queue without the element with the highest priority.
   * @return a copy of the priority queue without the element with the highest priority.
   * @throws EmptyPriorityQueueException  if called on an empty priority queue.
   */
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    return this.rest;
  }

  @Override
  public boolean equals(Object obj) {
    NonEmptyPriorityQueue o = (NonEmptyPriorityQueue) obj;
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (this.head.equals(o.head)) {
      return this.rest.equals(o.rest);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(head, rest);
  }
}