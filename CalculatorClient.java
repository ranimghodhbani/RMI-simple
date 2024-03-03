import java.rmi.*;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/Calculator");

            java.util.Scanner scanner = new java.util.Scanner(System.in);

            while (true) {
                System.out.println("Enter operation code (1. Add, 2. Subtract, 3. Multiply, 4. Divide): ");
                int operation = scanner.nextInt();

                System.out.println("Enter first operand: ");
                int x = scanner.nextInt();

                System.out.println("Enter second operand: ");
                int y = scanner.nextInt();

                int result = 0;
                switch (operation) {
                    case 1:
                        result = calculator.add(x, y);
                        break;
                    case 2:
                        result = calculator.subtract(x, y);
                        break;
                    case 3:
                        result = calculator.multiply(x, y);
                        break;
                    case 4:
                        result = calculator.divide(x, y);
                        break;
                    default:
                        System.out.println("Invalid operation code");
                        continue;
                }

                System.out.println("Result: " + result);

                System.out.println("Do you want to continue? (y/n)");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
