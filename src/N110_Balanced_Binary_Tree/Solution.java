package N110_Balanced_Binary_Tree;


public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean left_balanced = isBalanced(root.left);
        boolean right_balanced = isBalanced(root.right);
        int height_diffrence = Math.abs(height(root.left) - height(root.right));

        return left_balanced && right_balanced && (height_diffrence <= 1);
    }
}
