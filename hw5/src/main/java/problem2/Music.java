package problem2;
/**
 * Class Music represents a piece of music which has a Creator that is either a Band or a
 * Recording Artist
 */
public class Music extends Media {

  /**
   * Constructor for creating a new Music item with the given band, title, and year.
   * @param band - The Band of the music, as a Band.
   * @param title - The title of the music, as a String.
   * @param year - The release year of the music, as an Integer
   */
  public Music(Band band, String title, Integer year) {
    super(band, title, year);
  }

  /**
   * Constructor for creating a new Music item with the given recordingArtist, title, and year.
   * @param recordingArtist - The Recording Artist of the music, as a RecordingArtist.
   * @param title - The title of the music, as a String.
   * @param year - The release year of the music, as an Integer
   */
  public Music(RecordingArtist recordingArtist, String title, Integer year) {
    super(recordingArtist, title, year);
  }
}
