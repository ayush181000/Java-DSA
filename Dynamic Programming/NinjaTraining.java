import java.util.*;

// Link : https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

// PROBLEM: Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn

// You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

public class NinjaTraining {

}

class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[] prev = new int[4];
        Arrays.fill(prev, -1);

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][1], points[0][0]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        curr[last] = Math.max(curr[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = curr;
        }

        return prev[3];
        // return helper(n-1,3,points,dp);
    }

    public static int helper(int n, int last, int points[][], int[][] dp) {
        if (n == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }

        if (dp[n][last] != -1)
            return dp[n][last];

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int score = points[n][i] + helper(n - 1, i, points, dp);
                max = Math.max(max, score);
            }
        }

        dp[n][last] = max;
        return max;
    }
}
