package problem1;

public class EmptySet<T> implements Set<T> {

  public EmptySet() {

  }

  @Override
  public Set<T> emptySet() {
    return new EmptySet<T>();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public Set<T> add(T element) {
    return new NonEmptySet(element);
  }

  @Override
  public Boolean contains(T element) {
    return Boolean.FALSE;
  }

  @Override
  public Set<T> remove(T element) {
    return this;
  }
}
