package Option2;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Utility Class RideshareDriverValidator validates Drivers and adds valid drivers to the pool of
 * rideshare drivers.
 */

public class RideshareDriverValidator {
  public static final String MENU = "Enter 'search' to search for a driver by last name or"
      + "'quit' to quit the program.";

  public static List<Driver> acceptedDrivers;

  public static void addDriver(Driver driver) {
    if (RegistrationValidator.registrationValidator(driver) && !acceptedDrivers.contains(driver)) {
      acceptedDrivers.add(driver);
    }
  }

  /**
   * This method prints out vehicle and driving violation information about all drivers with the
   * given last name, or an error message if no drivers with that last name are found.
   * @param lastName - The last name to query, as a String.
   */
  public static void provideDriverInfo(String lastName) {
    List<Driver> matches = acceptedDrivers.stream().filter(x -> x.getName().getLastName().equals(lastName))
        .toList();
    if (matches.isEmpty()) {
      System.out.println("No registered driver found");
    } else {
      for (Driver driver:matches) {
        System.out.println(driver.getVehicle());
        for (Violation violation:driver.getDrivingHistory()) {
          System.out.println("Driving violations: ");
          System.out.println("\t" + violation);
        }
      }
    }
  }

  /**
   * Method to run the simulation. Opens the file path given by the user and reads in the data from
   * the file, adds valid drivers to the driver pool, and allows users to query the driver pool
   * by last name.
   * @param filePath - The file path given by the user, as a String.
   */
  public static void runSimulation(String filePath) {
    Scanner scanner = new Scanner(System.in);
    String[] pathElements = filePath.split("[\\\\/]");
    String systemAgnosticPath = String.join(File.separator, pathElements);
    // read in data
    List<Driver> data = csvParser.readData(systemAgnosticPath);
    // add drivers to the rideshare driver pool
    for(Driver driver:data) {
      RideshareDriverValidator.addDriver(driver);
    }
    // get user choice
    String input = "";
    while (!Objects.equals(input, "quit")) {
      System.out.println(MENU);
      input = scanner.nextLine();
      switch (input) {
        case "search":
          System.out.println("Enter the last name to search: ");
          String lastName = scanner.nextLine();
          RideshareDriverValidator.provideDriverInfo(lastName);
          break;
        case "quit":
          System.out.println("Quitting the program.");
          break;
        default:
          System.out.println("Invalid option. Try again.");
      }
    }
    scanner.close();
  }
}