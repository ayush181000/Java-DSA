import java.util.*;

// link : https://www.codingninjas.com/codestudio/problems/maze-obstacles_977241?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

public class UniquePaths2 {

}

class Solution {
    static int mod = (int) Math.pow(10, 9) + 7;

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        // for(int i = 0 ; i < n ; i++){
        // Arrays.fill(dp[i],-1);
        // }

        // return helper(n-1,m-1,mat,dp);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == -1)
                    dp[i][j] = 0;
                else if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];
                    dp[i][j] = (up + left) % mod;
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    static int helper(int row, int col, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if (row < 0 || col < 0)
            return 0;
        if (mat.get(row).get(col) == -1)
            return 0;
        if (row == 0 && col == 0)
            return 1;

        if (dp[row][col] != -1)
            return dp[row][col];

        int up = helper(row - 1, col, mat, dp);
        int left = helper(row, col - 1, mat, dp);

        dp[row][col] = (up + left) % mod;

        return (up + left) % mod;
    }

}
