package Problem2;

import java.util.Objects;

/**
 * TermNode is a class which represents a term in a polynomial. A term has an integer
 * non-zero coefficient and an integer power.
 */

public class TermNode {
  private Integer coefficient;
  private Integer power;
  private TermNode nextNode;

  /**
   * Constructor for creating a new Term Node with the given coefficient and power. The next Node is
   * set to null by default.
   * @param coefficient - The coefficient of the term to be created as an Integer.
   * @param power - The power of the term to be created as an Integer.
   */
  public TermNode(Integer coefficient, Integer power) {
    this.coefficient = coefficient;
    this.power = power;
    this.nextNode = null;
  }

  /**
   * Returns the coefficient of the term.
   * @return the coefficient of the term.
   */
  public Integer getCoefficient() {
    return coefficient;
  }

  /**
   * Returns the power of the term.
   * @return the power of the term.
   */
  public Integer getPower() {
    return power;
  }

  /**
   * Returns the next node.
   * @return the next node.
   */
  public TermNode getNextNode() {
    return nextNode;
  }

  /**
   * Sets the coefficient to the given coefficient
   * @param coefficient - The coefficient to be set as an Integer.
   */
  public void setCoefficient(Integer coefficient) {
    this.coefficient = coefficient;
  }

  /**
   * Sets the next TermNode to the given TermNode.
   * @param nextNode - The TermNode to be set as next.
   */
  public void setNextNode(TermNode nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TermNode termNode = (TermNode) o;
    return Objects.equals(coefficient, termNode.coefficient) && Objects.equals(
        power, termNode.power);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coefficient, power);
  }
}
