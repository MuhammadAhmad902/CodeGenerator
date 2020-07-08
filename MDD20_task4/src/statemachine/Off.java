package statemachine;

public class Off extends State {
	public void goNext(MachineContext ctx){
		ctx.setState(new Washing());
		System.out.println("Initial 2 Washing");
	}
}
