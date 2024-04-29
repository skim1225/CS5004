package problem1;

public class LinkedMarineMammalDirectory implements MarineMammalDirectory{

  private MarineMammalNode headNode;
  private Integer numMarineMammals;

  public LinkedMarineMammalDirectory(MarineMammalNode headNode, Integer numMarineMammals) {
    this.headNode = headNode;
    this.numMarineMammals = numMarineMammals;
  }

  public LinkedMarineMammalDirectory() {
    this.headNode = null;
    this.numMarineMammals = 0;
  }

  @Override
  public MarineMammalDirectory createEmpty() {
    return new LinkedMarineMammalDirectory();
  }

  @Override
  public MarineMammalDirectory add(MarineMammal marineMammal) {
    if (this.contains(marineMammal)) {
      return this;
    } else {
      MarineMammalNode newMammalNode = new MarineMammalNode(marineMammal, this.headNode);
      return new LinkedMarineMammalDirectory(newMammalNode, this.numMarineMammals + 1);
    }
  }

  @Override
  public Boolean isEmpty() {
    return this.numMarineMammals == 0;
  }

  @Override
  public Integer size() {
    return this.numMarineMammals;
  }

  @Override
  public Boolean contains(MarineMammal marineMammal) {
    MarineMammalNode curr = this.headNode;
    for (int i = 0; i < this.numMarineMammals - 1; i++) {
      if (curr.getMarineMammal().equals(marineMammal)) {
        return true;
      } else {
        curr = curr.getNextNode();
      }
    }
    return curr.getMarineMammal(). equals(marineMammal);
  }

  @Override
  public MarineMammalDirectory remove(MarineMammal marineMammal) {
    if (!this.contains(marineMammal)) {
      return this;
    }
    if (this.headNode.getMarineMammal().equals(marineMammal)) {
      return new LinkedMarineMammalDirectory(this.headNode.getNextNode(), this.numMarineMammals - 1);
    } else {
      MarineMammalNode curr = this.headNode;
      while (curr.getNextNode() != null) {
        MarineMammalNode nodeToRemove = curr.getNextNode();
        if (nodeToRemove.getMarineMammal().equals(marineMammal)) {
          curr.setNextNode(nodeToRemove.getNextNode());
          break;
        }
        curr = curr.getNextNode();
      }
    }
    return new LinkedMarineMammalDirectory(this.headNode, this.numMarineMammals - 1);
  }

  @Override
  public MarineMammal getSomeMammal() {
    return null;
  }
}
