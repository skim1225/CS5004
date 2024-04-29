import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommercialTest {
  private Commercial testCommercial;
  private Integer expectedNumOffices;
  private Boolean expectedRetailSuitable;

  @BeforeEach
  void setUp() throws InvalidArgumentException {
    testCommercial = new Commercial("225 Terry Ave N, Seattle, WA 98109", 40000, 15, Boolean.FALSE);
    expectedNumOffices = 15;
    expectedRetailSuitable = Boolean.FALSE;
  }

  @Test
  void testConstructor_InvalidNumOffices() {
    Assertions.assertThrows(InvalidArgumentException.class, () -> {
      Commercial o = new Commercial("225 Terry Ave N, Seattle, WA 98109", 40000, -15, Boolean.FALSE);
    });
  }

  @Test
  void getNumOffices() {
    assertEquals(expectedNumOffices, testCommercial.getNumOffices());
  }

  @Test
  void getRetailSuitable() {
    assertEquals(expectedRetailSuitable, testCommercial.getRetailSuitable());
  }
}