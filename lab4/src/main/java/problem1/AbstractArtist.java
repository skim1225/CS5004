package problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 */
public abstract class AbstractArtist implements Artist {

  private static final Integer MIN_AGE = 0;
  private static final Integer MAX_AGE = 128;
  protected Name artistsName;
  protected Integer age;
  protected String[] genres;
  protected String[] awards;

  public AbstractArtist(Name artistsName, Integer age, String[] genres, String[] awards)
      throws InvalidAgeException {
    if (!validateAge(age))
      throw new InvalidAgeException("The given age is invalid");
    this.artistsName = artistsName;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }

  private Boolean validateAge(Integer age) {
    return age >= MIN_AGE && age <= MAX_AGE;
  }

  public void receiveAward(String award) {
    String[] newAwards = new String[this.awards.length + 1];
    for(int i = 0; i < this.awards.length; i++) {
      newAwards[i] = this.awards[i];
    }
    newAwards[this.awards.length] = award;
    this.awards = newAwards;
  }

  public Name getArtistsName() {
    return artistsName;
  }

  public Integer getAge() {
    return age;
  }

  public String[] getGenres() {
    return genres;
  }

  public String[] getAwards() {
    return awards;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractArtist that = (AbstractArtist) o;
    return Objects.equals(artistsName, that.artistsName) && Objects.equals(age,
        that.age) && Arrays.equals(genres, that.genres) && Arrays.equals(awards,
        that.awards);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(artistsName, age);
    result = 31 * result + Arrays.hashCode(genres);
    result = 31 * result + Arrays.hashCode(awards);
    return result;
  }
}
