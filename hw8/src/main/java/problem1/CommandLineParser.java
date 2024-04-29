package problem1;

import java.util.Arrays;
import java.util.List;


/**
 * CommandLineParser class processes and validates arguments from the command line.
 * This class also has getters to retrieve file paths for other classes to use when
 * necessary.
 */

public class CommandLineParser {
  public static final String EMAIL = "--email";
  public static final String EMAIL_TEMPLATE = "--email-template";
  public static final String LETTER = "--letter";
  public static final String LETTER_TEMPLATE = "--letter-template";
  public static final String OUTPUT = "--output-dir";
  public static final String INPUT = "--csv-file";
  private String outputPath;
  private String inputPath;
  private String emailTemplatePath;
  private String letterTemplatePath;


  /**
   * Constructor for CommandLineParser class. Instantiates file paths as empty strings
   * and will throw exceptions if output and input arguments or at least one email or
   * letter argument is given.
   * @param args
   * @throws InvalidArgumentsException
   */
  public CommandLineParser(String[] args)
      throws InvalidArgumentsException {

    this.outputPath = "";
    this.inputPath = "";
    this.emailTemplatePath = "";
    this.letterTemplatePath = "";
    if (!isValid(args)) {
      throw new InvalidArgumentsException("--output-dir and --csv-file are required options.");
    } else if (!containsCommand(args)) {
      throw new InvalidArgumentsException("Neither --email nor --letter is provided.");
    } else {
      this.processArgs(args);
    }
  }


  /**
   * Helper method that runs argument checks in the switch cases where they
   * are needed. This helper also reassigns file paths where required. Will throw
   * an error if invalid command is given.
   * @param args
   * @throws InvalidArgumentsException
   */

  private void processArgs(String[] args) throws InvalidArgumentsException {
    List<String> argsList = Arrays.asList(args);
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case EMAIL:
          if (!argsList.contains(EMAIL_TEMPLATE)) {
            throw new InvalidArgumentsException("Error: --email provided but no --email-template was given");
          }
          break;
        case EMAIL_TEMPLATE:
          if (!argsList.contains(EMAIL)) {
            throw new InvalidArgumentsException("Error: --email-template provided but no --email was given");
          } else {
            emailTemplatePath = args[i + 1];
            i++;
          }
          break;
        case LETTER:
          if (!argsList.contains(LETTER_TEMPLATE)) {
            throw new InvalidArgumentsException("Error: --letter provided but no --letter-template was given");
          }
          break;
        case LETTER_TEMPLATE:
          if (!argsList.contains(LETTER)) {
            throw new InvalidArgumentsException("Error: --letter-template provided but no --letter was given");
          } else {
            letterTemplatePath = args[i + 1];
            i++;
          }
          break;
        case OUTPUT:
          outputPath = args[i + 1];
          i++;
          break;
        case INPUT:
          inputPath = args[i + 1];
          i++;
          break;
        default:

          throw new InvalidArgumentsException("Error: This is not a valid option: " + args[i]);

      }
    }
  }


  /**
   * Helper method to determine if arguments consist of OUTPUT and INPUT
   * @param args
   * @return true if OUTPUT and INPUT are given in arguments, false if
   * even one of the two is missing
   */

  private boolean isValid(String[] args) {
    List<String> argsList = Arrays.asList(args);
    return argsList.contains(OUTPUT) && argsList.contains(INPUT);
  }


  /**
   * Helper method to determine if EMAIL or LETTER are one of the
   * given arguments
   * @param args
   * @return
   */

  private boolean containsCommand(String[] args) {
    List<String> argsList = Arrays.asList(args);
    return argsList.contains(EMAIL) || argsList.contains(LETTER);
  }


  /**
   * Getter for output file path
   * @return output file path as a String
   */

  public String getOutputPath() {
    return outputPath;
  }


  /**
   * Getter for input file path
   * @return input file path as a String
   */

  public String getInputPath() {
    return inputPath;
  }


  /**
   * Getter for email template path
   * @return email template file path as a String
   */

  public String getEmailTemplatePath() {
    return emailTemplatePath;
  }


  /**
   * Getter for letter template path
   * @return letter template file path as a String
   */

  public String getLetterTemplatePath() {
    return letterTemplatePath;
  }


  /**
   * Helper method to determine if email template path exists, used in Main
   * @return true if email template file path exists
   */

  public boolean emailTemplateExists() {
    return !this.emailTemplatePath.isEmpty();
  }


  /**
   * Helper method to determine if letter template path exists, used in Main
   * @return true if letter template file path exists
   */

  public boolean letterTemplateExists() {
    return !this.letterTemplatePath.isEmpty();
  }
}