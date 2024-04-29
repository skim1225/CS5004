package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Poet extends AbstractArtist{
protected String publishingCompany;
protected String lastPublishedCollection;

  public Poet(Name artistsName, Integer age, String[] genres, String[] awards,
      String publishingCompany, String lastPublishedCollection) throws InvalidAgeException {
    super(artistsName, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Poet poet = (Poet) o;
    return Objects.equals(publishingCompany, poet.publishingCompany)
        && Objects.equals(lastPublishedCollection, poet.lastPublishedCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
  }

  @Override
  public String toString() {
    return "Poet{" +
        "publishingCompany='" + publishingCompany + '\'' +
        ", lastPublishedCollection='" + lastPublishedCollection + '\'' +
        ", artistsName=" + artistsName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }
}
