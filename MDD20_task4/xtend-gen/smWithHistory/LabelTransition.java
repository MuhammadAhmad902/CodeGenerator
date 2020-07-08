package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import smWithHistory.Action;
import smWithHistory.Transition;

@Accessors
@SuppressWarnings("all")
public class LabelTransition extends Transition {
  private Action action;
  
  @Pure
  public Action getAction() {
    return this.action;
  }
  
  public void setAction(final Action action) {
    this.action = action;
  }
}
