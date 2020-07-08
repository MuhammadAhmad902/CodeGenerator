package fanStatemachine;

public class Off extends State {
	public void pull(MachineContext ctx){
		ctx.setState(new Low());
		System.out.println("Initial 2 Low");
	}
}
