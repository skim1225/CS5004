package Option2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class csvParser is a utility class which reads a CSV containing driver information and returns
 * a list of driver objects.
 */

public class csvParser {

  /**
   * Opens the csv file of the given file path and converts the data into a list of drivers.
   * @param filePath - The path of the csv file, as a String.
   * @return a list of Drivers.
   */
  public static List<Driver> readData(String filePath) {
    List<Driver> drivers = new ArrayList<>();
    File file = new File(filePath);
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
        drivers.add(parseDriverData(line));
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
    return drivers;
  }

  /**
   * Helper method to turn 1 line of data into an encapsulated Driver object.
   * @param line - The driver's information, as a String.
   * @return a Driver object.
   */
  private static Driver parseDriverData(String line) {
    Name name;
    LocalDate birthday;
    DriversLicense license;
    Vehicle vehicle;
    Insurance insurance;
    List<Violation> drivingHistory;
    VehicleHistory vehicleHistory;
    String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    name = new Name(values[0], values[1]);
    birthday = getDate(values[2]);
    license = new DriversLicense(Integer.parseInt(values[3]), new Name(values[4], values[5]), values[6], getDate(values[7]), values[8],
        values[9], getDate(values[10]), getDate(values[11]));
    insurance = new Insurance(new Name(values[12], values[13]), getNames(values[14]), getDate(values[15]));
    drivingHistory = new ArrayList<>(Arrays.asList(values[16].split(",")));
    vehicleHistory = new VehicleHistory(Arrays.asList(values[17].split(",")),
        Arrays.asList(values[18].split(",")));
    Driver driver = new Driver(name, birthday, license, vehicle, insurance, drivingHistory,
        vehicleHistory);
    return driver;
  }

  /**
   * Helper method to return the LocalDate of a String representation of a date.
   * @param stringDate - The date, as a String.
   * @return the LocalDate of a String representation of a date.
   */
  private static LocalDate getDate(String stringDate) {
    String[] dateArr = stringDate.split("/");
    return LocalDate.of(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
  }

  /**
   * Parses a comma-seperated list of names into a List of Names.
   * @param list - The list of insured drivers, as a String.
   * @return a List of insured drivers' Names.
   */
  private static List<Name> getNames(String list) {
    String[] namesArr = list.split(",");

  }

  /**
   * Parses a String containing comma-separated values into a list of Strings.
   * @param list - The String containing the comma separated values.
   * @return A list of Strings.
   */
  private static List<String> getValues(String list) {
    return Arrays.asList(list.split(","));
  }

}
