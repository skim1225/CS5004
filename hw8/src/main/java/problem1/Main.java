package problem1;

import java.util.List;
public class Main {
  public static void main(String [] args) {
    try {
      String[] testArgs = {"--output-dir",
         "C:\\Users\\kimso\\OneDrive\\Documents\\NEU\\24Sp 5004\\Team_repo_Brian_Hyun_Oh_Sooji\\Group Assignments\\hw8\\output\\",
      "--csv-file", "C:\\Users\\kimso\\OneDrive\\Documents\\NEU\\24Sp 5004\\Team_repo_Brian_Hyun_Oh_Sooji\\Group Assignments\\hw8\\insurance-company-members.csv",
          "--letter", "--letter-template",
          "C:\\Users\\kimso\\OneDrive\\Documents\\NEU\\24Sp 5004\\Team_repo_Brian_Hyun_Oh_Sooji\\Group Assignments\\hw8\\letter_template.txt"};

      // PARSE CLI ARGS AND GET FILE PATHS
      CommandLineParser parser = new CommandLineParser(testArgs);
      String CSVFilePath = parser.getInputPath();
      String outputPath = parser.getOutputPath();
      String emailTemplatePath = parser.getEmailTemplatePath();
      String letterTemplatePath = parser.getLetterTemplatePath();

      // READ, PROCESS, AND WRITE FILES
      List<List<String>> customers = CSDataReader.readData(CSVFilePath);
      TemplateWriter writer = new TemplateWriter(customers);
      if (parser.emailTemplateExists()) {
        List<String> emailTemplate = TemplateReader.readTemplate(emailTemplatePath);
        writer.writeFiles(outputPath + "\\email", emailTemplate);
      }
      if (parser.letterTemplateExists()) {
        List<String> letterTemplate = TemplateReader.readTemplate(letterTemplatePath);
        writer.writeFiles(outputPath + "\\letter", letterTemplate);
      }
    } catch (InvalidArgumentsException e) {
      System.out.println(e.getMessage());
      System.out.println(CommandLineException.USAGE);
    }
  }
}