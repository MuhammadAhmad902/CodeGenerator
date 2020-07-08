package statemachine2;

public class Spining extends State {
	public void goNext(MachineContext ctx){
		ctx.setState(new Off());
		System.out.println("Spining 2 Final");
	}
}
