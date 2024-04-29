package midterm.p3;

import java.util.Objects;

public class RegattaNode {

  private Regatta regatta;
  private RegattaNode next;

  public RegattaNode(Regatta regatta, RegattaNode next) {
    this.regatta = regatta;
    this.next = next;
  }

  public Regatta getRegatta() {
    return regatta;
  }

  public RegattaNode getNext() {
    return next;
  }

  public void setNext(RegattaNode next) {
    this.next = next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegattaNode that = (RegattaNode) o;
    return Objects.equals(regatta, that.regatta) && Objects.equals(next,
        that.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regatta, next);
  }
}
