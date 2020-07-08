package statemachine2;

public class Washing extends State {
	public void goNext(MachineContext ctx){
		ctx.setState(new Rinsing());
		System.out.println("Washing 2 Rinsing");
	}
}
