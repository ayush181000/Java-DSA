public class RodCuttingProblem {

}

// link :
// https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

class Solution {
    public static int cutRod(int price[], int l) {
        int n = price.length;
        int[][] dp = new int[n][l + 1];

        // base case
        for (int L = 0; L <= l; L++) {
            dp[0][L] = L * price[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int L = 0; L <= l; L++) {
                int cut = Integer.MIN_VALUE;
                int rodL = ind + 1;
                if (rodL <= L)
                    cut = price[ind] + dp[ind][L - rodL];
                int notCut = dp[ind - 1][L];

                dp[ind][L] = Math.max(cut, notCut);
            }
        }

        return dp[n - 1][l];
    }

    public static int f(int ind, int l, int price[], int[][] dp) {
        if (ind == 0) {
            return l * price[0];
        }

        if (dp[ind][l] != -1)
            return dp[ind][l];

        int cut = Integer.MIN_VALUE;
        int rodL = ind + 1;
        if (rodL <= l)
            cut = price[ind] + f(ind, l - rodL, price, dp);
        int notCut = f(ind - 1, l, price, dp);

        dp[ind][l] = Math.max(cut, notCut);
        return Math.max(cut, notCut);
    }
}