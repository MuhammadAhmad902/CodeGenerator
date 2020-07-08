package lightStatemachine;

public class Low extends State {
	public void push(MachineContext ctx){
		ctx.setState(new Off());
		System.out.println("OFF");
	}
}
