import java.util.Objects;

/**
 * Class Commercial represents a commercial property and include information about the number
 * of offices it contains as well as whether it is suitable for retail.
 */
public class Commercial extends Property{
  private Integer numOffices;
  private Boolean retailSuitable;

  /**
   * Constructor for creating a new Commercial Property with the given address, size in sq ft,
   * number of offices, and whether it is retail-suitable.
   * @param address - The address to be set, as a String.
   * @param sqFt - The size to be set, as an Integer.
   * @param numOffices - The number of offices to be set, as an Integer.
   * @param retailSuitable - A flag indicating whether the property is retail suitable, as a boolean.
   * @throws InvalidArgumentException if the number of offices is negative.
   */
  public Commercial(String address, Integer sqFt, Integer numOffices, Boolean retailSuitable)
      throws InvalidArgumentException {
    super(address, sqFt);
    if (numOffices >= 0) {
      this.numOffices = numOffices;
      this.retailSuitable = retailSuitable;
    } else {
      throw new InvalidArgumentException("Number of offices cannot be negative.");
    }
  }

  /**
   * Returns the number of offices.
   * @return the number of offices.
   */
  public Integer getNumOffices() {
    return numOffices;
  }

  /**
   * Returns whether ths property is suitable for retail.
   * @return whether ths property is suitable for retail.
   */
  public Boolean getRetailSuitable() {
    return retailSuitable;
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
    Commercial that = (Commercial) o;
    return Objects.equals(numOffices, that.numOffices) && Objects.equals(
        retailSuitable, that.retailSuitable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOffices, retailSuitable);
  }
}
