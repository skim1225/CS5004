package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BandTest {

  private Band testBand;
  private String expectedBandName;
  private ArrayList<RecordingArtist> expectedBandMembers;

  @BeforeEach
  void setUp() {
    ArrayList<RecordingArtist> artists = new ArrayList<>();
    artists.add(new RecordingArtist("Nymphia", "Wind"));
    testBand = new Band("Bananas", artists);
    expectedBandMembers = new ArrayList<>();
    expectedBandMembers.add(new RecordingArtist("Nymphia", "Wind"));
    expectedBandName = "Bananas";
  }

  @Test
  void getBandName() {
    assertEquals(expectedBandName, testBand.getBandName());
  }

  @Test
  void getBandMembers() {
    assertEquals(expectedBandMembers, testBand.getBandMembers());
  }
}