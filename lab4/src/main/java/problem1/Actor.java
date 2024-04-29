package problem1;

import java.util.Arrays;

public class Actor extends MultimediaArtist{

  public Actor(Name artistsName, Integer age, String[] genres, String[] awards, String[] movies,
      String[] series, String[] otherMultimedia) throws InvalidAgeException {
    super(artistsName, age, genres, awards, movies, series, otherMultimedia);
  }

  @Override
  public String toString() {
    return "Actor{" +
        "movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", otherMultimedia=" + Arrays.toString(otherMultimedia) +
        ", artistsName=" + artistsName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }
}
