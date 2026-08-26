class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        // dp[j] stores whether s1[0...i-1] and s2[0...j-1] can form s3[0...i+j-1]
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Base case: matching s2 with s3 when s1 is empty
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            // Base case for column 0: matching s1 with s3 when s2 is empty
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                char c3 = s3.charAt(i + j - 1);
                boolean fromS1 = dp[j] && s1.charAt(i - 1) == c3;
                boolean fromS2 = dp[j - 1] && s2.charAt(j - 1) == c3;

                dp[j] = fromS1 || fromS2;
            }
        }

        return dp[n];
    }
}