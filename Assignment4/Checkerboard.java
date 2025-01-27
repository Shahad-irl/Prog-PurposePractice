public class Checkerboard {
    public static void main(String[] args) {
        // Get board size from command line
        int n = Integer.parseInt(args[0]);
        
        // Set the scale of the drawing
        StdDraw.setScale(0, n);
        
        // Draw each square
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculate center point of the square
                double x = i + 0.5;
                double y = j + 0.5;
                
                // Set color based on position
                // Bottom-left square should be blue
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                
                // Draw filled square
                StdDraw.filledSquare(x, y, 0.5);
            }
        }
    }
}