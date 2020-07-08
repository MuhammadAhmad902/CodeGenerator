package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import smWithHistory.PseudostateKind;
import smWithHistory.Vertex;

@Accessors
@SuppressWarnings("all")
public class Pseudostate extends Vertex {
  private PseudostateKind kind;
  
  @Pure
  public PseudostateKind getKind() {
    return this.kind;
  }
  
  public void setKind(final PseudostateKind kind) {
    this.kind = kind;
  }
}
