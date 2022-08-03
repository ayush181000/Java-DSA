
public class LongestBitonicSequence {

}

class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            dp2[n - i - 1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && 1 + dp1[j] > dp1[i]) {
                    dp1[i] = dp1[j] + 1;
                }
                if (arr[n - j - 1] < arr[n - i - 1] && 1 + dp2[n - j - 1] > dp2[n - i - 1]) {
                    dp2[n - i - 1] = dp2[n - j - 1] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (dp1[i] + dp2[i]) - 1);
        }
        return ans;
    }
}