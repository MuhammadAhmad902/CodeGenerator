package smWithHistory;

public class TestMachine {

	public static void main(String[] args) {
		
		//Creating the states and setting their names
		Pseudostate initial = new Pseudostate();
		initial.setKind(PseudostateKind.Initial);
		
		Pseudostate Final = new Pseudostate();
		Final.setKind(PseudostateKind.Final);
		
		Pseudostate shallowHistory = new Pseudostate();
		shallowHistory.setKind(PseudostateKind.ShallowHistory);
		
		State washing = new State();
		washing.setStateName("Washing");
		
		State rinsing = new State();
		rinsing.setStateName("Rinsing");
		
		State spining = new State();
		spining.setStateName("Spining");
		
		State powerOff = new State();
		powerOff.setStateName("PowerOff");
		
		//creating the complexState and setting the subStates which i have created above.
		ComplexState running = new ComplexState();
		running.setStateName("Running");
		running.setSubVertex(new Vertex[]{washing,rinsing,spining});
		
		//creating the actions
		Action powerCut = new Action();
		powerCut.setActionName("powerCut");
		
		Action restorePower = new Action();
		restorePower.setActionName("restorePower");
		
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
		
		LabelTransition run2pO = new LabelTransition();
		run2pO.setTransitionStatus("Running 2 PowerOff");
		run2pO.setSource(running);
		run2pO.setTarget(powerOff);
		run2pO.setAction(powerCut);
		
		LabelTransition pO2History = new LabelTransition();
		pO2History.setTransitionStatus("Running 2 LastActiveClass");
		pO2History.setSource(powerOff);
		pO2History.setTarget(shallowHistory);
		pO2History.setAction(restorePower);
		
		//setting the outgoing of all States
		initial.setOutgoings(new Transition[] {i2w});
		washing.setOutgoings(new Transition[] {w2r});
		rinsing.setOutgoings(new Transition[] {r2s});
		spining.setOutgoings(new Transition[] {s2f});
		running.setOutgoings(new Transition[] {run2pO});
		powerOff.setOutgoings(new Transition[] {pO2History});
		
		// setting states, actions, transition in a single statemachine
		Statemachine smWithHistory = new Statemachine();
		smWithHistory.setStates(new Vertex[] {initial,running,Final,powerOff});
		smWithHistory.setTransitions(new Transition[] {i2w,w2r,r2s,s2f,run2pO,pO2History});
		smWithHistory.setActions(new Action[] {powerCut,restorePower});

		//using getTransitions() to get name of the states.
		System.out.println("using getTransitions() with casting to print states.");
		/*for (int i = 0; i < smWithHistory.getTransitions().length; i++) {
			if (smWithHistory.getTransitions()[i].getSource() instanceof Pseudostate) {
				System.out.println(
						((Pseudostate)smWithHistory.getTransitions()[i].getSource()).getKind()
						);
			} else {
				System.out.println(
						((State)smWithHistory.getTransitions()[i].getSource()).getStateName()
						);
			}
			if(smWithHistory.getTransitions()[i].getTarget() instanceof Pseudostate) {
				System.out.println(
						((Pseudostate)smWithHistory.getTransitions()[i].getTarget()).getKind()
						);
			}
		}*/
		
		//using getstates() with casting to print states.  => improvements => use recursive
		System.out.println("\n==========\n\nusing getstates() with casting to print states.");
	    /*for (int i = 0; i < smWithHistory.getStates().length; i++) {
	 		if (smWithHistory.getStates()[i] instanceof Pseudostate) {
	 			System.out.println(((Pseudostate)smWithHistory.getStates()[i]).getKind());
	 		}else {
	 			System.out.println(((State)smWithHistory.getStates()[i]).getStateName());
	 			if (smWithHistory.getStates()[i] instanceof ComplexState) {
	 				for (int j = 0; j < ((ComplexState)smWithHistory.getStates()[i]).getSubVertex().length; j++) {
	 					System.out.println(
	 							( 
	 									(
	 									(State)(
	 											(ComplexState) smWithHistory.getStates()[i]).getSubVertex()[j]).getStateName())
	 							);
	  				}
	 			}
	 		}
	 	}*/
		
//		TemplateGenerator tmpGen = new TemplateGenerator();
//		tmpGen.getTestMachine(smWithHistory);
	
	}

}
