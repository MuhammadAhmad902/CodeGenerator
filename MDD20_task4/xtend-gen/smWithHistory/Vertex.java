package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import smWithHistory.Transition;

@Accessors
@SuppressWarnings("all")
public abstract class Vertex {
  private Transition[] outgoings;
  
  @Pure
  public Transition[] getOutgoings() {
    return this.outgoings;
  }
  
  public void setOutgoings(final Transition[] outgoings) {
    this.outgoings = outgoings;
  }
}
