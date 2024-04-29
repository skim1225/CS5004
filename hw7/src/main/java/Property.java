import java.util.Objects;

/**
 * Abstract class property represents a property in terms of its address and size in square feet.
 */
public abstract class Property {
  protected String address;
  protected Integer sqFt;

  /**
   * Constructor for creating a new Property with the given address and size in square feet.
   * @param address - The address to be set, as a String.
   * @param sqFt - The size to be set, as an Integer.
   * @throws InvalidArgumentException if the size is negative.
   */
  public Property(String address, Integer sqFt) throws InvalidArgumentException {
    if (sqFt >= 0) {
      this.address = address;
      this.sqFt = sqFt;
    } else {
      throw new InvalidArgumentException("Size cannot be negative.");
    }
  }

  /**
   * Returns the address of the Property.
   * @return the address of the Property.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns the size of the Property in square feet.
   * @return the size of the Property in square feet.
   */
  public Integer getSqFt() {
    return sqFt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Property property = (Property) o;
    return Objects.equals(address, property.address) && Objects.equals(sqFt,
        property.sqFt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, sqFt);
  }
}
