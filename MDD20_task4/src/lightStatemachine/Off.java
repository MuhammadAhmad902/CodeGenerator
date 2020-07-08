package lightStatemachine;

public class Off extends State {
	public void push(MachineContext ctx){
		ctx.setState(new On());
		System.out.println("ON");
	}
}
