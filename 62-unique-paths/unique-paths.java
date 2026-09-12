class Solution {
    public int uniquePaths(int m, int n) {
        int k = Math.min(m - 1, n - 1);
        long result = 1;

        for(int i = 1; i <= k; i++){
            result = result * (m + n - 2 - k + i) / i;
        }

        return (int) result;
    }
}