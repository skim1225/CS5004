package problem3;

import java.util.Objects;

/**
 * Class Amount represents information about an amount of money in dollars and cents.
 */

public final class Amount {

  private final Integer dollars;
  private final Integer cents;

  /**
   * Constructor for the class Amount
   * @param dollars Integer, representing the number of dollars
   * @param cents Integer, representing the number of cents
   * @throws IllegalArgumentException If dollars is negative or cents is not between 0-99 inclusive.
   */
  public Amount(Integer dollars, Integer cents) throws IllegalArgumentException {
    if (dollars < 0 || !(cents >= 0 && cents <= 99)) {
      throw new IllegalArgumentException("Dollars must be greater than 0 and cents must be between 0 and 99.");
    }
    this.dollars = dollars;
    this.cents = cents;
  }

  /**
   * @return dollars, giving the number of dollars
   */
  public final Integer getDollars() {
    return dollars;
  }

  /**
   * @returnn cents, giving the number of cents
   */
  public final Integer getCents() {
    return cents;
  }

  /**
   * @param o - The Amount object to be compared
   * @return Boolean, giving whether the 2 Amounts have the same field values.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return Objects.equals(dollars, amount.dollars) && Objects.equals(cents,
        amount.cents);
  }

  /**
   * @return int, giving the Amount's hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(dollars, cents);
  }
}
