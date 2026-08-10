class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // dp[i] = true if the current player can win with i stones

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // If we can move to a losing position,
                // the current position is winning.
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
