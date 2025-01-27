public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        // Earth's radius in kilometers
        double radius = 6371.0;

        // Convert degrees to radians
        double x1Rad = Math.toRadians(x1);
        double y1Rad = Math.toRadians(y1);
        double x2Rad = Math.toRadians(x2);
        double y2Rad = Math.toRadians(y2);

        // Calculate the differences in coordinates
        double deltaX = x2Rad - x1Rad;
        double deltaY = y2Rad - y1Rad;

        double sinDeltaX = Math.sin(deltaX / 2) * Math.sin(deltaX / 2);
        double sinDeltaY = Math.sin(deltaY / 2) * Math.sin(deltaY / 2);
        double cosX1 = Math.cos(x1Rad);
        double cosX2 = Math.cos(x2Rad);

        double a = sinDeltaX + cosX1 * cosX2 * sinDeltaY;


        double guess = a / 2; // Initial guess
        guess = (guess + a / guess) / 2; // First iteration
        guess = (guess + a / guess) / 2; // Second iteration since loops are not allowed

        // Central angle 'c'
        double c = 2 * guess;

        double distance = radius * c;

        System.out.println(distance + " Kilometers");
    }
}

