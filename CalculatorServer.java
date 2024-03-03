import java.rmi.*;
import java.rmi.server.*;

public class CalculatorServer extends UnicastRemoteObject implements Calculator {
    public CalculatorServer() throws RemoteException {
        super();
    }

    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    public int subtract(int x, int y) throws RemoteException {
        return x - y;
    }

    public int multiply(int x, int y) throws RemoteException {
        return x * y;
    }

    public int divide(int x, int y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return x / y;
    }

    public static void main(String[] args) {
        try {
            CalculatorServer server = new CalculatorServer();
            Naming.rebind("Calculator", server);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
