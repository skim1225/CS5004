package problem1;

import java.util.Arrays;

public class MultimediaArtist extends AbstractArtist {
  protected String[] movies;
  protected String[] series;
  protected String[] otherMultimedia;

  public MultimediaArtist(Name artistsName, Integer age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] otherMultimedia) throws InvalidAgeException {
    super(artistsName, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  public String[] getMovies() {
    return movies;
  }

  public String[] getSeries() {
    return series;
  }

  public String[] getOtherMultimedia() {
    return otherMultimedia;
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
    MultimediaArtist that = (MultimediaArtist) o;
    return Arrays.equals(movies, that.movies) && Arrays.equals(series,
        that.series) && Arrays.equals(otherMultimedia, that.otherMultimedia);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(movies);
    result = 31 * result + Arrays.hashCode(series);
    result = 31 * result + Arrays.hashCode(otherMultimedia);
    return result;
  }
}
