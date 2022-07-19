
public class MinPathSum {

}

class Solution {
    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // int[][] dp = new int[n][m];
        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    curr[j] = grid[0][0];
                else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if (i > 0)
                        up = prev[j];
                    if (j > 0)
                        left = curr[j - 1];
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[m - 1];

        // return helper(n-1,m-1,grid,dp);
    }

    public static int helper(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }

        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[row][col] != 0)
            return dp[row][col];

        int up = helper(row - 1, col, grid, dp);
        int left = helper(row, col - 1, grid, dp);

        dp[row][col] = grid[row][col] + Math.min(up, left);
        return grid[row][col] + Math.min(up, left);
    }
}