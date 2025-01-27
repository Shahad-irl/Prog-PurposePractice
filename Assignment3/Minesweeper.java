public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);    // rows
        int n = Integer.parseInt(args[1]);    // columns
        int k = Integer.parseInt(args[2]);    // mines

        // Create the minefield
        boolean[][] mines = new boolean[m][n];

        // Place k mines randomly
        int minesPlaced = 0;
        while (minesPlaced < k) {
            int row = (int) (Math.random() * m);
            int col = (int) (Math.random() * n);

            if (!mines[row][col]) {
                mines[row][col] = true;
                minesPlaced++;
            }
        }

        // Create and fill the game board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) {
                    System.out.print("*  ");
                } else {
                    // Count neighboring mines
                    int count = 0;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ni = i + di;
                            int nj = j + dj;
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                                if (mines[ni][nj]) count++;
                            }
                        }
                    }
                    System.out.print(count + "  ");
                }
            }
            System.out.println();
        }
    }
}