
public class Stock5 {

}

class Solution {

    public static int stockProfit(int[] prices) {
        int n = prices.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];

        // states
        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[2];
            curr[1] = Math.max(-prices[ind] + front1[0], front1[1]);
            curr[0] = Math.max(prices[ind] + front2[1], front1[0]);
            front2 = front1;
            front1 = curr;
        }

        return front1[1];
    }

    public static int stockProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        // for(int[] row:dp) Arrays.fill(row,-1);

        // states
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0],
                            dp[ind + 1][1]);
                } else {
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 2][1],
                            dp[ind + 1][0]);
                }
            }
        }

        return dp[0][1];
        // return f(0,1,prices,dp);
    }

    public static int f(int ind, int buy, int[] prices, int[][] dp) {
        if (ind >= prices.length)
            return 0;
        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[ind] + f(ind + 1, 0, prices, dp),
                    f(ind + 1, 1, prices, dp));
        } else {
            profit = Math.max(prices[ind] + f(ind + 2, 1, prices, dp),
                    f(ind + 1, 0, prices, dp));
        }

        return dp[ind][buy] = profit;
    }
}
