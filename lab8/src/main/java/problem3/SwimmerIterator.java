package problem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class SwimmerIterator implements Iterator {

  private static final Double QUAL_TIME = 26.17;
  private static final Integer MIN_BUTTERFLY_TIMES = 5;

  private List<Swimmer> swimmers;

  public SwimmerIterator(List<Swimmer> swimmers) {
    this.swimmers = this.filterSwimmers(swimmers);
  }

  private List<Swimmer> filterSwimmers(List<Swimmer> swimmers) {
    List<Swimmer> filteredSwimmers = new ArrayList<>();
    for (Swimmer swimmer : swimmers) {
      if (hasQualified(swimmer)) {
        filteredSwimmers.add(swimmer);
      }
    }
    return filteredSwimmers;
  }

  private boolean hasQualified(Swimmer swimmer) {
    return (swimmer.getButterfly50mTimes().size() >= MIN_BUTTERFLY_TIMES) &&
        this.isFreestyleQualified(swimmer);
  }

  private boolean isFreestyleQualified(Swimmer swimmer) {
    for (Double freeStyleTime : swimmer.getFreestyle50mTimes()) {
      if (freeStyleTime <= QUAL_TIME) {
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return !this.swimmers.isEmpty();
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Object next() {
    return this.swimmers.remove(0);
  }
}
