package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediaTest {

  private Media testMedia;
  private Creator expectedCreator;
  private String expectedTitle;
  private Integer expectedYear;

  @BeforeEach
  void setUp() {
    testMedia = new Book(new Author("Sooji", "Kim"), "Book", 2024);
    expectedCreator = new Author("Sooji", "Kim");
    expectedTitle = "Book";
    expectedYear = 2024;
  }

  @Test
  void getCreator() {
    assertEquals(expectedCreator, testMedia.getCreator());
  }

  @Test
  void getTitle() {
    assertEquals(expectedTitle, testMedia.getTitle());
  }

  @Test
  void getYear() {
    assertEquals(expectedYear, testMedia.getYear());
  }
}