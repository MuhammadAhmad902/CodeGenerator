package fanStatemachine;

public class Medium extends State {
	public void pull(MachineContext ctx){
		ctx.setState(new High());
		System.out.println("Medium 2 High");
	}
}
