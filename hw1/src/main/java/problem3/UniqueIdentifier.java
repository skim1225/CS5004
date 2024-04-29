package problem3;

import java.util.Objects;

/**
 * Class UniqueIdentifier stores information about a Customer's unique identifier
 */

public class UniqueIdentifier {

  private final Integer yearCreated;
  private final String countryCreated;

  /**
   * Constructor for the class UniqueIdentifier
   * @param yearCreated - Integer, representing the year the account was created
   * @param countryCreated - Integer, representing the country the account was created
   */
  public UniqueIdentifier(Integer yearCreated, String countryCreated) {
    this.yearCreated = yearCreated;
    this.countryCreated = countryCreated;
  }

  /**
   * @return Integer, giving the year the account was created
   */
  public final Integer getYearCreated() {
    return yearCreated;
  }

  /**
   * @return Integer, giving the country the account was created
   */
  public final String getCountryCreated() {
    return countryCreated;
  }

  /**
   * @param o - The UniqueIdentifier objece to be cmopared to
   * @return boolean, giving whether all of the fields of both objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UniqueIdentifier that = (UniqueIdentifier) o;
    return Objects.equals(yearCreated, that.yearCreated) && Objects.equals(
        countryCreated, that.countryCreated);
  }

  /**
   * @return int, giving the hash code of the Unique Identifier object
   */
  @Override
  public int hashCode() {
    return Objects.hash(yearCreated, countryCreated);
  }
}
