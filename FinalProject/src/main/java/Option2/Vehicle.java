package Option2;

import java.util.Objects;

/**
 * Class VehicleInformation contains information about a vehicle such as make, model and year of
 * the vehicle, as well as about the vehicle’s official owner.
 */

public class Vehicle {
  // made Strings and not enums because there are too many makes and models to manually create an enum
  private String make;
  private String model;
  private Integer year;
  private Driver owner;

  /**
   * Constructor for creating a new Vehicle object with the given make, model, year, and owner.
   * @param make - The make of the Vehicle to be set, as a String.
   * @param model - The model of the Vehicle to be set, as a String.
   * @param year - The year of the Vehicle to be set, as an Integer.
   * @param owner - The owner of the Vehicle to be set, as a Driver.
   */
  public Vehicle(String make, String model, Integer year, Driver owner) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.owner = owner;
  }

  /**
   * Returns the make of the Vehicle, as a String.
   * @return the make of the Vehicle, as a String.
   */
  public String getMake() {
    return make;
  }

  /**
   * Returns the model of the Vehicle, as a String.
   * @return the model of the Vehicle, as a String.
   */
  public String getModel() {
    return model;
  }

  /**
   * Returns the year of the Vehicle, as an Integer.
   * @return the year of the Vehicle, as an Integer.
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Returns the owner of the Vehicle, as a Driver.
   * @return the owner of the Vehicle, as a Driver.
   */
  public Driver getOwner() {
    return owner;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(make, vehicle.make) && Objects.equals(model,
        vehicle.model) && Objects.equals(year, vehicle.year) && Objects.equals(
        owner, vehicle.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, owner);
  }

  @Override
  public String toString() {
    return year + " " + make + " " + model;
  }
}
