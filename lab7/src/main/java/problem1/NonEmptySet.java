package problem1;

public class NonEmptySet<T> implements Set<T> {

  private T firstElement;
  private Set<T> rest;

  public NonEmptySet(T firstElement, Set<T> rest) {
    this.firstElement = firstElement;
    this.rest = rest;
  }

  public NonEmptySet(T firstElement) {
    this.firstElement = firstElement;
    this.rest = this.emptySet();
  }

  @Override
  public Set<T> emptySet() {
    return new EmptySet<T>();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Set<T> add(T element) {
    if (this.contains(element)) {
      return this;
    } else {
      return new NonEmptySet<T>(element, this);
    }
  }

  @Override
  public Boolean contains(T element) {
    if (this.firstElement.equals(element)) {
      return Boolean.TRUE;
    } else {
      return this.rest.contains(element);
    }
  }

  @Override
  public Set<T> remove(T element) {
    if (!contains(element)) {
      return this;
    } else if (this.firstElement.equals(element)) {
      return this.rest;
    } else {
      return new NonEmptySet<T>(this.firstElement, this.rest.remove(element));
    }
  }
}
