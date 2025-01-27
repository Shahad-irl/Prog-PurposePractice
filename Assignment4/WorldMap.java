public class WorldMap {
    public static void main(String[] args) {
        // Read canvas width and height
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        
        // Set canvas size and scale
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        
        // Enable double buffering to prevent flickering
        StdDraw.enableDoubleBuffering();
        
        // Read and process regions until end of input
        while (!StdIn.isEmpty()) {
            // Read region name (not used in drawing)
            String regionName = StdIn.readString();
            
            // Read number of vertices
            int vertices = StdIn.readInt();
            
            // Create arrays for polygon coordinates
            double[] x = new double[vertices];
            double[] y = new double[vertices];
            
            // Read vertices
            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            
            // Draw the polygon
            StdDraw.polygon(x, y);
        }
        
        // Show the final drawing
        StdDraw.show();
    }
}