import java.util.*;

class Solution {
    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        dp = new int[n][n];
        prefix = new int[n + 1];

        // Prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(stoneValue, 0, n - 1);
    }

    private int solve(int[] stones, int left, int right) {

        // Only one stone
        if (left >= right) {
            return 0;
        }

        // Already calculated
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = 0;

        // Try every possible split
        for (int k = left; k < right; k++) {

            int leftSum = prefix[k + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[k + 1];

            if (leftSum < rightSum) {

                // Bob removes right side
                ans = Math.max(
                    ans,
                    leftSum + solve(stones, left, k)
                );

            } else if (leftSum > rightSum) {

                // Bob removes left side
                ans = Math.max(
                    ans,
                    rightSum + solve(stones, k + 1, right)
                );

            } else {

                // Equal → Alice can choose either side
                ans = Math.max(
                    ans,
                    Math.max(
                        leftSum + solve(stones, left, k),
                        rightSum + solve(stones, k + 1, right)
                    )
                );
            }
        }

        return dp[left][right] = ans;
    }
}