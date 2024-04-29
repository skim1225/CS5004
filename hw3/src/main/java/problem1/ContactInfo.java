package problem1;

import java.util.Objects;

/**
 * Class Contact Info stores information about an employee's contact information such as their
 * name, address, phone number, email address, and emergency contact.
 */
public class ContactInfo {
  private Name name;
  private String address;
  private String phoneNumber;
  private String emailAddress;
  private Name emergencyContact;

  /**
   * Constructor creating a new Contact Info object with the given name, address, phone number,
   * email, and emergency contact
   * @param name
   * @param address
   * @param phoneNumber
   * @param emailAddress
   * @param emergencyContact
   */
  public ContactInfo(Name name, String address, String phoneNumber, String emailAddress,
      Name emergencyContact) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.emergencyContact = emergencyContact;
  }

  /**
   * Returns the name
   * @return name
   */
  public Name getName() {
    return name;
  }

  /**
   * Returns the address
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns the phone number
   * @return phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Returns the email address
   * @return email address
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * Returns the emergency contact
   * @return emergency contact
   */
  public Name getEmergencyContact() {
    return emergencyContact;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfo that = (ContactInfo) o;
    return Objects.equals(name, that.name) && Objects.equals(address,
        that.address) && Objects.equals(phoneNumber, that.phoneNumber)
        && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(
        emergencyContact, that.emergencyContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, phoneNumber, emailAddress, emergencyContact);
  }
}
