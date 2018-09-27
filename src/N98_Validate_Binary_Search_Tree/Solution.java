package N98_Validate_Binary_Search_Tree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x;}
    }

    public int maximum(TreeNode root) {

        if (root == null) return Integer.MIN_VALUE;

        int left_maximum = maximum(root.left);
        int right_maximum = maximum(root.right);

        return Math.max(Math.max(left_maximum, right_maximum), root.val);
    }

    public int minimum(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int left_minimum = minimum(root.left);
        int right_minimum = minimum(root.right);

        return Math.min(Math.min(left_minimum, right_minimum), root.val);
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        boolean valid_left = isValidBST(root.left);
        boolean valid_right = isValidBST(root.right);

        int maximum_left = maximum(root.left);
        int minimum_right = minimum(root.right);

        return valid_left && valid_right && ((maximum_left < root.val) || root.left == null) && ((root.val < minimum_right) || root.right == null);
    }
}
