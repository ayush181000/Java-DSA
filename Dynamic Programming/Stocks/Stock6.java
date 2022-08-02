
public class Stock6 {

}

class Solution {
    public static int maximumProfit(int n, int fee, int[] prices) {
        // int[][] dp = new int[n][2];
        // for(int[] row:dp) Arrays.fill(row,-1);

        // return f(0,1,prices,dp,fee);

        int aheadBuy = 0, aheadNotBuy = 0, currBuy, currNotBuy;

        for (int i = n - 1; i >= 0; i--) {
            currBuy = Math.max(-prices[i] - fee + aheadNotBuy, aheadBuy);
            currNotBuy = Math.max(prices[i] + aheadBuy, aheadNotBuy);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
    }

    public static int f(int ind, int buy, int[] prices, int[][] dp, int fee) {
        if (ind == prices.length)
            return 0;
        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[ind] - fee + f(ind + 1, 0, prices, dp, fee),
                    f(ind + 1, 1, prices, dp, fee));
        } else {
            profit = Math.max(prices[ind] + f(ind + 1, 1, prices, dp, fee),
                    f(ind + 1, 0, prices, dp, fee));
        }

        return dp[ind][buy] = profit;
    }
}