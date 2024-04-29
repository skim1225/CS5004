package problem1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TemplateWriter {

  private List<List<String>> customerData;
  private List<String> headerInfo;

  /**
   * Constructor to construct a new TemplateWriter object with provided customerData
   * @param customerData customerData retrieved from parsed csv file as a List of lists of strings
   */
  public TemplateWriter(List<List<String>> customerData) {
    this.customerData = customerData;
    this.headerInfo = customerData.get(0);
  }

  /**
   * Getter method that retrieves the Customer data
   * @return - returns customerData as a list of lists of strings
   */
  public List<List<String>> getCustomerData() {
    return customerData;
  }

  /**
   * Getter method that retrieves the headerInfo of a csv file
   * @return - returns the headInfo usually at the index of 0 as a list of strings
   */
  public List<String> getHeaderInfo() {
    return headerInfo;
  }

  /**
   * Method that writes the filled templates into the provided output directory and fills in the template
   * that is provided.
   * @param outputDirectory the output directory of where the written filled templates should be stored
   * @param template the template that should be used to fill in with the customer data
   */
  public void writeFiles(String outputDirectory, List<String> template) {
    for (int i = 1; i < customerData.size(); i++) {
      List<String> customerInfo = this.customerData.get(i);

      if (isEmptyLine(customerInfo)) {
        continue;
      }

      String filledTemplate = fillTemplate(customerInfo, template);
      String firstName = customerInfo.get(0);
      String lastName = customerInfo.get(1);
      String fileName = "customer_" + firstName + lastName + ".txt";
      String filePath = outputDirectory + "/" + fileName;

      try (BufferedWriter createTemplate = new BufferedWriter(new FileWriter(filePath))) {
        createTemplate.write(filledTemplate);
        System.out.println("Template successfully created " + filePath);
      } catch (IOException e) {
        System.out.println("OOPS!: The given file path was not found: " + e.getMessage());
      }
    }
  }

  /**
   * Helper method to check whether a given line in a list of strings is empty or not. Line
   * is considered empty if all fields are empty strings
   * @param lineOfString the line in the list of strings to check to see if its empty
   * @return - returns boolean value. True if line is empty and false if line is not empty
   */
  private Boolean isEmptyLine(List<String> lineOfString) {
    for (String field : lineOfString) {
      if (!field.trim().isEmpty()) {
        return Boolean.FALSE;
      }
    }
    return Boolean.TRUE;
  }

  /**
   * Helper method to fill in the provided template with customer data
   * @param customerInfo - The customer data to fill the information
   * @param templateLines - The lines in the template where info needs to be filled in
   * @return - returns the filled template as a string
   */
  private String fillTemplate(List<String> customerInfo, List<String> templateLines) {
    StringBuilder filledTemplate = new StringBuilder();
    for (String line : templateLines) {
      String filledLine = replaceTemp(line, customerInfo, this.headerInfo);
      filledTemplate.append(filledLine).append("\n");
    }
    return filledTemplate.toString();
  }

  /**
   * Helper method that replaces placeholder values in the given template with the actual customer data
   * It iterates over each placeholder in the template and replaces with customer data
   * @param line - The line in the template to replace the placeholder in
   * @param customerInfo - The customer information that will be replaced with
   * @param headerInfo - The header information of which values need to be replaced with
   * @return returns the lines of strings replaced with customer data
   */
  private String replaceTemp(String line, List<String> customerInfo, List<String> headerInfo) {
    for (int i = 0; i < headerInfo.size(); i++) {
      String placeholder = headerInfo.get(i);
      line = line.replaceAll("\\[\\[" + placeholder + "]]", customerInfo.get(i));
    }
    return line;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateWriter that = (TemplateWriter) o;
    return Objects.equals(customerData, that.customerData) && Objects.equals(
        headerInfo, that.headerInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerData, headerInfo);
  }

  @Override
  public String toString() {
    return "TemplateWriter{" +
        "customerData=" + customerData +
        ", headInfo=" + headerInfo +
        '}';
  }
}