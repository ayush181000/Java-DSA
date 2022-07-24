
import java.util.*;

public class PrintLCSubsequence {

}

class Solution {

    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[n + 1][m + 1];

        // base case
        for (int j = 0; j < m; j++)
            dp[0][j] = 0;
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    int pick = 1 + dp[i - 1][j - 1];
                    dp[i][j] = pick;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                sb.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.print(sb.reverse().toString());
        return dp[n][m];
    }

    public static int lcsRecur(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n, m, s, t, dp);
    }

    public static int f(int ind1, int ind2, String s, String t, int[][] dp) {
        if (ind1 == 0 || ind2 == 0)
            return 0;
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s.charAt(ind1 - 1) == t.charAt(ind2 - 1)) {
            int pick = 1 + f(ind1 - 1, ind2 - 1, s, t, dp);
            dp[ind1][ind2] = pick;
            return pick;
        }

        dp[ind1][ind2] = Math.max(f(ind1 - 1, ind2, s, t, dp), f(ind1, ind2 - 1, s, t, dp));
        return dp[ind1][ind2];
    }

}