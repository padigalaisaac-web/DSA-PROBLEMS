class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect the rightmost node to the right subtree
                prev.right = curr.right;

                // Move left child to right child and clear left child
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to the next node on the right
            curr = curr.right;
        }
    }
}