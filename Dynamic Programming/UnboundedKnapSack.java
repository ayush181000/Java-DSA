// link : https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

class Solution {
    public static int unboundedKnapsack(int n, int wt, int[] pf, int[] wts) {
        int[][] dp = new int[n][wt + 1];

        // base case
        for (int W = 0; W <= wt; W++) {
            dp[0][W] = W / wts[0] * pf[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int w = 0; w <= wt; w++) {

                int pick = Integer.MIN_VALUE;
                if (w >= wts[ind])
                    pick = pf[ind] + dp[ind][w - wts[ind]];
                int notPick = dp[ind - 1][w];

                dp[ind][w] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][wt];
    }

    public static int helper(int ind, int w, int[] pf, int[] wt, int[][] dp) {
        if (ind == 0) {
            return w / wt[0] * (pf[0]);
        }
        if (dp[ind][w] != -1)
            return dp[ind][w];
        int pick = Integer.MIN_VALUE;
        if (w >= wt[ind])
            pick = pf[ind] + helper(ind, w - wt[ind], pf, wt, dp);
        int notPick = helper(ind - 1, w, pf, wt, dp);

        dp[ind][w] = Math.max(pick, notPick);
        return Math.max(pick, notPick);
    }
}
