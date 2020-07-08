package fanStatemachine;

public class Low extends State {
	public void pull(MachineContext ctx){
		ctx.setState(new Medium());
		System.out.println("Low 2 Medium");
	}
}
