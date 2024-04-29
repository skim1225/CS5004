package problem1;

import java.util.Objects;

/**
 * Class ElementNode represents an element in the priority queue as its priority and value.
 */
public class ElementNode {

  private Integer priority;
  private String value;

  /**
   * Constructor for creating a new element node with the given priority and value.
   * @param priority - The priority of the element, as an Integer.
   * @param value - The value of the element, as a String.
   */
  public ElementNode(Integer priority, String value) {
    this.priority = priority;
    this.value = value;
  }

  /**
   * Returns the priority of the element
   * @return the priority of the element
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Returns the value of the element
   * @return the value of the element
   */
  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementNode that = (ElementNode) o;
    return Objects.equals(priority, that.priority) && Objects.equals(value,
        that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, value);
  }
}
