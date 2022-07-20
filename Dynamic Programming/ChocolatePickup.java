import java.util.*;

public class ChocolatePickup {
    public static void main(String[] args) {

    }
}

class Solution {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int front[][] = new int[m][m];

        // base case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    front[j1][j2] = grid[n - 1][j1];
                } else {
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        // states

        for (int i = n - 2; i >= 0; i--) {
            int curr[][] = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = -100000000;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int value = 0;
                            if (j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];
                            if (j1 + d1 >= 0 && j1 + d1 < m && j2 + d2 >= 0 && j2 + d2 < m)
                                value += front[j1 + d1][j2 + d2];
                            else
                                value += -100000000;
                            max = Math.max(max, value);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            front = curr;
        }

        return front[0][m - 1];
    }
}

class Solution3 {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];

        // base case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                } else {
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        // states

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = -100000000;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int value = 0;
                            if (j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];
                            if (j1 + d1 >= 0 && j1 + d1 < m && j2 + d2 >= 0 && j2 + d2 < m)
                                value += dp[i + 1][j1 + d1][j2 + d2];
                            else
                                value += -100000000;
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][m - 1];
    }
}

class Solution2 {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];

        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return helper(0, 0, m - 1, n, m, grid, dp);
    }

    public static int helper(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) (Math.pow(-10, 9));

        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int max = -100000000;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int value = 0;
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];
                value = value + helper(i + 1, j1 + d1, j2 + d2, n, m, grid, dp);
                max = Math.max(max, value);
            }
        }
        dp[i][j1][j2] = max;
        return max;
    }
}