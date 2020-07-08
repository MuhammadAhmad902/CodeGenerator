package lightStatemachine;

public class On extends State {
	public void push(MachineContext ctx){
		ctx.setState(new Off());
		System.out.println("OFF");
	}
}
