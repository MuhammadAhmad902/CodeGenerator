package statemachine2;

public abstract class State{
	
	public abstract void goNext(MachineContext ctx);
	
}
