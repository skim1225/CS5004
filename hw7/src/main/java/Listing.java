import java.util.Objects;

/**
 * Class Listing represents a listing for a property on a company's website. It contains information
 * about the property and the contract of the listing.
 * @param <P> - A subclass of the abstract class Property; the type for the first value.
 * @param <C> - A subclass of the abstract class Contract; the type for the second value.
 */
public class Listing<P extends Property, C extends Contract> {
  private P property;
  private C contract;

  /**
   * Constructor for creating a new Listing with the given property and contract
   * @param property - The property to be stored in the listing, as a Property
   * @param contract - The contract to be stored in the listing, as a Contract
   */
  public Listing(P property, C contract) {
    this.property = property;
    this.contract = contract;
  }

  /**
   * Returns the property of the listing.
   * @return the property of the listing.
   */
  public P getProperty() {
    return property;
  }

  /**
   * Returns the contract of the listing.
   * @return the contract of the listing.
   */
  public C getContract() {
    return contract;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return Objects.equals(property, listing.property) && Objects.equals(contract,
        listing.contract);
  }

  @Override
  public int hashCode() {
    return Objects.hash(property, contract);
  }
}
