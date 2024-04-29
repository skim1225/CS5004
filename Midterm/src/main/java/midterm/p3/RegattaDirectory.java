package midterm.p3;

public interface RegattaDirectory {

  /**
   * Returns whether the RegattaDirectory is empty.
   * @return whether the RegattaDirectory is empty.
   */
  boolean isEmpty();

  /**
   * Returns whether a regatta with the requested name exists in the RegattaDirectory.
   * @param regattaName - The name of the regatta to be checked, as a String.
   * @return whether a regatta with the requested name exists in the RegattaDirectory.
   */
  boolean check(String regattaName);

  /**
   * Removes a specified regatta from the RegattaDirectory.
   * @param regattaToRemove - The regatta to be removed, as a Regatta.
   * @return a new RegattaDirectory with the specified regatta removed.
   * @throws RegattaNotFoundException if the given regatta does not exist in the regatta directory.
   */
  RegattaDirectory remove(Regatta regattaToRemove) throws RegattaNotFoundException;

}
