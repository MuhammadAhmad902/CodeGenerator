package smWithHistory;

public class TestFanStatemachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating the states and setting their names
		Pseudostate initial = new Pseudostate();
		initial.setKind(PseudostateKind.Initial);
		
		State low = new State();
		low.setStateName("Low");
		
		State Medium = new State();
		Medium.setStateName("Medium");
		
		State High = new State();
		High.setStateName("High");
		
		Action pull = new Action();
		pull.setActionName("pull");
		
		
		//Creating the transitions, labelTransitions and setting their source and target. 
		LabelTransition i2l = new LabelTransition();
		i2l.setTransitionStatus("Initial 2 Low");
		i2l.setAction(pull);
		i2l.setSource(initial);
		i2l.setTarget(low);
		
		LabelTransition l2m = new LabelTransition();
		l2m.setTransitionStatus("Low 2 Medium");
		l2m.setAction(pull);
		l2m.setSource(low);
		l2m.setTarget(Medium);
		
		LabelTransition m2h = new LabelTransition();
		m2h.setTransitionStatus("Medium 2 High");
		m2h.setAction(pull);
		m2h.setSource(Medium);
		m2h.setTarget(High);
		
		LabelTransition h2o = new LabelTransition();
		h2o.setTransitionStatus("High 2 Off");
		h2o.setAction(pull);
		h2o.setSource(High);
		h2o.setTarget(initial);
		
		// setting the outgoing of all States
		initial.setOutgoings(new LabelTransition[] {i2l});
		low.setOutgoings(new LabelTransition[] {l2m});
		Medium.setOutgoings(new LabelTransition[] {m2h});
		High.setOutgoings(new LabelTransition[] {h2o});
		
		// setting states, actions, transition in a single statemachine
		Statemachine smWithHistory = new Statemachine();
		smWithHistory.setStates(new Vertex[] {initial,low,Medium,High});
		smWithHistory.setTransitions(new LabelTransition[] {i2l,l2m,m2h,h2o});
		smWithHistory.setActions(new Action[] {pull});
		
		//Passing the state machine to Template
		FanTemplateGenerator tmpGen = new FanTemplateGenerator();
		tmpGen.getTestMachine(smWithHistory);
				
	}

}
