
import java.util.*;

public class LongestDivisibleSubset {

}

class Solution {

    public static ArrayList<Integer> divisibleSet(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;

        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
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

        // tracing back
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans.add(arr[lastIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static ArrayList<Integer> divisibleSet2(int arr[]) {
        Arrays.sort(arr);
        ArrayList<Integer> ans = f(0, new ArrayList<>(), arr);
        return ans;
    }

    public static ArrayList<Integer> f(int ind, ArrayList<Integer> ds, int[] arr) {
        if (ind == arr.length)
            return new ArrayList<>(ds);

        ArrayList<Integer> pick = new ArrayList<>();
        if (ds.size() == 0 || arr[ind] % ds.get(ds.size() - 1) == 0) {
            ds.add(arr[ind]);
            pick = f(ind + 1, ds, arr);
            ds.remove(ds.size() - 1);
        }

        ArrayList<Integer> notPick = f(ind + 1, ds, arr);

        if (pick.size() >= notPick.size())
            return pick;
        return notPick;
    }

}