package N662_Maxium_Width_of_Binary_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private int max_depth = 0;
    private Integer[] left_most = new Integer[65535];
    private Integer[] right_most = new Integer[65535];

    private void dfs(TreeNode node, int depth, int value) {

        if (max_depth < depth) max_depth = depth;

        if (value < left_most[depth]) left_most[depth] = value;
        if (value > right_most[depth]) right_most[depth] = value;

        if (node.left != null) {
            dfs(node.left, depth+1, value * 2);
        }

        if (node.right != null) {
            dfs(node.right, depth+1, value * 2 + 1);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        int max_width = 0;

        Arrays.fill(left_most, Integer.MAX_VALUE);
        Arrays.fill(right_most, Integer.MIN_VALUE);

        dfs(root, 1, 1);
        for (int i = 1; i <= max_depth; i++) {

            System.out.printf("%d %d\n", left_most[i], right_most[i]);

            if (left_most[i] != Integer.MAX_VALUE && right_most[i] != Integer.MIN_VALUE) {
                if (max_width < (right_most[i] - left_most[i] + 1)) {
                    max_width = right_most[i] - left_most[i] + 1;
                }
            }
        }

        return max_width;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node2.right = node4;

        System.out.print(solution.widthOfBinaryTree(node));
    }
}
