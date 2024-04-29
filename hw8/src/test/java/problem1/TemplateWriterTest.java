package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateWriterTest {
  private TemplateWriter testWriter;
  private List<List<String>> testCustomerData;

  private String testTemplate;

  @BeforeEach
  void setUp() {
    testCustomerData = Arrays.asList(
        Arrays.asList("first_name", "last_name", "company_name", "address"),
        Arrays.asList("Mikal","Bridges","Brooklyn Nets", "123 Ave 456th St"),
        Arrays.asList("", "", "", ""),
        Arrays.asList("Luka", "Doncic", "Dallas Mavericks", "987 Ave 876th St"));

    testWriter = new TemplateWriter(testCustomerData);

  }

  @Test
  void getCustomerData() {
    assertEquals(testCustomerData, testWriter.getCustomerData());
  }

  @Test
  void getHeadInfo() {
    List<String> expectedHeader = testCustomerData.get(0);
    assertEquals(expectedHeader, testWriter.getHeaderInfo());
  }

  @Test
  void writeFiles() throws IOException {
    String testOutputDirectory = "testoutput";
    testTemplate = "test.txt";
    List<String> expectedTemplate = TemplateReader.readTemplate(testTemplate);
    testWriter.writeFiles(testOutputDirectory, expectedTemplate);
    List<String> expectedOutput = Arrays.asList(
        "My favorite basketball player is Mikal Bridges, he plays for Brooklyn Nets.",
        "The arena is located in 123 Ave 456th St.");
    List<String> actualTemplate = TemplateReader.readTemplate(testOutputDirectory + "/customer_MikalBridges.txt");
    assertEquals(expectedOutput, actualTemplate);

  }

  @Test
  void writeFilesWrongOutput() throws IOException {
    testTemplate = "output";
    List<String> expectedTemplate = TemplateReader.readTemplate(testTemplate);

    Assertions.assertDoesNotThrow(() -> {
      testWriter.writeFiles("/path/that/does/not/exist", expectedTemplate);
    });
  }

  @Test
  void testEqualsSameValues() {
    assertTrue(testWriter.equals(testWriter));

  }

  @Test
  void testEqualsNullObject() {
    assertFalse(testWriter.equals(null));

  }

  @Test
  void testEqualsDifferentType() {
    assertFalse(testWriter.equals("testWriter"));

  }

  @Test
  void testEqualsDifferentObjectDifferentCustomerData() {
    List<List<String>> emptyCustomer = Arrays.asList(
        Arrays.asList("","","",""),
        Arrays.asList("","","",""));
    TemplateWriter otherWriter = new TemplateWriter(emptyCustomer);
    assertFalse(testWriter.equals(otherWriter));

  }

  @Test
  void testEqualsDifferentObjectSameValue() {
    List<List<String>> otherCustomer = Arrays.asList(
        Arrays.asList("first_name", "last_name", "company_name", "address"),
        Arrays.asList("Mikal","Bridges","Brooklyn Nets", "123 Ave 456th St"),
        Arrays.asList("", "", "", ""),
        Arrays.asList("Luka", "Doncic", "Dallas Maverick", "987 Ave 876th St"));
    TemplateWriter otherWriter = new TemplateWriter(otherCustomer);
    assertTrue(testWriter.equals(otherWriter));

  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testWriter.getCustomerData(), testWriter.getHeaderInfo());
    assertEquals(expectedHash, testWriter.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "TemplateWriter{" +
        "customerData=" + testWriter.getCustomerData() +
        ", headInfo=" + testWriter.getHeaderInfo() +
        '}';
    assertEquals(expectedString, testWriter.toString());
  }
}