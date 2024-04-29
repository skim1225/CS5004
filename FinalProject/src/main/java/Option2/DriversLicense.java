package Option2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class DriversLicense contains information about a Driver's driver's license including information
 * such as the license unique number, a driver’s name, a driver’s address, a driver’s birthdate,
 * country and state of issuance, and issuance and expiration date.
 */
public class DriversLicense {
  private Integer licenseNumber;
  private Name name;
  // implemented as a String and not an Address class because different countries may have different
  // address formats/fields.
  private String address;
  private LocalDate birthday;
  private String issuingCountry;
  private String issuingState;
  private LocalDate issuedDate;
  private LocalDate expirationDate;

  public DriversLicense(Integer licenseNumber, Name name, String address, LocalDate birthday,
      String issuingCountry, String issuingState, LocalDate issuedDate, LocalDate expirationDate) {
    this.licenseNumber = licenseNumber;
    this.name = name;
    this.address = address;
    this.birthday = birthday;
    this.issuingCountry = issuingCountry;
    this.issuingState = issuingState;
    this.issuedDate = issuedDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Returns the license number, as an Integer.
   * @return the license number, as an Integer.
   */
  public Integer getLicenseNumber() {
    return licenseNumber;
  }

  /**
   * Returns the name on the license, as a Name.
   * @return the name on the license, as a Name.
   */
  public Name getName() {
    return name;
  }

  /**
   * Returns the address on the license, as a String.
   * @return the address on the license, as a String.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns the birthday on the license, as a LocalDate.
   * @return the birthday on the license, as a LocalDate.
   */
  public LocalDate getBirthday() {
    return birthday;
  }

  /**
   * Returns the license's issuing country, as a String.
   * @return the license's issuing country, as a String.
   */
  public String getIssuingCountry() {
    return issuingCountry;
  }

  /**
   * Returns the license's issuing state, as a String.
   * @return the license's issuing state, as a String.
   */
  public String getIssuingState() {
    return issuingState;
  }

  /**
   * Returns the date the license was issued, as a LocalDate.
   * @return the date the license was issued, as a LocalDate.
   */
  public LocalDate getIssuedDate() {
    return issuedDate;
  }

  /**
   * Returns the date the license expires, as a LocalDate.
   * @return the date the license expires, as a LocalDate.
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriversLicense that = (DriversLicense) o;
    return Objects.equals(licenseNumber, that.licenseNumber) && Objects.equals(
        name, that.name) && Objects.equals(address, that.address)
        && Objects.equals(birthday, that.birthday) && Objects.equals(
        issuingCountry, that.issuingCountry) && Objects.equals(issuingState,
        that.issuingState) && Objects.equals(issuedDate, that.issuedDate)
        && Objects.equals(expirationDate, that.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(licenseNumber, name, address, birthday, issuingCountry, issuingState,
        issuedDate, expirationDate);
  }

  @Override
  public String toString() {
    return "DriversLicense{" +
        "licenseNumber=" + licenseNumber +
        ", name=" + name +
        ", address='" + address + '\'' +
        ", birthday=" + birthday +
        ", issuingCountry='" + issuingCountry + '\'' +
        ", issuingState='" + issuingState + '\'' +
        ", issuedDate=" + issuedDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
