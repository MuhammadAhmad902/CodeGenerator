package smWithHistory;

public class TestLightStatemachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating the states and setting their names
				Pseudostate initial = new Pseudostate();
				initial.setKind(PseudostateKind.Initial);
				
				State on = new State();
				on.setStateName("On");
				
				Action push = new Action();
				push.setActionName("push");
				
				//Creating the transitions, labelTransitions and setting their source and target. 
				LabelTransition turnOn = new LabelTransition();
				turnOn.setTransitionStatus("ON");
				turnOn.setAction(push);
				turnOn.setSource(initial);
				turnOn.setTarget(on);
				
				LabelTransition trunOFF = new LabelTransition();
				trunOFF.setTransitionStatus("OFF");
				trunOFF.setAction(push);
				trunOFF.setSource(on);
				trunOFF.setTarget(initial);
				
				
				// setting the outgoing of all States
				initial.setOutgoings(new LabelTransition[] {turnOn});
				on.setOutgoings(new LabelTransition[] {trunOFF});
								
				// setting states, actions, transition in a single statemachine
				Statemachine smWithHistory = new Statemachine();
				smWithHistory.setStates(new Vertex[] {initial,on});
				smWithHistory.setTransitions(new LabelTransition[] {turnOn,trunOFF});
				smWithHistory.setActions(new Action[] {push});
				
				//Passing the state machine to Template
				LightTemplateGenerator tmpGen = new LightTemplateGenerator();
				tmpGen.getTestMachine(smWithHistory);
				
	}

}
