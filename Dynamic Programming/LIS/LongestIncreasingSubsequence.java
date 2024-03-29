import java.util.*;

public class LongestIncreasingSubsequence {

}

class Solution {

    // binary search solution
    // NOTE: cannot be used to get LIS itself . for that use reccurence or
    // tabulation
    public static int longestIncreasingSubsequence(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (list.get(list.size() - 1) < arr[i])
                list.add(arr[i]);
            else {
                // finding lower bound
                int index = Arrays.binarySearch(list.toArray(), arr[i]);
                if (index < 0) {
                    index = Math.abs(index) - 1;
                }
                list.set(index, arr[i]);
            }
        }

        return list.size();
    }

    public static int longestIncreasingSubsequence3(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        hash[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        int[] lis = new int[max];
        lis[0] = arr[lastIndex];
        int ind = 1;
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lis[ind++] = arr[lastIndex];
        }
        Collections.reverse(Arrays.asList(lis));
        // System.out.print(Arrays.toString(lis));
        return max;
    }

    public static int longestIncreasingSubsequence2(int arr[]) {
        int n = arr.length;

        // int dp[][] = new int[n+1][n+1];
        int ahead[] = new int[n + 1];
        // for(int[] row : dp) Arrays.fill(row,-1);

        for (int ind = n - 1; ind >= 0; ind--) {
            int curr[] = new int[n + 1];
            for (int last = n - 1; last >= -1; last--) {
                int len = ahead[last + 1];
                if (last == -1 || arr[ind] > arr[last])
                    len = Math.max(len, 1 + ahead[ind + 1]);
                curr[last + 1] = len;
            }
            ahead = curr;
        }

        return ahead[0];
        // return f(0,-1,arr,n,dp);
    }

    public static int f(int ind, int last, int[] arr, int n, int[][] dp) {
        if (ind == n)
            return 0;

        if (dp[ind][last + 1] != -1)
            return dp[ind][last + 1];

        int len = f(ind + 1, last, arr, n, dp);
        if (last == -1 || arr[ind] > arr[last])
            len = Math.max(len, 1 + f(ind + 1, ind, arr, n, dp));

        return dp[ind][last + 1] = len;
    }

}