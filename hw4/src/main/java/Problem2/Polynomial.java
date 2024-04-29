package Problem2;

import java.util.Objects;

/**
 * Class Polynomial represents a polynomial consisting of terms with weights and coefficients.
 * The polynomial is sorted with terms in descending order.
 */

public class Polynomial implements IPolynomial {

  private static final Integer INVALID_COEFFICIENT = 0;

  private TermNode head;
  private Integer size;

  /**
   * Constructor for creating a new polynomial. The polynomial contains no terms at creation.
   */
  public Polynomial() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Returns the head node of the polynomial.
   * @return the head node of the polynomial.
   */
  public TermNode getHead() {
    return head;
  }

  /**
   * Returns the size of the polynomial.
   * @return the size of the polynomial.
   */
  public Integer getSize() {
    return size;
  }

  /**
   * Returns the degree of the polynomial which is the highest power it contains.
   * @return the degree of the polynomial.
   */
  @Override
  public Integer getDegree() {
    return this.head.getPower();
  }

  /**
   * Returns the coefficient of the term with the given power. If it doesn't exist, returns 0.
   * @param power - The power of the term to return the coefficient of.
   * @return - The coefficient of the term of the given power. If the term does not exist, returns 0.
   */
  @Override
  public Integer getCoefficient(Integer power) {
    TermNode curr = this.head;
    while (curr != null) {
      if (curr.getPower().equals(power)) {
        return curr.getCoefficient();
      } else {
        curr = curr.getNextNode();
      }
    }
    return INVALID_COEFFICIENT;
  }

  /**
   * Adds a new term of the given power and coefficient to the term
   * @param coefficient - The coefficient of the term to be added as an Integer.
   * @param power - The power of the term to be added as an Integer.
   * @throws InvalidCoefficientException if the given coefficient is 0
   */
  @Override
  public void addTerm(Integer coefficient, Integer power) throws InvalidCoefficientException {
    if (coefficient.equals(INVALID_COEFFICIENT)) {
      throw new InvalidCoefficientException("Coefficient cannot be 0.");
    } else {
      // case A: empty list or new node is greater than current head
      if (this.head == null || power > this.head.getPower()) {
        TermNode newNode = new TermNode(coefficient, power);
        newNode.setNextNode(this.head);
        this.head = newNode;
        size += 1;
      } else {
        // case B: non-empty list
        TermNode curr = this.head;
        while(curr.getNextNode() != null && curr.getNextNode().getPower() > power) {
          curr = curr.getNextNode();
        }
        if (power.equals(curr.getPower())) {
          // case 1: power exists - add coefficients. If sum of coefficient is 0, remove node, decrement size
          Integer newCoefficient = coefficient + curr.getCoefficient();
          if (!newCoefficient.equals(INVALID_COEFFICIENT)) {
            curr.setCoefficient(newCoefficient);
          } else {
            this.removeTerm(power);
            size -= 1;
          }
        } else {
          // case 2: adding new term - insert node and increment size
          TermNode newNode = new TermNode(coefficient, power);
          newNode.setNextNode(curr.getNextNode());
          curr.setNextNode(newNode);
          this.size += 1;
        }
      }
    }
  }

  /**
   * Removes the term with the given power from the Polynomial
   * @param power - The power of the term to be removed, as an Integer.
   */
  @Override
  public void removeTerm(Integer power) {
    // case 1: term to remove is head
    if (power.equals(this.getDegree())) {
      this.head = this.head.getNextNode();
      this.size -= 1;
    } else {
      TermNode prev = this.head;
      TermNode curr = this.head.getNextNode();
      while (curr != null) {
        if (curr.getPower().equals(power)) {
          if (curr.getNextNode() != null) {
            // case 2: term to remove is internal
            prev.setNextNode(curr.getNextNode());
          } else {
            // case 3: term to remove is tail
            prev.setNextNode(null);
          }
          this.size -= 1;
        } else {
          prev = curr;
          curr = curr.getNextNode();
        }
      }
      // case 4: term to remove is not in list, do nothing
    }
  }

  /**
   * Returns whether this and the given Polynomial are the same.
   * @param other - The other Polynomial to be compared
   * @return whether this and the given Polynomial are the same.
   */
  @Override
  public Boolean isSame(Polynomial other) {
    if (!this.size.equals(other.getSize())) {
      return false;
    } else {
      TermNode curr1 = this.head;
      TermNode curr2 = other.getHead();
      while (curr1 != null) {
        if (!curr1.equals(curr2)) {
          return false;
        }
        curr1 = curr1.getNextNode();
        curr2 = curr2.getNextNode();
      }
    }
    return true;
  }

  /**
   * Returns a new Polynomial representing the result of adding this polynomial to the given polynomial.
   * @param other - The other Polynomial to be added.
   * @return The sum of this and the given Polynomial.
   * @throws InvalidCoefficientException if a coefficient is 0
   */
  @Override
  public Polynomial add(Polynomial other) throws InvalidCoefficientException {
    Polynomial newPolynomial = new Polynomial();
    TermNode curr = this.head;
    while (curr != null) {
      newPolynomial.addTerm(curr.getCoefficient(), curr.getPower());
      curr = curr.getNextNode();
    }
    curr = other.getHead();
    while (curr != null) {
      newPolynomial.addTerm(curr.getCoefficient(), curr.getPower());
      curr = curr.getNextNode();
    }
    return newPolynomial;
  }

  /**
   * Returns a string representing the polynomial
   * @return a string representing the polynomial
   */
  @Override
  public String printPolynomial() {
    TermNode curr = this.head;
    String polymomialStr = "";
    while (curr != null) {
      String termStr = curr.getCoefficient() + "x^" + curr.getPower();
      polymomialStr += termStr;
      if (curr.getNextNode() != null) {
        polymomialStr += " + ";
      }
      curr = curr.getNextNode();
    }
    return polymomialStr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Polynomial that = (Polynomial) o;
    return Objects.equals(head, that.head);
  }

  @Override
  public int hashCode() {
    return Objects.hash(head);
  }
}
