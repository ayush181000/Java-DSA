
public class WildcardPatternMatching {

}

class Solution {
    public static boolean wildcardMatching(String p, String t) {
        int n = p.length();
        int m = t.length();

        // int[][] dp = new int[n+1][m+1];
        // for(int[] row : dp) Arrays.fill(row,-1);

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*')
                dp[i][0] = true;
            else
                break;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(i - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else
                    dp[i][j] = false;
            }
        }

        return dp[n][m];
        // return f(n , m , p , t ,dp);
    }

    public static boolean f(int i, int j, String p, String t, int[][] dp) {
        if (i == 0 && j == 0)
            return true;
        if (i == 0 && j > 0)
            return false;
        if (j == 0 && i > 0) {
            for (int ii = 0; ii < i; ii++) {
                if (p.charAt(ii) != '*')
                    return false;
            }
            return true;
        }

        if (dp[i][j] != -1) {
            if (dp[i][j] == 1)
                return true;
            return false;
        }

        // match
        if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == t.charAt(j - 1)) {
            boolean charMatch = f(i - 1, j - 1, p, t, dp);
            dp[i][j] = charMatch ? 1 : 0;
            return charMatch;
        }

        // not match : it is a *
        if (p.charAt(i - 1) == '*') {
            boolean pickStar = f(i - 1, j, p, t, dp);
            boolean notPickStar = f(i, j - 1, p, t, dp);
            dp[i][j] = (pickStar || notPickStar) ? 1 : 0;
            return pickStar || notPickStar;
        }

        dp[i][j] = 0;
        return false;
    }
}
