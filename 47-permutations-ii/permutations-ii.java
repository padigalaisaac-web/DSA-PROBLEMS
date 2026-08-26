import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to place duplicates adjacent to each other
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in the current branch
            if (used[i]) continue;

            // Skip duplicates: if the current element matches the previous element
            // and the previous element has not been used yet in this permutation depth, skip it
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, result);

            // Undo the choice (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}