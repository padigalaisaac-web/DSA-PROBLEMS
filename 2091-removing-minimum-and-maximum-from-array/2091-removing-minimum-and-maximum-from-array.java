class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int low = Math.min(minIdx, maxIdx);
        int high = Math.max(minIdx, maxIdx);

        // Option 1: Both from the front
        int option1 = high + 1;
        // Option 2: Both from the back
        int option2 = n - low;
        // Option 3: One from front, one from back
        int option3 = (low + 1) + (n - high);

        return Math.min(option1, Math.min(option2, option3));
    }
}