package smWithHistory;

public class TestMachine2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating the states and setting their names
		Pseudostate initial = new Pseudostate();
		initial.setKind(PseudostateKind.Initial);
		
		Pseudostate Final = new Pseudostate();
		Final.setKind(PseudostateKind.Final);
		
		State washing = new State();
		washing.setStateName("Washing");
		
		State rinsing = new State();
		rinsing.setStateName("Rinsing");
		
		State spining = new State();
		spining.setStateName("Spining");
		
		//Creating the transitions, labelTransitions and setting their source and target. 
		Transition i2w = new Transition();
		i2w.setTransitionStatus("Initial 2 Washing");
		i2w.setSource(initial);
		i2w.setTarget(washing);
		
		Transition w2r = new Transition();
		w2r.setTransitionStatus("Washing 2 Rinsing");
		w2r.setSource(washing);
		w2r.setTarget(rinsing);
		
		Transition r2s = new Transition();
		r2s.setTransitionStatus("Rinsing 2 Spining");
		r2s.setSource(rinsing);
		r2s.setTarget(spining);
		
		Transition s2f = new Transition();
		s2f.setTransitionStatus("Spining 2 Final");
		s2f.setSource(spining);
		s2f.setTarget(Final);
		
		// setting the outgoing of all States
		initial.setOutgoings(new Transition[] {i2w});
		washing.setOutgoings(new Transition[] {w2r});
		rinsing.setOutgoings(new Transition[] {r2s});
		spining.setOutgoings(new Transition[] {s2f});
		
		// setting states, actions, transition in a single statemachine
		Statemachine smWithHistory = new Statemachine();
		smWithHistory.setStates(new Vertex[] {initial,Final,washing,rinsing,spining});
		smWithHistory.setTransitions(new Transition[] {i2w,w2r,r2s,s2f});
		
		//Passing the state machine to Template
		TemplateGenerator tmpGen = new TemplateGenerator();
		tmpGen.getTestMachine(smWithHistory);
		
		TemplateGenerator2 tmpGen1 = new TemplateGenerator2();
		tmpGen1.getTestMachine(smWithHistory);

	}

}
