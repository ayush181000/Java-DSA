
public class SubsetSumEqualK {

}

class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n][k + 1];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            for (int target = 1; target < k; target++) {
                boolean notTake = dp[idx - 1][target];
                boolean take = false;
                if (target - arr[idx] >= 0)
                    take = dp[idx - 1][target - arr[idx]];
                dp[idx][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }

    public static boolean subsetSumToK2(int n, int k, int arr[]) {
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
