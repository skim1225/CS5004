package problem1;

import java.util.Arrays;

public class Painter extends GraphicArtist{

  public Painter(Name artistsName, Integer age, String[] genres, String[] awards, String[] exhibits)
      throws InvalidAgeException {
    super(artistsName, age, genres, awards, exhibits);
  }

  @Override
  public String toString() {
    return "Painter{" +
        "exhibits=" + Arrays.toString(exhibits) +
        ", artistsName=" + artistsName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }
}
