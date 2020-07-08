package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Action {
  private String actionName;
  
  @Pure
  public String getActionName() {
    return this.actionName;
  }
  
  public void setActionName(final String actionName) {
    this.actionName = actionName;
  }
}
