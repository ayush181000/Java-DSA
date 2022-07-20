
public class ChocolatePickup {

}

class Solution {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        return helper(0, 0, m - 1, n - 1, m - 1, grid, dp);
    }

    public static int helper(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) {
            return -100000000;
        }

        if (i == r - 1) {
            if (j1 == j2)
                return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != 0)
            return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d1++) {
                int value = 0;
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];
                value += helper(i + 1, j1 + d1, j2 + d2, r, c, grid, dp);
                max = Math.max(max, value);
            }
        }
        dp[i][j1][j2] = max;
        return max;
    }
}