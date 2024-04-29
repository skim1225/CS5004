package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {
  private String expectedOutput;
  private String expectedInput;
  private String expectedEmailTemplatePath;
  private String expectedLetterTemplatePath;

  @BeforeEach
  void setUp() {
    expectedInput = "insurance-company-members.csv";
    expectedOutput = "output";
    expectedEmailTemplatePath = "email_template.txt";
    expectedLetterTemplatePath = "letter_template.txt";
  }

  @Test
  public void successfulParseEmail() {
    String[] testArgs = {"--email", "--email-template", "email_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    Assertions.assertDoesNotThrow(() -> new CommandLineParser(testArgs));
  }

  @Test
  public void successfulParseLetter() {
    String[] testArgs = {"--letter", "--letter-template", "letter.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    Assertions.assertDoesNotThrow(() -> new CommandLineParser(testArgs));
  }

  @Test
  public void successfulParseBoth() {
    String[] testArgs = {"--email", "--email-template", "email_template.txt", "--letter", "--letter-template",
        "letter.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    Assertions.assertDoesNotThrow(() -> new CommandLineParser(testArgs));
  }

  @Test
  public void successfulParseOutOfOrder() {
    String[] testArgs = {"--output-dir", "output", "--letter-template", "letter.txt", "--letter", "--csv-file",
        "insurance-company-members.csv"};
    Assertions.assertDoesNotThrow(() -> new CommandLineParser(testArgs));
  }

  @Test
  public void unsuccessfulParse() {
    String[] unsuccessfulArgs = {"--email", "--email-template", "email_template.txt", "--csv-file",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(unsuccessfulArgs));
  }

  @Test
  public void unsuccessfulParseMissingOutputAndInput() {
    String[] unsuccessfulArgs = {"--email", "--email-template", "email_template.txt"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(unsuccessfulArgs));
  }

  @Test
  public void missingEmailandLetter() {
    String[] missingEmailAndLetterArg = {"--email-template", "email_template.txt", "--letter-template",
        "letter-template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(missingEmailAndLetterArg));
  }

  @Test
  public void missingEmail() {
    String[] missingEmailArg = {"--email-template", "email_template.txt", "--letter", "--letter-template",
        "letter-template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(missingEmailArg));
  }

  @Test
  public void missingEmailTemplate() {
    String[] missingEmailTemplateArg = {"--email", "email_template.txt", "--letter", "--letter-template",
        "letter-template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(missingEmailTemplateArg));
  }

  @Test
  public void missingLetterParse() {
    String[] missingLetterArg = {"--letter-template", "letter_template.txt", "--email",
        "--email-template", "email_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(missingLetterArg));
  }

  @Test
  public void missingLetterTemplateParse() {
    String[] missingLetterTemplateArgs = {"--letter", "letter_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(missingLetterTemplateArgs));
  }

  @Test
  public void missingOutputParse() {
    String[] missingOutputArgs = {"--email", "--email-template", "email_template.txt", "output", "--csv-file",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(missingOutputArgs));
  }

  @Test
  public void missingInputParse() {
    String[] missingInputArgs = {"--email", "--email-template", "email_template.txt", "--output-dir", "output",
        "insurance-company-members.csv"};
    assertThrows(InvalidArgumentsException.class,
        () -> new CommandLineParser(missingInputArgs));
  }

  @Test
  void getOutputPath() throws InvalidArgumentsException {
    String[] testArgs = {"--email", "--email-template", "email_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    CommandLineParser testParser = new CommandLineParser(testArgs);
    assertEquals(testParser.getOutputPath(), expectedOutput);
  }

  @Test
  void getInputPath() throws InvalidArgumentsException {
    String[] testArgs = {"--email", "--email-template", "email_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    CommandLineParser testParser = new CommandLineParser(testArgs);
    assertEquals(testParser.getInputPath(), expectedInput);
  }

  @Test
  void getEmailTemplatePath() throws InvalidArgumentsException {
    String[] testArgs = {"--email", "--email-template", "email_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    CommandLineParser testParser = new CommandLineParser(testArgs);
    assertEquals(testParser.getEmailTemplatePath(), expectedEmailTemplatePath);
  }

  @Test
  void getLetterTemplatePath() throws InvalidArgumentsException {
    String[] testArgs = {"--letter", "--letter-template", "letter_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    CommandLineParser testParser = new CommandLineParser(testArgs);
    assertEquals(testParser.getLetterTemplatePath(), expectedLetterTemplatePath);
  }

  @Test
  void emailTemplateExists() throws InvalidArgumentsException {
    String[] emailArgs = {"--email", "--email-template", "email_template.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    CommandLineParser testParser = new CommandLineParser(emailArgs);
    assertTrue(testParser.emailTemplateExists());
  }

  @Test
  void letterTemplateExists() throws InvalidArgumentsException {
    String[] letterArgs = {"--letter", "--letter-template", "letter.txt", "--output-dir", "output", "--csv-file",
        "insurance-company-members.csv"};
    CommandLineParser testParser = new CommandLineParser(letterArgs);
    assertTrue(testParser.letterTemplateExists());
  }

}