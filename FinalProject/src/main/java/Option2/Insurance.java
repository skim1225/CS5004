package Option2;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Class Insurance represents information about a Driver's car insurance including the name of the
 * official owner, the insured drivers, and the expiration date of the insurance.
 */

public class Insurance {
  private Name vehicleOwner;
  private List<Name> insuredDrivers;
  private LocalDate expirationDate;

  /**
   * Constructor for creating a new Insurance object with the given vehicle owner, list of insured
   * drivers, and date of expiration.
   * @param vehicleOwner - The owner of the Vehicle, as a Name.
   * @param insuredDrivers - A list of insured drivers' names..
   * @param expirationDate - The expiration date of insurance, as a LocalDate.
   */
  public Insurance(Name vehicleOwner, List<Name> insuredDrivers, LocalDate expirationDate) {
    this.vehicleOwner = vehicleOwner;
    this.insuredDrivers = insuredDrivers;
    this.expirationDate = expirationDate;
  }

  /**
   * Returns the name of the Vehicle owner, as a Name.
   * @return the name of the Vehicle owner, as a Name.
   */
  public Name getVehicleOwner() {
    return vehicleOwner;
  }

  /**
   * Returns the drivers insured by the policy, as a List of Driver objects.
   * @return the drivers insured by the policy, as a List of Driver objects.
   */
  public List<Name> getInsuredDrivers() {
    return insuredDrivers;
  }

  /**
   * Returns the expiration date of the insurance policy, as a Date.
   * @return the expiration date of the insurance policy, as a Date.
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
    Insurance insurance = (Insurance) o;
    return Objects.equals(vehicleOwner, insurance.vehicleOwner) && Objects.equals(
        insuredDrivers, insurance.insuredDrivers) && Objects.equals(expirationDate,
        insurance.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleOwner, insuredDrivers, expirationDate);
  }

  @Override
  public String toString() {
    return "Insurance{" +
        "vehicleOwner=" + vehicleOwner +
        ", insuredDrivers=" + insuredDrivers +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
