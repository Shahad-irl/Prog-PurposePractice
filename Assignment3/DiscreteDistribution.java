public class DiscreteDistribution {
    public static void main(String[] args) {
        // Parse m from first argument
        int m = Integer.parseInt(args[0]);

        // Create array for input numbers, skipping first argument
        int[] numbers = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            numbers[i - 1] = Integer.parseInt(args[i]);
        }

        // Calculate cumulative sums
        int[] sums = new int[numbers.length];
        sums[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            sums[i] = sums[i - 1] + numbers[i];
        }

        // Generate m random indices
        for (int i = 0; i < m; i++) {
            // Generate random number between 0 and total sum - 1
            int r = (int) (Math.random() * sums[sums.length - 1]);

            // Find the index where this random number falls
            int index = 0;
            while (index < sums.length && r >= sums[index]) {
                index++;
            }

            // Print index + 1 (to match 1-based indexing in example)
            System.out.print((index + 1) + " ");
        }
        System.out.println();
    }
}