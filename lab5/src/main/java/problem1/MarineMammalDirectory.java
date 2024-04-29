package problem1;

public interface MarineMammalDirectory {

  MarineMammalDirectory createEmpty();
  MarineMammalDirectory add(MarineMammal marineMammal);
  Boolean isEmpty();
  Integer size();
  Boolean contains(MarineMammal mammal);
  MarineMammalDirectory remove(MarineMammal marineMammal);
  MarineMammal getSomeMammal();

}
