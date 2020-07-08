package smWithHistory

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Statemachine {
	String statemachineName;
	Vertex[] states;
	Transition[] transitions;
	Action[] actions; 
}