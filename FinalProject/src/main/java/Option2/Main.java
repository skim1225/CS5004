package Option2;

import java.util.Scanner;

public class Main {

  /**
   * Main method to run the rideshare driver validator.
   * @param args - The command line arguments to run the main method with, as an array of Strings.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the filepath of the file containing driver information: ");
    String filePath = scanner.nextLine();
    RideshareDriverValidator.runSimulation(filePath);
  }
}
