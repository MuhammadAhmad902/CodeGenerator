package smWithHistory

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
abstract class Vertex {
	Transition[] outgoings;
}