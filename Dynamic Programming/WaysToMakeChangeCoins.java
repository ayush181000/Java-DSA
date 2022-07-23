// link : https://www.codingninjas.com/codestudio/problems/ways-to-make-coin-change_630471?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

class Solution {

    public static long countWaysToMakeChange(int deno[], int value) {
        int n = deno.length;
        long[] prev = new long[value + 1];
        // for(long[] row :dp) Arrays.fill(row,-1);

        // base cases
        prev[0] = 1;
        for (int i = 1; i <= value; i++) {
            if (value % deno[0] == 0)
                prev[i] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            long[] curr = new long[value + 1];
            for (int target = 0; target <= value; target++) {
                long pick = 0;
                if (target - deno[ind] >= 0)
                    pick = curr[target - deno[ind]];
                long notPick = prev[target];
                curr[target] = pick + notPick;
            }
            prev = curr;
        }

        return prev[value];
    }

    public static long helper(int ind, int target, int[] deno, long[][] dp) {
        if (ind == 0) {
            if (target == 0)
                return 1;
            if (target != 0 && target % deno[0] == 0)
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        long pick = 0;
        if (target - deno[ind] >= 0)
            pick = helper(ind, target - deno[ind], deno, dp);
        long notPick = helper(ind - 1, target, deno, dp);
        dp[ind][target] = pick + notPick;
        return pick + notPick;
    }
}