import java.util.Objects;

/**
 * Abstract class Contract represents a contract for a property as its asking
 * price and whether it is negotiable.
 */
public abstract class Contract {
  protected Double askingPrice;
  protected Boolean negotiable;

  /**
   * Constructor for creating a new Contract with the given asking price and negotiable flag.
   * @param askingPrice - The asking price to be set, as a Double.
   * @param negotiable - The negotiable flag to be set, as a Boolean.
   * @throws InvalidArgumentException if the asking price is negative.
   */
  public Contract(Double askingPrice, Boolean negotiable) throws InvalidArgumentException {
    if (askingPrice >= 0) {
      this.askingPrice = askingPrice;
      this.negotiable = negotiable;
    } else {
      throw new InvalidArgumentException("Asking price cannot be negative.");
    }
  }

  /**
   * Returns the asking price of the contract.
   * @return the asking price of the contract.
   */
  public Double getAskingPrice() {
    return askingPrice;
  }

  /**
   * Returns the negotiable flag of the contract.
   * @return the negotiable flag of the contract.
   */
  public Boolean getNegotiable() {
    return negotiable;
  }

  /**
   * Returns the commision earnings for this contract.
   * @return the commision earnings for this contract.
   */
  protected abstract double calculateCommissionEarnings();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contract contract = (Contract) o;
    return Objects.equals(askingPrice, contract.askingPrice) && Objects.equals(
        negotiable, contract.negotiable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(askingPrice, negotiable);
  }
}
