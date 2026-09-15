/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        calAns(root, 0);
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return sum;
    }
    List<Integer> list = new ArrayList<>();
    private void calAns(TreeNode root, int num) {
        if(root.left == null && root.right == null) {
            num = num * 10 + root.val;
            list.add(num);
            return;
        }
        num = num * 10 + root.val;
        if(root.left != null) calAns(root.left, num);
        if(root.right != null) calAns(root.right, num);
    }
}