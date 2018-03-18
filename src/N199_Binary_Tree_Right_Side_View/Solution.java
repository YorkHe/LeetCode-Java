package N199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int curDepth = 0;
    int maxDepth = 0;

    public void view(TreeNode root) {
        if (root == null) return;

        if (maxDepth < curDepth) maxDepth = curDepth;

        if (map.containsKey(curDepth)) {
            map.replace(curDepth, root.val);
        } else {
            map.put(curDepth, root.val);
        }


        curDepth += 1;
        view(root.left);
        curDepth -= 1;

        curDepth += 1;
        view(root.right);
        curDepth -= 1;
    }

    public List<Integer> rightSideView(TreeNode root) {
        view(root);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= maxDepth; i++) {
            if (map.containsKey(i))
                result.add(map.get(i));
        }

        return result;
    }
}
