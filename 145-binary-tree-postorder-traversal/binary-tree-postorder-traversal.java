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
    ArrayList<Integer> postOrder= new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        //Left-Right-root
        if(root==null)
            return postOrder; 
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        postOrder.add(root.val);

        return postOrder;
    }
}