package problem1;

public class EmptyPriorityQueue implements PriorityQueue {

  /**
   * Returns whether the priority queue is empty
   * @return whether the priority queue is empty
   */
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Adds the given element to the priority queue and returns the priority queue
   * @param priority - The priority of the element to be added, as an Integer.
   * @param value - The value of the element to be added, as a String.
   * @return the updated priority queue
   */
  public PriorityQueue add(Integer priority, String value) {
    return new NonEmptyPriorityQueue(new ElementNode(priority, value), this);
  }

  /**
   * Returns the value of the element with the highest priority in the queue. If multiple elements
   * have the same priority, the value of the element added last chronologically will be returned.
   * @return the value of the element with the highest priority in the queue
   * @throws EmptyPriorityQueueException if called on an empty priority queue.
   */
  public String peek() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  /**
   * Returns a copy of the priority queue without the element with the highest priority.
   * @return a copy of the priority queue without the element with the highest priority.
   * @throws EmptyPriorityQueueException if called on an empty priority queue.
   */
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    return !(o == null || getClass() != o.getClass());
  }
}