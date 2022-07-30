// link : https://www.codingninjas.com/codestudio/problems/shortest-supersequence_4244493?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class ShortestCommonSuperSequence {

}

class Solution {
    public static String shortestSupersequence(String a, String b) {
        int[][] dp = lcsDp(a, b);

        int i = a.length();
        int j = b.length();

        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(a.charAt(i - 1));
                i--;
            } else {
                sb.append(b.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(a.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(b.charAt(j - 1));
            j--;
        }

        String ans = sb.reverse().toString();
        // System.out.println(ans);
        return ans;
    }

    public static int[][] lcsDp(String str, String t) {
        int n = str.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

}