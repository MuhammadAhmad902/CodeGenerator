package smWithHistory

import java.io.File
import java.io.BufferedWriter
import java.io.FileWriter

class TemplateGenerator {
	//defining the constants for whole class
	val pkg = "package statemachine;" ;
	val path = "src/statemachine"
	//Creating Directory
	var file = new File(path).mkdir();
	/* Getting the whole  test state machine in single object.
	*  Iterating over the array of the states and pass that state to machineContext, superStateClass and getSingleState methods.	
	*/
	def getTestMachine(Statemachine sm) {
		var Vertex singleState;
		for (st : sm.states) {
			if((st instanceof Pseudostate) && ((st as Pseudostate).kind == PseudostateKind::Final)){
				println("Do nothing!!")
			}else{
				singleState = st;
				getSingleState(st);	
			}
		}
		machineContext(singleState);
		superStateClass(singleState);	
	}
	/* Getting the single state.
	*  This method will iterate over the outgoings of the state pass the content to filewriter method.
	*  for creating .java class for each state.
	*/
	def getSingleState(Vertex vertex) {
		for (tr : vertex.outgoings) {
			var data = '''
			«pkg»
			
			public class «IF (tr.source instanceof Pseudostate) && ((tr.source as Pseudostate).kind == PseudostateKind::Initial)»Off«ELSEIF tr.source instanceof State»«(tr.source as State).stateName»«ENDIF» extends State {
				public void «IF tr instanceof LabelTransition»«((tr as LabelTransition).action).actionName»«ELSE»goNext«ENDIF»(MachineContext ctx){
					ctx.setState(«IF tr.target instanceof Pseudostate»new Off()«ELSEIF tr.target instanceof State»new «(tr.target as State).stateName»()«ENDIF»);
					System.out.println("«tr.transitionStatus»");
				}
			}
		'''
		var filename = "";
		if(tr.source instanceof Pseudostate){
			filename = "Off"
		}
		else{
			filename = (tr.source as State).stateName
		}
		filewriter(filename, data)
		}
	}
	/* Getting the single state.
	*  create abstract class state whom its child classes will extend it.
	*  Define abstract methods which will be implemented by its child classes.
	*  Pass the data variable and its name to filewriter method to create java class for it. 
	*/
	def superStateClass(Vertex vertex){
		var Action getActractAction;
		for (tr : vertex.outgoings) {
			if((tr instanceof LabelTransition)){
				getActractAction = tr.action
			}
		}
		var data = '''
		«pkg»
		
		public abstract class State{
			
			public abstract void «IF getActractAction !== null»«getActractAction.actionName»«ELSE»goNext«ENDIF»(MachineContext ctx);
			
		}
		'''
		filewriter("State", data);
	}
	/* Getting the single state.
	*  Define the Context for the state design pattern.
	*  Define abstract methods which will be implemented by its child class.
	*  Pass the data variable and its name to filewriter method to create java class for it. 
	*/
	def machineContext(Vertex vertex){
		var Action getActractAction;
		for (tr : vertex.outgoings) {
			if((tr instanceof LabelTransition)){
				getActractAction = tr.action
			}
		}
		var data  = '''
		«pkg»
		
		public class MachineContext {
			private State current;
			
			public MachineContext() {
				current = new Off();
			}
			
			public void setState(State state) {
				current = state;
			}
			
			public State getState() {
				return this.current;
			}
			
			public void run() {
				current.«IF getActractAction !== null»
							«getActractAction.actionName»
							«ELSE»goNext«ENDIF»(this);
			}
		}
		
		'''
		filewriter("MachineContext", data)
	}
	/* Getting the file name and data.
	*  file Writing for java classes  
	*/
	def filewriter(String fileName, String data){
		var bw = new BufferedWriter(new FileWriter(new File(path,fileName.concat(".java"))));
		bw.write(data);
		bw.close();
	}
	
}