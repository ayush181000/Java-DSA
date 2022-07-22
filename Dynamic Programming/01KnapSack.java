import java.util.*;
public class Solution{
    static int knapsack(int[] wt, int[] val, int n, int maxWt) {
//         int dp[][] = new int[n][maxWt+1];
        int prev[] = new int[maxWt+1];
        
        for(int w = wt[0] ; w<=maxWt ; w++){
            prev[w] = val[0];
        }
        
        for(int ind = 1 ; ind < n ; ind ++){
            for(int w = maxWt ; w >= 0 ; w--){
                
                int notPick = prev[w];
                int pick = Integer.MIN_VALUE;;
                if(w - wt[ind]>=0) 
                        pick = val[ind] + prev[w-wt[ind]];
                
                prev[w] = Math.max(pick , notPick);
            }
        }
        return prev[maxWt];
    }
    
    static int helper(int ind ,int W, int[] weights , int[] value, int[][] dp){
        if(ind == 0){
            if(weights[0] <=W ) return value[0];
            return 0;
        }
        if(dp[ind][W] != -1) return dp[ind][W];
        
        int notPick = helper(ind-1,W,weights,value,dp);
        int pick = Integer.MIN_VALUE;;
        if(W - weights[ind]>=0) 
            pick = value[ind] + helper(ind-1,W-weights[ind],weights,value,dp);
        
        
        dp[ind][W] = Math.max(pick,notPick);
        return Math.max(pick,notPick);
    }
}