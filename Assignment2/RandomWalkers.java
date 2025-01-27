public class RandomWalkers {
    public static void main(String[] args) {
        // Get target distance and number of trials from command line
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // Use long to handle large numbers of steps
        long totalSteps = 0;

        // Run the specified number of trials
        for (int t = 0; t < trials; t++) {
            int x = 0;  // current x coordinate
            int y = 0;  // current y coordinate
            int steps = 0;  // steps in this trial

            // Continue until we reach manhattan distance r
            while (Math.abs(x) + Math.abs(y) != r) {
                // Generate random direction
                double random = Math.random();

                // Take step in random direction
                if (random < 0.25) x++;        // east
                else if (random < 0.50) x--;   // west
                else if (random < 0.75) y++;   // north
                else y--;                      // south

                steps++;
            }

            totalSteps += steps;
        }

        // Calculate and print average
        double avgSteps = (double) totalSteps / trials;
        System.out.println("average number of steps = " + avgSteps);

        // Optional: Print ratio to r^2 to demonstrate quadratic growth
        double ratio = avgSteps / (r * r);
        System.out.println("ratio to r^2 = " + ratio);
    }
}