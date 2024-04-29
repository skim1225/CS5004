/**
 * Class Sale represents a contract for the sale of a property.
 */
public class Sale extends Contract {

  /**
   * Constructor for creating a new contract for a sale.
   * @param askingPrice - The asking price to be set, as a Double.
   * @param negotiable - The negotiable flag to be set, as a Boolean.
   * @throws InvalidArgumentException if the asking price is negative.
   */
  public Sale(Double askingPrice, Boolean negotiable) throws InvalidArgumentException {
    super(askingPrice, negotiable);
  }

<<<<<<< HEAD
=======
  /**
   * Returns the commision earnings for this contract.
   * @return the commision earnings for this contract.
   */
>>>>>>> main
  @Override
  protected double calculateCommissionEarnings() {
    return this.askingPrice;
  }
}
