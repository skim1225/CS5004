package problem2;

import java.util.Objects;

/**
 * This class represents a Recipient which has a first name, last name, and email address.
 */

public class Recipient {

  private String firstName;
  private String lastName;
  private String emailAddress;

  /**
   * Construct a Recipient object which has the given first name, last name, and email address.
   *
   * @param firstName The first name to be given
   * @param lastName The last name to be given
   * @param emailAddress The email address to be given
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * Return the first name of the recipient
   * @return the first name of the recipient
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Return the last name of the recipient
   * @return the last name of the recipient
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Return the email address of the recipient
   * @return the email address of the recipient
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(firstName, recipient.firstName) && Objects.equals(
        lastName, recipient.lastName) && Objects.equals(emailAddress,
        recipient.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, emailAddress);
  }
}
