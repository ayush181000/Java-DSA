import java.util.*;

public class NumberOfLIS {

}

class Solution {
    public static int findNumberOfLIS(int n, int[] arr) {
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == max)
                ans += count[i];
        }
        return ans;
    }
}