// link : https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091?leftPanelTab=0

import java.util.*;

public class MinimumElements {

}

class Solution {

    public static int minimumElements(int num[], int x) {
        int n = num.length;
        int dp[][] = new int[n][x + 1];

        for (int t = 0; t <= x; t++) {
            if (t % num[0] == 0)
                dp[0][t] = t / num[0];
            else
                dp[0][t] = 1000000000;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int t = 0; t <= x; t++) {
                int pick = Integer.MAX_VALUE;
                int notPick = dp[ind - 1][t];
                if (num[ind] <= t)
                    pick = 1 + dp[ind][t - num[ind]];
                dp[ind][t] = Math.min(pick, notPick);
            }
        }

        int ans = dp[n - 1][x];
        if (ans == 1000000000)
            return -1;
        return ans;
    }

    public static int minimumElementsDP(int num[], int x) {

        int n = num.length;
        int dp[][] = new int[n][x + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = helper(n - 1, x, num, dp);
        if (ans == 1000000000)
            return -1;
        return ans;
    }

    public static int helper(int ind, int x, int[] num, int[][] dp) {
        if (ind == 0) {
            if (x % num[ind] == 0)
                return x / num[ind];
            return 1000000000;
        }

        if (dp[ind][x] != -1)
            return dp[ind][x];

        int pick = Integer.MAX_VALUE;
        int notPick = helper(ind - 1, x, num, dp);
        if (num[ind] <= x)
            pick = 1 + helper(ind, x - num[ind], num, dp);

        dp[ind][x] = Math.min(pick, notPick);
        return Math.min(pick, notPick);
    }

}