
public class LongestPalindromeSubsequence {

}

class Solution {

    // pure dp solution
    public int longestPalindromeSubseq(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int max = 0;
        int[] dp = new int[length];
        for (int j = 0; j < length; j++) {
            dp[j] = 1;
            max = 0;
            for (int i = j - 1; i >= 0; i--) {
                int len = dp[i];
                if (charArray[i] == charArray[j]) {
                    dp[i] = 2 + max;
                }
                max = Math.max(max, len);
            }
        }
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }

    public int longestPalindromeSubseq2(String s) {
        StringBuilder sb = new StringBuilder(s);
        return lcs(s, sb.reverse().toString());
    }

    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        // StringBuilder sb = new StringBuilder();

        int[][] dp = new int[n + 1][m + 1];

        // base case
        // for (int j = 0; j < m; j++) dp[0][j] = 0;
        // for (int i = 0; i < n; i++) dp[i][0] = 0;

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

        // int i = n, j = m;

        // while (i > 0 && j > 0) {
        // if (s.charAt(i - 1) == t.charAt(j - 1)) {
        // sb.append(s.charAt(i - 1));
        // i--;
        // j--;
        // } else if (dp[i - 1][j] > dp[i][j - 1]) {
        // i--;
        // } else {
        // j--;
        // }
        // }

        // System.out.print(sb.reverse().toString());
        return dp[n][m];
    }
}
