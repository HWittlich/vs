package rmi.example;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client2 {

    private Client2() {}

    public static void main(String[] args) {

    	Integer port = (args.length < 1) ? null : Integer.parseInt(args[0]);
        try {
            Registry registry = LocateRegistry.getRegistry(port);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}