package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {

  private Catalog testCatalog;

  @BeforeEach
  void setUp() {
    testCatalog = new Catalog();
    Book testBook1 = new Book(new Author("Sooji", "Kim"), "A", 2024);
    Book testBook2 = new Book(new Author("s", "a"), "B", 2024);
    ArrayList<RecordingArtist> artists = new ArrayList<>();
    artists.add(new RecordingArtist("Nymphia", "Wind"));
    artists.add(new RecordingArtist("Sooji", "Kim"));
    Band testBand = new Band("BLAH", artists);
    Music testMusic1 = new Music(testBand, "B", 2024);
    Music testMusic2 = new Music(new RecordingArtist("Sooji", "Kim"), "A", 2024);
    testCatalog.add(testBook1);
    testCatalog.add(testBook2);
    testCatalog.add(testMusic1);
    testCatalog.add(testMusic2);
  }

  @Test
  void add() {
    assertTrue(4 == testCatalog.getCollection().size());
  }

  @Test
  void remove() {
    testCatalog.remove(new Book(new Author("Sooji", "Kim"), "A", 2024));
    assertTrue(3 == testCatalog.getCollection().size());
  }

  @Test
  void TitleSearch() {
    ArrayList<Media> results = testCatalog.search("A");
    assertTrue(2 == results.size());
  }

  @Test
  void AuthorSearch() {
    ArrayList<Book> results = testCatalog.search(new Author("Sooji", "Kim"));
    assertTrue(1 == results.size());
  }

  @Test
  void ArtistSearch() {
    ArrayList<Music> results = testCatalog.search(new RecordingArtist("Sooji", "Kim"));
    assertTrue(2 == results.size());
  }
}