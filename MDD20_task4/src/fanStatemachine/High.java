package fanStatemachine;

public class High extends State {
	public void pull(MachineContext ctx){
		ctx.setState(new Off());
		System.out.println("High 2 Off");
	}
}
