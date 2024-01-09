import java.util.Scanner;

public enum Operation {
    ADD("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            if (y != 0)
                return x / y;
            else
                throw new ArithmeticException("Cannot divide by 0!");
        }
    };

    public abstract double apply(double x, double y);

    public static Operation fromSymbol(String symbol) {
        switch (symbol) {
            case "+":
                return ADD;
            case "-":
                return SUBTRACT;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalArgumentException("Invalid operation symbol");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Operation (+, -, *, /): ");
        String opSymbol = sc.nextLine();

        Operation op = Operation.fromSymbol(opSymbol);

        System.out.print("Enter the first operand: ");
        double x = sc.nextDouble();
        System.out.print("Enter the second operand: ");
        double y = sc.nextDouble();

        try {
            double result = op.apply(x, y);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
