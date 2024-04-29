package problem1;

/**
 * The interface PriorityQueueADT informs clients what operations are supported by my Priority Queue
 * Implementation.
 */

public interface PriorityQueue {

  /**
   * Creates and returns an empty Priority Queue
   * @return an empty Priority Queue
   */
  static PriorityQueue createEmpty() {
    return new EmptyPriorityQueue();
  }

  /**
   * Returns whether the priority queue is empty
   * @return whether the priority queue is empty
   */
  Boolean isEmpty();

  /**
   * Adds the given element to the priority queue according to its priority level. Duplicates allowed.
   * @param priority - The priority of the element to be added, as an Integer.
   * @param value - The value of the element to be added, as a String.
   * @return a non-empty priority queue with the element added in the correct position.
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Returns the value of the element with the highest priority in the queue. If multiple elements
   * have the same priority, the value of the element added first chronologically will be returned.
   * @return the value of the element with the highest priority in the queue
   * @throws EmptyPriorityQueueException if called on an empty priority queue.
   */
  String peek() throws EmptyPriorityQueueException ;

  /**
   * Returns a copy of the priority queue without the element with the highest priority.
   * @return a copy of the priority queue without the element with the highest priority.
   * @throws EmptyPriorityQueueException if called on an empty priority queue.
   */
  PriorityQueue pop() throws EmptyPriorityQueueException;
}