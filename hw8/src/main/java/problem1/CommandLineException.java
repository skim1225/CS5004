package problem1;
public class CommandLineException extends Exception{

  public static final String USAGE = "Usage" + "\n" + "--email Generate email messages. If this option is provided, then -- email-"
      + "template must also be provided" + "\n" + "--email-template <path/to/file> A filename for the "
      + "email template." + "\n" + "--letter Generate letters. If this option is provided, then --letter-"
      + "template must also be provided." + "\n" + "--letter-template <path/to/file> A filename for the "
      + "letter template." + "\n" + "--output-dir <path/to/folder> The folder to store all generated files."
      + "This option is required." + "\n" + "--csv-file <path/to/folder> The CSV file to process. This option"
      + "is required." + "\n\n" + "Examples:" + "\n" + "--email --email-template Path/To/email-template.txt --output-dir "
      + "Path/To/emails --csv-file customer.csv" + "\n\n" + "--letter --letter-template Path/To/letter-template.txt --output-dir "
      + "Path/To/letters --csv-file customer.csv";
  public CommandLineException(String s) {
    super(s);
  }
}