import java.util.*;

public class Stock4 {

}

class Solution {
    public static int maximumProfit(int[] prices, int n, int k) {
        k = 2 * k;
        int[] ahead = new int[k + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[k + 1];
            for (int cap = k - 1; cap >= 0; cap--) {
                if (cap % 2 == 0) {
                    curr[cap] = Math.max(-prices[ind] + ahead[cap + 1], ahead[cap]);
                } else {
                    curr[cap] = Math.max(prices[ind] + ahead[cap + 1], ahead[cap]);
                }
            }
            ahead = curr;
        }

        return ahead[0];
    }

    public static int maximumProfitRecur(int[] prices, int n, int k) {
        k = 2 * k;
        int[][] dp = new int[n][k];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, 0, prices, n, dp, k);
    }

    public static int helper(int ind, int cap, int[] prices, int n, int[][] dp, int k) {
        if (ind == n || cap == k)
            return 0;
        if (dp[ind][cap] != -1)
            return dp[ind][cap];

        int profit = 0;
        if (cap % 2 == 0) {
            profit = Math.max(-prices[ind] + helper(ind + 1, cap + 1, prices, n, dp, k),
                    helper(ind + 1, cap, prices, n, dp, k));
        } else {
            profit = Math.max(prices[ind] + helper(ind + 1, cap + 1, prices, n, dp, k),
                    helper(ind + 1, cap, prices, n, dp, k));
        }

        return dp[ind][cap] = profit;

    }
}
