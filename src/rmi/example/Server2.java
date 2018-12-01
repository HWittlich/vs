package rmi.example;


import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Server2 implements Hello {
        
    public Server2() {}
    
    @Override
    public String sayHello() {
        return "Hello, world!";
    }
        
    public static void main(String args[]) {
    	Integer port = (args.length < 1) ? null : Integer.parseInt(args[0]);
        try {
            Server2 obj = new Server2();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry 
            Registry registry = LocateRegistry.getRegistry(port);
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}