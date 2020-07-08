package smWithHistory;

public class TestFanStatemachineComplexState {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating the states and setting their names
		Pseudostate initial = new Pseudostate();
		initial.setKind(PseudostateKind.Initial);
		
		State low = new State();
		low.setStateName("Low");
		
		State medium = new State();
		medium.setStateName("Medium");
		
		State high = new State();
		high.setStateName("High");
		
		//creating the complexState and setting the subStates which i have created above.
		ComplexState fanSpeed = new ComplexState();
		fanSpeed.setStateName("FanSpeed");
		fanSpeed.setSubVertex(new Vertex[]{low,medium,high});
		
		//creating the actions
		Action press = new Action();
		press.setActionName("press");
		
		Action pull = new Action();
		pull.setActionName("pull");
		
		//Creating the transitions, labelTransitions and setting their source and target. 
		LabelTransition i2l = new LabelTransition();
		i2l.setTransitionStatus("light on with low fanspeed");
		i2l.setAction(press);
		i2l.setSource(initial);
		i2l.setTarget(low);
		
		LabelTransition l2m = new LabelTransition();
		l2m.setTransitionStatus("low 2 medium");
		l2m.setSource(low);
		l2m.setTarget(medium);
		l2m.setAction(pull);
		
		LabelTransition r2s = new LabelTransition();
		r2s.setTransitionStatus("Rinsing 2 Spining");
		r2s.setSource(medium);
		r2s.setTarget(high);
		
		LabelTransition h2l = new LabelTransition();
		h2l.setTransitionStatus("Spining 2 Final");
		h2l.setSource(high);
		h2l.setTarget(low);
		h2l.setAction(pull);
		
		LabelTransition fanspeed2init = new LabelTransition();
		fanspeed2init.setTransitionStatus("Running 2 PowerOff");
		fanspeed2init.setSource(fanSpeed);
		fanspeed2init.setTarget(initial);
		fanspeed2init.setAction(press);
		
		//setting the outgoing of all States
		initial.setOutgoings(new LabelTransition[] {i2l});
		low.setOutgoings(new LabelTransition[] {l2m});
		medium.setOutgoings(new LabelTransition[] {r2s});
		high.setOutgoings(new LabelTransition[] {h2l});
		fanSpeed.setOutgoings(new LabelTransition[] {fanspeed2init});
		
		// setting states, actions, transition in a single statemachine
		Statemachine smWithHistory = new Statemachine();
		smWithHistory.setStates(new Vertex[] {initial,fanSpeed});
		smWithHistory.setTransitions(new LabelTransition[] {i2l,l2m,r2s,h2l,fanspeed2init});
		smWithHistory.setActions(new Action[] {press,pull});
	}

}
