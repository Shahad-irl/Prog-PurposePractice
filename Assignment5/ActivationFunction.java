public class ActivationFunction {
    // Returns the Heaviside function of x
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x < 0) return 0.0;
        if (x == 0) return 0.5;
        return 1.0;
    }

    // Returns the sigmoid function of x
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return 1.0 / (1.0 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x >= 20) return 1.0;    // to avoid overflow
        if (x <= -20) return -1.0;  // to avoid overflow
        double ex = Math.exp(x);
        double emx = Math.exp(-x);
        return (ex - emx) / (ex + emx);
    }

    // Returns the softsign function of x
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -2) return -1;
        if (x < 0) return x + (x * x / 4);
        if (x < 2) return x - (x * x / 4);
        return 1;
    }

    // Takes a double command-line argument x and prints each activation function
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.printf("heaviside(%.1f) = %.1f\n", x, heaviside(x));
        System.out.printf("  sigmoid(%.1f) = %.16f\n", x, sigmoid(x));
        System.out.printf("     tanh(%.1f) = %.16f\n", x, tanh(x));
        System.out.printf(" softsign(%.1f) = %.16f\n", x, softsign(x));
        System.out.printf("     sqnl(%.1f) = %.16f\n", x, sqnl(x));
    }
}