public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // Create array to store the Thue-Morse sequence
        int[] sequence = new int[n];
        sequence[0] = 0;

        // Generate sequence
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                sequence[i] = sequence[i/2];
            } else {
                sequence[i] = 1 - sequence[i-1];
            }
        }

        // Print the n-by-n pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}