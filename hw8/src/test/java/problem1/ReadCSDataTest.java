package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ReadCSDataTest {

  private Integer expectedNumCustomers = 20;
  private String CSVFilePath = "members.csv";

  @Test
  void readData() {
    List<List<String>> customers = CSDataReader.readData(CSVFilePath);
    assertEquals(expectedNumCustomers, customers.size());
  }

  @Test
  void readData_FNFE() {
    assertDoesNotThrow(() -> {
      List<List<String>> customers = CSDataReader.readData("C:\\bad\\file\\path.csv");
    });
  }
}