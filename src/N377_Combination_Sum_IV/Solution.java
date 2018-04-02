package N377_Combination_Sum_IV;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    private int dfs(int[] nums, int x) {
        int count = 0;
        if (nums.length == 0 || x < 0) return 0;
        if (x == 0) return 1;

        if (map.containsKey(x)) return map.get(x);

        for (int i : nums) {
            count += dfs(nums, x - i);
        }

        map.put(x, count);

        return count;
    }

    public int combinationSum4(int[] nums, int target) {
        int sum = dfs(nums, target);
        return sum;
    }
}
