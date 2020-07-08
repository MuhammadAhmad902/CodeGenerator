package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import smWithHistory.Vertex;

@Accessors
@SuppressWarnings("all")
public class State extends Vertex {
  private String stateName;
  
  @Pure
  public String getStateName() {
    return this.stateName;
  }
  
  public void setStateName(final String stateName) {
    this.stateName = stateName;
  }
}
