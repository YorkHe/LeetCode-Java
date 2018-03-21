package N117_Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int currentDepth = 0;

    Map<Integer, TreeLinkNode> map = new HashMap<>();

    public void connect(TreeLinkNode root) {

        if (root == null) return;

        if (map.containsKey(currentDepth)) {
            TreeLinkNode lastNode = map.get(currentDepth);
            lastNode.next = root;
            map.replace(currentDepth, root);
        } else {
            map.put(currentDepth, root);
        }


        currentDepth += 1;
        connect(root.left);
        currentDepth -= 1;

        currentDepth += 1;
        connect(root.right);
        currentDepth -= 1;
    }

    public static void main (String args[]) {
        Solution s = new Solution();
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);

        a.left = b;
        a.right = c;

        s.connect(a);
    }
}
