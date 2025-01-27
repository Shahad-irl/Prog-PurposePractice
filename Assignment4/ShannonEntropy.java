public class ShannonEntropy {
    public static void main(String[] args) {
        // Get the maximum value m from command line
        int m = Integer.parseInt(args[0]);
        
        // Array to store frequencies of each number
        int[] frequencies = new int[m + 1];
        int total = 0;
        
        // Read integers and count frequencies
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            frequencies[value]++;
            total++;
        }
        
        // Calculate Shannon entropy
        double entropy = 0.0;
        for (int i = 1; i <= m; i++) {
            if (frequencies[i] > 0) {
                double p = (double) frequencies[i] / total;
                entropy -= p * (Math.log(p) / Math.log(2));
            }
        }
        
        // Print result with 4 decimal places
        System.out.printf("%.4f\n", entropy);
    }
}