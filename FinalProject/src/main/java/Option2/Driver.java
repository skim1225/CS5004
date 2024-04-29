package Option2;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Class Driver represents a prospective driver for the rideshare app and includes information about
 * their license, insurance, vehicle, and driving history.
 */

public class Driver {
  private Name name;
  private LocalDate birthday;
  private DriversLicense license;
  private Vehicle vehicle;
  private Insurance insurance;
  private List<Violation> drivingHistory;
  private VehicleHistory vehicleHistory;

  /**
   * Constructor for creating a new Driver.
   * @param name - The name of the Driver, as a Name.
   * @param birthday - The birthday of the Driver, as a LocalDate.
   * @param license - The license of the Driver, as a DriversLicense.
   * @param vehicle - The Driver's vehicle, as a Vehicle.
   * @param insurance - The Driver's insurance, as an Insurance.
   * @param drivingHistory - The Driver's driving history, as a List of violations.
   * @param vehicleHistory - The Vehicle's history, as a VehicleHistory.
   */
  public Driver(Name name, LocalDate birthday, DriversLicense license, Vehicle vehicle,
      Insurance insurance, List<Violation> drivingHistory, VehicleHistory vehicleHistory) {
    this.name = name;
    this.birthday = birthday;
    this.license = license;
    this.vehicle = vehicle;
    this.insurance = insurance;
    this.drivingHistory = drivingHistory;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Returns the name of the Driver, as a Name.
   * @return the name of the Driver, as a Name.
   */
  public Name getName() {
    return name;
  }

  /**
   * Returns the Driver's birthday, as a LocalDate.
   * @return the Driver's birthday, as a LocalDate.
   */
  public LocalDate getBirthday() {
    return birthday;
  }

  /**
   * Returns the Driver's license, as a DriversLicense.
   * @return the Driver's license, as a DriversLicense.
   */
  public DriversLicense getLicense() {
    return license;
  }

  /**
   * Returns the Driver's vehicle, as a Vehicle.
   * @return the Driver's vehicle, as a Vehicle.
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Returns the Driver's insurance, as an Insurance.
   * @return the Driver's insurance, as an Insurance.
   */
  public Insurance getInsurance() {
    return insurance;
  }

  /**
   * Returns the Driver's driving history as a list of violations.
   * @return the Driver's driving history as a list of violations.
   */
  public List<Violation> getDrivingHistory() {
    return drivingHistory;
  }

  /**
   * Returns the Vehicle's history, as a VehicleHistory.
   * @return the Vehicle's history, as a VehicleHistory.
   */
  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Driver driver = (Driver) o;
    return Objects.equals(name, driver.name) && Objects.equals(birthday,
        driver.birthday) && Objects.equals(license, driver.license)
        && Objects.equals(vehicle, driver.vehicle) && Objects.equals(insurance,
        driver.insurance) && Objects.equals(drivingHistory, driver.drivingHistory)
        && Objects.equals(vehicleHistory, driver.vehicleHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthday, license, vehicle, insurance, drivingHistory,
        vehicleHistory);
  }
}
