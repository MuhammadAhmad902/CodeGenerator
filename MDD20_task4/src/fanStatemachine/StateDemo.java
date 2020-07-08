package fanStatemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StateDemo {

    public static void main(String[] args) throws IOException {
                // TODO Auto-generated method stub
                MachineContext ctx = new MachineContext();

                System.out.println("Please enter 1 to change the speed of fan");
                
            while (true) {
                String name;
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
                name = reader.readLine();
    
                if(name.equals("1")) {
                            ctx.run();
                            
                } 
            }
    }

}

