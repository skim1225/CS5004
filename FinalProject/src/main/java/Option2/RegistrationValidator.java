package Option2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Class RegistrationValidator is a utility class which checks if the prospective driver is
 * suitable to be added to the pool of registered and accepted drivers, and adds the driver if
 * suitable.
 */
public class RegistrationValidator {
  public static final Integer AGE_LIMIT = 21;
  public static final Integer VEHICLE_AGE_LIMIT = 15;
  public static final Integer MONTHS_LIMIT = 6;
  public static final List<MovingViolation> DISQUALIFYING_VIOLATIONS = new ArrayList<>(Arrays.asList(
      MovingViolation.RECKLESS_DRIVING, MovingViolation.DUI,
      MovingViolation.DRIVING_WITHOUT_VALID_LICENSE_OR_INSURANCE,
      MovingViolation.SPEEDING));

  /**
   * Returns whether the Driver's application meets the rideshare app's standards.
   * @param driver - The driver to be inspected, as a Driver.
   * @return - Whether the given Driver is qualified to be added to the pool of drivers.
   */
  public static boolean registrationValidator(Driver driver) {
    return validateDriverAge(driver) && validateDriversLicense(driver) && validateVehicleAge(driver)
        && validateInsurance(driver) && validateDrivingHistory(driver) && validateVehicleHistory(driver);
  }

  /**
   * Returns whether the Drive is a valid age (21 or older)
   * @param driver - The driver to be inspected, as a Driver.
   * @return whether the Drive is a valid age (21 or older)
   */
  private static boolean validateDriverAge(Driver driver) {
    Period period = Period.between(driver.getBirthday(), LocalDate.now());
    int age = period.getYears();
    return age >= AGE_LIMIT;
  }

  /**
   * Returns whether the driver's license is valid.
   * @param driver - The driver to be inspected, as a Driver.
   * @return whether the driver's license is valid.
   */
  private static boolean validateDriversLicense(Driver driver) {
    if (driver.getName() != driver.getLicense().getName())
      return Boolean.FALSE;
    if (driver.getBirthday() != driver.getLicense().getBirthday())
      return Boolean.FALSE;
    if (!Objects.equals(driver.getLicense().getIssuingCountry(), "US")
        || !Objects.equals(driver.getLicense().getIssuingCountry(), "Canada"))
      return Boolean.FALSE;
    Period period = Period.between(driver.getBirthday(), LocalDate.now());
    int months = period.getMonths();
    if (months <= MONTHS_LIMIT)
      return Boolean.FALSE;
    return Boolean.TRUE;
  }

  /**
   * Returns whether the vehicle is a suitable age (15 or less).
   * @param driver - The driver to be inspected, as a Driver.
   * @return whether the vehicle is a suitable age (15 or less).
   */
  private static boolean validateVehicleAge(Driver driver) {
    int vehicleAge = LocalDate.now().getYear() - driver.getVehicle().getYear();
    return vehicleAge <= VEHICLE_AGE_LIMIT;
  }

  /**
   * Returns whether the driver's insurance is valid.
   * @param driver - The driver to be inspected, as a Driver.
   * @return whether the driver's insurance is valid.
   */
  private static boolean validateInsurance(Driver driver) {
    if (driver.getName() != driver.getInsurance().getVehicleOwner())
      return Boolean.FALSE;
    else if (!driver.getInsurance().getInsuredDrivers().contains(driver))
      return Boolean.FALSE;
    return LocalDate.now().isAfter(driver.getInsurance().getExpirationDate());
  }

  /**
   * Returns whether the driver's driving history qualifies.
   * @param driver - The driver to be inspected, as a Driver.
   * @return whether the driver's driving history qualifies.
   */
  private static boolean validateDrivingHistory(Driver driver) {
    boolean accepted = Boolean.TRUE;
    for (Violation violation : driver.getDrivingHistory()) {
      if (DISQUALIFYING_VIOLATIONS.contains(violation.getViolationType())) {
        accepted = Boolean.FALSE;
      }
    }
    return accepted;
  }

  /**
   * Returns whether the vehicle's history qualifies.
   * @param driver - The driver to be inspected, as a Driver.
   * @return Returns whether the vehicle's history qualifies.
   */
  private static boolean validateVehicleHistory(Driver driver) {
    boolean accepted = Boolean.TRUE;
    for (Violation violation : driver.getVehicleHistory().getViolations()) {
      Period period = Period.between(violation.getViolationDate(), LocalDate.now());
      if (period.getMonths() <= MONTHS_LIMIT)
        accepted = Boolean.FALSE;
    }
    for (Crash crash : driver.getVehicleHistory().getCrashes()) {
      Period period = Period.between(crash.getDate(), LocalDate.now());
      if (period.getMonths() <= MONTHS_LIMIT)
        accepted = Boolean.FALSE;
    }
    return accepted;
  }
}
