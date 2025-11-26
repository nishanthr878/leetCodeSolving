public class GridGame {
    public long gridGame(int [][] grid) {
        int n = grid[0].length;

        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];

        topPrefix[0] = grid[0][0];

        bottomPrefix[0] = grid[1][0];

        for(int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        for(int k = 0; k < n; k++) {
            long topRight = 0;
            long bottomLeft = 0;

            if(k == 0) {
                bottomLeft = 0;
            } else {
                bottomLeft = bottomPrefix[k -1];
            }

            if (k == n -1) {
                topRight = 0;
            } else {
                topRight = topPrefix[n - 1] - topPrefix[k];
            }

            long score = Math.max(topRight, bottomLeft);
            result = Math.min(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        GridGame gg = new GridGame();
        int[][] grid = {
            {2,5,4},
            {1,5,1}
        };
        System.out.println("Minimum score the second player can achieve: " + gg.gridGame(grid)); // Output: 4
    }
}
