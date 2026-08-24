class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;

        // Traverse the array up to the second to last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Keep track of the farthest reach from the current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump range,
            // we must make another jump and update the range.
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }

        return jumps;
    }
}