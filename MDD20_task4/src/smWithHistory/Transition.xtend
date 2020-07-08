package smWithHistory

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Transition {
	String transitionStatus;
	Vertex target;
	Vertex source;
}