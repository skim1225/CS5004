package problem1;

import java.util.Arrays;

public abstract class GraphicArtist extends AbstractArtist {
  protected String[] exhibits;

  public GraphicArtist(Name artistsName, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws InvalidAgeException {
    super(artistsName, age, genres, awards);
    this.exhibits = exhibits;
  }

  public String[] getExhibits() {
    return exhibits;
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
    GraphicArtist that = (GraphicArtist) o;
    return Arrays.equals(exhibits, that.exhibits);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(exhibits);
    return result;
  }
}
