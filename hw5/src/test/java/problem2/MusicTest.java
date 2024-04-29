package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicTest {

  private Music testMusic;

  @Test
  void BandConstructor() {
    ArrayList<RecordingArtist> artists = new ArrayList<>();
    artists.add(new RecordingArtist("Nymphia", "Wind"));
    testMusic = new Music(new Band("The Bananas", artists), "Banana", 2024);
    assertEquals(new Band("The Bananas", artists), testMusic.getCreator());
  }

  @Test
  void RecordingArtistConstructor() {
    testMusic = new Music(new RecordingArtist("Sooji", "Kim"), "Music", 2024);
    assertEquals(new RecordingArtist("Sooji", "Kim"), testMusic.getCreator());
  }
}