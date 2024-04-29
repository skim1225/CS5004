package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class Band represents a Band as its band name and band members.
 */

public class Band extends Group {
  private String bandName;
  private ArrayList<RecordingArtist> bandMembers;

  /**
   * Constructor to create a new Band object with the given name and band members
   * @param bandName - The name of the band, as a String
   * @param bandMembers - The band members, as an ArrayList
   */
  public Band(String bandName, ArrayList<RecordingArtist> bandMembers) {
    this.bandName = bandName;
    this.bandMembers = bandMembers;
  }

  /**
   * Returns the band name
   * @return the band name
   */
  public String getBandName() {
    return bandName;
  }

  /**
   * Returns the band members
   * @return the band members
   */
  public ArrayList<RecordingArtist> getBandMembers() {
    return bandMembers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(bandName, band.bandName) && Objects.equals(bandMembers,
        band.bandMembers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bandName, bandMembers);
  }
}
