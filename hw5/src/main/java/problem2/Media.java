package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Abstract class Media represents an item in a library's collection as its creator, title, and year
 * it was published.
 */

public abstract class Media {

  private Creator creator;
  private String title;
  private Integer year;

  /**
   * Constructor for creating a new Media object with the given params.
   * @param creator - The Creator of the Media, as an Author, Individual, or Band.
   * @param title - The title of the Media, as a String.
   * @param year - The year the Media was published, as an Integer.
   */
  public Media(Creator creator, String title, Integer year) {
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  /**
   * Returns the Creator of the Media.
   * @return the Creator of the Media.
   */
  public Creator getCreator() {
    return creator;
  }

  /**
   * Returns the title of the Media.
   * @return the title of the Media.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the publishing year of the Media.
   * @return the publishing year of the Media.
   */
  public Integer getYear() {
    return year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Media media = (Media) o;
    return Objects.equals(creator, media.creator) && Objects.equals(title,
        media.title) && Objects.equals(year, media.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creator, title, year);
  }

  @Override
  public String toString() {
    return "Media{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", year=" + year +
        '}';
  }
}
