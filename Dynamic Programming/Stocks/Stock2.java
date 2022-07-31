
public class Stock2 {

}

// import java.util.*;

class Solution {
    public static long getMaximumProfit(int n, long[] values) {
        long aheadBuy = 0, aheadNotBuy = 0, currBuy, currNotBuy;

        for (int i = n - 1; i >= 0; i--) {
            currBuy = Math.max(-values[i] + aheadNotBuy, aheadBuy);
            currNotBuy = Math.max(values[i] + aheadBuy, aheadNotBuy);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
    }

    public static long getMaximumProfit2(int n, long[] values) {
        // if(n== 0) return 0;
        long[][] dp = new long[n + 1][2];
        // for(long[] row : dp) Arrays.fill(row,-1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                long profit = 0;
                if (j == 1) {
                    profit = Math.max(-values[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    profit = Math.max(values[i] + dp[i + 1][1], dp[i + 1][0]);
                }
                dp[i][j] = profit;
            }
        }

        return dp[0][1];
        // return f (0 , 1 ,values,n,dp);

    }

    public static long f(int ind, int buy, long[] v, int n, long[][] dp) {
        if (ind == n)
            return 0;
        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        long profit = 0;
        if (buy == 1) {
            profit = Math.max(-v[ind] + f(ind + 1, 0, v, n, dp), 0 + f(ind + 1, 1, v, n, dp));
        } else {
            profit = Math.max(v[ind] + f(ind + 1, 1, v, n, dp), 0 + f(ind + 1, 0, v, n, dp));
        }

        return dp[ind][buy] = profit;
    }

    // my function -> works perfectly but writing strivers solution for reference
    public static long f1(int ind, long buy, long[] values) {
        if (ind == values.length - 1) {
            if (buy != 0)
                return values[ind] - buy;
            return 0;
        }

        if (buy != 0) {
            long sell = values[ind] - buy + f1(ind + 1, 0, values);
            long notSell = f1(ind + 1, buy, values);
            return Math.max(sell, notSell);
        }

        long bought = f1(ind + 1, values[ind], values);
        long notBuy = f1(ind + 1, 0, values);

        return Math.max(bought, notBuy);
    }
}
