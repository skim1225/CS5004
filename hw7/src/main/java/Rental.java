import java.util.Objects;

/**
 * Class Rental represents a contract for rental of a property and stores information about
 * the length of the contract in months.
 */
public class Rental extends Contract {
  private Integer months;

  /**
   * Constructor for creating a new rental contract with the given asking price, negotiable flag,
   * and term in months.
   * @param askingPrice - The asking price to be set, as a Double.
   * @param negotiable - The negotiable flag to be set, as a Boolean.
   * @param months - The length of the contract in months, as an Integer.  * @throws InvalidArgumentException
   */
  public Rental(Double askingPrice, Boolean negotiable, Integer months)
      throws InvalidArgumentException {
    super(askingPrice, negotiable);
    if (months >= 0) {
      this.months = months;
    } else {
      throw new InvalidArgumentException("Number of months in the contract cannot be negative. ");
    }
  }

  /**
   * Returns the length of the contract in months.
   * @return the length of the contract in months.
   */
  public Integer getMonths() {
    return months;
  }

<<<<<<< HEAD
=======
  /**
   * Returns the commission earnings for this contract.
   * @return the commission earnings for this contract.
   */
>>>>>>> main
  @Override
  protected double calculateCommissionEarnings() {
    return this.askingPrice * this.months;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(months, rental.months);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), months);
  }
}
