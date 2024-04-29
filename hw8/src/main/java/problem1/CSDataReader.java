/**
 * Class problem1.ReadCSData is a helper class for getting information about customers from a provided CSV
 * file. It represents a collection of customers as a List of Lists; the other list is a list of
 * all customers, and each inner list is a list of each customer's information.
 */
package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSDataReader {

  /**
   * Method for reading in the data from a given file path and stores the information in a list
   * of lists of strings.
   * @param filePath - The file path of the file to be read in.
   */
  public static List<List<String>> readData(String filePath) {
    List<List<String>> customers = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line = "";
      while ((line = reader.readLine()) != null) {
        String[] CSInfo = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        for(int i = 0; i < CSInfo.length; i++) {
          CSInfo[i] = CSInfo[i].replaceAll("^\"|\"$", "");
        }
        customers.add(Arrays.asList(CSInfo));
      }
    } catch (FileNotFoundException e) {
      System.out.println("The given file path was not found: " + e.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    }
    return customers;
  }
}