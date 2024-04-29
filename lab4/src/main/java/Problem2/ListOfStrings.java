package Problem2;

public interface ListOfStrings {
  Boolean isEmpty();
  Integer size();
  Boolean contains(String elem);
  Boolean containsAll(ListOfStrings sublist);
  ListOfStrings filterLargerThan(Integer cutoffSize);
  Boolean hasDuplicates();
  ListOfStrings removeDuplicates();
}
