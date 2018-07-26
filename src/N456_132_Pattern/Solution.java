package N456_132_Pattern;

public class Solution {
    public boolean find132pattern(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                }
            }

            for (int k = i+1; k < nums.length; k++) {
                if (min < nums[i] && nums[k] < nums[i] && min < nums[k]) {
                    return true;
                }
            }
        }

        return false;
    }
}