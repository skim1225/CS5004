package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TemplateReaderTest {

  private String templateFilePath = "letter_template.txt";
  private String badFilePath = "not\\a\\file.txt";
  private Integer expectedNumLines = 39;

  @Test
  void readTemplate() {
    List<String> testTemplate = TemplateReader.readTemplate(templateFilePath);
    assertEquals(expectedNumLines, testTemplate.size());
  }

  @Test
  void readTemplate_FNFE() {
    Assertions.assertDoesNotThrow(() -> {
      TemplateReader.readTemplate(badFilePath);
    });
  }

  @Test
  void readTemplate_IOE() {
  // I can't test this because I can't simulate an IOE via the params for readTemplate
  }

  // todo: assertfails filenotfound
  // todo: assertfails ioe exception
}
