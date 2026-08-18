class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
      
            if (nums[i] == 0) continue;
            
            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;
            
            while (true) {
       
                slow = getNextIndex(nums, isForward, slow);
                if (slow == -1) break;
                

                fast = getNextIndex(nums, isForward, fast);
                if (fast == -1) break;
                
                fast = getNextIndex(nums, isForward, fast);
                if (fast == -1) break;
       
                if (slow == fast) return true;
            }
            
    
            int curr = i;
            while (nums[curr] != 0 && (nums[curr] > 0) == isForward) {
                int next = getNextIndex(nums, isForward, curr);
                nums[curr] = 0;
                if (next == -1) break;
                curr = next;
            }
        }
        
        return false;
    }
    
    private int getNextIndex(int[] nums, boolean isForward, int curr) {
        boolean direction = nums[curr] > 0;
       
        if (direction != isForward) return -1;
        
        int n = nums.length;
        int next = (curr + nums[curr]) % n;
        if (next < 0) next += n;
        if (next == curr) return -1;
        
        return next;
    }
}