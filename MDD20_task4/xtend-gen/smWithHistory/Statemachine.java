package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import smWithHistory.Action;
import smWithHistory.Transition;
import smWithHistory.Vertex;

@Accessors
@SuppressWarnings("all")
public class Statemachine {
  private String statemachineName;
  
  private Vertex[] states;
  
  private Transition[] transitions;
  
  private Action[] actions;
  
  @Pure
  public String getStatemachineName() {
    return this.statemachineName;
  }
  
  public void setStatemachineName(final String statemachineName) {
    this.statemachineName = statemachineName;
  }
  
  @Pure
  public Vertex[] getStates() {
    return this.states;
  }
  
  public void setStates(final Vertex[] states) {
    this.states = states;
  }
  
  @Pure
  public Transition[] getTransitions() {
    return this.transitions;
  }
  
  public void setTransitions(final Transition[] transitions) {
    this.transitions = transitions;
  }
  
  @Pure
  public Action[] getActions() {
    return this.actions;
  }
  
  public void setActions(final Action[] actions) {
    this.actions = actions;
  }
}
