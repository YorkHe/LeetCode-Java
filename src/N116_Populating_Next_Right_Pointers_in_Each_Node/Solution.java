package N116_Populating_Next_Right_Pointers_in_Each_Node;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
