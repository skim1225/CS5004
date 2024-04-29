package problem1;

import java.util.Arrays;

public class Photographer extends GraphicArtist{

  public Photographer(Name artistsName, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws InvalidAgeException {
    super(artistsName, age, genres, awards, exhibits);
  }

  @Override
  public String toString() {
    return "Photographer{" +
        "exhibits=" + Arrays.toString(exhibits) +
        ", artistsName=" + artistsName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }
}
