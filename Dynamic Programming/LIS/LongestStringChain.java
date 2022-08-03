import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

}

class Solution {

    public static boolean compareMe(String str1, String str2) {

        int str1Length = str1.length();
        int str2Length = str2.length();

        if (str1Length != str2Length + 1)
            return false;

        int ind1 = 0;
        int ind2 = 0;

        while (ind1 < str1Length) {
            if (ind2 < str2Length && str1.charAt(ind1) == str2.charAt(ind2)) {
                ind1++;
                ind2++;
            } else {
                ind1++;
            }
        }
        if (ind1 == str1Length && ind2 == str2Length)
            return true;
        else
            return false;
    }

    public static int longestStrChain(int n, String[] arr) {

        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String str, String strr) {
                return str.length() - strr.length();
            }
        });

        int maxi = 1;
        for (int curr = 0; curr < n; curr++) {
            for (int prev = 0; prev < curr; prev++) {
                if (compareMe(arr[curr], arr[prev]) == true && dp[curr] < dp[prev] + 1) {
                    dp[curr] = dp[prev] + 1;
                }
            }
            maxi = Math.max(dp[curr], maxi);
        }
        return maxi;
    }
}