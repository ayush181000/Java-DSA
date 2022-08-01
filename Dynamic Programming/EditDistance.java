// import java.util.*;

public class EditDistance {

}

class Solution {

    public static int editDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] prev = new int[m + 1];
        // for(int[] row : dp) Arrays.fill(row,-1);

        // base case
        for (int j = 0; j <= m; j++)
            prev[j] = j;
        // for(int i = 0 ; i<= n ;i++) dp[i][0] = i;

        // state loop
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int replace = prev[j - 1];
                    int delete = prev[j];
                    int insert = curr[j - 1];
                    curr[j] = 1 + Math.min(replace, Math.min(delete, insert));
                }
            }
            prev = curr;
        }

        return prev[m];
        // return f(n,m,s.toCharArray(),t.toCharArray(),dp);
    }

    public static int f(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s[i - 1] == t[j - 1]) {
            return dp[i][j] = f(i - 1, j - 1, s, t, dp);
        }

        int replace = f(i - 1, j - 1, s, t, dp);
        int delete = f(i - 1, j, s, t, dp);
        int insert = f(i, j - 1, s, t, dp);

        return dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));

    }
}