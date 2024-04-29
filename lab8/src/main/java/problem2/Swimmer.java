package problem2;
import java.util.List;
import java.util.Objects;

/*Class Swimmer contains information about a swimmer, and the list of their swimming times, when
swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke, and freestyle.
*/
public class Swimmer implements Comparable<Swimmer> {
  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;
  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
      List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breaststroke50mTimes = breaststroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }
  public String getName() {
    return name;
  }
  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }
  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }
  public List<Double> getBreaststroke50mTimes() {
    return breaststroke50mTimes;
  }
  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }
  @Override
  public int compareTo(Swimmer otherSwimmer) {
    double val = this.computeAvgSwimTime(getFreestyle50mTimes()) - otherSwimmer.computeAvgSwimTime(otherSwimmer.getFreestyle50mTimes());
    if (val == 0) {
      return 0;
    } else if (val < 0) {
      return -1;
    } else {
      return 1;
    }
  }

  private Double computeAvgSwimTime(List<Double> swimTimes) {
    Double runningAvg = 0.0;
    for (Double swimTime:swimTimes) {
      runningAvg += swimTime;
    }
    return runningAvg / swimTimes.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Swimmer swimmer = (Swimmer) o;
    return Objects.equals(computeAvgSwimTime(getFreestyle50mTimes()), swimmer.computeAvgSwimTime(getFreestyle50mTimes()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(computeAvgSwimTime(getFreestyle50mTimes()));
  }
}