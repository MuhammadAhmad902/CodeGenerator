package statemachine2;

public class Rinsing extends State {
	public void goNext(MachineContext ctx){
		ctx.setState(new Spining());
		System.out.println("Rinsing 2 Spining");
	}
}
