package statemachine;

public abstract class State{
	
	public abstract void goNext(MachineContext ctx);
	
}
