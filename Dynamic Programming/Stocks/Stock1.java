simport java.util.ArrayList;

public class Stock1 {

}

class Solution {

    public static int maximumProfit(ArrayList<Integer> prices) {
        int n = prices.size();
        int profit = 0;
        int min = prices.get(0);

        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, prices.get(i) - min);
            min = Math.min(min, prices.get(i));
        }

        return profit;
    }
}