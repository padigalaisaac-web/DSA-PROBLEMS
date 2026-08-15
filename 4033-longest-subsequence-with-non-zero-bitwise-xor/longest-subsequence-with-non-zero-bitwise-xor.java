class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zeros = 0;
        int n = nums.length;

        for (int x : nums) {
            xor ^= x;

            if (x == 0) {
                zeros++;
            }
        }

        // Whole array has non-zero XOR
        if (xor != 0) {
            return n;
        }

        // All elements are zero
        if (zeros == n) {
            return 0;
        }

        // Remove one non-zero element
        return n - 1;
    }
}
