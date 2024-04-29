package problem1;

import java.util.Objects;

/**
 * Class Name represents a name as their first name and last name.
 */

public class Name {
  private String firstName;
  private String lastName;

  /**
   * Constructor creating a new Name object with given first and last name
   * @param firstName - first name as a String
   * @param lastName - last name as a String
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name
   * @return last name
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
}
