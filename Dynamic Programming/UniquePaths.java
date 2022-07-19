import java.util.*;

// link : https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

// You are present at point ‘A’ which is the top-left cell of an M X N matrix, your destination is point ‘B’, which is the bottom-right cell of the same matrix. Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’, your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].

// To traverse in the matrix, you can either move Right or Down at each step. For example in a given point MATRIX[i] [j], you can move to either MATRIX[i + 1][j] or MATRIX[i][j + 1].

public class UniquePaths {

}

class Solution {
    public static int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    curr[j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0)
                        up = prev[j];
                    if (j > 0)
                        left = curr[j - 1];
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }

        return prev[n - 1];
        // return helper(m-1,n-1,dp);
    }

    public static int helper(int row, int col, int[][] dp) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];

        int up = helper(row - 1, col, dp);
        int left = helper(row, col - 1, dp);

        dp[row][col] = up + left;
        return up + left;
    }
}