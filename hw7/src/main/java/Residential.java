import java.util.Objects;

/**
 * Class Residential represents a residential property and includes information about the
 * number of beds and baths it contains.
 */
public class Residential extends Property{
  private Integer numBed;
  private Double numBath;

  /**
   * Constructor for creating a new Residential Property with the given address, size in sq ft,
   * number of bedrooms, and number of bathrooms.
   * @param address - The address to be set, as a String.
   * @param sqFt - The size to be set, as an Integer.
   * @param numBed - The number of bedrooms to be set, as an Integer.
   * @param numBath - The number of bathrooms to be set, as a Double.
   * @throws InvalidArgumentException if thd number of bedrooms or bathrooms is negative.
   */
  public Residential(String address, Integer sqFt, Integer numBed, Double numBath)
      throws InvalidArgumentException {
    super(address, sqFt);
    if (numBed >= 0 && numBath >= 0) {
      this.numBed = numBed;
      this.numBath = numBath;
    } else {
      throw new InvalidArgumentException("Number of bedrooms and bathrooms cannot be negative.");
    }
  }

  /**
   * Returns the number of bedrooms.
   * @return the number of bedrooms.
   */
  public Integer getNumBed() {
    return numBed;
  }

  /**
   * Returns the number of bathrooms.
   * @return the number of bathrooms.
   */
  public Double getNumBath() {
    return numBath;
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
    Residential that = (Residential) o;
    return Objects.equals(numBed, that.numBed) && Objects.equals(numBath,
        that.numBath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numBed, numBath);
  }
}
