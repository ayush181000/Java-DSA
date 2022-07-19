import java.util.*;

// link : https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class MinPathSum2 {

}

class Solution {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        // base case
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }

        // executing loop
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i - 1][j];
                int left = Integer.MIN_VALUE + 100000;
                int right = Integer.MIN_VALUE + 100000;
                if (j > 0)
                    left = dp[i - 1][j - 1];
                if (j + 1 < m)
                    right = dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] + Math.max(up, Math.max(left, right));
            }
        }

        // find maximum in dp last row
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }

        return max;
    }
}

class Solution2 {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, helper(n - 1, i, matrix, dp));
        }

        return max;
    }

    public static int helper(int row, int col, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= matrix[0].length) {
            return Integer.MIN_VALUE + 100000;
        }
        if (row == 0) {
            return matrix[0][col];
        }
        if (dp[row][col] != -1)
            return dp[row][col];
        int up = helper(row - 1, col, matrix, dp);
        int left = helper(row - 1, col - 1, matrix, dp);
        int right = helper(row - 1, col + 1, matrix, dp);

        dp[row][col] = matrix[row][col] + Math.max(up, Math.max(left, right));

        return matrix[row][col] + Math.max(up, Math.max(left, right));
    }
}
