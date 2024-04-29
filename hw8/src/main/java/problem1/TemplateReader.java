/**
 * Class ReadTemplate is a helper method which has functionality for taking a file path to a
 * template file and converting it to a List of Strings representing each line of the template.
 */
package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemplateReader {

  /**
   * Method for reading in a template from a file and storing it in a List of Strings.
   * @param filePath - The file path of the template to be read.
   */
  public static List<String> readTemplate(String filePath) {
    List<String> template = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line = "";
      while ((line = reader.readLine()) != null) {
        template.add(line);
      }
    } catch (FileNotFoundException e) {
      System.out.println("The given file path was not found: " + e.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    }
    return template;
  }
}