
public class Triangle {

}

class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        int m = triangle[n - 1].length;
        // int[][] dp = new int[n][m];
        int[] next = new int[m];

        // tabulation is opposite
        // so ulta loop chalayenge

        // base case
        for (int j = 0; j < m; j++) {
            next[j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[i + 1];
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + next[j];
                int dg = triangle[i][j] + next[j + 1];
                curr[j] = Math.min(down, dg);
            }
            next = curr;
        }

        // print2D(triangle);

        return next[0];
        // return dp[0][0];
        // return helper(0,0,triangle,n,dp);
    }

    public static int helper(int row, int col, int[][] triangle, int n, int[][] dp) {
        if (row < 0 || col < 0 || col > row + 1)
            return 0;
        if (row == n - 1) {
            return triangle[row][col];
        }

        if (dp[row][col] != 0)
            return dp[row][col];

        int down = helper(row + 1, col, triangle, n, dp);
        int right = helper(row + 1, col + 1, triangle, n, dp);
        dp[row][col] = triangle[row][col] + Math.min(down, right);
        return triangle[row][col] + Math.min(down, right);
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }
}