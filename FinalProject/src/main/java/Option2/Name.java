package Option2;

import java.util.Objects;

/**
 * Class Name provides information about a prospective driver’s first and last name.
 */

public class Name {

  private String firstName;

  private String lastName;

  /**
   * Constructor for creating a new Name with the given strings.
   * @param firstName - The first name of the Name, as a String.
   * @param lastName - The last name of the Name, as a String.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name of the Name, as a String.
   * @return the first name of the Name, as a String.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the Name, as a String.
   * @return the last name of the Name, as a String.
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
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects.equals(lastName,
        name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
