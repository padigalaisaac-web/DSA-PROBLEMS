class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxPrefix = 0;
        int minPrefix = 0;
        int currentPrefix = 0;

        for (int num : nums) {
            currentPrefix += num;
            maxPrefix = Math.max(maxPrefix, currentPrefix);
            minPrefix = Math.min(minPrefix, currentPrefix);
        }

        return maxPrefix - minPrefix;
    }
}