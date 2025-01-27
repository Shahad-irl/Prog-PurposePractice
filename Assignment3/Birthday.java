public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);     // number of days
        int trials = Integer.parseInt(args[1]); // number of trials

        // Array to store count of people for each trial
        int[] counts = new int[n + 2];  // +2 to handle edge cases

        // Perform trials
        for (int t = 0; t < trials; t++) {
            // Array to mark birthdays
            boolean[] birthdays = new boolean[n];
            int count = 0;
            boolean foundMatch = false;

            // Add people until we find a match
            while (!foundMatch && count < n) {
                int birthday = (int) (Math.random() * n);
                count++;

                if (birthdays[birthday]) {
                    foundMatch = true;
                } else {
                    birthdays[birthday] = true;
                }
            }
            counts[count]++;
        }

        // Print results
        double fraction = 0.0;
        int i = 1;
        while (fraction < 0.5) {
            fraction += (double) counts[i] / trials;
            System.out.println(i + "\t" + counts[i] + "\t" + fraction);
            i++;
        }
    }
}