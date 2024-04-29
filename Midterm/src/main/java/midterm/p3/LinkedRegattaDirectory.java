package midterm.p3;

public class LinkedRegattaDirectory implements RegattaDirectory{

  private RegattaNode head;
  private Integer numRegattas;

  public LinkedRegattaDirectory(RegattaNode head, Integer numRegattas) {
    this.head = head;
    this.numRegattas = numRegattas;
  }

  public LinkedRegattaDirectory() {
    this.head = null;
    this.numRegattas = 0;
  }

  /**
   * Returns whether the RegattaDirectory is empty.
   *
   * @return whether the RegattaDirectory is empty.
   */
  @Override
  public boolean isEmpty() {
    return this.numRegattas == 0;
  }

  /**
   * Returns whether a regatta with the requested name exists in the RegattaDirectory.
   *
   * @param regattaName - The name of the regatta to be checked, as a String.
   * @return whether a regatta with the requested name exists in the RegattaDirectory.
   */
  @Override
  public boolean check(String regattaName) {
    RegattaNode curr = this.head;
    for (int i = 0; i < this.numRegattas - 1; i++) {
      if (curr.getRegatta().getRegattaName().equals(regattaName)) {
        return Boolean.TRUE;
      } else {
        curr = curr.getNext();
      }
    }
    return curr.getRegatta().getRegattaName().equals(regattaName);
  }

  /**
   * Removes a specified regatta from the RegattaDirectory.
   *
   * @param regattaToRemove - The regatta to be removed, as a Regatta.
   * @return a new RegattaDirectory with the specified regatta removed.
   * @throws RegattaNotFoundException if the given regatta does not exist in the regatta directory.
   */
  @Override
  public RegattaDirectory remove(Regatta regattaToRemove) throws RegattaNotFoundException {
    if (!this.check(regattaToRemove.getRegattaName())) {
      throw new RegattaNotFoundException("The regatta to remove does not exist in the regatta directory.");
    }
    if (this.head.getRegatta().equals(regattaToRemove)) {
      return new LinkedRegattaDirectory(this.head.getNext(), this.numRegattas - 1);
    } else {
      RegattaNode curr = this.head;
      while (curr.getNext() != null) {
        RegattaNode nextNode = curr.getNext();
        if (nextNode.getRegatta().equals(regattaToRemove)) {
          curr.setNext(nextNode.getNext());
          break;
        }
        curr = curr.getNext();
      }
      return new LinkedRegattaDirectory(this.head, this.numRegattas - 1);
    }
  }
}
