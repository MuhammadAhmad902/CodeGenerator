package smWithHistory;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import smWithHistory.State;
import smWithHistory.Vertex;

@Accessors
@SuppressWarnings("all")
public class ComplexState extends State {
  private Vertex[] subVertex;
  
  @Pure
  public Vertex[] getSubVertex() {
    return this.subVertex;
  }
  
  public void setSubVertex(final Vertex[] subVertex) {
    this.subVertex = subVertex;
  }
}
