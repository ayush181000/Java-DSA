import java.util.*;

public class Stock3 {

}

class Solution {

    public static int maxProfit(ArrayList<Integer> prices, int n) {
        // int[][] dp = new int[n][4];
        // int[][] dp = new int[n+1][5];
        int[] ahead = new int[5];
        // for(int[] row:dp) Arrays.fill(row,-1);

        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[5];
            for (int cap = 3; cap >= 0; cap--) {
                if (cap % 2 == 0) {
                    curr[cap] = Math.max(-prices.get(ind) + ahead[cap + 1], ahead[cap]);
                } else {
                    curr[cap] = Math.max(prices.get(ind) + ahead[cap + 1], ahead[cap]);
                }
            }
            ahead = curr;
        }

        return ahead[0];
        // return helper(0,0,prices,n,dp);
    }

    public static int helper(int ind, int cap, ArrayList<Integer> prices, int n, int[][] dp) {
        if (ind == n || cap == 4)
            return 0;
        if (dp[ind][cap] != -1)
            return dp[ind][cap];

        int profit = 0;
        if (cap % 2 == 0) {
            profit = Math.max(-prices.get(ind) + helper(ind + 1, cap + 1, prices, n, dp),
                    helper(ind + 1, cap, prices, n, dp));
        } else {
            profit = Math.max(prices.get(ind) + helper(ind + 1, cap + 1, prices, n, dp),
                    helper(ind + 1, cap, prices, n, dp));
        }

        return dp[ind][cap] = profit;

    }

    public static int maxProfit2(ArrayList<Integer> prices, int n) {
        // int[][][] dp = new int[n+1][2][3];
        int[][] after = new int[2][3];
        // for(int[][] mat:dp) for(int[] row:mat) Arrays.fill(row,-1);

        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int transactions = 1; transactions >= 0; transactions--) {
                    if (buy == 1) {
                        curr[buy][transactions] = Math.max(-prices.get(ind) + after[0][transactions],
                                after[1][transactions]);
                    } else {
                        curr[buy][transactions] = Math.max(prices.get(ind) + after[1][transactions + 1],
                                after[0][transactions]);
                    }
                }
            }
            after = curr;
        }

        return after[1][0];
        // return f(0 , 1 , 0 , prices,n,dp);
    }

    public static int f(int ind, int buy, int transactions, ArrayList<Integer> prices, int n, int[][][] dp) {
        if (ind == n)
            return 0;

        if (dp[ind][buy][transactions] != -1)
            return dp[ind][buy][transactions];

        if (transactions == 2)
            return 0;

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices.get(ind) + f(ind + 1, 0, transactions, prices, n, dp),
                    0 + f(ind + 1, 1, transactions, prices, n, dp));
        } else {
            profit = Math.max(prices.get(ind) + f(ind + 1, 1, transactions + 1, prices, n, dp),
                    0 + f(ind + 1, 0, transactions, prices, n, dp));
        }

        return dp[ind][buy][transactions] = profit;
    }

}