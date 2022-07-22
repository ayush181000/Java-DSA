
// link : https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class MinAbsDiffSubset {

}

class Solution {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int i = 0; i < n; i++)
            totalSum += arr[i];

        for (int k = totalSum / 2; k >= 0; k--) {
            int[][] dp = new int[n + 1][k + 1];
            if (f(n - 1, k, arr, dp)) {
                int sum1 = k;
                int sum2 = totalSum - k;
                return Math.abs(sum1 - sum2);
            }
        }

        return -1;
    }

    public static boolean f(int index, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (index == 0)
            return arr[0] == target;
        if (dp[index][target] != 0)
            return dp[index][target] == 1;

        boolean notTake = f(index - 1, target, arr, dp);
        boolean take = f(index - 1, target - arr[index], arr, dp);

        if (notTake || take)
            dp[index][target] = 1;
        else
            dp[index][target] = -1;

        return take || notTake;
    }

}
