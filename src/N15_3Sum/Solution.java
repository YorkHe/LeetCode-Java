package N15_3Sum;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ret;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            twoSums(nums, left, right, target, ret);
        }

        return ret;
    }

    public void twoSums(int[] nums, int left, int right, int target, List<List<Integer>> results) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);

                results.add(triple);

                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right --;
            }
        }
    }
}
