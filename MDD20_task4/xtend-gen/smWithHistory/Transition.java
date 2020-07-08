package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import smWithHistory.Vertex;

@Accessors
@SuppressWarnings("all")
public class Transition {
  private String transitionStatus;
  
  private Vertex target;
  
  private Vertex source;
  
  @Pure
  public String getTransitionStatus() {
    return this.transitionStatus;
  }
  
  public void setTransitionStatus(final String transitionStatus) {
    this.transitionStatus = transitionStatus;
  }
  
  @Pure
  public Vertex getTarget() {
    return this.target;
  }
  
  public void setTarget(final Vertex target) {
    this.target = target;
  }
  
  @Pure
  public Vertex getSource() {
    return this.source;
  }
  
  public void setSource(final Vertex source) {
    this.source = source;
  }
}
