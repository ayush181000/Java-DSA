// link : https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class PartitionEqualSubsetSum {

}

class Solution {
    public static boolean canPartition(int[] arr, int n) {
        int totalSum = 0;
        for (int i = 0; i < n; i++)
            totalSum += arr[i];
        if (totalSum % 2 != 0)
            return false;

        int k = totalSum / 2; // target
        int[][] dp = new int[n + 1][k + 1];
        return f(n - 1, k, arr, dp);
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