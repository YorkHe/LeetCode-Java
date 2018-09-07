package N300_Longest_Increasing_Subsequence;

public class Solution {
    public int lengthOfLIS(int[] nums) {

        int size = nums.length;

        int[] lis = new int[size];

        int answer = 0;

        for (int i = 0; i < size; i++) {
            int max_value = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && max_value < lis[j] + 1) {
                    max_value = lis[j] + 1;
                }
            }

            lis[i] = max_value;

            if (answer < max_value) {
                answer = max_value;
            }
        }

        return answer;
    }
}
