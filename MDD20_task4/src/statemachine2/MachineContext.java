package statemachine2;

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
		current.goNext(this);
	}
}

