package problem2;

import java.util.Objects;

/**
 * Abstract class Individual represents an individual creator of a piece of media as their
 * first and last names.
 */

public abstract class Individual extends Creator {

  private String firstName;
  private String lastName;

  /**
   * A constructor for creating an Individual with the given first and last names.
   * @param firstName - The first name of the Individual, as a String.
   * @param lastName - The last name of the Individual, as a String.
   */
  public Individual(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name of the Individual.
   * @return the first name of the Individual.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the Individual.
   * @return the last name of the Individual.
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Individual that = (Individual) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName,
        that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
