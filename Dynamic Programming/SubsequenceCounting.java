// link : https://www.codingninjas.com/codestudio/problems/subsequence-counting_3755256?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class SubsequenceCounting {

}

class Solution {
    static int prime = (int) (Math.pow(10, 9) + 7);

    public static int subsequenceCounting(String s, String t, int lt, int ls) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];

        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // states
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
        // return f(n,m,s.toCharArray(),t.toCharArray(),dp);
    }

    public static int f(int i, int j, char[] s, char[] t, int[][] dp) {
        if (j == 0)
            return 1;
        if (i == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s[i - 1] == t[j - 1]) {
            return dp[i][j] = (f(i - 1, j - 1, s, t, dp) + f(i - 1, j, s, t, dp)) % prime;
        }

        return dp[i][j] = f(i - 1, j, s, t, dp);
    }

}